package ning.nc.framework.mvc;


import ning.nc.framework.database.annotation.Column;
import ning.nc.framework.database.annotation.Table;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 *
 * @author allen
 * 2019-03-22 17:56
 */
public class GridParameterParser {
    public static GridParameter parse(Class<?> clazz, Map<String, String[]> parameterMap) {
        GridParameter gp = new GridParameter();

        Map<String, String> formCollection = new HashMap<>();
        if(null != parameterMap) {
            for (Map.Entry<String, String[]> mapEntry : parameterMap.entrySet()) {
                String value = "";
                String[] values = mapEntry.getValue();
                if (values.length > 0) {
                    value = String.join(",", values);
                    //todo:以下语句出错
                    //value= StringEscapeUtils.escapeHtml4(value.trim());//将传入的html代码中的尖括号编码，防止xss攻击
                }
                formCollection.put(mapEntry.getKey(), value);
            }
        }

        if (clazz.getAnnotation(Table.class)!=null) {
            gp.setSqlSelect("select * from " + clazz.getAnnotation(Table.class).name());
        }

        //start
        int pageNo = 0;
        if (formCollection.get("page_no") != null) {
            pageNo = Integer.parseInt(formCollection.get("page_no"));
        }
        gp.setPageNo(pageNo);

        //limit
        int pageSize = 20;
        if (formCollection.get("page_size") != null) {
            pageSize = Integer.parseInt(formCollection.get("page_size"));
        }
        gp.setPageSize(pageSize);

        //sort and dir
        if (formCollection.get("sort") != null && formCollection.get("dir") != null) {
            gp.setSort(formCollection.get("sort"));
            gp.setDir(formCollection.get("dir"));
        }else{
            gp.setSort("id");
            gp.setDir("ASC");
        }
        //其系统本身处理了无排序，以id倒序排序的机制

        List<String> term = new ArrayList<>();

        StringBuffer sb = new StringBuffer(" WHERE 1=1");

        //fixedCondition
        if (formCollection.get("fixedCondition") != null) {
            String fixedCondition = formCollection.get("fixedCondition");
            sb.append(" AND ").append(fixedCondition);
        }

        //动态条件
        List<Filter> filterList = new ArrayList<Filter>();
        formCollection.keySet().stream().filter(p -> p.toLowerCase().endsWith("[field]")).forEach(p -> {
            //过滤对象组装
            Filter filter = buildFilter(formCollection, p);
            filterList.add(filter);
        });

        //拼接sql
        for (Filter f : filterList) {
            switch (f.Type) {
                case "number":
                case "date":
                    switch (f.Comparison) {
                        case "eq":
                            sb.append(" AND ").append(f.Field).append("=?");
                            break;
                        case "gt":
                            sb.append(" AND ").append(f.Field).append(">?");
                            break;
                        case "lt":
                            sb.append(" AND ").append(f.Field).append("<?");
                            break;
                        case "gte":
                            sb.append(" AND ").append(f.Field).append(">=?");
                            break;
                        case "lte":
                            sb.append(" AND ").append(f.Field).append("<=?");
                            break;
                        case "null":
                            //sb.append(" AND ").append(f.Field).append("=");
                            break;
                        case "neq":
                            sb.append(" AND ").append(f.Field).append("<>?");
                            break;
                    }
                    term.add(f.Value);
                    break;
                case "boolean":
                    sb.append(" AND ").append(f.Field).append("=?");
                    term.add(f.Value);
                    break;
                case "list":
                    sb.append(" AND ").append(f.Field).append(" in{?}");
                    term.add(f.Value.replace(",", "','"));
                    break;
                case "string":
                default:
                    if (f.Comparison.equals("false")) {
                        sb.append(" AND ").append(f.Field).append(" NOT LIKE ?");
                        term.add("%" + f.Value + "%");
                    } else {
                        sb.append(" AND ").append(f.Field).append(" LIKE ?");
                        term.add("%" + f.Value + "%");
                    }
                    break;
            }
        }

        //query
        if (formCollection.get("query") != null) {
            sb.append(" AND (0=1 ");
            String query = formCollection.get("query").toString();

            boolean hasFilterCondition = (filterList.size() > 0);
            Field[] fields = clazz.getDeclaredFields();

            //过滤掉非模糊查询条件
            Set<String> fuzzySearchFields = Arrays.stream(fields).filter(p -> {
                List<String> filterFields = filterList.stream().map(pp -> pp.Field).collect(Collectors.toList());
                return !filterFields.contains(p.getName());
            }).filter(p -> {
                return p.getType().equals(String.class)&&p.getAnnotation(Column.class)!=null; //只查询字符串
            }).map(p ->p.getAnnotation(Column.class).name()).collect(Collectors.toSet());    //返回字段的数据库列名

            //组装模糊查询
            for (String filedName : fuzzySearchFields) {
                sb.append(" OR ").append(filedName).append(" LIKE ?");
                term.add("%" + query + "%");
            }

            sb.append(")");
        }

        gp.setSqlWhere(sb.toString());
        gp.setTerm(term);

        return gp;
    }

    private static Filter buildFilter(Map formCollection, Object p) {
        String filterPre = p.toString().substring(0, p.toString().length() - 7);
        Filter filter = new Filter();
        filter.Field = formCollection.get(p).toString();
        filter.Value = formCollection.get(filterPre + "[data][value]").toString();
        filter.Type = formCollection.get(filterPre + "[data][type]").toString();
        filter.Comparison = formCollection.get(filterPre + "[data][comparison]").toString();
        return filter;
    }
}
