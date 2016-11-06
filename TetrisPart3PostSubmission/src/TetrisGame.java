/**The TetrisGame creates an object of Tetris Board
 * and links methods from TetrisBoard to TetrisController**/

public class TetrisGame   {

	/**int for counter clockwise**/
	public static int ccw;

	/**int to hold clockwise rotation**/
	

	/**creating an object of TetrisBoard class**/
	private TetrisBoard tetrisBoard = new TetrisBoard(); 

	/**constructor**/
	public TetrisGame() {

	}


	/**returns tetrisBoard object**/
	public TetrisBoard getTetrisBoard()
	{
		return tetrisBoard;
	}

	/**returns Tetris board**/
	public boolean[][] getBlockMatrix() 
	{
		return tetrisBoard.getBlockMatrix();
	}

	/**returns number of rows in Tetris board**/
	public int getNumRows() 
	{
		return tetrisBoard.getNumRows();
	}

	/**returns number of columns of TetrisBoard**/
	public int getNumCols()
	{
		return tetrisBoard.getNumCols();
	}

	/**adds new piece**/
	public void addNewPiece () {
		tetrisBoard.addNewPiece();
	}

	/**returns current grid position of Tetris piece**/
	public int[] getCurrentGridPosition() {
		//tetrisBoard.getCurrentGridPosition();
		return tetrisBoard.getCurrentGridPosition();
	}

	/**performed when piece cannot move down anymore
	 * Ends the round by checking for newly formed lines and adding a new piece.**/
	public void endRound() {
		tetrisBoard.clearLine();
	}

	/**move the Tetris piece left**/
	public void moveLeft() {
		tetrisBoard.moveLeft();
	}

	/**move the Tetris piece right**/
	public void moveRight() {
		tetrisBoard.moveRight();
	}

	/**move the Tetris piece down**/
	public void moveDown() {
		if (tetrisBoard.checkMoveDown()) {
			System.out.println("CONDITION OKAY HIT");
			tetrisBoard.moveDown();
		}

		else {
			System.out.println("CONDITION BS HIT");
			endRound();
		}
	}
	/**move the Tetris piece counter clockwise**/
	public void rotateCW() {
		tetrisBoard.rotateCW();
	}

	/**move the Tetris piece counter clockwise**/
	public void rotateCCW() {
		tetrisBoard.rotateCCW();
	}

	public int getClearedLines() {
		return tetrisBoard.getClearedLines();
	}

	public int getTetrisCount() {
		return tetrisBoard.getTetrisCount();
	}
}
