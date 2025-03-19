package wargame;


import wargame.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
public class WarGame {
    public static void main(String[] args) {
        List<Card> cardDeck = new LinkedList<>();

        // Initialize deck with 52 cards (4 suits, values 2-14)
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 2; rank <= 14; rank++) {
                cardDeck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardDeck, new Random());

        // Split the deck between two players
        LinkedList<Card> deck1 = new LinkedList<>(cardDeck.subList(0, 26));
        LinkedList<Card> deck2 = new LinkedList<>(cardDeck.subList(26, 52));

        int round = 1;
        while (!deck1.isEmpty() && !deck2.isEmpty()) {
            System.out.println("\nRound " + round++);
            System.out.println("Player 1 has " + deck1.size() + " cards.");
            System.out.println("Player 2 has " + deck2.size() + " cards.");

            // Each player plays the top card
            Card p1Card = deck1.removeFirst();
            Card p2Card = deck2.removeFirst();

            System.out.println("Player 1 plays: " + p1Card);
            System.out.println("Player 2 plays: " + p2Card);

            List<Card> warPile = new LinkedList<>();
            warPile.add(p1Card);
            warPile.add(p2Card);

            while (p1Card.getCard() == p2Card.getCard()) { // War condition
                System.out.println("WAR! Each player places 3 cards face down and 1 face up...");

                // If a player has fewer than 4 cards, they lose immediately
                if (deck1.size() < 4) {
                    System.out.println("Player 1 does not have enough cards for war. Player 2 wins!");
                    return;
                } else if (deck2.size() < 4) {
                    System.out.println("Player 2 does not have enough cards for war. Player 1 wins!");
                    return;
                }

                // Each player places 3 face-down cards
                for (int i = 0; i < 3; i++) {
                    warPile.add(deck1.removeFirst());
                    warPile.add(deck2.removeFirst());
                }

                // The next face-up card determines the winner
                p1Card = deck1.removeFirst();
                p2Card = deck2.removeFirst();

                warPile.add(p1Card);
                warPile.add(p2Card);

                System.out.println("Player 1's war card: " + p1Card);
                System.out.println("Player 2's war card: " + p2Card);
            }

            // Determine winner of the round
            if (p1Card.getCard() > p2Card.getCard()) {
                deck1.addAll(warPile);
                System.out.println("Player 1 wins this round!");
            } else {
                deck2.addAll(warPile);
                System.out.println("Player 2 wins this round!");
            }
        }

        // Game Over Message
        if (deck1.isEmpty()) {
            System.out.println("\nGame Over! Player 2 wins!");
        } else {
            System.out.println("\nGame Over! Player 1 wins!");
        }
    }
}