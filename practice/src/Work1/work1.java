package Work1;

import java.util.Scanner;

public class work1 {
    public static void main(String[] args) {
        Change();
    }

  public static void Change(){
        Scanner scan  = new Scanner(System.in);
        System.out.println("Number One");
        int a = scan.nextInt();
        System.out.println("Number Two");
        int b = scan.nextInt();
        System.out.println(b+" "+a);
  }
}

