package ning.nc.framework.database.impl;

import ning.nc.framework.exception.ServiceException;
import ning.nc.framework.logs.Debugger;
import ning.nc.framework.mvc.GridParameter;
import ning.nc.framework.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ning.nc.framework.database.CRUDBaseManager;
import ning.nc.framework.database.DaoSupport;
import ning.nc.framework.database.Page;

import java.lang.reflect.ParameterizedType;

public class CRUDBaseManagerImpl<T> implements CRUDBaseManager<T> {

    @Autowired
    @Qualifier("systemDaoSupport")
    public DaoSupport daoSupport;

    @Autowired
    public Debugger debugger;

    private Class<T> getGenericClass(){
        Class<T> entityClass = (Class <T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return entityClass;
    }

    @Override
    public Page list(GridParameter gp) {
        return daoSupport.queryForPage(gp,getGenericClass());
    }

    @Override
    public T edit(T t, Integer id) {
        T dbModel = daoSupport.queryForObject(getGenericClass(), id);
        if (dbModel == null) {
            throw new ServiceException("没有找到数据");
        }

        BeanUtil.copyProperties(t, dbModel);
        daoSupport.update(dbModel, id);
        return dbModel;
    }

    @Override
    public T add(T t) {
        daoSupport.insert(t);
        return t;
    }

    @Override
    @Transactional(value = "systemTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            daoSupport.delete(getGenericClass(), id);
        }
    }

    @Override
    public T getModel(Integer id) {
        return daoSupport.queryForObject(getGenericClass(), id);
    }
}
