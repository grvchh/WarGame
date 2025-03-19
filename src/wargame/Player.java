/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wargame;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author kaush
 */
class Player {
    private String name;
    private LinkedList<Card> deck;
    private int score;
    
    public Player(String name, LinkedList<Card> deck) {
        this.name = name;
        this.deck = deck;
        this.score = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    public void increaseScore() {
        score++;
    }
    
    public void showDeck() {
        System.out.println(name + "'s Deck:");
        for (int i = 0; i < deck.size(); i++) {
            System.out.println((i + 1) + ". " + deck.get(i));
        }
    }
    
    public Card chooseCard(Scanner scanner) {
        showDeck();
        System.out.print(name + ", choose a card to play (1 - " + deck.size() + "): ");
        int choice = scanner.nextInt() - 1;
        while (choice < 0 || choice >= deck.size()) {
            System.out.print("Invalid choice. Try again: ");
            choice = scanner.nextInt() - 1;
        }
        return deck.remove(choice);
    } 
}
