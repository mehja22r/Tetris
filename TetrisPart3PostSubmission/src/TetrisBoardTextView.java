/**TetrisBoardView is the view for the Tetris
 * It displays information to the user
 * It is updated by the controller
 * @author mehja22r
 *
 */

public class TetrisBoardTextView {

	String instructions;  //instructions for game
	String message;			//shows whether player won or lost

	//instance of TetrisBoard and TetrisPiece
	private TetrisBoard board; 
	private TetrisPiece piece;

	public String boardString;

	/**constructor takes in TetrisBoard parameter**/
	public TetrisBoardTextView (TetrisBoard board){
		this.board = board;
	}

	/** called by the TetrisGameTextController
	 * create the display for instruction and game components **/	
	public void showDisplay() 
	{	
		//System.out.println(board.currentGridPosition[0]+" "+board.currentGridPosition[1]);

		//a view board to display the Tetris board
		boolean[][] viewBoard = board.getBlockMatrix();

		//for all rows and columns 
		for (int i=0; i<board.getNumRows(); i++)
		{
			boardString = "";

			for (int j=0; j<board.getNumCols(); j++)
			{
				//pass the boolean values of Tetris board to view board
				boolean[][] viewBoard1 = board.getBlockMatrix();

				//System.out.println(board.pieceLook());
				//System.out.println("bjdbfkjs");

				//if the Tetris board or the the has block methods is true in i, j indices
				if (viewBoard[i][j] == true || board.hasBlock(i, j) == true)
				{ 
					//System.out.println("board is"+(viewBoard[i][j]==true)+(board.hasBlock(i, j)==true));
					//System.out.println("first if there is x at" +i+" "+j);

					//add an x to the board String
					boardString += "x";
				}

				//if board doesn't have anything in i, j indices
				else if (viewBoard1[i][j] == false) 
				{
					//leave it blank
					boardString += "-";
				}


			}
			System.out.println(boardString);
			//print out the board


		}

		System.out.println("Number of lines cleared: "+board.getClearedLines()+
				" \nNumber of tetrices cleared: "+board.getTetrisCount());
	}
}
