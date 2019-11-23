package rps;
/**
 * 
 * @author SAIMIR
 * 
 */
import java.util.Scanner;

public class Game implements Runnable{

	final static Player firstPlayer = new Player();
	final static Player secondPlayer = new Player();
	
	public void run() {
		PlayGame();
	}

	public static void main(String[] args) {
		(new Thread(new Game())).start();
	}

	public static void PlayGame() {
		int rounds = 0;
		Scanner in = new Scanner(System.in);
		String input = null;

		greet();

		while (true) {
			System.out.print("\r");
			input = in.nextLine().toLowerCase().trim();

			if (input.equals("c")) {
				try {
					secondPlayer.setName("Computer");
					secondPlayer.setCompHG();
					rounds = 5;
				} catch (IllegalArgumentException ex) {
					System.out.print("\r");
					System.out.println("\nInvalid choice. Just typ either r for ROCK or c for COMPUTER");
				}
			} else if (input.equals("r")) {
				try {
					secondPlayer.setName("ROCK Player");
					secondPlayer.setRockHG();
					rounds = 100;
				} catch (IllegalArgumentException ex) {
					System.out.print("\r");
					System.out.println("\nInvalid choice.Just type in either R for ROCK or C for COMPUTER");
				}
			}

			input = null;

			System.out.print("\r");
			System.out.println("\nPlayer can pick a Name. Please keep it as tide as possible.\nAlfa numeric characters welcomed!!!\nPlease id Yourself");
			input = in.next();

			if (input != null) {
				try {
					firstPlayer.setName(input.toUpperCase());
				} catch (IllegalArgumentException ex) {
					System.out.print("\r");
					System.out.println("\nInvalid choice!");
				}
			} else {
				firstPlayer.setName("Player One ");
				continue;
			}

			input = null;
			System.out.println("\n" + firstPlayer.getName() + " you chose to play against " + secondPlayer.getName());

			break;
		}

		/**
		 * if we use while loop rounds = 5 or 100
		 * with do/while rounds = 4 or 99
		 * with do/while loop we count down till 0 included
		 * when condition rounds-- != 0 or rounds-- > = 0 otherwise
		 * when condition rounds-- >0 rounds = 5 or 100
		 * while (--rounds != 0) {
		 */
		do{
			if (in.nextLine() != null) {
				/**
				 * try/catch to make shore we get the correct input for ease of
				 * use we can only type 'R' for ROCK, 'P' for PAPER or 'S'for
				 * SCISSORS
				 */
				System.out.println("\n" + firstPlayer.getName() + " take a pick \n");
				
				try {					
					input = in.nextLine();
					firstPlayer.setInputHG(input.toUpperCase());
				} catch (IllegalArgumentException ex) {
					System.out.println("\nInvalid choice. Only 'R', 'P' or 'S' accepted!");
					continue;
				}
			}

			/** 
			 * if we want to have two players who dynamically chose their
			 * hand gestures for each round  
			 * 
			 * System.out.println(secondPlayer.getName() + " take a pick ");
			 * input = in.nextLine();
			 *
			 * try/catch to make shore we get the correct input for ease of use
			 * we can only type 'R' for ROCK, 'P' for PAPER or 'S'for SCISSORS
			 *
			 *
			 * try {
			 * 
			 * secondPlayer.setInputHG(input.toUpperCase()); } catch
			 * (IllegalArgumentException ex) { System.out
			 * .println("\nInvalid choice. Only 'R', 'P' or 'S' accepted!\n");
			 * continue; }
			 */
			
			/**
			 * The nextHandGesture method call for each instance of the Player class
			 * helps keep count of the respective chosen hand gestures by each instance
			 */
			firstPlayer.nextHandGesture();
			secondPlayer.nextHandGesture();

			if (secondPlayer.getInputHG() == firstPlayer.getInputHG()) {
				secondPlayer.setOutCome("TIE");
				secondPlayer.nextOutCome();
				firstPlayer.setOutCome("TIE");
				firstPlayer.nextOutCome();
				System.out.println("\n" + secondPlayer.getName() + " and " + firstPlayer.getName()
						+ secondPlayer.getOutCome().getS());
			} else if (secondPlayer.getInputHG().losesTo(
					firstPlayer.getInputHG())) {
				secondPlayer.setOutCome("LOOSES");
				secondPlayer.nextOutCome();
				firstPlayer.setOutCome("WINS");
				firstPlayer.nextOutCome();
				System.out.println("\n" + secondPlayer.getName()
						+ secondPlayer.getOutCome().getS()
						+ firstPlayer.getName());
			} else {
				secondPlayer.setOutCome("WINS");
				secondPlayer.nextOutCome();
				firstPlayer.setOutCome("LOOSES");
				firstPlayer.nextOutCome();
				System.out.println("\n" + secondPlayer.getName()
						+ secondPlayer.getOutCome().getS()
						+ firstPlayer.getName());
			}
			secondPlayer.setOutCome("ROUNDS");
			secondPlayer.nextOutCome();
			firstPlayer.setOutCome("ROUNDS");
			firstPlayer.nextOutCome();

			if (secondPlayer.getName() == "Computer")
				secondPlayer.setCompHG();

		}while(--rounds > 0);
		
		firstPlayer.getStatistics();
		secondPlayer.getStatistics();
		secondPlayer.getGameStatistics();
		firstPlayer.getGameStatistics();
	}

	/**
	 * Short introduction of the game and its rules
	 */
	public static void greet() {
		String introText = "\nWelcome to the Rock-Paper-Scissors game!\nROCK crushes SCISSORS, PAPER wraps ROCK and SCISSORS cuts PAPER\nDo YOU want to play against Rockplayer or Computer?\nType in either C for Computer or R for Rock Player\n";
		System.out.printf("%s", introText);

		/**
		 * System.out.println(
		 * "Welcome to the Rock-Paper-Scissors game!\nROCK crushes SCISSORS, PAPER wraps ROCK and SCISSORS cuts PAPER"
		 * + "Choose 'R' for ROCK, 'P' for PAPER or 'S' for SCISSORS\n");
		 */
	}
}
