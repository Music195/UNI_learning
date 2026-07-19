import java.util.Scanner;

class Plus4a {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        for (int i=0; i<n/4; i++) {
            System.out.println("++++");
        }
        for (int i=0; i<n%4; i++) {
            System.out.print("+");
        }
        System.out.println();
    }
}
