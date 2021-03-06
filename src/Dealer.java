import java.util.ArrayList;
import java.util.Random;

public class Dealer {
	private static final int NCARDS = 53;
	ArrayList<Integer> usedcards;
	Random random;

	public Dealer() {
		random = new Random();
		usedcards = new ArrayList<Integer>();
	}

	public Hand getHand(int nCardsInHand) {
		Hand hand = new Hand();

		for (int i = 0; i < nCardsInHand; i++) {
			int card;

			do {
				card = random.nextInt(NCARDS * 3);
			} while (usedcards.contains(card));

			
			usedcards.add(card);
			hand.add(new Card(card % NCARDS));
		}

		return hand;
	}

}
