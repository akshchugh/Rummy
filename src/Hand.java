import java.util.ArrayList;


public class Hand {
	
	private static final int NCARDS = 13;
	ArrayList<Card> cards;
	
	public Hand() {
		cards = new ArrayList<Card>();
	}

	public void add(Card card) {
		if(cards.size() <= NCARDS)
			cards.add(card);
	}
	
	public int minWinMoves() {
		//TODO 
		return 0;
	}
	
	public void print() {
		for (Card card : cards) {
			System.out.print(card+ ", ");
		}
	}
}
