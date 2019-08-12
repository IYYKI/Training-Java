package Day_8_16.Works.MyDataBase;
public class Database {
    private int id;
    private String url;
    private String user;
    private String password;


    public Database() {
        super();
    }

    public Database(String url, String user, String password) {
        super();
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Database(int id, String url, String user, String password) {
        super();
        this.id = id;
        this.url = url;
        this.user = user;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Database [url=" + url + ", user=" + user + ", password=" + password + "]";
    }

}
