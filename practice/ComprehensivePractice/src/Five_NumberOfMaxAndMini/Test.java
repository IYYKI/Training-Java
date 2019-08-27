package Five_NumberOfMaxAndMini;

/**
 *
 *
 * 	   8	16
 * 4 | 2	4  |——————4x2
 * 2 | 0     2 |			|
 *   -----------    		|
 *     4x2x2			 —————————》「最大公约数」
 *       |
 *   {最小公倍数}
 *
 *
 * **/
public class Test {

    public static void main(String[] args) {

        max_min(8, 16);
    }


    /**
     * 方法
     */

    public static void max_min(int m, int n) {

        int mm = m;

        int nn = n;

        int temp = 1;

        int yshu = 1;

        int bshu = m * n;

        if (n < m) {

            temp = n;

            n = m;

            m = temp;

        }

        while (m != 0) {

            temp = n % m;

            n = m;

            m = temp;

        }

        yshu = n;

        bshu /= n;

        System.out.println(mm + "和" + nn + "的最大公约数为" + yshu);

        System.out.println(mm + "和" + nn + "的最小公倍数为" + bshu);

    }
}
