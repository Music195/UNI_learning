import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class CardGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.print("Enter your money: ");
        int money = sc.nextInt();
        int mode;

        do {
            System.out.println("Welcome to the card game!");

            do {
                if (money <= 0) {
                    System.out.println("You have no money left. Exiting the game.");
                    return;
                }
                System.out.println("Avaliabe Modes:\n1. High or Low\n2. Shichi-Narabe\n3. Shin Ko Mee\n4. Exit");
                System.out.println("Select a mode to play(1/2/3/4): ");
                mode = sc.nextInt();
            } while (mode < 1 || mode > 4);

            switch (mode) {
                case 1 -> money = highLow(sc, rd, money);
                case 2 -> money = shichiNarabe(sc, rd, money);
                case 3 -> money = shinKoMee(sc, rd, money);
                case 4 -> {
                    System.out.println("Exiting the game.");
                    return;
                }
                default -> System.out.println("Invalid mode selected.");
            }

        } while (true);
    }

    public static int highLow(Scanner sc, Random rd, int money) {
        char[] cards = { ' ', ' ', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A' };
        do {
            System.out.println("money: " + money);
            int bet;
            do {
                System.out.print("Bet or Exit (0 to exit): ");
                bet = sc.nextInt();
                if (bet == 0) {
                    System.out.println("You have " + money + " money now.");
                    System.out.println("Exiting the game.");
                    return money;
                }
            } while (bet > money);

            money -= bet;
            do {
                int result = rd.nextInt(13) + 2;
                int com = rd.nextInt(13) + 2;
                System.out.println("com: " + cards[com]);
                System.out.println("High or Low: (h/l)?");
                char inp = sc.next().charAt(0);
                System.out.println("usr: " + cards[result]);

                if (inp == 'h' && result > com || inp == 'l' && com > result) {
                    System.out.println("You win");
                    bet *= 2;
                } else if (result == com) {
                    System.out.println("Draw");
                } else {
                    System.out.println("You lose");
                    System.out.println("You have " + money + " money now.");
                    return money;
                }
                System.out.println("Current profits: " + bet);
                System.out.print("Continue? (y/n) ");
                char c = sc.next().charAt(0);
                if (c == 'y') {
                    continue;
                } else {
                    money += bet;
                    System.out.println("You have " + money + " money now.");
                    return money;
                }
            } while (true);
        } while (true);
    }

    public static int shichiNarabe(Scanner sc, Random rd, int money) {

        String[] suits = { "\u2664", "\u2661", "\u2667", "\u2662" };// Spade, Heart, Club, Diamond
        char[] cards = { ' ', ' ', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A' };

        // Create an array to keep track of the taken cards
        String[] taken_cards = new String[52];
        int taken_count = taken_count(taken_cards);

        // Generate all cards without 7s
        String[] remaining_cards = new String[48];
        int index = 0;
        for (int i = 0; i < 52; i++) {
            if (cards[i % 13 + 2] != '7') {
                remaining_cards[index] = suits[i / 13] + cards[i % 13 + 2];
                index++;
            }

        }

        // Print the remaining cards
        System.out.println("Remaining cards (without 7s):");
        for (int i = 0; i < remaining_cards.length; i++) {
            System.out.print(remaining_cards[i] + " ");
            if ((i + 1) % 12 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        // other players
        int numPlayers = 2;

        // Print the players
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player" + (i + 1) + " has joined the game.");
        }
        
        // Generate the seven desk cards
        String[] seven_desk = new String[4];
        for (int i = 0; i < seven_desk.length; i++) {
            seven_desk[i] = suits[i] + cards[7];
        }

        // Add the seven desk cards to the taken cards
        for (int i = 0; i < seven_desk.length; i++) {
            taken_cards[taken_count] = seven_desk[i];
            taken_count++;
        }
        taken_count = taken_count(taken_cards);

        // Create an array for each player
        String[] my_cards = new String[16];
        String[] player1_cards = new String[16];
        String[] player2_cards = new String[16];
        
        // Generate the cards for the user without 7s
        for (int i = 0; i < my_cards.length; i++) {
            String card;
            do {
                card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
            } while (java.util.Arrays.asList(taken_cards).contains(card)); // Ensure the card is not already taken
            my_cards[i] = card;
        }

        // Add the user's cards to the taken cards
        for (int i = 0; i < my_cards.length; i++) {
            taken_cards[taken_count] = my_cards[i];
            taken_count++;
        }
        taken_count = taken_count(taken_cards);

        // Print the user's cards
        System.out.println("Your cards:");
        for (String card : my_cards) {
            System.out.print(card + " ");
        }
        System.out.println();

        // Generate and print the cards for the other players without 7s and not
        // overlapping with the user's cards and each other
        for (int i = 0; i < numPlayers; i++) {

            String[] player_cards = new String[16];
            for (int j = 0; j < player_cards.length; j++) {
                String card;
                do {
                    card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
                } while (java.util.Arrays.asList(taken_cards).contains(card)); // Ensure the card is not already taken
                player_cards[j] = card;
                taken_cards[taken_count] = card; // Add the card to the taken cards
                taken_count++;
            }

            switch (i) {
                case 0:
                    player1_cards = player_cards;
                case 1:
                    player2_cards = player_cards;
            }

            System.out.println("Player" + (i + 1) + "'s cards:");
            for (String card : player_cards) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        // Create arrays for each suit
        String[] spade_cards = new String[13];
        String[] heart_cards = new String[13];
        String[] club_cards = new String[13];
        String[] diamond_cards = new String[13];

        // Check and print for the user to have the card that is next to the seven desk card in each suit
        ArrayList<String> playable_card = new ArrayList<>();

        System.out.println("Your playable cards:");
        for (String card : my_cards) {
            if (card != null && (card.charAt(1) == '8' || card.charAt(1) == '6')) {
                playable_card.add(card);
            }
        }

        for (String pc : playable_card) {
            System.out.print(pc + " ");
        }
        System.out.println();

        // Prompt the user to select a playable card
        String selected_card;
        int selected_index;
        do {
            System.out.print("Select a playable card index: ");
            selected_index = sc.nextInt();
        } while (selected_index < 0 || selected_index >= playable_card.size());

        selected_card = playable_card.get(selected_index);

        int mid_num = 13 / 2 + 1;

        // Assign the seven desk cards to the middle index of each suit array
        spade_cards[mid_num] = seven_desk[0];
        heart_cards[mid_num] = seven_desk[1];
        club_cards[mid_num] = seven_desk[2];
        diamond_cards[mid_num] = seven_desk[3];
        


        // Print the cards for each suit
        System.out.println("Spade cards:");
        print_cards(spade_cards);

        System.out.println("Heart cards:");
        print_cards(heart_cards);

        System.out.println("Club cards:");
        print_cards(club_cards);

        System.out.println("Diamond cards:");
        print_cards(diamond_cards);

        return money;
    }

    public static int shinKoMee(Scanner sc, Random rd, int money) {
        // Placeholder for Shin Ko Mee game logic
        System.out.println("Shin Ko Mee mode is not implemented yet.");
        return money;
    }

    public static int taken_count(String[] taken_cards) {
        int count = 0;
        for (String card : taken_cards) {
            if (card != null) {
                count++;
            }
        }
        return count;
    }

    public static void print_cards(String[] cards) {
        for (int i = 0; i < 13; i++) {
            if (cards[i] != null) {
                System.out.print(cards[i] + " ");
            }
        }
        System.out.println();
    }
}
