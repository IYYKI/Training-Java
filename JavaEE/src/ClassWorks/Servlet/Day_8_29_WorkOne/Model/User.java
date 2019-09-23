package ClassWorks.Servlet.Day_8_29_WorkOne.Model;
public class User {

    private String account;
    private String password;
    private String name;
    private int age;
    private String sex;
    private String career;
    private int salary;
    private String address;
    private String phone;
    private String email;


    public User() {
        super();
    }
    public User(String account, String password, String name, int age, String sex, String career, int salary,
                String address, String phone, String email) {
        super();
        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.career = career;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public String getUsername() {
        return account;
    }
    public void setUsername(String username) {
        this.account = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCareer() {
        return career;
    }
    public void setCareer(String career) {
        this.career = career;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [username=" + account + ", password=" + password + ", name=" + name + ", age=" + age + ", sex="
                + sex + ", career=" + career + ", salary=" + salary + ", address=" + address + ", phone=" + phone
                + ", email=" + email + "]";
    }





}
