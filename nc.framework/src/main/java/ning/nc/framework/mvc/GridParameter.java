package ning.nc.framework.mvc;

import java.util.List;

/**
 * 描述
 *
 * @author allen
 * 2019-03-22 17:27
 */
public class GridParameter {

    /**
     * 开始行数
     */
    private int pageNo;

    /**
     * 页容量
     */
    private int pageSize;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序 DESC / ASC
     */
    private String dir;

    /**
     * select语句，主要拼接表名
     */
    private String sqlSelect;

    /**
     * sql条件
     */
    private String sqlWhere;

    /**
     * 条件
     */
    private List<String> term;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<String> getTerm() {
        return term;
    }

    public void setTerm(List<String> term) {
        this.term = term;
    }

    public String getSqlSelect() {
        return sqlSelect;
    }

    public void setSqlSelect(String sqlSelect) {
        this.sqlSelect = sqlSelect;
    }

    public String getSqlWhere() {
        return sqlWhere;
    }

    public void setSqlWhere(String sqlWhere) {
        this.sqlWhere = sqlWhere;
    }
}
