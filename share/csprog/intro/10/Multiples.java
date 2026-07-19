import java.util.Scanner;

class Multiples {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<(100/n); i++) {
            int m = n * (i + 1);
            System.out.print(m + " ");
        }
    }
}
