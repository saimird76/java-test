package rps;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * @author SAIMIR
 *
 */

public class RockPlayer extends Player {

	HandGesture rockHG;

	public static Map<HandGesture, Integer> counterRPHG = new EnumMap<HandGesture, Integer>(
			HandGesture.class) {
		private static final long serialVersionUID = 1L;

		{
			for (HandGesture item : HandGesture.values())
				put(item, 0);
		}
	};
	
	public RockPlayer() {
		
	}

	public void nextHandGesture() {
		rockHG = HandGesture.R;
		counterRPHG.put(rockHG, counterRPHG.get(rockHG) + 1);
	}

	@Override
	public HandGesture getHandGesture() {
		return rockHG;
	}
	
	public void getMap() {
		for (Map.Entry<HandGesture, Integer> entry : counterRPHG
				.entrySet()) {
			System.out.printf("Rock Player chose %s %d times \n", entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void setHandGesture(String input) {
		// TODO Auto-generated method stub		
	}
}
