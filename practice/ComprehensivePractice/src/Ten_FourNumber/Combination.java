package Ten_FourNumber;

public class Combination {
    public static void main(String[] args) {
        int count;
        count = 0;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=4;j++){
                for(int k=1;k<=4;k++){
                    //相互都不相等
                    if(i!=j&&i!=k&&j!=k){
                        ++count;
                        System.out.println(100*i+10*j+k);
                    }
                }
            }
        }
        System.out.println("一共有: "+ count + "个");
    }
}
