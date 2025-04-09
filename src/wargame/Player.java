/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;



/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

public class Player {
    private final String name;
    private final LinkedList<Card> deck;

    public Player(String name, LinkedList<Card> deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public int getDeckSize() {
        return deck.size();
    }

    public boolean hasLost() {
        return deck.isEmpty();
    }

    public Card playCard() {
        return deck.isEmpty() ? null : deck.removeFirst();
    }

    public void winCards(Card... cards) {
        deck.addAll(Arrays.asList(cards));
    }

    public boolean canContinueWar() {
        return deck.size() >= 4;
    }

    public List<Card> playWarCards() {
        List<Card> warCards = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            warCards.add(deck.removeFirst());
        }
        warCards.add(playCard()); // The deciding card
        return warCards;
    }
}