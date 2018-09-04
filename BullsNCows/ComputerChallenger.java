import java.util.Random;

public class ComputerChallenger implements Challenger {

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
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(digCount);

        sb.append((char)('1' + rnd.nextInt(9)));
        for(int i=1; i < digCount; i++)
        {
            char nextDigit = (char) ('0' + rnd.nextInt(10));
            sb.append(nextDigit);
        }

        BullsNCowsUtils.setWinningNumber(sb.toString());
    }

    public void calculateBullsNCows(int digCount) {

        bulls = 0;
        cows = 0;

        for(int i = 0; i < digCount; i++) {
            for(int j = 0; j < digCount; j++) {
                if (BullsNCowsUtils.getWinningNumber().charAt(i) == BullsNCowsUtils.getGuess().charAt(j)) {
                    if(i == j) bulls ++;
                    else cows ++;
                }
            }
        }
    }

    public void tellResults() {

        System.out.print("Bulls: ");
        if(bulls != 0)
            System.out.println(bulls);
        else System.out.println("none");

        System.out.print("Cows: ");
        if(cows != 0)
            System.out.println(cows);
        else System.out.println("none");

        System.out.println("Attempts: " + BullsNCowsUtils.attempts);
    }
}
