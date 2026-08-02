class PrintImageHtml1 {
    public static void main (String args[]) {
        System.out.print("<HTML>\n");
        System.out.print("<HEAD><TITLE>Multiple Image Page </TITLE></HEAD>\n");
        System.out.print("<BODY>\n");
        for (int i=1; i<=10; i++){
            System.out.print("<IMG SRC=\""+ i +".image.jpg\"><BR>\n");
        }
        System.out.print("</BODY>\n");
        System.out.print("</HTML>\n");
    }
}
