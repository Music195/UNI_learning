import java.util.Scanner;

class Asterisk5a {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n/5; i++) {
            System.out.println("*****");
        }
        for (int i=0; i<n%5; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
