import java.util.Scanner;

class PrintImageHtml2 {
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        int max = sc.nextInt();
        if (max <= 10) {
            System.out.print("<HTML>\n");
            System.out.print("<HEAD><TITLE>Multiple Image Page </TITLE></HEAD>\n");
            System.out.print("<BODY>\n");
            for (int i=1; i<=max; i++) {
                System.out.print("<IMG SRC=\""+ i + ".image.jpg\"><BR>\n");
            }
            System.out.print("</BODY>\n");
            System.out.print("</HTML>\n");
            System.err.print("処理は終了しました。");
        }

    }
}
