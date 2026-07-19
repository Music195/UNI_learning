import java.util.Scanner;

class Loop4d {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int x;
        do {
            System.out.print("整数値 1から9：");
            x = sc.nextInt();
        } while (x < 0 || 10 < x);
    }
}
