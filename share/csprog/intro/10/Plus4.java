import java.util.Scanner;

class Plus4 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.print("*");
            if (i%4==3) System.out.println();
        }
        System.out.println();
    }
}
