package ning.nc.framework.exception;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 错误消息
 * Created by Allen
 */
public class ErrorMessage  {

	private String code;
	private String message;

	public ErrorMessage() {
	}

	public ErrorMessage(String code, String message ) {

		this.code = code;
		this.message = message;

	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ErrorMessage that = (ErrorMessage) o;

		return new EqualsBuilder()
				.append(code, that.code)
				.append(message, that.message)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(code)
				.append(message)
				.toHashCode();
	}

	@Override
	public String toString() {
		return "ErrorMessage{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
