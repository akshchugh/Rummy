import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> normalCards;
	private ArrayList<Card> jokers;

	private ArrayList<ArrayList<Card> > naturalSeq;
	private int numOfSeq;
	private int numOfGroup;
	private int numOfTriplets;
	private int numOfQuadruples;
	//private int numOf

	public Hand() {
		normalCards = new ArrayList<Card>();
		jokers = new ArrayList<Card>();

		this.naturalSeq = new ArrayList<ArrayList<Card>>();

		this.numOfSeq = 0;
		this.numOfGroup = 0;
		this.numOfTriplets = 0;
		this.numOfQuadruples = 0;

	}

	public void add(Card card) {
		if (card.isJoker())
			jokers.add(card);
		else
			normalCards.add(card);
	}

	private ArrayList<Card> getSequenceStartingAt(ArrayList<Card> cards, int start) {

		ArrayList<Card> seqCards = new ArrayList<Card>();
		seqCards.add(cards.get(start));

		for (int i = start; i< cards.size()-1; i++) {
			if(cards.get(i).equals(cards.get(i+1))){
				continue;
			}
			if (cards.get(i).isNext(cards.get(i+1))) {
				seqCards.add(cards.get(i+1));
			} else {
				break;
			}
		}

		for (Card card : seqCards) {
			System.err.print("->"+card);
		}
		if (seqCards.size()>=3)
			return seqCards;
		else
			return null;
	}
	
	private ArrayList<Card> getTripletStartingAt(ArrayList<Card> cards, int start){
		
		ArrayList<Card> tripletCards = new ArrayList<Card>();
		tripletCards.add(cards.get(start));
		
		for (int i = start; i< cards.size()-1; i++) {
			if(cards.get(i).equals(cards.get(i+1))){
				if(cards.get(i).isDifferentSuit(cards.get(i+1))){
					tripletCards.add(cards.get(i+1));
				}
			}
			else {
				break;
			}
		}
		
		for (Card card : tripletCards) {
			System.err.print("->"+card);
		}
		if (tripletCards.size()>=3)
			return tripletCards;
		else
			return null;
	}
	
	public void computenumberofsequences() {
		
		ArrayList<Card> sortedCards = sort();

		print();

		for (int i = 0; i < sortedCards.size(); i++) {

			getSequenceStartingAt(sortedCards, i);
			System.err.println();
		}
	}
	public void getAllCanasta() {
		ArrayList<Card> sortedCards =sort();
		print();
		for (int i = 0; i < sortedCards.size()-2; i++) {
			ArrayList<Card> canastaCards = new ArrayList<Card>();
			if(isCanasta(sortedCards, i)) {
				canastaCards.add(sortedCards.get(i));
				canastaCards.add(sortedCards.get(i + 1));
				canastaCards.add(sortedCards.get(i + 2));
				System.err.println();}
			}
			
	}
	private boolean isCanasta(ArrayList<Card> cards, int start) {
		if (cards.get(start).equals(cards.get(start + 1 )) && cards.get(start).equals(cards.get(start + 2))) {
				return true;
		}
		return false;
	}
	public void computeTriplets(){
		
		ArrayList<Card> sortedCards = sort();
		
		print();
		
		for (int i = 0; i < sortedCards.size(); i++) {
			
			getTripletStartingAt(sortedCards, i);
			System.err.println();
		}
	}
	
	public int minWinMoves() {
		// TODO
		computenumberofsequences();
		computeTriplets();
		return 0;
	}

	public void print() {
		for (Card card : normalCards) {
			System.out.print(card + ", ");
		}
		System.out.println();
	}

	private ArrayList<Card> sort(){
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards);
		normalCards = cards;
		return cards;
	}


	private ArrayList<Card> sortByRank(){
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards,Card.rankComparator());
		return cards;
	}

	private ArrayList<Card> sortBySuit(){
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards,Card.suitComparator());
		return cards;
	}

}
