import java.util.Scanner;

public class ComputerGuesser implements Guesser {

    private static String input;

    @Override
    public String getInput() {
        return input;
    }

    public void makeAGuess() {

        for(int i = 0; i < Main.POSSIBILITIES_COUNT; i++) {

            if(!BullsNCowsUtils.eliminated[i]) {
                BullsNCowsUtils.computersGuess = BullsNCowsUtils.allThePossiblities[i];
                BullsNCowsUtils.eliminated[i] = true;
                break;
            }
        }

        System.out.println("\nComputer's guess is: " + BullsNCowsUtils.computersGuess + "\nEnter number of bulls and number of cows, separated by a single whitespace.");
        Scanner scn = new Scanner(System.in);
        input = (scn.nextLine()).toLowerCase();
    }

    public void endGame() {
        System.out.println("\nThe Computer guessed your number right with " + BullsNCowsUtils.attempts + " attempts.\n\nPlay again? [Y]es/[N]ope");
        Scanner scn = new Scanner(System.in);
        input = (scn.nextLine()).toLowerCase();
    }
}
