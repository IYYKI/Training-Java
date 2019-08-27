package MothAndYear;

public class MothYear {
    public static void main(String[] args) {
        GetDay(2019,3,26);
    }

    public static void GetDay(int year, int month, int date) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum += 31;
                    break;
                case 2:
                    sum += year % 4 == 0 && year % 100 == 0 || year % 400 == 0 ? 29 : 28;
                default:
                    sum += 30;
            }
        }
        //加上当前日期
        sum+=date;
        System.out.println(year+"-"+month+"-"+date+"是今年的的第"+sum+"天");
    }
}
