package Day16_7_31_Wednesday.Shen;

import java.util.Scanner;

public class CityTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        City city = new City();
        System.out.println("������: ");
        String s1 = s.next();
        city.getCity(s1);

        System.out.println("������: ");
        String s2 = s.next();
        city.getCity(s2);
    }
}