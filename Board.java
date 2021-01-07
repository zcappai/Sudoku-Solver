import java.util.*;
import java.io.*;
import java.awt.*;

/* Class handles the sudoku board */
public class Board {

  // Declares sudoku 'board' and 'input' for setting challenge board
  private int[][] board;
  private Input input;

  // 'ArrayList' stores empty cell coordinates and 'filled' is true if puzzle solved
  private ArrayList<Point> emptyCells;
  private boolean filled = false;

  // Constructor instantiates game board, sets challenge board and stores empty cells
  public Board() throws IOException, FileNotFoundException, NumberFormatException {
    board = new int[9][9];
    input = new Input();
    emptyCells = new ArrayList<Point>();
    board = input.setChallenge(board);
    findEmpties();
  }

  /* Getter method for returning value from specific array element
  *  y - column index, x - row index */
  public int getElement(int y, int x) {
    return board[y][x];
  }

  /* Setter method for setting value for specific array element
  *  y - column index, x - row index */
  public void setElement(int y, int x, int value) {
    this.board[y][x] = value;
  }

  // Returns true if current number is already in horizontal row
  public boolean checkHorizontal(int y, int x, int currNum) {
    boolean found = false;
    for(int i = 0; i < 9; i++){
      if(getElement(y, i) == currNum && i != x){
          found = true;
        }
    }
    return found;
  }

  // Returns true if current number is already in vertical column
  public boolean checkVertical(int y, int x, int currNum) {
    boolean found = false;
    for(int i = 0; i < 9; i++){
      if(getElement(i, x) == currNum && i != y){
        found = true;
      }
    }
    return found;
  }

  // Returns true if current number is already in quadrant
  public boolean checkQuadrant(int y, int x, int currNum) {
    int[] quadrant = findQuadrant(y, x);
    int firstY = quadrant[0] * 3;
    int firstX = quadrant[1] * 3;
    for(int i = firstY; i < firstY + 3; i++) {
      for(int j = firstX; j < firstX + 3; j++) {
        if(getElement(i, j) == currNum) {
          return true;
        }
      }
    }
    return false;
  }

  // Returns 'int' array with indexes of quadrant that (x, y) are in
  public int[] findQuadrant(int y, int x) {
    int[] quadrant = new int[2];
    if(y >= 0 && y < 3) {
      quadrant[0] = 0;
    }
    else if(y >= 3 && y < 6) {
      quadrant[0] = 1;
    }
    else if(y >= 6 && y < 9) {
      quadrant[0] = 2;
    }
    if(x >= 0 && x < 3) {
      quadrant[1] = 0;
    }
    else if(x >= 3 && x < 6) {
      quadrant[1] = 1;
    }
    else if(x >= 6 && x < 9) {
      quadrant[1] = 2;
    }
    return quadrant;
  }

  // Stores coordinates of empty cells in puzzleboard as 'Point' objects
  public void findEmpties() {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        if(getElement(i, j) == 0) {
          emptyCells.add(new Point(j, i));
        }
      }
    }
  }

  /* Returns true if solution to sudoku puzzle is found
  * Uses recursion and depth-first-search algorithm called
  * Backtracking, which is a form of brute-force search
  * index - starting index for empty cells 'ArrayList' */
  public boolean backtrack(int index) {
    // Gets x and y coordinates for empty cell
    Point currentPoint = emptyCells.get(index);
    int y = (int) currentPoint.getY();
    int x = (int) currentPoint.getX();
    // Iterates through possible values for empty cell
    for(int i = 1; i <= 9; i++) {
      // Checks if current 'i' can be placed in current empty cell
      boolean hori = checkHorizontal(y, x, i);
      boolean vert = checkVertical(y, x, i);
      boolean quad = checkQuadrant(y, x, i);
      // If 'i' can be placed in current empty cell, sets value and calls method again
      if(hori == false && vert == false && quad == false) {
        setElement(y, x, i);
        // Only calls method again if current cell is NOT the last empty cell
        if(index < emptyCells.size() - 1) {
          backtrack(index+1);
        }
        // If current cell is the last empty cell, solution has been found
        else {
          filled = true;
        }
      }
      // Sets current cell to empty before backtracking
      if(filled == false) {
        setElement(y, x, 0);
      }
    }
    return filled;
  }
}