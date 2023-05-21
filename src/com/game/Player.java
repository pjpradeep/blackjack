package com.game;

import java.util.Scanner;

public class Player extends Gamer {

    Scanner input = new Scanner(System.in);
    
    public Player() {
    	super();
    }

    public void makeDecision(Deck deck, Deck discard) {

        int  decision = 0;
        boolean getNum = true;
        
        while(getNum){
            try{
                System.out.println(this.getName() + " :: 1) Hit or 2) Stand ?");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
        }

        if (decision == 1) {
            this.hit(deck, discard);
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                this.makeDecision(deck, discard);
            }

        } else {
            System.out.println(this.getName() + " stand.");
        }

    }

}
