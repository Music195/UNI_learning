import java.util.Scanner;

class SumAveMN {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the frequency: ");
        int r = sc.nextInt();
        System.out.print("Enter the NO. of number: ");
        int n = sc.nextInt();

        int[] a = new int[n]; //For storing number in user
        for (int i=0; i<r; i++) {
            System.out.println();
            System.out.println();
            int sum = 0;

            for (int m=0; m<n; m++) {
                System.out.print("Enter number: ");
                int b = sc.nextInt();
                sum += b;
                a[m] = b;
            }

            System.out.println();
            for (int m=0; m<n; m++) {
                System.out.printf("%2d ", a[m]);
            }

            System.out.printf("\nSum     : "+ sum);
            if (n != 0) System.out.printf("\nAverage : %.1f", (double)sum/n);
        }
    }
}
