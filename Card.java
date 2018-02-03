
public class Card {

	enum Suit {
		clubs, diamonds, hearts, spades
	}

	private char value;
	private Suit suit;
	private boolean errorFlag;
	// >add constants for the default value 'A' and default suit Card.Suit.spades
	static final char defaultValue ='A';
	static final Suit defaultSuit = Card.Suit.spades;

	// 3 constructors with no parameters, all parameters, and a copy constructor
	// (with signature public Card(Card card))
	public Card() {

		// >Use my constants in here
		//		this.value = 'A';
		//this.suit = Suit.spades;
		this.value = defaultValue;
		this.suit = defaultSuit;
		
	}

	public Card(char value, Suit suit) {
		set(value, suit);
	}

	public Card(Card card) {
		this.suit = card.suit;
		this.value = card.value;
		// >also set the errorFlag member variable
		this.errorFlag = card.errorFlag;
	}


	// mutator
	public boolean set(char value, Suit suit) {
		char upVal; // for upcasing char
		errorFlag = false; // return value

		this.suit = suit;

		// convert to uppercase to simplify
		upVal = Character.toUpperCase(value);
		value = upVal;
		// check for validity
		// >use your isValid helper method here
		if (isValid(value, suit)) {
			this.value = upVal;
		} else {
			errorFlag = true;
			return errorFlag;	
		}
		//errorFlag = this.isValid(this.value, this.suit);
		return errorFlag;
	}

	// accessors
	public char getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	public boolean isErrorFlag() {
		return errorFlag;
	}

	// boolean equals(Card card) returns true if all the fields (members) are
	// identical
	// >must check errorFlag too
	public boolean equals(Card card) {
		if (card.set(card.getValue(), card.getSuit())==false)
		{	
			if (card.value == this.getValue() && card.suit == this.getSuit())
			{	
				card.toString();
				return true;
			}
			else
				return false;
		}
		else {
			card.toString();
		
			return false;
		}
		
	}

	// stringizer
	public String toString() {
		String retVal;
		String invalid = "*** illegal ***";

		if (errorFlag == true)
			return invalid;
		// >No need to explicitly convert the char to a String, concatenating it with " of " will do that.
		//retVal = String.valueOf(value) + " of " + suit;
		retVal = value + " of " + suit;
		return retVal;
	}


	// a static helper method that returns true or false, depending on the legality of the parameters.
	// >always use curly brackets for ALL of your loops, if, and if-else statements
	static boolean isValid(char value, Suit suit) {
		if (value == 'A' || value == 'K' || value == 'Q' || value == 'J' || value == 'T' || (value >= '2' && value <= '9'))
		{
			return true;
		}
		else
			return false;
	}
}
