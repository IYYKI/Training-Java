package LengXing;

public class Lengxing {
    public static void main(String[] args) {
        X(7);
    }
    public static void X(int size){
        if (size % 2 == 0) {
            size++; // �������δ�С
        }
        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" "); // ������Ͻ�λ�õĿհ�
            }
            for (int j = 0; j < 2 * i + 1; j++) {

                System.out.print("*"); // ��������ϰ벿��Ե

            }
            System.out.println(); // ����
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" "); // ����������½ǿհ�
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {

                System.out.print("*"); // ��������°벿��Ե

            }
            System.out.println(); // ����
        }
    }
}
