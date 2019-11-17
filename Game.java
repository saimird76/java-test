package rps;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author SAIMIR
 *
 */

public class Game {

	private static int NUMBER_OF_GAMES = 100;

	static OutCome outCome = null;

	public static Map<OutCome, Integer> countOutCome = new EnumMap<OutCome, Integer>(
			OutCome.class) {
		private static final long serialVersionUID = 1L;
		{
			for (OutCome item : OutCome.values())
				put(item, 0);
		}
	};

	static Player stonePlayer = new RockPlayer();
	static Player inputPlayer = new InputPlayer();

	public static void main(String[] args) {
		greet();
		run();
		getMap();
	}

	private static void run() {
		int i = 0;
		Scanner in = new Scanner(System.in);
		while ((i++ < NUMBER_OF_GAMES) && (in.hasNextLine())) {
			String input = in.nextLine();
			/**
			 * try/catch to make shore we get the correct input
			 * for ease of use we can only type 
			 * 'R' for ROCK, 'P' for PAPER or 'S'for SCISSORS
			 */
			try {
				inputPlayer.setHandGesture(input.toUpperCase());
			} catch (IllegalArgumentException ex) {
				System.out.println("Invalid choice. Only 'R', 'P' or 'S' accepted!");
				/**
				 * for wrong input decrement i, so we do get to play 100 rounds!
				 */
				i--;
				continue;
			}

			stonePlayer.nextHandGesture();
			inputPlayer.nextHandGesture();

			if (stonePlayer.getHandGesture() == inputPlayer.getHandGesture()) {
				// System.out.println(OutCome.TIE.getS());
				// tie++;
				outCome = OutCome.TIE;
				System.out.println(outCome.getS());
				countOutCome.put(outCome, countOutCome.get(outCome) + 1);
			} else if (stonePlayer.getHandGesture().losesTo(
					inputPlayer.getHandGesture())) {
				// System.out.println(OutCome.B_WINS.getS());
				// rndPl_Wins++;
				outCome = OutCome.B_WINS;
				System.out.println(outCome.getS());
				countOutCome.put(outCome, countOutCome.get(outCome) + 1);
			} else {
				// System.out.println(OutCome.A_WINS.getS());
				// rockPl_Wins++;
				outCome = OutCome.A_WINS;
				System.out.println(outCome.getS());
				countOutCome.put(outCome, countOutCome.get(outCome) + 1);
			}
		}
		stonePlayer.getMap();
		inputPlayer.getMap();
	}

	/**
	 * Short introduction of the game and its rules
	 */
	public static void greet() {
		String introText = "Welcome to the Rock-Paper-Scissors game!\nROCK crushes SCISSORS, PAPER wraps ROCK and SCISSORS cuts PAPER";
		System.out.printf("%s", introText);
		
		/**
		 * System.out.println("Welcome to the Rock-Paper-Scissors game!\nROCK crushes SCISSORS, PAPER wraps ROCK and SCISSORS cuts PAPER"
		 * + "Choose 'R' for ROCK, 'P' for PAPER or 'S' for SCISSORS\n");
		 */
	}

	/**
	 * Here make use of enumeration to keep count of win/loss/tie for each player
	 */
	public static void getMap() {
		for (Map.Entry<OutCome, Integer> entry : countOutCome.entrySet()) {
			System.out.printf("%s %d times \n", entry.getKey().getS(),
					entry.getValue());
		}
	}
}
