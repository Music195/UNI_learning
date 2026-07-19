import java.util.Random;

class RandomGen {
    static public void main (String args[]) {
        Random rand = new Random();
        int x = rand.nextInt(10);
        System.out.print(x);
    }
}
