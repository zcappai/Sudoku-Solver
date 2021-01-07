import java.util.*;

/* Class for printing sudoku board to console */
public class View {
  // Prints sudoku board
	public void printBoard(Board gameBoard){
    System.out.println("\n");
		for(int i = 0; i < 9; i++){
      System.out.print((i+1)+" ");
			for(int j = 0; j < 9; j++){
        // Prints number if element is not empty
        if(gameBoard.getElement(i, j) != '\0') {
          System.out.print("| "+gameBoard.getElement(i, j)+" ");
        }
        // Prints all other sudoku board elements
        else {
          System.out.print("|   ");
        }
			}
			System.out.println("|");
		}
    // Iterates through and prints numbers for columns
    for(int i = 1; i <= 9; i++) {
      if(i == 1) {
        System.out.print("    "+i);  
      }
      else {
        System.out.print("   "+i);
      }
    }
    System.out.println("\n");
	}
}