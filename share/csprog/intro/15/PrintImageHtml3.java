import java.util.Random;
import java.io.*;

class PrintImageHtml3 {
	public static void main (String args[]) {
	    Random rd = new Random();
	    int r1, r2;
	    while(true) {
	    	r1 = rd.nextInt(10);
	    	r2 = rd.nextInt(10);
	    	if (r1 != r2) {
	    		break;
	    	}
	    } 
	    System.out.printf("%d, %d",r1 , r2);


	}
}
