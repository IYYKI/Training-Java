package Day_8_5.WorkFour;

import java.io.Serializable;

public class BeFor_TestFile implements Serializable {
    private String username;
    transient private String password;
    private String sex;
    private String address;

    public BeFor_TestFile() {
        super();
    }

    public BeFor_TestFile(String username, String password, String sex, String address) {
        super();
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member [username=" + username + ", sex=" + sex + ", address=" + address + "]";
    }

}
