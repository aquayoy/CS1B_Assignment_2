
public class Hand {

	public static final int MAX_CARDS = 30;
	private Card[] myCards;
	private int numCards;

	// construtor
	public Hand() {
		this.myCards = new Card[MAX_CARDS];
		this.numCards= 0;
	}

	// remove all cards from the hand
	public void resetHand() {
		this.numCards = 0;
		
	}

	public boolean takeCard(Card card) {
		if (numCards < MAX_CARDS) 
		{
			numCards++;
//			myCards[numCardsInHand - 1] = card;
			 myCards[numCards - 1] = new Card(card);

			return true;
		} 
		else
			return false;

	}

	// returns and removes the card in the top occupied position of the array
	public Card playCard() {
		// >check if the new numCard value will be too low or too high and avoid an ArrayIndexOutOfBoundsException. You should return an error card (a card with the errorFlag set to true) if something like that happens.
		if (numCards<=0 || numCards>MAX_CARDS)
		{	
			Card cardTest=new Card();
			cardTest.set('0', Card.Suit.clubs);
			return cardTest;
		}
		int cardplayed = numCards - 1;
		numCards--;
	
		return myCards[cardplayed];

	}

	public String toString() {
		String returnVal="";

		// >use a loop to iterate though the myCards array and add to returnVal the String returned from calling toString on each card
		for (int i=0;i<numCards;i++) 
		{ 
			returnVal = returnVal +myCards[i].toString()+",";
		}
		
		return returnVal;
	}

	// accesor for numCards
	public int getNumCards() {
		return numCards;
	}

	// accessor for an individual card and returns a card with errorFlag = true if k is bad.
	public Card inspectCard(int k) {
		// >check if k will be too low or too high and avoid an ArrayIndexOutOfBoundsException when you return myCards[k]. You should return an error card (a card with the errorFlag set to true) if something like that happens.
		// >inspectCard(0) should return myCards[0]. Variables for array indexes should be expected to start at zero.
		Card cardTest = new Card();
		if (k>(numCards-1) || k<0)
		{	
			cardTest.set('0', Card.Suit.clubs);
		}
		else
			cardTest = new Card (myCards[k].getValue(),myCards[k].getSuit());
		
		return cardTest;

	}
}
