package ning.nc.framework.security.model;

/**
 * 店员
 *
 * @author Allen
 */

public class Clerk extends Seller {

    /**
     * 店员id
     */
    private Integer clerkId;
    /**
     * 店员名称
     */
    private String clerkName;
    /**
     * 是否是超级店员
     */
    private Integer founder;
    /**
     * 权限
     */
    private String role;

    public Clerk() {
        //clerk有 买家的角色和卖宾角色
        add(Role.CLERK);
    }

    public Integer getClerkId() {
        return clerkId;
    }

    public void setClerkId(Integer clerkId) {
        this.clerkId = clerkId;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public Integer getFounder() {
        return founder;
    }

    public void setFounder(Integer founder) {
        this.founder = founder;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "clerkId=" + clerkId +
                ", clerkName='" + clerkName + '\'' +
                ", founder=" + founder +
                ", role='" + role + '\'' +
                '}';
    }
}
