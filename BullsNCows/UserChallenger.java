import java.util.Scanner;
import java.util.Random;

public class UserChallenger implements Challenger {

    public int bulls = 0, cows = 0;

    @Override
    public int getBulls() {
        return bulls;
    }

    @Override
    public int getCows() {
        return cows;
    }

    public void thinkOfANumber(int digCount) {

        System.out.println(
                "Now you have to think of a number that the Computer will try to guess.\n" +
                        "When you're done, hit Enter.\n" +
                        "Tip: ... and try not to forget the number, okay?\n" +
                        "Note: it has to be made up of different digits.\n");
    }

    public void calculateBullsNCows(int digCount) {

        String[] inputSplit = Main.guesser.getInput().split(" ");
        bulls = Integer.parseInt(inputSplit[0]);
        cows = Integer.parseInt(inputSplit[1]);

        for(int i = 0; i < Main.POSSIBILITIES_COUNT; i++) {

            if(BullsNCowsUtils.eliminated[i]) {
                continue;
            }

            int currentBulls = 0;
            int currentCows = 0;

            for(int j = 0; j < digCount; j++) {
                for(int u = 0; u < digCount; u++) {
                    if (BullsNCowsUtils.allThePossiblities[i].charAt(j) == BullsNCowsUtils.computersGuess.charAt(u)) {
                        if(j == u) currentBulls ++;
                        else currentCows ++;
                    }
                }
            }

            if(currentBulls != bulls || currentCows != cows)
                BullsNCowsUtils.eliminated[i] = true;
        }
    }

    public void tellResults() {

        System.out.print("Bulls: ");
        if(bulls != 0)
            System.out.print(bulls + "; ");
        else System.out.print("none; ");

        System.out.print("Cows: ");
        if(cows != 0)
            System.out.println(cows);
        else System.out.println("none");

        System.out.println("Computer's attempts: " + BullsNCowsUtils.attempts);
    }
}
