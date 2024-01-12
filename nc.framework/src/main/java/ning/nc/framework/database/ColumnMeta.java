package ning.nc.framework.database;

/**
 * 列数据
 * @author Allen
 */
public class ColumnMeta {

    /**
     * 字段名
     */
    private Object[] names;

    /**
     * 字段值
     */
    private Object[] values;

    public Object[] getNames() {
        return names;
    }

    public void setNames(Object[] names) {
        this.names = names;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
