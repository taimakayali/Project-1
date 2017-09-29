package com.company;

import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {

        int numGame = 1;

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

        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");

        System.out.println("Choose an option: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        
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
                    } else if (totalHand2 > 21) {
                        System.out.println("You exceeded 21!! You lose :(");
                    } else {
                        System.out.println("1. Get another card");
                        System.out.println("2. Hold hand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                    }
                    break;

                case 2:
                    Random holdHand = new Random();
                    int dealerHand = holdHand.nextInt((26 - 16) + 1) + 16;

                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is " + totalHand);

                    if (dealerHand > 21) {
                        System.out.println("You win!");
                    } else if (dealerHand == totalHand) {
                        System.out.println("It's a tie! No one wins!");
                    } else if (dealerHand > totalHand) {
                        System.out.println("Dealer wins!");
                    } else if (totalHand > dealerHand) {
                        System.out.println("You win!");
                    }
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.err.println("Invalid input!");
                    System.err.println("Please enter an integer value between 1 and 4.");
                    return;

            }

            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");


        }

    }



