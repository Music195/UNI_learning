import java.util.Scanner;

class PrimeNumber {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int i ;
        for (i=2; i<=x; i++) {
            if (x % i == 0) {
                break;
            }
        }
        if (i == x) {
            System.out.println("Prime Number");
        } else {
            System.out.println("None Prime Number");
        }
    }
}
