

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package wargame;

/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 * 
 */

import wargame.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class WarGame {
    public static void main(String[] args) {
        List<Card> cardDeck = new LinkedList<>();
        
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardDeck, new Random());

        LinkedList<Card> deck1 = new LinkedList<>(cardDeck.subList(0, 26));
        LinkedList<Card> deck2 = new LinkedList<>(cardDeck.subList(26, 52));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1 Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 Name: ");
        String name2 = scanner.nextLine();

        Game game = new Game(name1, name2, deck1, deck2);
        game.start();
        scanner.close();
    }
}