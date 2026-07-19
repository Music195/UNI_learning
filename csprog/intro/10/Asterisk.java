import java.util.Scanner;

class Asterisk {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
