import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        // Variable definitions
        Scanner in = new Scanner(System.in);
        P1Random rng = new P1Random();
        int i = 0, tie = 0, dealerWins = 0, playerWins = 0, game = 1;
        int option;
        String myCard = null;

        while (i != 1) {

            // Generates a random number from 1 to 13 and assigns it its face value
            int playerHand = rng.nextInt(13) + 1;
            int playerHandValue = 0;
            switch (playerHand) {
                case 1:
                    myCard = "ACE";
                    break;
                case 2:
                    myCard = "2";
                    break;
                case 3:
                    myCard = "3";
                    break;
                case 4:
                    myCard = "4";
                    break;
                case 5:
                    myCard = "5";
                    break;
                case 6:
                    myCard = "6";
                    break;
                case 7:
                    myCard = "7";
                    break;
                case 8:
                    myCard = "8";
                    break;
                case 9:
                    myCard = "9";
                    break;
                case 10:
                    myCard = "10";
                    break;
                case 11:
                    myCard = "JACK";
                    playerHand = 10;
                    break;
                case 12:
                    myCard = "QUEEN";
                    playerHand = 10;
                    break;
                case 13:
                    myCard = "KING";
                    playerHand = 10;
                    break;
            }

            //Assigns value to player's hand and outputs game number and player's hand
            playerHandValue = playerHandValue + playerHand;
            System.out.println("START GAME #" + game);
            System.out.println("Your card is a " + myCard + "!");
            System.out.println("Your hand is: " + playerHandValue);

            while (game < 17) {

                //Prints menu
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println("Choose an option: ");
                option = in.nextInt();

                if (option == 1) {

                    //Generates random number from 1 to 13 and assigns it its face value
                    playerHand = rng.nextInt(13) + 1;

                    if (playerHand == 1) {
                        myCard = "ACE";
                    } else if (playerHand == 2) {
                        myCard = "2";
                    } else if (playerHand == 3) {
                        myCard = "3";
                    } else if (playerHand == 4) {
                        myCard = "4";
                    } else if (playerHand == 5) {
                        myCard = "5";
                    } else if (playerHand == 6) {
                        myCard = "6";
                    } else if (playerHand == 7) {
                        myCard = "7";
                    } else if (playerHand == 8) {
                        myCard = "8";
                    } else if (playerHand == 9) {
                        myCard = "9";
                    } else if (playerHand == 10) {
                        myCard = "10";
                    } else if (playerHand == 11) {
                        myCard = "JACK";
                        playerHand = 10;
                    } else if (playerHand == 12) {
                        myCard = "QUEEN";
                        playerHand = 10;
                    } else if (playerHand == 13) {
                        myCard = "KING";
                        playerHand = 10;
                    }
                    playerHandValue = playerHandValue + playerHand;
                    System.out.println("Your card is a " + myCard + "!");
                    System.out.println("Your hand is: " + playerHandValue);

                    //Checks for blackjack or bust

                    if (playerHandValue == 21) {
                        System.out.println("BLACKJACK! You win!");
                        game += 1;
                        playerWins += 1;
                        break;
                    } else if (playerHandValue > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        game += 1;
                        dealerWins += 1;
                        break;
                    }

                } else if (option == 2) {

                    int dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHandValue);

                    //Checks to see who won or if it's a tie
                    if (dealerHand == playerHandValue) {
                        System.out.println("It's a tie! No one wins!");
                        game += 1;
                        tie += 1;
                        break;
                    } else if (dealerHand > 21 && playerHandValue > 21) {
                        System.out.println("It's a tie! No one wins!");
                        game += 1;
                        tie += 1;
                        break;
                    } else if (dealerHand <= 21 && dealerHand > playerHandValue) {
                        System.out.println("Dealer wins!");
                        game += 1;
                        dealerWins += 1;
                        break;
                    } else if (playerHandValue <= 21 && playerHandValue > dealerHand) {
                        System.out.println("You win!");
                        game += 1;
                        playerWins += 1;
                        break;
                    } else if (dealerHand > 21 && playerHandValue <= 21){
                        System.out.println("You win!");
                        game += 1;
                        playerWins += 1;
                        break;
                    }

                } else if (option == 3) {

                    double gameDouble = game, playerWinsDouble = playerWins;
                    double percentPlayerWins = playerWinsDouble / (gameDouble - 1) * 100;

                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tie);
                    System.out.println("Total # of games played is: " + (game - 1));
                    System.out.println("Percentage of Player wins: " + percentPlayerWins + "%");

                } else if (option == 4) {

                    i = 1;
                    break;

                } else {

                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                }
            }
        }
    }
}