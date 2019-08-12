package Pet.Model;



public class User {
    private String name;
    private String password;
    private String sex;
    private String birthday;
    private String address;
    private String hobby;
    private String telephone;

    public User() {
        super();

    }

    public User(String name, String password, String sex, String birthday, String address, String hobby,
                String telephone) {
        super();
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.hobby = hobby;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
