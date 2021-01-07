import java.io.*;
import java.util.*;

/* Class handles setting of challenge board */
public class Input {

  private BufferedReader br;
  private Scanner sc;
  private int y = 0;
  private int x = 0;

  // Constructor instantiates 'BufferedReader' to read puzzleboard file
	public Input() throws FileNotFoundException {
    br = new BufferedReader(new FileReader("puzzleboard.csv"));
  }

  // Moves coordinates to next cell
  public void nextCell() {
    if(y < 9) {
      if(x == 8 && y < 8) {
        x = 0;
        y++;
      }
      else if(x == 8 && y == 8) {
      }
      else {
        x++;
      }
    }
  }

  // Returns 2D 'int' array containing puzzleboard
	public int[][] setChallenge(int[][] board) throws NumberFormatException, IOException {
    String line;
    // Runs while line is NOT empty
    while ((line = br.readLine()) != null) {
      // 'Scanner' looks for tokens separated by delimiter
      sc = new Scanner(line).useDelimiter(",");
      while(sc.hasNext()) {
        int next = Integer.parseInt(sc.next());
        // Adds to board if number is valid
        if(next > 0 && next < 10) {
          board[y][x] = next;
          nextCell();
        }
        // Goes to next cell if current cell is empty
        else if(next == 0) {
          nextCell();
        }
        // Throws Exception if current token is not valid integer
        else {
          throw new NumberFormatException();
        }
      }
    }
    sc.close();
		return board;
  }
}