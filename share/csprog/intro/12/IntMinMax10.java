import java.util.Random;

class IntMinMax10 {
    static public void main (String args[]) {
        Random rd = new Random();
        int[] b = new int[10];

        int min = b[0];
        int max = b[0];

        for (int i = 0; i < b.length; i++) {
             b[i] = rd.nextInt(100);
             System.out.print(b[i] + " ");
        }
        System.out.println();

        for (int v: b) {
             if (max <= v) {
                  max = v;
             }
             if (min >= v) {
                  min = v;
             }

        }
        System.out.print("Max: " + max + "\n" + "Min: " + min);
        System.out.println();
    }
}
