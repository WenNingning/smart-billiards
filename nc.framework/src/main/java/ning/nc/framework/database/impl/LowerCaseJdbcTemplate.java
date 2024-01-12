package ning.nc.framework.database.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 * 覆写jdbctemlate ，使用LowerCaseColumnMapRowMapper
 * @author Allen
 */
public class LowerCaseJdbcTemplate extends JdbcTemplate {
	@Override
	protected RowMapper getColumnMapRowMapper() {

		return new MySqlColumnMapRowMapper();

	}

}
