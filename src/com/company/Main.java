package com.company;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Main {

    public static void main(String[] args) {

        int Ace = 1;
        int Jack = 10;
        int Queen = 10;
        int King = 10;
        int playerWins = 0;
        int dealerWins = 0;
        int playersTie = 0;
        int numGame = 1;
        boolean continuePlaying = true;

        while (continuePlaying == true) { // while loop for start game

            System.out.println("START GAME # " + numGame + "\n");

            Random hand = new Random();
            int card = hand.nextInt((13 - 1) + 1) + 1;

            int totalHand = 0;
            int totalHandAces = 0; // total hand values for Aces
            int totalHandFaceCards = 0; // total hand values for Face Cards
            int handAceCard = 0; // hand for Ace Cards

            totalHand = totalHand + card; // how to calculate player's total hand
            totalHandFaceCards = totalHandAces + 10; // adds 10 to player's hand
            handAceCard = totalHandAces + 1; // adds 1 to player's hand


            if (card == 1) {
                System.out.println("Your card is a ACE!");
                System.out.println("Your hand is " + handAceCard + "!\n");
            } else if ((card > 1) && (card < 11)) {
                System.out.println("Your card is a " + card + "!");
                System.out.println("Your hand is " + totalHand + "!\n");
            } else if (card == 11) {
                System.out.println("Your card is a JACK!");
                System.out.println("Your hand is " + totalHandFaceCards + "!\n");
            } else if (card == 12) {
                System.out.println("Your card is a QUEEN!");
                System.out.println("Your hand is " + totalHandFaceCards + "!\n");
            } else if (card == 13) {
                System.out.println("Your card is a KING!");
                System.out.println("Your hand is " + totalHandFaceCards + "!\n");
            }


            boolean gameOver = false; // while loop for dealer/player wins
            while (gameOver == false) {

                Scanner scan = new Scanner(System.in);
                int option = 0; // scanner for option menu

                while (option < 1 || option > 4) { // while loop for try catch statement

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit\n");

                    System.out.println("Choose an option: ");

                    try {
                        option = scan.nextInt();
                        if (option < 1 || option > 4) {
                            throw new InputMismatchException();
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("\nInvalid input!\nPlease enter an integer value between 1 and 4.\n");
                        scan.nextLine();
                    }
                }
                    // OPTION MENU

                    switch (option) {
                        case 1:
                            Random hand2 = new Random();
                            int card2 = hand2.nextInt((13 - 1) + 1) + 1;

                            totalHand = card + card2;

                            System.out.println("\nYour card is a " + card2 + "!");
                            System.out.println("Your hand is " + totalHand + "!\n");

                            if (totalHand == 21) {
                                System.out.println("BLACKJACK! You win!\n");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (totalHand > 21) {
                                System.out.println("You exceeded 21!! You lose :(\n");
                                dealerWins++;
                                numGame++;
                                gameOver = true;
                            }
                            break;

                        case 2:
                            Random holdHand = new Random();
                            int dealerHand = holdHand.nextInt((26 - 16) + 1) + 16;

                            System.out.println("\nDealer's hand: " + dealerHand);
                            System.out.println("Your hand is " + totalHand + "\n");

                            if (dealerHand > 21) {
                                System.out.println("You win!\n");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (dealerHand == totalHand) {
                                System.out.println("It's a tie! No one wins!\n");
                                playersTie++;
                                numGame++;
                                gameOver = true;
                            } else if (dealerHand > totalHand) {
                                System.out.println("Dealer wins!\n");
                                dealerWins++;
                                numGame++;
                                gameOver = true;
                            } else if (totalHand > dealerHand) {
                                System.out.println("You win!\n");
                                playerWins++;
                                numGame++;
                                gameOver = true;
                            }
                            break;

                        case 3:
                            System.out.println("\nNumber of player wins: " + playerWins);
                            System.out.println("Number of dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + playersTie);
                            System.out.println("Total # of games played is: " + numGame);

                            double decimalPlayWins = ((playerWins) / ((double)numGame));

                            double percentPlayWins = decimalPlayWins * 100;
                            int percentPlayWinners = (int) percentPlayWins; // casting for the percentage

                            System.out.println("Percentage of Player wins: " + percentPlayWinners + "%\n");
                            break;

                        case 4:
                            continuePlaying = false; // end of while loop
                            return;
                    }
                }
            }
        }
    }









