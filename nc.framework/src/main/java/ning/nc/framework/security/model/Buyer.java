package ning.nc.framework.security.model;

/**
 * Created by Allen
 *
 * @author Allen
 */
public class Buyer extends User {


    /**
     * 定义买家的角色
     */
    public Buyer() {
        this.add(Role.BUYER);
    }


}
