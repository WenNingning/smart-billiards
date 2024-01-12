package ning.nc.framework.exception;

import org.springframework.http.HttpStatus;

/**
 * 资源找不到异常
 *
 */
public class ResourceNotFoundException extends ServiceException {


    private static final long serialVersionUID = -6945068834935110333L;


    public ResourceNotFoundException(String message) {

        super(SystemErrorCodeV1.RESOURCE_NOT_FOUND, message);
        this.statusCode = HttpStatus.NOT_FOUND;

    }
}
