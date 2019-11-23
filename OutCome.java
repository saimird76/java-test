package rps;
/**
 * 
 * @author SAIMIR
 * 
 */
public enum OutCome {
	ROUNDS(" played "), WINS(" wins against "), LOOSES(" looses to "), TIE(" TIE ");

	private final String s;

	private OutCome(final String s) {
		this.s = s;
	}
	
	public String getS() {
		return s;
	}
}
