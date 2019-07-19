package Day4_7_17周三.男孩女孩;

public class Boy {
    public static void main(String [] args){
        BoyTest tm = new BoyTest();
        tm.setAge("18岁的");
        tm.setName("汤姆");
        tm.setSex('男');
        System.out.println(tm.getSex());
        System.out.println(tm.getAge()+tm.getName());

        System.out.println(tm.learning(" "));
    }
}
