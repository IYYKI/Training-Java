package MT.model;



public class Cart {
    private int cartid;
    private String account;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    private int foodid;
    private int status;
    public int getCartid() {
        return cartid;
    }
    public void setCartid(int cartid) {
        this.cartid = cartid;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public int getFoodid() {
        return foodid;
    }
    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Cart(int cartid, String account, int foodid) {
        super();
        this.cartid = cartid;
        this.account = account;
        this.foodid = foodid;
    }
    @Override
    public String toString() {
        return "Cart [cartid=" + cartid + ", account=" + account + ", foodid=" + foodid + ", status=" + status + "]";
    }



}
