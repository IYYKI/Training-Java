public class Num {
    public static void main (String [] args){
        int oddNum=0;
        int evenNum=0;
        for(int j=0;j<=100;j++){
            if(j%2!=0){//如果是奇数
                oddNum+=j;
            }else{//否则是偶数
                evenNum+=j;
            }
        }
        System.out.println("1到100以内的奇数和为:"+oddNum);
        System.out.println("1到100以内的偶数和为:"+evenNum);
    }
}
