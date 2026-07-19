import java.util.Scanner;

class SumAveM {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, c =0, sum=0;
        for (i=0; i<n; i++) {
            System.out.print("Positive Integer: ");
            int a = sc.nextInt();
            if (a < 0) continue;
            sum += a;
            c++;
        }
        System.out.println("Sum: " + sum);
        if (i != 0) System.out.println("Average :" + sum/c);
    }
}
