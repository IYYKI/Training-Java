public class Father {
    int num = 55;
    public void sound(int num){
        System.out.println("fa"+num);
    }
    public static class Baby extends Father{
        int num =2;
        public void sound(int num){
            System.out.println("baby"+num);
        }
    }

    public static void main(String[] args) {
        Father tmp = new Baby();
        tmp.sound(((Baby) tmp).num);
    }
}
