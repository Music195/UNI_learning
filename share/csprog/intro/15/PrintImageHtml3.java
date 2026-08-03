import java.util.Random;
import java.io.*;

class PrintImageHtml3 {
	public static void main (String args[]) {
	    // Create an array of filename 
	    String[] filename = new String[100];
	    int actualLineCount = 0;

	    try {
		    InputStreamReader is = new InputStreamReader(System.in);
		    BufferedReader sc = new BufferedReader(is);

		    for (int i=0; i<filename.length; i++) {
	                String line = sc.readLine();

			if (line == null) {
		            break;
			}

			filename[i] = line;
			actualLineCount++;
		    }
	    }
	    catch (Exception e) {
		    e.printStackTrace();
	    }
            
	    Random rd = new Random();
	    int[] r = two_rd_num(actualLineCount);
            
	    //Write HTML
	    write_html(r, filename);

	}

	public static int[] two_rd_num (int range) {
	    Random rd = new Random();
	    int r1, r2;
	    while(true) {
		    r1 = rd.nextInt(range);
		    r2 = rd.nextInt(range);
		    if (r1 != r2) {
			    break;
		    }
	    }
	    return new int[]{r1, r2};
	}

	public static void write_html (int[] two_rd_num, String[] filename) {
		System.out.print("<HTML>\n");
		System.out.print("<HEAD><TITLE>Image Shower </TITLE></HEAD>\n");
		System.out.print("<BODY>\n");
		for (int i=0; i<two_rd_num.length; i++) {
			System.out.print("<IMG SRC=\"images15/"+ filename[two_rd_num[i]] +"\"><BR>\n");
		}
		System.out.print("</BODY>\n");
		System.out.print("</HTML>\n");
		System.err.print("処理は終了しました。");
	}
}
