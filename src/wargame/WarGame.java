

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package wargame;

/**
 *
 * Main class: Initializes game setup and starts the game.
 * 
 * Follows:
 * - Separation of Concerns: Only handles input, deck setup, and game starting.
 * - Delegation: Actual game logic is in Game class.
 * 
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

import Controller.Game;
import Model.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Model.Card;
import Model.Rank;
import Model.Suit;


public class WarGame {
    public static void main(String[] args) {
        List<Card> cardDeck = new LinkedList<>();
        
        // Create full deck of 52 cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardDeck, new Random());

        // Divide deck between two players
        LinkedList<Card> deck1 = new LinkedList<>(cardDeck.subList(0, 26));
        LinkedList<Card> deck2 = new LinkedList<>(cardDeck.subList(26, 52));

        // Take player input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1 Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 Name: ");
        String name2 = scanner.nextLine();

        // Create game and start it
        Game game = new Game(name1, name2, deck1, deck2);
        game.start();
        scanner.close();
    }
}