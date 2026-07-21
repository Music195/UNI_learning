import java.util.Random;
import java.util.Scanner;

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
        // Placeholder for Shichi-Narabe game logic
        String[] suits = { "\u2664", "\u2661", "\u2667", "\u2662" };// Spade, Heart, Club, Diamond
        char[] cards = { ' ', ' ', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K', 'A' };

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

        // Prompt for the number of players
        int numPlayers;
        do {
            System.out.println("Enter the number of players (3-4): ");
            numPlayers = sc.nextInt();
            if (numPlayers < 3 || numPlayers > 4) {
                System.out.println("Invalid number of players. Please enter a number between 3 and 4.");
                continue;
            }
            break;
        } while (true);

        // Print the players
        String[] players = new String[numPlayers - 1];
        for (int i = 0; i < numPlayers - 1; i++) {
            players[i] = "Player" + (i + 1);
            System.out.println("Player" + (i + 1) + " has joined the game.");
        }

        // Generate the cards for the user without 7s
        String[] my_cards = new String[13];
        for (int i = 0; i < my_cards.length; i++) {
            String card;
            do {
                card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
            } while (card.charAt(1) == '7'); // Ensure the card is not a 7
            my_cards[i] = card;
        }

        // Create an array for each player
        String[] player1_cards = new String[13];
        String[] player2_cards = new String[13];
        String[] player3_cards = new String[13];

        // Print the user's cards
        System.out.println("Your cards:");
        for (String card : my_cards) {
            System.out.print(card + " ");
        }
        System.out.println();

        // Create an array to keep track of the taken cards
        java.util.List<String> taken_cards = new java.util.ArrayList<>();
        for (String card : my_cards) {
            taken_cards.add(card);
        }

        // Print the the taken cards
        for (int i = 0; i < taken_cards.length; i++) {
            if (taken_cards[i] != null) {
                System.out.print("Index " + i + ": " + taken_cards[i] + " ");
            }
        }
        System.out.println();

        // Generate and printthe cards for the other players without 7s and not
        // overlapping with the user's cards and each other
        for (int i = 0; i < players.length; i++) {

            String[] player_cards = new String[13];
            for (int j = 0; j < player_cards.length; j++) {
                String card;
                do {
                    card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
                } while (card.charAt(1) == '7' || java.util.Arrays.asList(taken_cards).contains(card)); // Ensure the card is not a 7 and already taken
                player_cards[j] = card;
                taken_cards.add(card); // Add the card to the taken cards
            }

            switch (i) {
                case 0:
                    player1_cards = player_cards;
                case 1:
                    player2_cards = player_cards;
                case 2:
                    player3_cards = player_cards;
            }

            System.out.println(players[i] + "'s cards:");
            for (String card : player_cards) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        // Generate the seven desk cards
        String[] seven_desk = new String[4];
        for (int i = 0; i < seven_desk.length; i++) {
            seven_desk[i] = suits[i] + cards[7];
        }

        // Create arrays for each suit
        String[] spade_cards = new String[13];
        String[] heart_cards = new String[13];
        String[] club_cards = new String[13];
        String[] diamond_cards = new String[13];

        int mid_num = 13 / 2 + 1;

        // Assign the seven desk cards to the middle index of each suit array
        spade_cards[mid_num] = seven_desk[0];
        heart_cards[mid_num] = seven_desk[1];
        club_cards[mid_num] = seven_desk[2];
        diamond_cards[mid_num] = seven_desk[3];

        // Print the cards for each suit
        for (int i = 0; i < 13; i++) {
            if (spade_cards[i] != null) {
                System.out.print(spade_cards[i] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < 13; i++) {
            if (heart_cards[i] != null) {
                System.out.print(heart_cards[i] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < 13; i++) {
            if (club_cards[i] != null) {
                System.out.print(club_cards[i] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < 13; i++) {
            if (diamond_cards[i] != null) {
                System.out.print(diamond_cards[i] + " ");
            }
        }
        System.out.println();

        return money;
    }

    public static int shinKoMee(Scanner sc, Random rd, int money) {
        // Placeholder for Shin Ko Mee game logic
        System.out.println("Shin Ko Mee mode is not implemented yet.");
        return money;
    }
}
