package ning.nc.framework.util;

import java.util.List;


/**
 * 
 * sql语句拼接工具类
 * @author zjp
 * @version v1.0
 * @since v6.4.0
 * 2017年12月1日 下午4:51:28
 */
public class SqlSplicingUtil {
	/**
	 * sql拼接
	 * @param list
	 * @return
	 */
	public static String sqlSplicing(List<String> list) {
		StringBuffer sql = new StringBuffer("");
		if(list.size()>0) {
			sql.append(" where ");
			for(int i=0;i<list.size();i++) {
				if(i==list.size()-1) {
					sql.append(list.get(i)+" ");
				}else {
					sql.append(list.get(i)+" and ");
				}
			}
		}
		return sql.toString();
	}
}
