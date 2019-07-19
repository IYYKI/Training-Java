package Day4_7_17周三.邮箱;

public class EmailTest {

    private String id;
    private String pwd;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void show(){
        System.out.println("你的ID为:"+"   |"+this.id);
        System.out.println("你的密码为: "+" |"+this.pwd);
        System.out.println("你的邮箱为:"+"  |"+this.email);
    }
}
