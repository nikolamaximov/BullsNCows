import java.util.Scanner;

public class BullsNCowsUtils {

    private static String winningNumber = ("");

    static String getWinningNumber(){
        return winningNumber;
    }
    static void setWinningNumber(String value){
        winningNumber = value;
    }

    private static String guess;

    public static String getGuess(){
        return guess;
    }
    public static void setGuess(String value){
        guess = value;
    }

    private boolean hasRepeatingDigits(String str) {

        for(int i=0; i < str.length(); i++) {
            for(int j=i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static String[] allThePossiblities = new String[Main.POSSIBILITIES_COUNT];
    public static boolean[] eliminated = new boolean[Main.POSSIBILITIES_COUNT];
    int position = 0;

    private void genAllThePossibilities(int digitPosition, String current) {

        if (digitPosition == Main.DIGIT_COUNT) {
            if (!hasRepeatingDigits(current)) {
                allThePossiblities[position] = current;
                eliminated[position] = false;
                position ++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            genAllThePossibilities(digitPosition + 1, current + Integer.toString(i));
        }
    }

    public static int games = 0, wins = 0, attempts;
    public static String computersGuess = ("");
    private boolean generated = false;

    public void playGame(Challenger challenger, Guesser guesser)
    {
        Scanner scn = new Scanner(System.in);

        if(Main.gameType.equals("2")) {

            if(!generated) {
                genAllThePossibilities(0, (""));
                generated = true;
            }
            else {
                for(int i = 0; i < Main.POSSIBILITIES_COUNT; i++) {
                    eliminated[i] = false;
                }
            }
        }

        do {
            challenger.thinkOfANumber(4);
        } while(hasRepeatingDigits(winningNumber));

        System.out.println(winningNumber);
        System.out.println("Hit Enter to begin...");

        String Enter;
        Enter = scn.nextLine();

        attempts = 0;
        do {

            guesser.makeAGuess();
            if(guesser.getInput().equals("h")) {
                // To-do: Insert Help here
            }
            else {
                attempts ++;
                guess = guesser.getInput();
                challenger.calculateBullsNCows(Main.DIGIT_COUNT);

                if(challenger.getBulls() == Main.DIGIT_COUNT) {
                    wins ++; games ++;

                    guesser.endGame();

                    if(guesser.getInput().equals("y") || guesser.getInput().equals("yes"))
                        playGame(challenger, guesser);
                    else  if(guesser.getInput().equals("n") || guesser.getInput().equals("no") || guesser.getInput().equals("nope")){
                        System.out.println("Bye! x)");
                    }
                    break;
                } else {
                    challenger.tellResults();
                }
            }

        } while (true);
    }
}