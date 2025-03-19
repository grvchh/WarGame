/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 */
public class WarGame {
    public static void main(String[] args) {
        List<Card> cardDeck = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            for (int y = 2; y <= 14; y++) {
                cardDeck.add(new Card(x, y));
            }
        }
        Collections.shuffle(cardDeck, new Random());

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        for (int i = 0; i < 26; i++) {
            player1.addCard(cardDeck.get(i));
            player2.addCard(cardDeck.get(i + 26));
        }

        int round = 1;
        while (round <= 4 && player1.getDeckSize() > 0 && player2.getDeckSize() > 0) {
            System.out.println("Round " + round);
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            if (card1 == null || card2 == null) break;

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getRank() > card2.getRank()) {
                player1.increaseScore();
                System.out.println(player1.getName() + " wins this round!");
            } else if (card1.getRank() < card2.getRank()) {
                player2.increaseScore();
                System.out.println(player2.getName() + " wins this round!");
            } else {
                System.out.println("It's a tie!");
            }
            round++;
            System.out.println();
        }

        System.out.println("Final Scores: ");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a draw!");
        }
    }
}


