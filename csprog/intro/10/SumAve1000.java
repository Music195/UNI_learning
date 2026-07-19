import java.util.Scanner;

class SumAve1000 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the frequncy: ");
        int n = sc.nextInt();
        int i, c=0, sum=0;
        for (i=0; i<n; i++) {
            System.out.print("Number: ");
            int a = sc.nextInt();

            if (sum + a > 1000 ) {
                System.out.println("Since sum is greater than 1000, last number will be cut out and continue with above numbers.");
                break;
            }

            c++;
            sum += a;
        }
        System.out.println("Sum: " + sum);
        if (i != 0) System.out.println("Average: " + sum/c);
    }
}
