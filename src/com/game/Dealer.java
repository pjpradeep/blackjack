package com.game;

public class Dealer extends Gamer{

 
    public Dealer(){

        super.setName("Dealer");

    }
    public void printFirstHand(){
        System.out.println("Dealing to computer, cards:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }
    
    public String toString() {
    	return super.getName() + " with value of " + super.getHand().calculatedValue();
    }



}