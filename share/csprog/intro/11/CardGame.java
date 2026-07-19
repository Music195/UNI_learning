import java.util.Scanner;
import java.util.Random;

class CardGame {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        char[] cards = {' ', ' ', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A'};

        int money = 1000;
        int card;
        do {
            System.out.println("money: " + money);
            int bet;
            do {
                System.out.print("bet: ");
                bet = sc.nextInt();
            } while (bet>money);

            money -= bet;
            do {
                int result = rd.nextInt(13)+2;
                int com = rd.nextInt(13)+2;
                System.out.println("com: " + cards[com]);
                System.out.println("High or Low: ");
                char inp = sc.next().charAt(0);
                System.out.println("usr: " + cards[result]);

                if (inp == 'h' && result > com || inp == '1' && com> result) {
                    System.out.println("You win");
                    bet *= 2;
                } else if (result == com) {
                    System.out.println("Draw");
                } else {
                    System.out.println("You lose");
                    break;
                }
                System.out.println("Current tmp money: " + bet);
                System.out.print("Continue? ");
                char c = sc.next().charAt(0);
                if (c == 'y') {
                    continue;
                } else {
                    money += bet;
                    break;
                }
            } while (true);
        } while (true);
    }
}
