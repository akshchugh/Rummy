
public class Main {

	/**
	 * @param args
	 */
	private static final int NCARDS = 13;
	public static void main(String[] args) {
		
		Dealer rummyDealer = new Dealer();
		
		Hand rummyHand = rummyDealer.getHand(NCARDS);
		
		rummyHand.print();
		System.out.println(rummyHand.minWinMoves());
		
	}

}
