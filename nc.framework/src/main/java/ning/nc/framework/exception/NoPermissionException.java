package ning.nc.framework.exception;

import org.springframework.http.HttpStatus;

/**
 * 无权限异常，比如试图更新一个别人的账号的密码
 *
 * @author yanlin
 */
public class NoPermissionException extends ServiceException {

    private static final long serialVersionUID = 8207742972948289957L;

    public NoPermissionException(String message) {
        super(SystemErrorCodeV1.NO_PERMISSION, message);
        this.statusCode = HttpStatus.UNAUTHORIZED;
    }


}
