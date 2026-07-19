import java.util.Scanner;

class LoopLesson2 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int x;
        do {
            System.out.print("10から20までの整数値を入力：");
            x = sc.nextInt();
            } while (10>=x || x>=20);
        System.out.print(x);
    }
}
