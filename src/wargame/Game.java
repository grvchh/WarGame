/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

import java.util.*;


public class Game {
    private final Player player1;
    private final Player player2;
    private int round;

    public Game(String name1, String name2, LinkedList<Card> deck1, LinkedList<Card> deck2) {
        this.player1 = new Player(name1, deck1);
        this.player2 = new Player(name2, deck2);
        this.round = 1;
    }

    public void start() {
        while (!player1.hasLost() && !player2.hasLost()) {
            System.out.println("\nRound " + round++);
            System.out.println(player1.getName() + " has " + player1.getDeckSize() + " cards.");
            System.out.println(player2.getName() + " has " + player2.getDeckSize() + " cards.");

            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            List<Card> warPile = new LinkedList<>();
            warPile.add(card1);
            warPile.add(card2);

            while (card1.getRank().getValue() == card2.getRank().getValue()) {
                System.out.println("WAR! Each player places 3 cards face down and 1 face up...");

                if (!player1.canContinueWar() || !player2.canContinueWar()) {
                    declareWinner(player1.canContinueWar() ? player1 : player2);
                    return;
                }

                warPile.addAll(player1.playWarCards());
                warPile.addAll(player2.playWarCards());

                card1 = warPile.get(warPile.size() - 2);
                card2 = warPile.get(warPile.size() - 1);
            }

            if (card1.getRank().getValue() > card2.getRank().getValue()) {
                player1.winCards(warPile.toArray(new Card[0]));
                System.out.println(player1.getName() + " wins this round!");
            } else {
                player2.winCards(warPile.toArray(new Card[0]));
                System.out.println(player2.getName() + " wins this round!");
            }
        }

        declareWinner(player1.hasLost() ? player2 : player1);
    }

    private void declareWinner(Player winner) {
        System.out.println("\nGame Over! " + winner.getName() + " wins!");
    }
}
