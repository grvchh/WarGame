/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 */
class WarGame {
    private Player player1;
    private Player player2;
    private int round;
    private final int maxRounds = 4;
    
    public WarGame(String name1, String name2) {
        List<Card> cardDeck = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            for (int y = 2; y < 15; y++) {
                cardDeck.add(new Card(x, y));
            }
        }
        Collections.shuffle(cardDeck);
        
        LinkedList<Card> deck1 = new LinkedList<>(cardDeck.subList(0, 26));
        LinkedList<Card> deck2 = new LinkedList<>(cardDeck.subList(26, 52));
        
        this.player1 = new Player(name1, deck1);
        this.player2 = new Player(name2, deck2);
        this.round = 1;
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        
        while (round <= maxRounds) {
            System.out.println("\n--- Round " + round + " ---");
            Card card1 = player1.chooseCard(scanner);
            Card card2 = player2.chooseCard(scanner);
            
            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);
            
            if (card1.getRank() > card2.getRank()) {
                System.out.println(player1.getName() + " wins this round!");
                player1.increaseScore();
            } else if (card1.getRank() < card2.getRank()) {
                System.out.println(player2.getName() + " wins this round!");
                player2.increaseScore();
            } else {
                System.out.println("It's a tie!");
            }
            round++;
        }
        scanner.close();
        displayWinner();
    }
    
    private void displayWinner() {
        System.out.println("\n--- Game Over ---");
        System.out.println(player1.getName() + "'s Score: " + player1.getScore());
        System.out.println(player2.getName() + "'s Score: " + player2.getScore());
        
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String name2 = scanner.nextLine();
        
        WarGame game = new WarGame(name1, name2);
        game.playGame();
    }
}


