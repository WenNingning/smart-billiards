package ning.nc.framework.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 字符串型mapper
 * @author Allen
 */
public class StringMapper implements  RowMapper<String> {

	
	@Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		String str = rs.getString(1);
		return str;
	}

}
