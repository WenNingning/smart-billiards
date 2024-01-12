package ning.nc.framework.database;

import java.util.Arrays;

/**
 * 元数据
 * @author Allen
 */
public class DataMeta {

    /**
     * sql 语句
     */
    private String sql;

    /**
     * sql 语句中需要的参数
     */
    private Object[] paramter;


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object[] getParamter() {
        return paramter;
    }

    public void setParamter(Object[] paramter) {
        this.paramter = paramter;
    }

    @Override
    public String toString() {
        return "DataMeta{" +
                "sql='" + sql + '\'' +
                ", paramter=" + Arrays.toString(paramter) +
                '}';
    }
}
