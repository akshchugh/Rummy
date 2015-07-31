import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand {

	private ArrayList<Card> normalCards;
	private ArrayList<Card> jokers;

	public Hand() {
		normalCards = new ArrayList<Card>();
		jokers = new ArrayList<Card>();
	}

	public void add(Card card) {
		if (card.isJoker())
			jokers.add(card);
		else
			normalCards.add(card);
	}

	public int minWinMoves() {
		// TODO
		return 0;
	}

	public void print() {
		for (Card card : normalCards) {
			System.out.print(card + ", ");
		}
		System.out.println();
	}
	
	private void sort(){
		Collections.sort(normalCards);
	}
	
	
	private void sortByRank(){
		Collections.sort(normalCards,Card.rankComparator());
	}
	
	private void sortBySuit(){
		Collections.sort(normalCards,Card.suitComparator());
	}
	
}
