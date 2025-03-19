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
class Card {
    private final int rank;
    private final int suit;

    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        return ranks[rank - 2] + " of " + suits[suit];
    }
}

