import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private ArrayList<Card> normalCards;
	private ArrayList<Card> jokers;
	private int numOfNaturalSeq;
	private int numOfSeq;
	private int numOfGroup;
	private int numOfTriplets;
	private int numOfQuadruples;
	//private int numOf

	public Hand() {
		normalCards = new ArrayList<Card>();
		jokers = new ArrayList<Card>();
		this.numOfNaturalSeq = 0;
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
	
	private boolean isSequence(int start , int end) {
		for (int i = start; i < end && i< normalCards.size(); i++) {
			if (!normalCards.get(start).isNext(normalCards.get(end))) {
				return false;
			}
		}
		return true;
	}
	public void computenumberofsequences() {
		sort();
		int i=0;
		while(i < normalCards.size()) {
			if(isSequence(i,i+2)) {
				numOfSeq+=1;	
				numOfNaturalSeq +=1;
			}
			if(isSequence(i,i+3)) {
				numOfSeq+=1;
				numOfNaturalSeq +=1;
			}
			if(isSequence(i,i+4)) {
				numOfSeq+=1;	
				numOfNaturalSeq +=1;
			}
		}
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
	
	private ArrayList<Card> sort(){
		ArrayList<Card> cards = (ArrayList<Card>) normalCards.clone();
		Collections.sort(cards);
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
