import java.util.Comparator;

public class Card implements Comparable<Card> {

	public static final int HEARTS = 0;
	public static final int SPADES = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;

	private static final int JOKER = 52;

	private int value;
	private int suit;
	private int rank;

	public Card(int value) {
		this.value = value;
		rank = value % 13;
		suit = value / 13;
	}

	public boolean equals(Card card) {
		return this.value == card.value;
	}

	@Override
	public boolean equals(Object obj) {
		return equals((Card) obj);
	}

	public boolean isDifferentSuit(Card card) {
		return this.suit != card.suit;
	}

	public int getSuit() {

		return suit;
	}

	public int getRank() {

		return rank;
	}

	public boolean isSameSuite(Card card) {
		return (this.suit == card.suit);
	}

	public boolean isSameRank(Card card) {
		return (this.rank == card.rank);
	}

	public boolean isPrev(Card card) {
		return (isSameSuite(card) && (this.rank - card.rank) % 13 == 1);
	}

	public boolean isNext(Card card) {
		return (isSameSuite(card) && (card.rank - this.rank) % 13 == 1);
	}

	public boolean isJoker() {
		return (value == JOKER);
	}

	public int compareTo(Card card) {
		return Integer.compare(this.value, card.value);
	}

	@Override
	public String toString() {
		String suit[] = { "H", "S", "D", "C", "Joker" };
		String rank[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };
		return suit[getSuit()] + "-" + rank[getRank()];
	}

	public static Comparator<Card> rankComparator() {
		return (new Comparator<Card>() {

			public int compare(Card o1, Card o2) {
				int i = ((Integer) o1.rank).compareTo(o2.rank);

				if (i != 0)
					return i;
				return ((Integer) o1.getSuit()).compareTo(o2.getSuit());
			}
		});
	}

	public static Comparator<Card> suitComparator() {
		return (new Comparator<Card>() {

			public int compare(Card o1, Card o2) {
				int i = ((Integer) o1.suit).compareTo(o2.suit);

				if (i != 0)
					return i;

				return ((Integer) o1.rank).compareTo(o1.rank);
			}
		});
	}

	Card getNextCard() {
		return new Card((this.suit) * 13 + (this.rank + 1) % 13);
	}

	Card getPrevCard() {
		return new Card((this.suit) * 13 + (this.rank - 1) % 13);
	}

}
