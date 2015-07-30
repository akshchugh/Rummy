
public class Card {
	
	public static int HEARTS = 0;
	public static int spades = 1;
	public static int diamonds = 2;
	public static int clubs = 3;

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

	public int getValues() {
		return value%13;
	}
	
	public boolean isPrev(Card card){
		return (this.value - card.value == 1);
	}

	public boolean isNext(Card card){
		return (card.value - this.value == 1); 
	}
}
