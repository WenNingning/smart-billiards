package ning.nc.framework.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 浮点型mapper
 * @author Allen
 */
public class DoubleMapper implements RowMapper<Double> {

	
	@Override
    public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
		Double dobule = new Double(rs.getDouble(1));
		return dobule;
	}

}
