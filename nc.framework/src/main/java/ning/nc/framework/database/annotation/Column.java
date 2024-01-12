package ning.nc.framework.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识为数据库的字段
 * @author Allen
 */
@Target(ElementType.FIELD) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface Column {

	String name() default "";

	boolean allowNullUpdate() default  false;


}
