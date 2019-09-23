package Day9_7_24周三练习;

public class LaoMuJi extends Animal{
    private String name;
    public String getName(){
        return name;
    }
    public LaoMuJi(String name){
        this.name = name;
    }
    public Animal birth(){
        LaoMuJi muJi = new LaoMuJi("小母鸡");
        System.out.println(name+"咯咯咯咯哒...之后生出了一个蛋这个就是"+muJi.name);
        return muJi;
    }
}
