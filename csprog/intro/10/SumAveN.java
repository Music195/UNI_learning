import java.util.Scanner;

class SumAveN {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of numbers: ");
        int n = sc.nextInt();
        int i, sum = 0;
        for (i=0; i<n; i++) {
            System.out.print("Number (type 0 for culculating): ");
            int a = sc.nextInt();
            if (a == 0) break;
                sum += a;
        }

        System.out.println("Sum:" + sum);

        if (i != 0) System.out.println("Average:" + sum/i);
    }
}
