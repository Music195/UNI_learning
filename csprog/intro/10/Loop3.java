import java.util.Scanner;

class Loop3 {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("整数値を入力：");
        int x = sc.nextInt();
        while (x < 10) {
            System.out.print(x + " ");
            x++;
        }
    }
}
