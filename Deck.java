import java.util.Random;

public class Deck {
	// Private Static Class Constants
	private static final int MAX_PACKS = 6, NUM_CARDS_PER_PACK = 52,
			MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;

	// private instance variables

	// private static member, Card array , containing exactly 52 card references,
	// which point to all the standard cards
	private static Card[] masterPack;

	// Private Member Data
	private Card[] cards;
	private int topCard, numPacks, numCards; // > You all shouldn't have a numCards member variable
	static int counter = 0;

	// Public Methods
	// a constructor that populates the arrays and assigns initial values to
	// members.
	public Deck(int numPacks) {

		// >Validate to check that 1 <= numPacks <= MAX_PACKS
		if (1 <= numPacks && numPacks <= MAX_PACKS) {

			this.numPacks = numPacks;
		}
		cards = new Card[numPacks * NUM_CARDS_PER_PACK];
		numCards = numPacks * NUM_CARDS_PER_PACK;
		topCard = numPacks * NUM_CARDS_PER_PACK;
		for (int i = 1; i <= numPacks; i++)
			Deck.allocateMasterPack();

		// call method init()
		this.init(numPacks);

	}

	public Deck() {
		this.numPacks = 1;
		cards = new Card[numPacks * NUM_CARDS_PER_PACK];
		numCards = numPacks * NUM_CARDS_PER_PACK;
		topCard = numPacks * NUM_CARDS_PER_PACK;
		// for (int i = 1; i <= numPacks; i++)
		Deck.allocateMasterPack();
		// call method init()
		this.init(1);
	}

	/*
	 * helper, a private static methods, a method that will be called by the
	 * constructor Since masterPack[] is a static, unchanging, entity, it need not
	 * be built every time a new Deck is instantiated.
	 */
	private static void allocateMasterPack() {
		// check if method allocateMasterPack() has been called before
		if (counter > 0)
			return;
		// instantiate the array elements
		masterPack = new Card[NUM_CARDS_PER_PACK];

		char val;
		Card.Suit suit;
		int k;
		for (k = 0; k < 4; k++) {
			// set the suit for this loop pass
			switch (k) {
			case 0:
				suit = Card.Suit.clubs;
				masterPack[13 * k] = new Card('A', suit);
				int j;
				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 1:
				suit = Card.Suit.diamonds;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 2:
				suit = Card.Suit.hearts;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 3:
				suit = Card.Suit.spades;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				counter++;
				break;
			}

		}

		for (int a = 0; a < 52; a++) {
			System.out.println(masterPack[a].toString());
		}

		System.out.println(" ");

	}

	/*
	 * re-populate cards[] with the standard 52 กั numPacks cards to restock the deck
	 * (init()) to the original full condition in preparation for a fresh deal
	 */
	public boolean init(int numPacks) {
		// >also make sure numPacks is >=1
		if (numPacks >= 1 && numPacks <= MAX_PACKS) {

			cards = new Card[numPacks * NUM_CARDS_PER_PACK];
			for (int i = 1; i <= numPacks; i++) {
				for (int j = 0 + (i - 1) * NUM_CARDS_PER_PACK; j < i * NUM_CARDS_PER_PACK; j++)
					cards[j] = new Card(masterPack[NUM_CARDS_PER_PACK - (j % 52) - 1]);

			}
			return true;
		}

		else
			return false;

	}

	/*
	 * returns and removes (effectively, not physically) the card in the top
	 * occupied position of cards[] (at the top of the deck). We have to return a
	 * copy of the card, not the actual reference to the object in the cards[] array
	 * since that object is also the object in the masterPack[] array, which the
	 * client must not be allowed to change.
	 */
	public Card dealCard() {

		Card cardDealt;
		if (topCard > 0) {
			// if ((topCard % 52 == 0))
			// cards[topCard - 1] = new Card(masterPack[(NUM_CARDS_PER_PACK - 1)]);
			// else
			// cards[topCard - 1] = new Card(masterPack[(topCard % 52) - 1]);
			cardDealt = cards[topCard - 1];
			// String strCardDealt = cardDealt.toString();
			// System.out.println(strCardDealt);
			topCard--;
			return cardDealt;
		} else
			cardDealt = new Card('0', Card.Suit.clubs);
		// boolean isIllegal = cardDealt.set('0', Card.Suit.clubs);
		return cardDealt;
	}

	// An accessor for the int, topCard (no mutator.)
	/*
	 * The method getTopCard() should be called getNumCards() because otherwise it
	 * sounds like you are getting a Card object when you are really getting an int
	 * returned.
	 */
	public int getNumCards() {

		return topCard;

	}

	/*
	 * Accessor for an individual card. Returns a card with errorFlag = true if k is
	 * bad. Otherwise returns a copy of the card (see admonition for dealCard())
	 */
	public Card inspectCard(int k) {
		Card cardTest = null;
		if (k > topCard - 1) {
			cardTest = new Card();
			cardTest.set('0', Card.Suit.clubs);
		} else
			cardTest = new Card(cards[k].getValue(), cards[k].getSuit());

		return cardTest;
	}

	// to re-order the cards in a random fashion
	public void shuffle() {
		// this.init(numPacks);
		// Card shuffleClone = new Card();
		Card shuffleClone;
		Random random = new Random();
		int r1, r2;
		for (int i = 0; i < numCards; i++) {
			r1 = random.nextInt(numCards - 1);
			r2 = random.nextInt(numCards - 1);
			shuffleClone = cards[r1];
			cards[r1] = cards[r2];
			cards[r2] = shuffleClone;
		}
	}

}
