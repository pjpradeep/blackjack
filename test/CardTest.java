import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.Card;
import com.game.Face;
import com.game.Suit;

public class CardTest {
	//Declare various Card objects to test
		Card card1 = new Card(Suit.CLUB,Face.TWO);
		Card card2 = new Card(Suit.CLUB,Face.FIVE);
		Card card3 = new Card(Suit.CLUB,Face.TEN);
		Card card4 = new Card(Suit.CLUB,Face.FIVE);

		@Test //Test the getValue method by using assertEquals
		public void testGetValue() {
			
			assertEquals(2 , card1.getValue());
			
			assertEquals(5 , card2.getValue());
			
			assertEquals(10, card3.getValue());
			
		}//end method testGetValue

		@Test //Test setValue method by setting cards to various values and testing for equality
		public void testSetValue() {
			
			card1.setFace(Face.THREE);
			card2.setFace(Face.NINE);
			
			assertEquals(3, card1.getValue());
			assertEquals(9, card2.getValue());
			
		}//end testSetValue method


}
