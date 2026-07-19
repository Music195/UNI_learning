import java.util.Scanner;

class TriangleAsterisk2 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
