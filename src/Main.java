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
        gameBoardPrinter();
        while(true) {

            gameBoardController();



        }

    }
    static void gameBoardController(){

        System.out.println(playerTurn + " turn - enter column # to add piece (0-6)");
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
        gameBoardPrinter();
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

    /**
     * Prints out the gameBoard
     */
    static void gameBoardPrinter(){
        for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex ++) {
            for (int colIndex = 0; colIndex  < gameBoard[rowIndex].length; colIndex ++) {
                System.out.print(gameBoard[rowIndex ][colIndex] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }



    /**
     * Checks for a full board (tie) and checks for any connect 4
     * @param columnInput
     */
    static void endgameCheck(String columnInput){
        if(fullColumnChecker("0")&&fullColumnChecker("1")&&fullColumnChecker("2")&&
                fullColumnChecker("3") &&fullColumnChecker("4")&&fullColumnChecker("5")
                &&fullColumnChecker("6")) {
            System.out.println("Tie game");
            System.exit(0);
        }

        for(int rowIndex = 5; rowIndex > 2; rowIndex--){
            for (int colIndex = 0; colIndex  < 6; colIndex ++) {
                if(gameBoard[rowIndex][colIndex].equals("r")&& gameBoard[rowIndex-1][colIndex].equals("r")
                        &&gameBoard[rowIndex-2][colIndex].equals("r")&&gameBoard[rowIndex-3][colIndex].equals("r")){
                    System.out.println("Red wins");    //Checks for vertical, red connect 4
                    System.exit(0);
                }
                else if(gameBoard[rowIndex][colIndex].equals("b")&& gameBoard[rowIndex-1][colIndex].equals("b")
                        &&gameBoard[rowIndex-2][colIndex].equals("b")&&gameBoard[rowIndex-3][colIndex].equals("b")){
                    System.out.println("Black wins");    //Checks for vertical, black connect 4
                    System.exit(0);
                }





            }
        }
        for(int rowIndex = 0; rowIndex < 5; rowIndex++){
            for(int colIndex = 0; colIndex < 6; colIndex++){
                if(gameBoard[rowIndex][colIndex].equals("r")&& gameBoard[rowIndex][colIndex+1].equals("r")
                        &&gameBoard[rowIndex][colIndex+2].equals("r")&&gameBoard[rowIndex][colIndex+3].equals("r")){
                    System.out.println("Red wins");    //Checks for horizontal, red connect 4
                    System.exit(0);
                }
                else if(gameBoard[rowIndex][colIndex].equals("b")&& gameBoard[rowIndex][colIndex+1].equals("b")
                        &&gameBoard[rowIndex][colIndex+2].equals("b")&&gameBoard[rowIndex][colIndex+3].equals("b")){
                    System.out.println("Black wins");    //Checks for horizontal, black connect 4
                    System.exit(0);
                }

            }
        }


    }


}
