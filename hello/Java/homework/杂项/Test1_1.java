package 杂项;

class Test1_1 {

    public static void main(String[] args) {
        boolean b = c(28);
        System.out.println(b);
    }
    public static boolean c(int num){
        if ( num < 1 ){
            return false;
        }else {
            for (int i = 2 ; i<num ; i++){
                if (num % 2 == 0){
                    return false;
                }
            }
        }
        return true;
    }
}