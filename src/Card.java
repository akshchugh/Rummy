
public class Card {
	
	public static char HEARTS = 'h';
	public static char spades = 's';
	public static char diamonds = 'd';
	public static char clubs = 'c';

	private char suit;
	private char values;
	
	public Card(char suit, char values) {
		this.suit = suit;
		this.values = values;
	}

	public char getSuit() {
		return suit;
	}

	public char getValues() {
		return values;
	}

}
