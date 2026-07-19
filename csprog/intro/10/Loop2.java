import java.util.Random;

class Loop2 {
    static public void main (String args[]) {
        Random rand = new Random();
        int x = rand.nextInt(10);

        while (x < 10)  { 
            System.out.print(x + " ");
            x = x + 1;
        }
    }
}
