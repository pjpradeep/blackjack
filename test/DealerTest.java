
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.Card;
import com.game.Dealer;
import com.game.Deck;
import com.game.Face;
import com.game.Hand;
import com.game.Suit;

//start of test class
public class DealerTest {
	
	
	Dealer dealerTest = new Dealer();
	
	
	@Test //Compare for equality to test the toString method
	public void testToString() {
		System.out.println(dealerTest.toString());
		assertEquals("Dealer with value of 0", dealerTest.toString());
		
	}//end testToString

	@Test //test for equality with the getName method
	public void testGetName() {
		assertEquals("Dealer", dealerTest.getName());
		
	}//end testGetName

	@Test //Test for equality for the setName method
	public void testSetName() {
		
		dealerTest.setName("TheDealer");
		
		assertEquals("TheDealer", dealerTest.getName());
	}//end testSetName

	@Test //Test for true or false values for the calculatedValue method
	public void testDealerValue() {
		int score = 17;
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card1 = new Card(Suit.CLUB,Face.TEN);
		Card card2 = new Card(Suit.CLUB,Face.FIVE);
		Card card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		dealerTest.setHand(hand);
		
		System.out.println(dealerTest.getHand().calculatedValue());
		//If dealer's score is less than player's, it should return true
		assertEquals(dealerTest.getHand().calculatedValue(), score);
		
		
	}//end testDealerTurn

}//end of class DealerTest