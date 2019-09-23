package USER;

public class User {
    private String UserName;
    private String passwd;
    private String name;
    private String sex;
    private String birthday;
    private String address;
    private String hobby;
    private String contactNumber;

    public User() {

    }

    public User(String UserName, String passwd, String name, String sex, String birthday, String address,
                String hobby, String contactNumber) {
        super();
        this.UserName = UserName;
        this.passwd = passwd;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.hobby = hobby;
        this.contactNumber = contactNumber;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String toString() {
        return "User [UserName=" + UserName + ", passwd=" + passwd + ", name=" + name + ", sex=" + sex
                + ", birthday=" + birthday + ", address=" + address + ", hobby=" + hobby + ", contactNumber="
                + contactNumber + "]";
    }

}

