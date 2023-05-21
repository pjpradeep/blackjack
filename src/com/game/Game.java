package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	
    Scanner input = new Scanner(System.in);

    private Deck deck, discarded;
    private Dealer dealer;
    public static int BJ_WIN = 21;
    private int noOfPlayers = 3;
    List<Player> players = new ArrayList<Player>();
    Strategy dealersStrategy = Strategy.getStrategy();
    public Game(boolean startGame){
    	getNoOfPlayers();
    	deck = new Deck(true);
        discarded = new Deck();
        dealer = new Dealer();
        players = new ArrayList<Player>();
        for(int i=0;i<noOfPlayers;i++) {
        	Player player = new Player();
        	int playerNo = i + 1;
        	player.setName("Player " + playerNo);
            players.add(player);
        }
        deck.shuffle();
        if(startGame)
        	startGame();
    }
    public Game(){
    	this(true);
    	
    }
    public void startGame() {
    	startRound();
    }
    private void initialize() {
    	deck = new Deck(true);
        discarded = new Deck();
        dealer = new Dealer();
        players.forEach(player -> {
        	player.isGameOver=false;
        	player.wonGame=false;
        	player.setHand(new Hand());
        });
    }
    public void startRound(){
    
    	System.out.println("#####################################################################################");
        System.out.println("Starting New Round...");
        System.out.println("#####################################################################################");        
        //No cards left..reload
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }
        //Give all players including dealer one card each
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        dealer.printFirstHand();
        players.forEach(player -> {
        	player.getHand().takeCardFromDeck(deck);
            player.getHand().takeCardFromDeck(deck);
            player.printHand();
            if(dealer.hasBlackjack()){
                dealer.printHand();
                if(player.hasBlackjack()){
                    System.out.println(player.getName() + " and dealer have 21 - Push.");
                    player.isGameOver = true;
                    player.wonGame = true;
                    player.victories++;
                }
                else{
                    System.out.println("Dealer has BlackJack" + player.getName() +" lose.");
                    dealer.printHand();
                    player.isGameOver = true;
                }
            }
            if(player.hasBlackjack()){
                System.out.println(player.getName() + " has Blackjack! Won!");
                player.isGameOver = true;
                player.wonGame = true;
                player.victories++;
            }
        });
        players.forEach(player -> {
        	if(!player.isGameOver) {
        	player.makeDecision(deck, discarded);
        	
            if(player.hasBlackjack()){
                System.out.println(player.getName() +" have Blackjack! Won!");
                player.isGameOver = true;
                player.wonGame = true;
                player.victories++;
            }
            if(player.getHand().calculatedValue() > BJ_WIN){
                System.out.println(player.getName() + " Busted over 21.");
                player.isGameOver = true;
            }
        	}
        });
        boolean dealerPlayOn = players.stream().filter(player ->!player.isGameOver).findAny().isPresent();
        if(dealerPlayOn) {//check if deals has to play or not
	        dealer.printHand();
	        while(dealer.getHand().calculatedValue()< dealersStrategy.getStrategyLimit()){
	            dealer.hit(deck, discarded);
	            dealer.printHand();
	        }
	        if(dealer.getHand().calculatedValue()>BJ_WIN){
	            System.out.println("Dealer busts");
	            players.forEach(player -> {//since dealer busted, players win if they have not lost yet
	            	if(!player.isGameOver) {
	            		player.isGameOver=true;
	            		player.wonGame=true;
	            		player.victories++;
	            	}
	            });
	        }
	        else {
	        	players.forEach(player -> {
	        	if(!player.isGameOver) {
		    		if(dealer.hasBlackjack()){
		                    System.out.println("Dealer has BlackJack." +player.getName() +" lose.");
		                    player.isGameOver = true;
		            }
		            if(player.hasBlackjack()){
		                System.out.println(player.getName() + " has Blackjack! Won!");
		                player.isGameOver = true;
		                player.wonGame = true;
		                player.victories++;
		            }
			        if(!player.isGameOver && dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
			            System.out.println(player.getName() + " lose.");
			            player.isGameOver = true;
			        }
			        else if(!player.isGameOver && player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
			            System.out.println(player.getName() + " won.");
			            player.isGameOver = true;
		                player.wonGame = true;
		                player.victories++;
			        }
	        	}
	        	});
	        }
        }
        System.out.println("Final Result of the round");
        players.forEach(player -> {
        	String wonLost = player.wonGame? " Won this game" :" Lost this game";
        	System.out.println();
        	System.out.println(player.getName() +  wonLost);
        	System.out.println(player.getName() + " Total Victories : " + player.victories);
        	System.out.println();
        });
        pause();
        System.out.println();
        System.out.println();
        initialize();
        startRound();
    }


	public static void pause(){
	    try {
	        Thread.sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	public int getNoOfPlayers() {
		boolean getNum = true;
		while(getNum){
	        try{
	            System.out.println("Enter Number of Players ::?");
	            noOfPlayers = input.nextInt();
	            getNum = false;
	
	        }
	        catch(Exception e){
	            System.out.println("Invalid");
	            input.next();
	        }
	    }
	    return noOfPlayers;
	}
}