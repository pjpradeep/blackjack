package com.game;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Face face;

   public Card(Suit suit, Face face){
       this.suit = suit;
       this.face = face;
   }
   public void setFace(Face face) {
	   this.face=face;
   }

   public Card(Card card){
       this.suit = card.getSuit();
       this.face = card.getFace();
   }

   public int getValue(){
       return face.faceValue;
   }
   public Suit getSuit(){
       return suit;
   }

   public Face getFace(){
       return face;
   }
   public String toString(){
       return ("["+face+" of "+ suit + "] ("+this.getValue()+")");

   }

   @Override
   public int compareTo(Card c) {
       if(this.getValue() > c.getValue()){
           return 1;
       }
       else if(this.getValue() < c.getValue()){
           return -1;
       }
       else{
           return 0;
       }
   }
}
