package Day5_7_18周四.用户;

public class User {
    String name;
    int pwd;
    public User(){
    }
    public User(String name,int pwd){
        this.name = name;
        this.pwd = pwd;
        System.out.println("用户名: "+name);
        System.out.println("密码: "+pwd);
    }

    public String getName() {
        return name;
    }

    public int getPwd() {
        return pwd;
    }
}
