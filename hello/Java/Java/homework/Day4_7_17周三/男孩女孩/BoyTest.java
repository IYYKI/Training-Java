package Day4_7_17周三.男孩女孩;

public class BoyTest {
    private String name;
    private char   sex;
    private String age;
    private String learning;

    public String learning(String le) {
        learning = "正在学习语文";
        le = "我在学习";
        System.out.println(le);
        return learning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
