/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.LinkedList;

/**
 *
 * @author kaush
 */
class Player {
    private final String name;
    private final LinkedList<Card> deck;
    private int score;

    public Player(String name) {
        this.name = name;
        this.deck = new LinkedList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        deck.addLast(card);
    }

    public Card playCard() {
        return deck.isEmpty() ? null : deck.pop();
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
