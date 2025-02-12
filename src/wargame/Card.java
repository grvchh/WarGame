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
    private int rank; 
    private int suit; 
    public Card(int suit, int rank){
        this.rank = rank;
        this.suit = suit;
    }
    public int getCard(){
        return rank; 
    }    
    public void setCard(int rank){
        this.rank = rank;
    }
    @Override
    public String toString(){   
        StringBuilder displayCard = new StringBuilder();
        switch(rank){
            case 11:
                displayCard.append("Jack");
                break;
            case 12:
                displayCard.append("Queen");
                break;
            case 13:
                displayCard.append("King");
                break;
            case 14:
                displayCard.append("Ace");
                break;    
            default:
                displayCard.append(rank); 
                break;
        }
        displayCard.append(" of ");
        switch(suit){
            case 0:
                displayCard.append("Spades");
                break;
            case 1:
                displayCard.append("Hearts");
                break;
            case 2:
                displayCard.append("Clubs");
                break;
            case 3:
                displayCard.append("Diamonds");
                break;
            default: 
                break;
        } 
        return displayCard.toString();
    }  
}
