package ning.nc.framework.security.model;

/**
 *
 * 卖家
 * Created by Allen
 *
 * @author Allen
 */
public class Seller extends  Buyer {

    /**
     * 卖家id
     */
    private  Integer sellerId;

    /**
     * 卖家店铺名称
     */
    private String sellerName;
    
    /**
     * 是否是自营  0 不是  1是
     */
    private Integer selfOperated;


    public Seller() {
         //seller有 买家的角色和卖宾角色
         add( Role.SELLER);
    }


    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }


	public Integer getSelfOperated() {
		return selfOperated;
	}


	public void setSelfOperated(Integer selfOperated) {
		this.selfOperated = selfOperated;
	}
    
    
}
