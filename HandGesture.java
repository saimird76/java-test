package rps;

import java.util.Arrays;
import java.util.List;

public enum HandGesture {
	R, P, S;

	private List<HandGesture> losesToList;

	public boolean losesTo(HandGesture other) {
		return losesToList.contains(other);
	}
	
	static {
		S.losesToList = Arrays.asList(R);
		R.losesToList = Arrays.asList(P);
		P.losesToList = Arrays.asList(S);
	}
	
	public static HandGesture randomHG() {
		return HandGesture.values()[(int) (Math.random() * HandGesture.values().length)];
	}
}
