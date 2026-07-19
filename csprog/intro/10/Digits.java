import java.util.Scanner;

class Digits {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数値を入力：");
        int x = sc.nextInt();
        int digits = 0;
        while (x > 0) {
            x /= 10;
            digits += 1;
        }
        System.out.print("桁数：" + digits);
    }
}
