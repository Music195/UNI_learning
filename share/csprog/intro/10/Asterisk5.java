import java.util.Scanner;

class Asterisk5 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.print("*");
            if (i%5==4) System.out.println();
        }
        System.out.println();
    }
}
