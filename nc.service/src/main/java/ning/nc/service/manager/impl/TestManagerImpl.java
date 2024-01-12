package ning.nc.service.manager.impl;

import ning.nc.framework.database.DaoSupport;
import ning.nc.framework.database.Page;
import ning.nc.framework.database.annotation.Table;
import ning.nc.framework.mvc.GridParameter;
import ning.nc.framework.util.SqlUtil;
import ning.nc.service.manager.TestManager;
import ning.nc.service.model.dos.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2024/1/12
 * @Author： wnn
 * @Description:
 */
@Service
public class TestManagerImpl implements TestManager {
    @Autowired
    @Qualifier("systemDaoSupport")
    private DaoSupport daoSupport;

    @Override
    public Page list(GridParameter gp) {
        // 也可以直接写sql
        return daoSupport.queryForPage(gp, TestDO.class);
    }

    @Override
    public TestDO edit(TestDO testDO, Integer id) {
        this.daoSupport.update(testDO, id);
        return testDO;
    }

    @Override
    public TestDO add(TestDO testDO) {
        daoSupport.insert(testDO);
//       获取id： int last_id = this.daoSupport.getLastId(TestDO.class.getAnnotation(Table.class).name());
        return testDO;
    }

    @Override
    public void delete(Integer[] ids) {
        List term = new ArrayList<>();
        String idsStr = SqlUtil.getInSql(ids, term);
        String sql = "delete from " + TestDO.class.getAnnotation(Table.class).name() + " where id in (" + idsStr + ") ";
        this.daoSupport.execute(sql, term.toArray());
    }

    @Override
    public TestDO getModel(Integer id) {
        return this.daoSupport.queryForObject(TestDO.class, id);
    }
}
