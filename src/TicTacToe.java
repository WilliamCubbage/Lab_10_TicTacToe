
import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;                                   //private classes for TTT game
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    private static String currentPlayer = "X";          //First player is always X


    public static void main(String[] args) {       //MAIN           //MAIN                      //MAIN
        Scanner scanner = new Scanner(System.in); //SCANNER
        clearBoard(); // CLEARS BOARD
        showBoard();  // SHOWS BOARD

        while (true)
        {
            System.out.println("Player " + currentPlayer + "'s turn.");

            String moveInput = getPlayerMove();
            int[] move = convertInputToMove(moveInput);        //getting player's move
            int row = move[0];
            int col = move[1];

            if (isValidMove(row,col))
            {board[row][col] = currentPlayer;
                showBoard();

                if (isWin(currentPlayer))
                {
                    System.out.println("Player " + currentPlayer + " win's!");
                    break;
                }
                    else if (isTie())
                {
                System.out.println("It's a Tie!");
                break;
                }

                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            }
                else {
                System.out.println("Invalid move, please try again.");
            }
        }




    }  // END OF MAIN




    private static void clearBoard() // clears the board
    {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; //make this cell a space
            }
        }
    }



    private static void showBoard() // shows the board
    {
        System.out.println("-------------");
        for (int row = 0; row < ROW; row++) {

            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }
    }



    private static boolean isValidMove(int row, int col)        //valid move
    {
        return board[row][col].equals(" ");
    }




    private static boolean isWin(String player)     //win stip
    {
        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return  true;
        }
        return false;
    }



    private static boolean isRowWin(String player)              //ROW win
    {
        for (int row = 0; row < ROW; row++)
        {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; //no row win
    }



    private static boolean isColWin(String player)              //COL win
    {
        for (int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; //no row win
    }


    private static boolean isDiagonalWin(String player)      //check both diagonal win stipulation
    {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        return false;

    }

    private static boolean isTie()              //Tie Game
    {
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                return false;
            }
        }
        return !isWin("X") && !isWin("O");
    }



    private static String getPlayerMove()             //player move
    {
        Scanner scanner = new Scanner(System.in);
        return SafeInput.getNonZeroLenString(scanner, "Enter your move. (Example: row,column");
    }


    private static int[] convertInputToMove(String input)
    {
        String[] parts = input.split(",");
        int row = Integer.parseInt(parts[0]) - 1;
        int col = Integer.parseInt(parts[1]) - 1;
        return new int[]{row, col};
    }

} //END END END