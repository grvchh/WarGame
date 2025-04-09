/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

/**
 *
 * Represents a playing card with rank and suit.
 * 
 * Follows:
 * - Single Responsibility Principle (SRP): This class only handles card properties.
 * - Encapsulation: Fields are private, access via getters.
 * - Abstraction: Hides internal representation of a card.
 * 
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

// Represents a single card with suit and rank (SRP: Single Responsibility Principle)
public class Card {
    private final Rank rank; // SRP: Each Card object is only responsible for holding its own suit and rank.
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank; // Getter: exposes controlled access
    }

    public Suit getSuit() { 
        return suit;
    }
    
    @Override
    public String toString() {
        return rank.name() + " of " + suit.name(); // Abstraction: shows readable form
    }
}



