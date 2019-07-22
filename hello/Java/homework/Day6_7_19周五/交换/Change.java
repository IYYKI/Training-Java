package Day6_7_19周五.交换;


public class Change {
    public  Change(String number) {
        String[] numbers = number.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = numbers.length -1; i >= 0; i--) {
            sb.append(numbers[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        char[] ch = number.toCharArray();
        sb = new StringBuffer();
        for (int i = ch.length - 1; i >= 0; i--) {
            sb.append(ch[i]);
        }
        System.out.println(sb.toString());
    }
}