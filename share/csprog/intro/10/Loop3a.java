import java.util.Scanner;

class Loop3a {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数値；");
        int x = sc.nextInt();
        while (!(10 <= x)) {
            System.out.print(x + " ");
            x = x + 1;
        }
    }
}
