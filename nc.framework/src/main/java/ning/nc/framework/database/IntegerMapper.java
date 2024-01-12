package ning.nc.framework.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 整型mapper
 * @author Allen
 */
public class IntegerMapper implements RowMapper<Integer> {
	
	@Override
    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer  v = rs.getInt(1);
		return v;
	}

}
