package Day8_7_23周二.猴子和人;

public class People extends Monkey{
    public People(String s){
        super(s);
    }
    public void speak(){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话，认真思考");
    }


}
