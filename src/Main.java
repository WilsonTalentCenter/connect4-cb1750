import java.util.Scanner;

public class Main {
static Scanner scan = new Scanner(System.in);
static String[][] gameBoard = new String[6][7];
static String playerTurn = "Black's";
static String columnInput;
    public static void main(String[] args) {
        for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex ++) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                gameBoard[rowIndex][colIndex]="O";
            }
        }
        while(true) {

            gameBoardController(playerTurn);
            endgameCheck();

        }

    }
    static void gameBoardController(String playerTurn){
        for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex ++) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                System.out.print(gameBoard[rowIndex ][colIndex] + " ");
            }
            System.out.println();
        }
        System.out.println(playerTurn + " turn enter column # to add piece (0-6)");
        String columnInput = scan.nextLine();
        while(!(columnInput.equals("0")||columnInput.equals("1")||columnInput.equals("2")||
                columnInput.equals("3")||columnInput.equals("4")|| columnInput.equals("5")|| columnInput.equals("6"))){
            System.out.println("Not a valid column #, enter a number between 0 and 6");
            columnInput = scan.nextLine();
        }

        fullColumnChecker(columnInput);
        gameBoardAdder(columnInput);


        if(playerTurn.equalsIgnoreCase("Black's"))
            playerTurn = "Red's";
        else if(playerTurn.equalsIgnoreCase("Red's"))
            playerTurn = "Black's";


    }
    static boolean fullColumnChecker(String columnInput){
        int blankSpaceCount = 0;
        boolean fullColumn = false;

        for (int rowIndex = Integer.parseInt(columnInput); rowIndex < gameBoard.length;) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                if(gameBoard[rowIndex][colIndex].equals("0"))
                    blankSpaceCount++;
                if(blankSpaceCount == 6)
                    fullColumn = true;
                    break;



                }
            }
            return fullColumn;

    }
    static void gameBoardAdder(String columnInput){
        int blankSpaceCount = 0;


        for (int rowIndex = Integer.parseInt(columnInput); rowIndex < gameBoard.length;) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                if(gameBoard[rowIndex][colIndex].equals("0"))
                    blankSpaceCount++;



            }
        }
        gameBoard[Integer.parseInt(columnInput)][blankSpaceCount] = "r";


    }
    static void endgameCheck(){
        if(fullColumnChecker(columnInput) == true)
            System.exit(0);

    }


}
