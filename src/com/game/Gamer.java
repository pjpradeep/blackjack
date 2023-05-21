package com.game;

public abstract class Gamer {

    private Hand hand;
    private String name;
    boolean isGameOver = false;
    boolean wonGame = false;
    int victories = 0;
    
    public Gamer(){
        this.hand = new Hand();
        this.name = "";
    }


    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public void printHand(){
        System.out.println("Dealing to " + this.name + ", cards");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    public void hit(Deck deck, Deck discard){

        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
        Game.pause();

    }
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }

}