package com.game;

import java.util.Random;

public class Strategy {
	
	StrategyType strategyType;
	
	 public enum StrategyType {
	    Defensive(17),
	    Offensive(19),
	    Neutral(18);

	    int limit;

		 StrategyType(int limit) {
	        this.limit = limit;
	    }

	    public String toString(){
	        return limit + "";
	    }
	}
	 
	public Strategy(StrategyType type) {
		strategyType = type;
	}
	
	public int getStrategyLimit() {
		return this.strategyType.limit;
	}
	//Factory method to return a random strategy
	public static Strategy getStrategy() {
		int pick =  new Random().nextInt(StrategyType.values().length);
		StrategyType type = StrategyType.values()[pick];
		return new Strategy(type);
	}
}
