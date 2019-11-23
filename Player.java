package rps;
/**
 * 
 * @author SAIMIR
 * 
 */
import java.util.EnumMap;
import java.util.Map;

public class Player {

	HandGesture inputHG; 
	OutCome outCome;

	/**
	 * private modifier for the Mapping of the enumerations so each instance
	 * of the class has its own field variables and methods
	 */
	private Map<HandGesture, Integer> countPHG = new EnumMap<HandGesture, Integer>(
			HandGesture.class) {
		private static final long serialVersionUID = 1L;

		{
			for (HandGesture item : HandGesture.values())
				put(item, 0);
		}
	};
	
	private Map<OutCome, Integer> countOutCome = new EnumMap<OutCome, Integer>(
			OutCome.class) {
		private static final long serialVersionUID = 1L;
		{
			for (OutCome item : OutCome.values())
				put(item, 0);
		}
	};

	/**
	 * We id the player by name
	 */
	private String name;

	/**
	 * An empty constructor
	 */
	public Player() {

	}

	/**
	 * Constructor overloading
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * return chosen hand gesture
	 * @return
	 */
	public HandGesture getInputHG() {
		return inputHG;
	}

	/**
	 * Input player can pick a hand gesture
	 * @param input
	 */
	public void setInputHG(String input) {
		inputHG = HandGesture.valueOf(input);
	}
	
	/**
	 * Rock player pick the hand gesture ROCK/R
	 */
	public void setRockHG() {
		this.inputHG = HandGesture.R;
	}
	
	/**
	 * Computer picks a hand gesture randomly
	 */
	public void setCompHG() {
		this.inputHG = HandGesture.randomHG();
	}

	/**
	 * we get get player name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * we set player name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Here we increment the counter for the chosen hand gesture
	 * enumeration mapping for each instance of class player 
	 */
	public void nextHandGesture() {
		countPHG.put(getInputHG(), countPHG.get(inputHG) + 1);
	}

	/**
	 * a statistic of the hand gestures play by the respective
	 * instance of the class player
	 */
	public void getStatistics() {
		System.out.printf("\n" + getName() + " chose: ");
		for (Map.Entry<HandGesture, Integer> entry : countPHG.entrySet()) {
			System.out.printf("\n %s  %d ", entry.getKey(), entry.getValue());
		}
	}
	/**
	 * returns the outcome we chose to increment for the respective
	 * instance of the class player
	 * @return
	 */
	public OutCome getOutCome() {
		return outCome;
	}
	
	/**
	 * we set the outcome which counter we want to increment for
	 * the respective instance of the class player
	 * @param input
	 */
	public void setOutCome(String input) {
		outCome = OutCome.valueOf(input);
	}

	/**
	 * Same as above we keep track of rounds played, wins, loses, ties
	 * for each instance of class player
	 */
	public void nextOutCome() {
		countOutCome.put(getOutCome(), countOutCome.get(outCome) + 1);
	}
	
	/**
	 * a statistic of rounds played, wins, loses, ties for each
	 * instance of the class player
	 */
	public void getGameStatistics() {
		System.out.printf("\n" + getName() + " played: ");
		for (Map.Entry<OutCome, Integer> entry : countOutCome.entrySet()) {
			System.out.printf("\n %s  %d ", entry.getKey(), entry.getValue());
		}
	}
}
