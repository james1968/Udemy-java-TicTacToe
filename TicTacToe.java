import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    static char[][] board = new char[3][3];
    public static void main(String[] args) {
        
        System.out.println("\nLet's play tic tac toe");

        // Create an array with three rows of '_' characters.
      
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[i].length; j++) {
            board[i][j] = '_';
          }
        }

        printBoard();
        
        boolean play = true;

        System.out.println("Start game");
        while(play) {
          // Player X's turn
          boolean checkX = true;
          
          while (checkX) {
          System.out.println("Player X's turn");
          int arrX[] = askUser(board);
          int rowX = arrX[0];
          int columnX = arrX[1];
            if (board[rowX][columnX] == 'X' || board[rowX][columnX] == 'O') {
            checkX = true;
            } else {
            board[rowX][columnX] = 'X';
            checkX = false;
            }
          }
          printBoard();
          boolean winnerX = checkWinX(board);
          if (winnerX) {  
            System.out.println("Player X wins"); 
            play = false;
            System.exit(0);
          };

          boolean checkO = true;

          // Player O's turn
          while (checkO) {
            System.out.println("Player O's turn");
            int arrO[] = askUser(board);
            int rowO = arrO[0];
            int columnO = arrO[1];
              if (board[rowO][columnO] == 'X' || board[rowO][columnO] == 'O') {
              checkO = true;
              } else {
              board[rowO][columnO] = 'O';
              checkO = false;
              }
            }
          printBoard();
          boolean winnerO = checkWinX(board);
          if (winnerO) {  
            System.out.println("Player Y wins"); 
            play = false;
            System.exit(0);
          };
        }
      scan.close();
    }


    // Write a function that prints the board
    
    
    public static void printBoard() {
      System.out.println();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j]);
          System.out.print("  ");
        }
        System.out.println(" ");
        System.out.println();
      }  
    }

     public static int[] askUser(char[][] board) {
        int[] spot = new int[2];
        System.out.println();
        System.out.println("Pick a row");
        int row = scan.nextInt();
        System.out.println("Pick a column");
        int column = scan.nextInt();

        spot[0] = row;
        spot[1] = column;

        return spot;
     }

     public static boolean checkWinX(char[][] board) {
        for (int i = 0; i < board.length; i++) {
          // check rows
          if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X')
            return true;
        }
        for (int j = 0; j < board[0].length; j++) {
          if (board[0][j] == 'X' && board[1][j] == 'X' && board[2][j] == 'X')
            return true;
        }
       
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
          return true;

        else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')
          return true;

        else return false;
        }

        public static boolean checkWinO(char[][] board) {
          for (int i = 0; i < board.length; i++) {
            // check rows
            if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O')
              return true;
          }
          for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && board[1][j] == 'O' && board[2][j] == 'O')
              return true;
          }
         
          if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
            return true;
  
          else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')
            return true;
  
          else return false;
          }
     }
