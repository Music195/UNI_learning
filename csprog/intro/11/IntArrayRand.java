import java.util.Scanner;
import java.util.Random;

class IntArrayRand {
    static public void main (String args[]) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        double sum = 0;
        int i;
        for (i=0; i<n; i++) {
            a[i] = rd.nextInt(n);
            sum += a[i];
            System.out.printf("%2d ", a[i]);

        }

        System.out.printf("\n Sum is %.2f.", sum);
        if (n!=0) System.out.printf("\n Average is %.2f", sum/(double)n);
    }
}
