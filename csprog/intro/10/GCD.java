import java.util.Scanner;

class GCD {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int x = sc.nextInt();
        System.out.print("Enter the second number: ");
        int y = sc.nextInt();

        int multiplicant, multiplier, remainder, next_multiplicant;

        if (x < y) {
            multiplicant = y;
            multiplier = x;
        } else {
            multiplicant = x;
            multiplier = y;
        }

        do {
            next_multiplicant = multiplier;
            remainder = multiplicant % multiplier;
            multiplier = remainder;
            multiplicant = next_multiplicant;
        } while (remainder!=0);
        System.out.print(multiplicant);
    }
}
