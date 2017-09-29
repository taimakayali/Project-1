package com.company;

import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {

        int numGame = 1;
        boolean continuePlaying = true;

        while (continuePlaying == true) {

            System.out.println("START GAME # " + numGame++);

            Random hand = new Random();
            int card = hand.nextInt((13 - 1) + 1) + 1;

            int totalHand = 0;
            totalHand = totalHand + card;

            int totalHandAces = 0; // total hand values for Face Cards and Aces


            int totalHandFaceCards = 0;
            totalHandFaceCards = totalHandAces + 10; // adds 10 to player's hand

            int handAceCard = 0;
            handAceCard = totalHandAces + 1; // adds 1 to player's hand

            int playerWins = 0;
            int dealerWins = 0;
            int playersTie = 0;


            if (card == 1) {
                System.out.println("Your card is a ACE!");
                System.out.println("Your hand is " + handAceCard + "!");
            } else if ((card > 1) && (card < 11)) {
                System.out.println("Your card is a " + card + "!");
                System.out.println("Your hand is " + totalHand + "!");
            } else if (card == 11) {
                System.out.println("Your card is a JACK!");
                System.out.println("Your hand is " + totalHandFaceCards + "!");
            } else if (card == 12) {
                System.out.println("Your card is a QUEEN!");
                System.out.println("Your hand is " + totalHandFaceCards + "!");
            } else if (card == 13) {
                System.out.println("Your card is a KING!");
                System.out.println("Your hand is " + totalHandFaceCards + "!");
            }

            // Setting face card values after first draw
            int Ace = 1;
            int Jack = 10;
            int Queen = 10;
            int King = 10;

            int option = 0;
            while (option != 4) {

                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");

                System.out.println("Choose an option: ");
                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();

                boolean gameOver = false;

                while (gameOver == false) {

                    switch (option) {
                        case 1:
                            Random hand2 = new Random();
                            int card2 = hand2.nextInt((13 - 1) + 1) + 1;

                            int totalHand2 = 0;
                            totalHand2 = totalHand2 + card2 + card;

                            System.out.println("Your card is a " + card2 + "!");
                            System.out.println("Your hand is " + totalHand2 + "!");

                            if (totalHand2 == 21) {
                                System.out.println("BLACKJACK! You win!");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (totalHand2 > 21) {
                                System.out.println("You exceeded 21!! You lose :(");
                                dealerWins++;
                                numGame++;
                                gameOver = true;
                            }
                            break;

                        case 2:
                            Random holdHand = new Random();
                            int dealerHand = holdHand.nextInt((26 - 16) + 1) + 16;

                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is " + totalHand);

                            if (dealerHand > 21) {
                                System.out.println("You win!");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (dealerHand == totalHand) {
                                System.out.println("It's a tie! No one wins!");
                                playersTie++;
                                numGame++;
                                gameOver = true;
                            } else if (dealerHand > totalHand) {
                                System.out.println("Dealer wins!");
                                dealerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (totalHand > dealerHand) {
                                System.out.println("You win!");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            }
                            break;

                        case 3:
                            System.out.println("Number of player wins: " + playerWins);
                            System.out.println("Number of dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + playersTie);
                            System.out.println("Total # of games played is: " + numGame);

                            double decimalPlayWins = ((playerWins) / (numGame));

                            double percentPlayWins = decimalPlayWins * 100;
                            int percentPlayWinners = (int) percentPlayWins; // casting for the percentage


                            System.out.println("Percentage of Player wins: " + percentPlayWinners + "%");
                            break;

                        case 4:
                            continuePlaying = false;
                            return;

                        default:
                            System.err.println("Invalid input!");
                            System.err.println("Please enter an integer value between 1 and 4.");
                            break;

                    }


                }
            }
        }
    }
}








