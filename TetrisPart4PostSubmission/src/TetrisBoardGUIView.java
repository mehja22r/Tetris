/**displays GUI for Tetris Game**/

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JComponent;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TetrisBoardGUIView extends JPanel {

	/** vars representing bard to be displayed, tetrices and lines cleared **/
	public boolean[][] GUIboard;
	public int tetriceCount;
	public int lineCount;
	private TetrisBoard board;

	/** constructor calling JPanel superclass **/
	public TetrisBoardGUIView(TetrisBoard board) {
		super(new BorderLayout());
		this.board = board;
	}


	/**
	 * colors board blocks and Tetris pieces passes in current grid position to
	 * color the pieces
	 **/
	public void paint(Graphics g)
	{
		//System.out.println("paint called");
		//the moving pieces will be blue

		//for each row of the GUIboard
		for(int i = 0; i < GUIboard.length; i++){

			//and for each column
			for(int j = 0; j < GUIboard[i].length; j++){

				//if there is a piece
				if( board.getBlockMatrix()[i][j] == true ) {
					//					if(GUIboard[i][j] == true) {
					// && board.landed == true
					//color that block blue
					g.setColor(Color.RED);
					g.fillRect(20+ j *36,i *36, 35, 35);
				}

				//if there are no blocks
				else if(GUIboard[i][j] == false){

					//let the board be white
					g.setColor(Color.WHITE);
					g.fillRect(20+ j *36,i *36, 35, 35);

				}//if the piece landed
				else if(GUIboard[i][j] == true) {
					g.setColor(Color.BLUE);
					g.fillRect(20+ j *36,i *36, 35, 35);
				}

			}
		}
	}

	/**
	 * method takes in 2D boolean array and 2 ints and parameters sets GUIboard
	 * and tetrice and line count equal to the parameters passed in
	 * add current piece to the board, pass in cgp as parameters and turn
	 * the board true to where the piece is, clear the values again when
	 * piece moves
	 */

	public void setView(boolean[][] settingBoard, int tetriceValue, int lineValue) 
	{	

		GUIboard = new boolean[18][10];
		tetriceCount = tetriceValue;
		lineCount = lineValue;
		//System.out.println(board.currentGridPosition[0]+" "+board.currentGridPosition[1]);

		//a view board to display the Tetris board
		//GUIboard = board.getBlockMatrix();

		//for all rows and columns 
		for (int i=0; i<board.getNumRows(); i++)
		{
			//String boardString = "";
			for (int j=0; j<board.getNumCols(); j++)
			{
				//if the Tetris board or the the has block methods is true in i, j indices
				if (board.getBlockMatrix()[i][j] == true || board.hasBlock(i, j) == true)
				{ 
					//System.out.println("board is"+(viewBoard[i][j]==true)+(board.hasBlock(i, j)==true));
					//System.out.println("first if there is x at" +i+" "+j);

					//add an x to the board String
					GUIboard[i][j] = true;
					// boardString += "x";
				}


			}
		}
	}
}
