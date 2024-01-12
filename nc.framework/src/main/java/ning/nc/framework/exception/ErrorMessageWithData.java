package ning.nc.framework.exception;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 带数据的错误消息
 * Created by Allen
 */
public class ErrorMessageWithData  extends  ErrorMessage{

    private  Object data;


    public ErrorMessageWithData(String code, String message,Object data) {
        super(code, message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }


    public ErrorMessageWithData() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        ErrorMessageWithData that = (ErrorMessageWithData) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(data, that.data)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(data)
                .toHashCode();
    }
}
