import java.util.Scanner;

public class Main {

    public static String gameType;
    public static Guesser guesser;
    public static final int DIGIT_COUNT = 4, POSSIBILITIES_COUNT = 5040;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println(
                "Welcome to Bulls and Cows!\n\n" +
                        "Made with love at 4am on SAP Geeky Camp 5.0.\n\n" +
                        "Choose Game Type:\n" +
                        "[1] The Computer thinks of a number, you have to guess it.\n" +
                        "[2] You think of a number, the Computer has to guess it.\n");

        BullsNCowsUtils game = new BullsNCowsUtils();

        gameType = scn.nextLine();
        Challenger challenger;

        if(gameType.equals("1")) {
            System.out.println("You have chosen Game Type 1.\nType G to [G]ive up during the game.");
            challenger = new ComputerChallenger();
            guesser = new UserGuesser();
        }
        else{
            System.out.println("You have chosen Game Type 2.\n");
            challenger = new UserChallenger();
            guesser = new ComputerGuesser();
        }

        game.playGame(challenger, guesser);
    }
}
