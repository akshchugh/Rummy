
public class Card implements Comparable<Card>{
	
	public static final int HEARTS = 0;
	public static final int SPADES = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;

	private static final int JOKER = 52;
	
	private int value;
	
	public Card(int value) {
		this.value = value;
	}
	
	public boolean equals(Card card) {
		return this.value == card.value;
	}

	public int getSuit() {
		return value/13;
	}

	public int getRank() {
		return value%13;
	}
	
	public boolean isSameSuite (Card card) {
		return (this.getSuit() == card.getSuit());
	}
	
	public boolean isSameRank (Card card) {
		return (this.getRank() == card.getRank());
	}
	
	public boolean isPrev(Card card){
		return (isSameSuite(card) && (this.value - card.value == 1 || card.value - 12 == this.value));
	}

	public boolean isNext(Card card){
		return (isSameSuite(card) && (card.value - this.value == 1 || this.value - 12 == card.value)); 
	}
	
	public boolean isJoker() {
		return (value == JOKER);
	}
	
	public int compareTo(Card card) {
		return Integer.compare(this.value, card.value);
	}
	
	@Override
	public String toString() {
		String suit[] = {"H","S", "D", "C", "Joker"};
		String rank[] = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10" ,"J", "Q", "K"};
		return suit[getSuit()] +"-"+  rank[getRank()];
	}
	
	
}
