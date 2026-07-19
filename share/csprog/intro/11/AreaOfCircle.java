import java.util.Scanner;

class AreaOfCircle {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        final double PI = 3.1416;
        System.out.print("Enter the radius:");
        double r = sc.nextDouble();
        System.out.printf("Area of Circle wiht Radius ,%.3f, is %.3f.", r, r*r*PI);
    }
}
