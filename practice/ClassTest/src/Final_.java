public class Final_ {
    static String type = "type";
    static int i = 1;
    Final_(){
        if (i++==1){
            type="IBM";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Final_().type);
        System.out.println(new Final_().type);
    }
}
