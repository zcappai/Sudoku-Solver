import java.io.*;

/* Class runs the logic of the game */
public class Sudoku {
  public void solve() {
    try {
      // Instantiates sudoku board and board printing objects
      Board board = new Board();
      View view = new View();
      System.out.print("\nChallenge Sudoku:");
      view.printBoard(board);
      // Solves sudoku challenge, if solvable
      boolean solved = board.backtrack(0);
      if(solved == true) {
        System.out.print("\nSolution:");
        view.printBoard(board);
      }
      else if(solved == false) {
        System.out.print("\n\nThis sudoku has no solution!");
        System.out.print("\nPlease enter a valid, solvable sudoku puzzle!");
      }
    }
    catch(IOException e) {
      System.out.println("\nInvalid file!");
      System.out.println("Please use puzzleboard.csv file!\n");
    }
    catch(NumberFormatException e) {
      System.out.println("\nInvalid value in challenge board!\n");
    }
  }
}