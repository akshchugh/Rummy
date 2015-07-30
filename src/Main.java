
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Dealer rummyDealer = new Dealer();
		
		Hand rummyHand = rummyDealer.getHand();
		
		System.out.println(rummyHand.minWinMoves());
		
	}

}
