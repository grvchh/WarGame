/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;



/**
 *Represents a game player and manages their deck.
 * 
 * Follows:
 * - SRP: Handles only player-related responsibilities.
 * - Encapsulation: Deck and name are private.
 * - Abstraction: Interacts with deck through methods like playCard(), winCards().
 * 
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

public class Player {
    
    private final String name; // Encapsulated player name
    private final LinkedList<Card> deck; // Encapsulated deck of cards
    private List<Card> cards; // or Queue<Card> cards;

    
    public Player(String name, LinkedList<Card> deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public int getDeckSize() {
        return deck.size(); // Provides current deck size
    }

    public boolean hasLost() {
        return deck.isEmpty(); // Abstracts how loss is determined
    }

    public Card playCard() {
        return deck.isEmpty() ? null : deck.removeFirst(); // Removes and returns top card
    }

    public void winCards(Card... cards) {
        deck.addAll(Arrays.asList(cards)); // Adds cards to the deck
    }

    public int getCardCount() {
        return cards.size(); // or however you're storing cards
    }

    public boolean canContinueWar() {
        return deck.size() >= 4; // Checks if player has enough cards for war
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