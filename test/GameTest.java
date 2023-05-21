
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.Card;
import com.game.Dealer;
import com.game.Deck;
import com.game.Face;
import com.game.Hand;
import com.game.Player;
import com.game.Suit;

public class GameTest {

	@Test //Test the getValue method by using assertEquals
	public void testDealerHasBlackjack() {
		
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card1 = new Card(Suit.CLUB,Face.TEN);
		Card card2 = new Card(Suit.CLUB,Face.NINE);
		Card card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		dealer.setHand(hand);
		assertTrue(dealer.hasBlackjack());
	}
	@Test //Test the getValue method by using assertEquals
	public void testDealerHasNoBlackJack() {
		
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card1 = new Card(Suit.CLUB,Face.TEN);
		Card card2 = new Card(Suit.CLUB,Face.FIVE);
		Card card3 = new Card(Suit.CLUB,Face.NINE);
		Card card4 = new Card(Suit.CLUB,Face.ACE);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		deck.addCard(card4);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		dealer.setHand(hand);
		assertFalse(dealer.hasBlackjack());
	}
	@Test 
public void testPlayerWinAgainstDealerByBlackjack() {
		
		Dealer dealer = new Dealer();
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
		dealer.setHand(hand);
		
		Player player = new Player();
		hand = new Hand();
		deck = new Deck();
		card1 = new Card(Suit.CLUB,Face.TEN);
		card2 = new Card(Suit.CLUB,Face.NINE);
		card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		player.setHand(hand);
		assertTrue(!dealer.hasBlackjack() && player.hasBlackjack());
	}
	@Test
public void testPlayerLooseAgainstDealerByBlackjack() {
		
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card1 = new Card(Suit.CLUB,Face.TEN);
		Card card2 = new Card(Suit.CLUB,Face.NINE);
		Card card3 = new Card(Suit.CLUB,Face.TWO);
		
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		dealer.setHand(hand);
		
		Player player = new Player();
		hand = new Hand();
		deck = new Deck();
		card1 = new Card(Suit.CLUB,Face.TEN);
		card2 = new Card(Suit.CLUB,Face.FIVE);
		card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		player.setHand(hand);
		assertTrue(dealer.hasBlackjack() && !player.hasBlackjack());
	}
	@Test 
public void testPlayerWinAgainstDealerByNumber() {
		
		Dealer dealer = new Dealer();
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
		dealer.setHand(hand);
		
		Player player = new Player();
		hand = new Hand();
		deck = new Deck();
		card1 = new Card(Suit.CLUB,Face.TEN);
		card2 = new Card(Suit.CLUB,Face.SIX);
		card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		player.setHand(hand);
		assertTrue(player.getHand().calculatedValue() > dealer.getHand().calculatedValue());
	}
	@Test
public void testPlayerLooseAgainstDealerByNumber() {
		
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		Deck deck = new Deck();
		Card card1 = new Card(Suit.CLUB,Face.TEN);
		Card card2 = new Card(Suit.CLUB,Face.SIX);
		Card card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		dealer.setHand(hand);
		
		Player player = new Player();
		hand = new Hand();
		deck = new Deck();
		
		card1 = new Card(Suit.CLUB,Face.TEN);
		card2 = new Card(Suit.CLUB,Face.FIVE);
		card3 = new Card(Suit.CLUB,Face.TWO);
		deck.addCard(card1);
		deck.addCard(card2);
		deck.addCard(card3);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		hand.takeCardFromDeck(deck);
		player.setHand(hand);
		
		assertTrue(player.getHand().calculatedValue() < dealer.getHand().calculatedValue());
	}
}
