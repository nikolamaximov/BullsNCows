import java.util.Scanner;

public class UserGuesser implements Guesser {

    private String input;

    @Override
    public String getInput() {
        return input;
    }

    public void makeAGuess() {

        System.out.print("\nMake a guess... "); // add random
        Scanner scn = new Scanner(System.in);
        input = (scn.nextLine()).toLowerCase();
    }

    public void endGame() {

        if(!BullsNCowsUtils.giveUp) {
            System.out.println("\nCongrats! You won the game against the Computer.\n");
        }
        System.out.println("Games won so far: " + BullsNCowsUtils.wins + " of " + BullsNCowsUtils.games + "\nPlay again? [Y]es/[N]ope");
        Scanner scn = new Scanner(System.in);
        input = (scn.nextLine()).toLowerCase();
    }
}
