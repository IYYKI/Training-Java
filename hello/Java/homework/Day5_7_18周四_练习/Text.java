package Day5_7_18周四_练习;


public class Text {
    String  str;
    int age;
    public Text(){
        System.out.println("无参数构造器");
    }
    public Text(String str,int age){
        this.age = age;
        this.str = str;
        System.out.println(str+"有参"+age);
    }

}
