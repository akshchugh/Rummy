import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> normalCards;
	private ArrayList<Card> jokers;
	
	private ArrayList<Card> done;

	// private int numOf

	public Hand() {
		normalCards = new ArrayList<Card>();
		jokers = new ArrayList<Card>();
		done = new ArrayList<Card>();
	}

	public void add(Card card) {
		if (card.isJoker())
			jokers.add(card);
		else
			normalCards.add(card);
	}

	private ArrayList<Card> getSequenceStartingAt(ArrayList<Card> cards,
			int start) {

		ArrayList<Card> seqCards = new ArrayList<Card>();
		seqCards.add(cards.get(start));

		for (int i = start; i < cards.size() - 1; i++) {
			if (cards.get(i).equals(cards.get(i + 1))) {
				continue;
			}
			if (cards.get(i).isNext(cards.get(i + 1))) {
				seqCards.add(cards.get(i + 1));
			} else {
				break;
			}
		}
		
		if (seqCards.size() >= 3)
			return seqCards;
		else
			return null;
	}

	private ArrayList<Card> getTripletStartingAt(ArrayList<Card> cards,
			int start) {

		ArrayList<Card> tripletCards = new ArrayList<Card>();
		tripletCards.add(cards.get(start));

		for (int i = start; i < cards.size() - 1; i++) {
			Card currCard = cards.get(i);
			Card nextCard = cards.get(i + 1);
			if (currCard.isSameRank(nextCard)) {

				if (currCard.isDifferentSuit(nextCard)) {
					tripletCards.add(nextCard);
				}

			} else {
				break;
			}
		}

		if (tripletCards.size() >= 3)
			return tripletCards;
		else
			return null;
	}

	public void removeSequences() {

		ArrayList<Card> sortedCards = sort();

		for (int i = 0; i < sortedCards.size(); i++) {

			ArrayList<Card> sequence = getSequenceStartingAt(sortedCards, i);
			
			if (sequence != null) {
				done.addAll(sequence);
				normalCards.removeAll(sequence);
			}
		}
	}

	public void removeTriplets() {

		ArrayList<Card> sortedCards = sortByRank();

		for (int i = 0; i < sortedCards.size(); i++) {
			ArrayList<Card> triplet = getTripletStartingAt(sortedCards, i);
			
			if (triplet != null) {
				done.addAll(triplet);
				normalCards.removeAll(triplet);
			}
		}
	}

	
	public void removeAllCanasta() {
		ArrayList<Card> sortedCards = sort();
		for (int i = 0; i < sortedCards.size() - 2; i++) {
			if (isCanasta(sortedCards, i)) {
				
				Card currCard = sortedCards.get(i);
				done.add(currCard);
				done.add(currCard);
				done.add(currCard);
				
				normalCards.remove(currCard);
				normalCards.remove(currCard);
				normalCards.remove(currCard);
				i += 2;
			}
		}

	}

	private boolean isCanasta(ArrayList<Card> cards, int start) {
		if (cards.get(start).equals(cards.get(start + 1))
				&& cards.get(start).equals(cards.get(start + 2))) {
			return true;
		}
		return false;
	}

	public int minWinMoves() {
		// TODO
		print();
		removeAllCanasta();
		print();
		removeSequences();
		print();
		removeTriplets();
		print();
		return 0;
	}

	public void print() {
		for (Card card : normalCards) {
			System.out.print(card + ", ");
		}
		System.out.println();
	}

	private ArrayList<Card> sort() {
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards);
		normalCards = cards;
		return cards;
	}

	private ArrayList<Card> sortByRank() {
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards, Card.rankComparator());
		return cards;
	}

	private ArrayList<Card> sortBySuit() {
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards, Card.suitComparator());
		return cards;
	}

}
