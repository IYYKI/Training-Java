package TwentyFour_Monkey;

public class Test {
    public static void main(String[] args) {

        int minCount = 4;
        int minCountCopy = minCount;

        for (int i = 0; i < 5; i++) {

            if (i == 0) {
                minCount = minCountCopy;
                minCount = minCount * 5 + 1;
            } else {

                if (minCount % 4 != 0) {
                    minCount = minCountCopy;
                    minCount++;
                    minCountCopy = minCount;
                    i = -1;
                }
                minCount = minCount * 5 / 4 + 1;
            }
        }

        System.out.println(minCount);
    }
}
/**
 * int peach = 6;//假设沙滩上最初的桃子数为6
 * int monkey = 5;//5只猴子来分
 *
 * int tmp = peach;
 *     for(int i=0; i<money; i++){
 *     //几只猴子就做几次同样的操作
 *
 *     if((tmp-1)%5==0){
 *         //说明桃子数符合此次要求
 *
 *         //分桃
 *         tmp = (peach-1)/5*4;
 *         //一只猴子分完后剩下的桃子数
 *     }else{
 *         //分到某一个猴子 桃子数不能再分来
 *         //说明原始假设的桃子数不符合 假设的桃子数+1执行同样的操作
 *         peach++;
 *         //peach重制后 循环重新开始(5只猴子分)
 *         i=-1;
 *         //tmp也要重新赋值
 *         tmp = peach;
 *     }
 * }
 * System.out.println("最少符合的桃子数"+peach);
 *
 *
 *
 * **/
