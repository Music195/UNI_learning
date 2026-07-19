import java.util.Scanner;

class MultipleLoop {
    static public void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
