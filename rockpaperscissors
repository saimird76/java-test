package rps;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * @author SAIMIR
 * use of an abstract is one alternative
 *  
 */

public abstract class Player {
	
	public static Map<HandGesture, Integer> counts = new EnumMap<HandGesture, Integer>(
			HandGesture.class) {
		private static final long serialVersionUID = 1L;

		{
			for (HandGesture item : HandGesture.values())
				put(item, 0);
		}
	};
	
	public abstract void nextHandGesture();
	
	public abstract HandGesture getHandGesture() ;
	
	public abstract void setHandGesture(String input);
	
	public abstract void getMap();
	
}
