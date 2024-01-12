package ning.nc.framework.database;


import ning.nc.framework.mvc.GridParameter;

/**
 * 描述
 *
 * @author allen
 */
public interface CRUDBaseManager<T> {
    /**
     * 分页对象
     * @param gp
     * @return
     */
    Page list(GridParameter gp);

    /**
     * 编辑对象
     * @param t
     * @param id
     * @return
     */
    T edit(T t, Integer id);

    /**
     * 新增对象
     * @param t
     * @return
     */
    T add(T t);

    /**
     * 删除
     * @param ids
     */
    void delete(Integer[] ids);

    /**
     * 获取单个对象
     * @param id
     * @return
     */
    T getModel(Integer id);
}
