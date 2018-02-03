
public class Hand {

	public static final int MAX_CARDS = 30;
	private Card[] myCards;
	private int numCardsInHand;

	// construtor
	public Hand() {
		this.myCards = new Card[MAX_CARDS];
		this.numCardsInHand = 0;
	}

	// remove all cards from the hand
	public void resetHand() {
		this.numCardsInHand = 0;
		
	}

	public boolean takeCard(Card card) {
		if (numCardsInHand < MAX_CARDS) 
		{
			numCardsInHand++;
//			myCards[numCardsInHand - 1] = card;
			 myCards[numCardsInHand - 1] = new Card(card);

			return true;
		} 
		else
			return false;

	}

	// returns and removes the card in the top occupied position of the array
	public Card playCard() {
		// >check if the new numCard value will be too low or too high and avoid an ArrayIndexOutOfBoundsException. You should return an error card (a card with the errorFlag set to true) if something like that happens.
		if (numCardsInHand<=0 || numCardsInHand>MAX_CARDS)
		{	
			Card cardTest=new Card();
			cardTest.set('0', Card.Suit.clubs);
			return cardTest;
		}
		int cardplayed = numCardsInHand - 1;
		numCardsInHand--;
	
		return myCards[cardplayed];

	}

	public String toString() {
		String returnVal="";

		// >use a loop to iterate though the myCards array and add to returnVal the String returned from calling toString on each card
		for (int i=0;i<numCardsInHand;i++) 
		{ 
			returnVal = returnVal +myCards[i].toString()+",";
		}
		
		return returnVal;
	}

	// accesor for numCardsInHand
	public int getNumCardsInHand() {
		return numCardsInHand;
	}

	// accessor for an individual card and returns a card with errorFlag = true if k is bad.
	public Card inspectCard(int k) {
		// >check if k will be too low or too high and avoid an ArrayIndexOutOfBoundsException when you return myCards[k]. You should return an error card (a card with the errorFlag set to true) if something like that happens.
		Card cardTest = new Card();
		if (k>numCardsInHand || k<=0)
		{	
			cardTest.set('0', Card.Suit.clubs);
		}
		else
			cardTest = new Card (myCards[k-1].getValue(),myCards[k-1].getSuit());
		
		return cardTest;

	}
}
