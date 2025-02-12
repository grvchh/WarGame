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

/**
 *
 * @author Gourav,Dilpreet Singh, Simranpreet Kaur Khattra
 */
public class WarGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Card> cardDeck = new ArrayList<Card>(); //create an ArrayList
        
        for(int x=0; x<4; x++){          //0-3 for 4 suit
            for(int y=2; y<15; y++){     //2-14 for 13  where 14 is for ace
                cardDeck.add(new Card(x,y)); //create new card and add into the deck
            } //end rank for
        }//end suit for
        
        Collections.shuffle(cardDeck, new Random()); //shuffle the deck randomly
        
        //creating 2 decks, each for player1/player2
        LinkedList<Card> deck1 = new LinkedList<Card>();
        LinkedList<Card> deck2 = new LinkedList<Card>();
        
        deck1.addAll(cardDeck.subList(0, 25));                    
        deck2.addAll(cardDeck.subList(26, cardDeck.size()));
        
        while(true){
            Card p1Card = deck1.pop();  //player place one card 
            Card p2Card = deck2.pop();
            
            //display the card
            System.out.println("Player 1 plays card is " + p1Card.toString());
            System.out.println("Player 2 plays card is " + p2Card.toString());
            
            //rank comparition between two cards
            if(p1Card.getCard() > p2Card.getCard()){//if player 1 win 
                deck1.addLast(p1Card);
                deck1.addLast(p2Card); 
                System.out.println("PLayer 1 wins the round");
            }
 
            else if(p1Card.getCard() < p2Card.getCard()){//if player 2 win 
                deck2.addLast(p1Card);   
                deck2.addLast(p2Card);  
                System.out.println("PLayer 2 wins the round");
            }
            
            else { 
                System.out.println("War"); 
                
              
                List<Card> war1 = new ArrayList<Card>(); 
                List<Card> war2 = new ArrayList<Card>();
                
                //check player have enough (4)cards
                for(int x=0; x<3; x++){ 
                    //one player run out of card- game over
                    if(deck1.size() == 0 || deck2.size() == 0 ){                      
                        break;
                    }
                    
                    System.out.println("War card for player1 is xx\nWar card for player2 is xx");

                    war1.add(deck1.pop());  
                    war2.add(deck2.pop());                  
                }
                
                //compare result 
                if(war1.size() == 3 && war2.size() == 3 ){
                    //display the war cards from each player
                    System.out.println("War card for player1 is " + war1.get(0).toString());
                    System.out.println("War card for player2 is " + war2.get(0).toString());
                    
                    //player 1 wins war
                    if(war1.get(2).getCard() > war2.get(2).getCard()){
                        deck1.addAll(war1); //player1 get 10 card
                        deck1.addAll(war2);
                        System.out.println("Player 1 wins the war round");
                    }
                    //playr 2 win war
                    else{
                        deck2.addAll(war1); 
                        deck2.addAll(war2);
                        System.out.println("Player 2 wins the war round");
                    }                      
                }
                
            }
            
            //Game over
            if(deck1.size() == 0 ){
                System.out.println("game over\nPlayer 1 wins the game");
                break;
            }
            else if(deck2.size() == 0){
                System.out.println("game over\nPlayer 2 wins the game");
                break;
            }
        }  

    }
    }

