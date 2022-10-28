import java.util.Scanner;

public class Main {
static Scanner scan = new Scanner(System.in);
static String[][] gameBoard = new String[6][7];
static String playerTurn = "Black's";

    public static void main(String[] args) {
        for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex ++) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                gameBoard[rowIndex][colIndex]="o";
            }
        }
        while(true) {

            gameBoardController();



        }

    }
    static void gameBoardController(){
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
        while(fullColumnChecker(columnInput)){
            System.out.println("Invalid move. Please try again");
            columnInput = scan.nextLine();

        }

        gameBoardAdder(columnInput);
        endgameCheck(columnInput);


        if(playerTurn.equalsIgnoreCase("Black's"))
             playerTurn = "Red's";
        else if(playerTurn.equalsIgnoreCase("Red's"))
             playerTurn = "Black's";


    }

    /**
     * Checks if a column is filled, assumes taken spaces are all at the bottom
     * @param columnInput
     * @return Returns true or false
     */
    static boolean fullColumnChecker(String columnInput) {
        return gameBoard[0][Integer.parseInt(columnInput)].equals("r") || gameBoard[0][Integer.parseInt(columnInput)].equals("b");




    }

    /**
     * Adds the players piece to the lowest empty point in a column
     * @param columnInput
     */
    static void gameBoardAdder(String columnInput){
        for (int rowIndex = 5; rowIndex >= 0; rowIndex --){
            if(gameBoard[rowIndex][Integer.parseInt(columnInput)].equals("o")){
                if(playerTurn.equals("Red's")) {
                    gameBoard[rowIndex][Integer.parseInt(columnInput)] = "r";
                    break;
                }

                else {
                    gameBoard[rowIndex][Integer.parseInt(columnInput)] = "b";
                    break;
                }
            }


        }



    }
    static void endgameCheck(String columnInput){
        if(fullColumnChecker(columnInput))
            

    }


}
