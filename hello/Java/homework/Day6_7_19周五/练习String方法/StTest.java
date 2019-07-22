public class StTest {
    public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
        String str = "HellOWorlD!";
        String s1 = "hello";
        // 返回指定索引的char值,索引为3
        System.out.println("charAt(3): " + str.charAt(3));
        // 返回指定索引处的字符,索引为3
        System.out.println("codePointAt(3): " + str.codePointAt(3));
        // 按字典顺序比较两个字符串,考虑大小写,不等为负整数,相等为0,
        System.out.println("compareTo(): " + str.compareTo("helloworld!"));
        // 按字典顺序比较两个字符串,不考虑大小写
        System.out.println("compareToIgnoreCase(): " + str.compareToIgnoreCase("helloworld!"));
        // 将指定字符串连接到此字符串的结尾
        System.out.println("concat(): " + str.concat(s1));
        // 当此字符串包含指定的 char 值序列时,返回 true
        System.out.println("contains(): " + str.contains("E"));
        // 测试此字符串是否以指定的后缀结束
        System.out.println("endsWith(): " + str.endsWith("!"));
        // 将此字符串与指定的对象比较,考虑大小写
        System.out.println("equals(): " + str.equals("helloworld!"));
        // 将此 String 与另一个 String 比较，不考虑大小写
        System.out.println("equalsIgnoreCase(): " + str.equalsIgnoreCase("hEllOWorld!"));
        // 返回此字符串的长度
        System.out.println("length(): " + str.length());
        // 将此 String 中的所有字符都转换为大写
        System.out.println("toUpperCase(): " + str.toUpperCase());
        // 返回一个新字符串，它是此字符串的一个子字符串
        System.out.println("substring(): " + str.substring(4,9));
    }
}