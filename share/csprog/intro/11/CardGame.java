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
        
        // Create each suit array
        String[] ini_spade_cards = create_suit(suits[0], cards);
        String[] ini_heart_cards = create_suit(suits[1], cards);
        String[] ini_club_cards = create_suit(suits[2], cards);
        String[] ini_diamond_cards = create_suit(suits[3], cards);

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
        ArrayList<String> my_cards = new ArrayList<>();
        ArrayList<String> player1_cards = new ArrayList<>();
        ArrayList<String> player2_cards = new ArrayList<>();

        // Generate the cards for the user without 7s
        for (int i = 0; i < 16; i++) {
            String card;
            do {
                card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
            } while (java.util.Arrays.asList(taken_cards).contains(card)); // Ensure the card is not already taken
            my_cards.add(card);
        }

        // Add the user's cards to the taken cards
        for (int i = 0; i < my_cards.size(); i++) {
            taken_cards[taken_count] = my_cards.get(i);
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

            ArrayList<String> player_cards = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                String card;
                do {
                    card = suits[rd.nextInt(4)] + cards[rd.nextInt(13) + 2];
                } while (java.util.Arrays.asList(taken_cards).contains(card)); // Ensure the card is not already taken
                player_cards.add(card);
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

        // Check the start and end index of null values in each suit array
        int[] nspades_index = es_index(spade_cards);
        int[] nheart_index = es_index(heart_cards);
        int[] nclub_index = es_index(club_cards);
        int[] ndiamond_index = es_index(diamond_cards);

        // Check and print for the user to have the card that is next to the seven desk card in each suit
        ArrayList<String> playable_card = new ArrayList<>();

        System.out.println("Your playable cards:");
        for (String card : my_cards) {
            if (card != null && (card.charAt(1) == cards[nspades_index[0] - 1] || card.charAt(1) == cards[nspades_index[1] + 1] || card.charAt(1) < cards[nheart_index[0]] || card.charAt(1) > cards[nheart_index[1]] || card.charAt(1) < cards[nclub_index[0]] || card.charAt(1) > cards[nclub_index[1]] || card.charAt(1) < cards[ndiamond_index[0]] || card.charAt(1) > cards[ndiamond_index[1]])) {
                playable_card.add(card);
            }
        }

        for (String pc : playable_card) {
            System.out.print(pc + " ");
        }
        System.out.println();

        int mid_num = get_index(cards, "7") - 2; // Get the index of '7' in the cards array and adjust for suit arrays

        // Create arrays for each suit
        String[] spade_cards = new String[13];
        String[] heart_cards = new String[13];
        String[] club_cards = new String[13];
        String[] diamond_cards = new String[13];

        // Assign the seven desk cards to the middle index of each suit array
        spade_cards[mid_num] = seven_desk[0];
        heart_cards[mid_num] = seven_desk[1];
        club_cards[mid_num] = seven_desk[2];
        diamond_cards[mid_num] = seven_desk[3];
        // Prompt the user to select a playable card
        String selected_card;
        int selected_index;
        do {
            System.out.print("Select a playable card index: ");
            selected_index = sc.nextInt();
        } while (selected_index < 0 || selected_index >= playable_card.size());

        selected_card = playable_card.get(selected_index);

        
        
        // Assign the selected card to the appropriate suit array based on its suit
        if (selected_card.equals(ini_spade_cards[nspades_index[0]])) { // Spade
            spade_cards[nspades_index[0]] = selected_card;
        } else if (selected_card.equals(ini_spade_cards[nspades_index[1]])) {
            spade_cards[nspades_index[1]] = selected_card;
        }else if (selected_card.equals(ini_heart_cards[nheart_index[0]])) { // Heart
            heart_cards[nheart_index[0]] = selected_card;
        } else if (selected_card.equals(ini_heart_cards[nheart_index[1]])) {
            heart_cards[nheart_index[1]] = selected_card;
        }else if (selected_card.equals(ini_club_cards[nclub_index[0]])) { // Club
            club_cards[nclub_index[0]] = selected_card;
        } else if (selected_card.equals(ini_club_cards[nclub_index[1]])) {
            club_cards[nclub_index[1]] = selected_card;
        }else if (selected_card.equals(ini_diamond_cards[ndiamond_index[0]])) { // Diamond
            diamond_cards[ndiamond_index[0]] = selected_card;
        } else if (selected_card.equals(ini_diamond_cards[ndiamond_index[1]])) {
            diamond_cards[ndiamond_index[1]] = selected_card;
        }
        my_cards.remove(selected_card); // Remove the selected card from the user's cards

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
    // Method to count the number of taken cards
    public static int taken_count(String[] taken_cards) {
        int count = 0;
        for (String card : taken_cards) {
            if (card != null) {
                count++;
            }
        }
        return count;
    }
    // Method to print the cards in a suit
    public static void print_cards(String[] cards) {
        for (int i = 0; i < 13; i++) {
            if (cards[i] != null) {
                System.out.print(cards[i] + " ");
            }
        }
        System.out.println();
    }
    // Method to check the start and end index of null values in the suit_cards array
    public static int[] es_index(String[] suit_cards) {
        int start = -1, end = -1;
        // find the start and end index of the suit_cards array
        for (int i = 0; i < suit_cards.length; i++) {
            if (suit_cards[i] != null) {
                start  = i - 1;
                break;
            }
        }
        for (int i = suit_cards.length - 1; i >= 0; i--) {
            if (suit_cards[i] != null) {
                end = i + 1;
                break;
            }
        }
        //return start and end null index of the suit_cards array
        return new int[]{start, end};
    }

    // Method to create each complete suit array
    public static String[] create_suit(String suit, char[] cards) {
        String[] suit_cards = new String[13];
        for (int i = 2; i < cards.length; i++) {
            suit_cards[i - 2] = suit + cards[i];
        }
        return suit_cards;
    }

    // Method to get index from the value in cards
    public static int get_index(char[] cards, String value) {
        for (int i = 0; i < cards.length; i++) {
            if (String.valueOf(cards[i]).equals(value)) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }

    // Method to check playable cards for the user based on the current state of the suit arrays
    public static ArrayList<String> get_playable_cards(
                                                        ArrayList<String> my_cards, 
                                                        char[] cards, 
                                                        int[] nspades_index, 
                                                        int[] nheart_index, 
                                                        int[] nclub_index, 
                                                        int[] ndiamond_index
                                                    ) {

        ArrayList<String> playable_card = new ArrayList<>();
        for (String card : my_cards) {
            if (
                    card != null &&  
                    (
                        card.charAt(1) == cards[nspades_index[0] - 1] || 
                        card.charAt(1) == cards[nspades_index[1] + 1] || 
                        card.charAt(1) == cards[nheart_index[0] - 1] || 
                        card.charAt(1) == cards[nheart_index[1] + 1] || 
                        card.charAt(1) == cards[nclub_index[0] - 1] || 
                        card.charAt(1) == cards[nclub_index[1] + 1] || 
                        card.charAt(1) == cards[ndiamond_index[0] - 1] || 
                        card.charAt(1) == cards[ndiamond_index[1] + 1]
                    )
                ) {

                playable_card.add(card);
            }
        }
        return playable_card;
    }
}
