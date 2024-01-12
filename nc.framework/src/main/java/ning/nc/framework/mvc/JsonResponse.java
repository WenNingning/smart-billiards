package ning.nc.framework.mvc;

import java.io.Serializable;

/**
 * 描述
 *
 * @author allen
 * 2019-03-29 15:34
 */
public class JsonResponse implements Serializable {
    //成功失败标识
    public boolean success;
    //一般用于失败时的错误提示
    public String message;
    //返回的对象
    public Object data;

    public JsonResponse() {
    }

    public static JsonResponse successResponse(Object data) {
        JsonResponse response = new JsonResponse();
        response.success = true;
        response.data = data;
        return response;
    }

    public static JsonResponse errorResponse(String message) {
        JsonResponse response = new JsonResponse();
        response.success = false;
        response.message = message;
        return response;
    }
}
