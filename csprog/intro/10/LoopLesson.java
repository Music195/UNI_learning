import java.util.Scanner;

class LoopLesson {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数値を入力してください：");
        int x = sc.nextInt();
        int y = 0;
        int sum = 0;
        while (y < x) {
            y++;
            sum = sum + y;
        }
        System.out.print(sum);
    }
}
