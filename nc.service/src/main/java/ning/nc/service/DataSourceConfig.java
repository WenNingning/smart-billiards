package ning.nc.service;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import ning.nc.framework.database.DaoSupport;
import ning.nc.framework.database.impl.DaoSupportImpl;

import javax.sql.DataSource;

/**
 * Created by Allen
 */
@Configuration
@ConditionalOnProperty(value = "ning.product", havingValue = "stand")
public class DataSourceConfig {

    /*----------------------------------------------------------------------------*/
    /*                           DaoSupport配置                                    */
    /*----------------------------------------------------------------------------*/

    /**
     * 系统daoSupport
     * @param jdbcTemplate 系统 jdbcTemplate
     * @return
     */
    @Primary
    @Bean(name = "systemDaoSupport")
    public DaoSupport systemDaoSupport(@Qualifier("systemJdbcTemplate") JdbcTemplate jdbcTemplate) {
        DaoSupport daosupport = new DaoSupportImpl(jdbcTemplate);
        return daosupport;
    }

    @Bean(name = "testDaoSupport")
    public DaoSupport testDaoSupport(@Qualifier("testJdbcTemplate") JdbcTemplate jdbcTemplate) {
        DaoSupport daosupport = new DaoSupportImpl(jdbcTemplate);
        return daosupport;
    }


    /*----------------------------------------------------------------------------*/
    /*                           JdbcTemplate 配置                                */
    /*----------------------------------------------------------------------------*/


    /**
     * 系统jdbcTemplate
     * @param dataSource 系统数据源
     * @return
     */
    @Primary
    @Bean(name = "systemJdbcTemplate")
    public JdbcTemplate systemJdbcTemplate(
            @Qualifier("systemDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "testJdbcTemplate")
    public JdbcTemplate testJdbcTemplate(
            @Qualifier("testDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*----------------------------------------------------------------------------*/
    /*                           数据源配置                                        */
    /*----------------------------------------------------------------------------*/

    /**
     * 系统数据源
     * @return
     */
    @Primary
    @Bean(name = "systemDataSource")
    @Qualifier("systemDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.system")
    public DataSource systemDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "testDataSource")
    @Qualifier("testDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.test")
    public DataSource testDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    /*----------------------------------------------------------------------------*/
    /*                           事务配置                                         */
    /*----------------------------------------------------------------------------*/


    /**
     * 系统事务
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager systemTransactionManager(@Qualifier("systemDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public PlatformTransactionManager testTransactionManager(@Qualifier("testDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
