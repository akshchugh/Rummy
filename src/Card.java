
public class Card {
	
	public static final int HEARTS = 0;
	public static final int SPADES = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;

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
}
