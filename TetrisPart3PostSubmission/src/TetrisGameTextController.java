/**TetrisGameController is the controller for Tetris
 * It takes input from the user and changes the game accordingly
 * It also changes the view to reflect the model
 * @author mehja22r
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**Text Controller class executes the game**/
public class TetrisGameTextController { 

	//temporary ints
	int tempRows;
	int tempCols;
	boolean [][] tempMatrix;

	/**creates instance of the game**/
	private TetrisGame game = new TetrisGame();

	/**creates instance of the view**/
	private TetrisBoardTextView view = new TetrisBoardTextView(game.getTetrisBoard()); 

	//get Tetris board
	private TetrisBoard board = game.getTetrisBoard();

	/**constructor
	 * calls userInput to start the game
	 */
	public TetrisGameTextController() {
		userInput();
	}

	/**launch the game**/
	public static void main(java.lang.String[] args) {
		new TetrisGameTextController();
	}


	/**print text view of the game
	 * check to see if lines should be cleared after move**/
	private void refreshDisplay()
	{
		view.showDisplay();
		game.endRound();

	}

	/**updates TetrisGame with user inputs 
	 * updates score and tells game whether player won
	 */
	public void updateGame ()
	{

	}

	/**update view with changed game
	 * calls updateScore and showMessage in view
	 */
	public void updateView(int[] score, boolean wonOrLost)
	{

	}

	/**returns block Matrix**/
	public boolean[][] getBlockMatrix()
	{
		boolean[][] tempMatrix = game.getBlockMatrix();
		return tempMatrix;
	}

	/**returns num of rows of board**/
	public int getNumRows() 
	{
		int tempRows = game.getNumRows();
		return tempRows;
	}

	/**returns number of rows of columns**/
	public int getNumCols()
	{
		int tempCols = game.getNumCols();
		return tempCols;
	}

	/** buffer reader to read user input**/
	public void userInput () {			

		/**taking in user input**/
		BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
		try 
		{
			//instantiating a String called line
			String line = "";

			// loop until the user types "Quit"
			do {
				System.out.println("Please enter a move (l,r,d,z,x) or type Quit to end.");
				refreshDisplay();

				// try to read a line
				// this function potentially throws an IOException
				line = in.readLine(); 

				//System.out.println("before"+board.currentGridPosition[0]+" "+board.currentGridPosition[1]);

				//call attemptMove method to move the piece according to user's key input
				attemptMove(line);

				//System.out.println("after"+board.currentGridPosition[0]+" "+board.currentGridPosition[1]);

				//while the user doesn't enter Quit
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}

	}

	/**move TetrisPiece to how the user wants to move it
	 * method takes in user key input as its argument**/
	public void attemptMove(String input) {

		//user wants to move left
		if (input.equals("l")) {
			//System.out.println("left");
			board.moveLeft();
		}

		//user wants to move right
		else if (input.equals("r")) {
			System.out.println("right called");
			board.moveRight();
		}

		//user wants to move down
		else if (input.equals("d")) {
			board.moveDown();
		}

		//user wants a clockwise rotaton
		else if (input.equals("z")) {
			board.rotateCW();
		}

		//user wants an anti clockwise rotation
		else if (input.equals("x")) {
			board.rotateCCW();
		}
		refreshDisplay();
	}

}




