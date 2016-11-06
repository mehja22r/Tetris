/**The TetrisPiece class represents a piece made of 4 TetrisBlocks. 
 * It maintains 4 rotations (0 degrees, 90 degrees, 180 degrees and 270 degrees)
 * with each being a 4x4 grid with certain filled squares.
 * methods for subclasses
 * @author mehja22r
 *
 */

public abstract class TetrisPiece {

	/**boolean array of the piece shape and rotation**/
	protected boolean[][][] filledSquares;  

	/**maintains current rotation**/
	protected int pieceRotation = 0; 

	//a temporary int
	private int temp;

	/**constructor initializes the piece 3D array and sets current rotation to 0**/
	public TetrisPiece() 
	{
		filledSquares = new boolean [4][4][4]; 
		pieceRotation = 0; 
	}

	public int getPieceRotation() {
		//System.out.println(pieceRotation);
		return pieceRotation;
	}


	/**Checks if there is a TetrisBlock at the (row, col) position for the rotation rot
	 * where rot is 0, 90, 180 or 270 degrees.
	 */
	public boolean isFilled (int rot, int row, int col){
		if (filledSquares[rot][row][col] == true)    
		{
			return true;							//return true if there are filled boxes in the piece array
		}
		//System.out.println(filledSquares[rot][row][col]);
		return false;									 //	return false where there are blank boxes in pieceArray
	}


	/**Rotate the piece clockwise by 90 degrees**/
	public void clockwise() { 

		//System.out.println("rotation ="+pieceRotation);

		//if piece rotation is within 0-2
		if (pieceRotation>=0 && pieceRotation < 3)   
		{
			//System.out.println("rotation before ="+pieceRotation);

			//raise rotation by 1 to make it move clockwise
			pieceRotation += 1;
		}

		//if piece rotation is greater or equal to 3
		else if (pieceRotation >= 3)
		{
			//System.out.println("rotation2 ="+pieceRotation);

			//set it back to 0 to rotate it
			pieceRotation = 0;
		}
		else {
			pieceRotation = pieceRotation;
		}
	}


	/**rotate piece counter clockwise**/
	public void counterClockwise() {    

		//System.out.println("piece ccw calles");

		//if piece is in rotation 0
		if (pieceRotation==0) 
		{
			//set it to 3 to make one counter clockwise rotation
			pieceRotation = 3;
		}

		//if piece rotation is 1, 2 or 3
		else if (pieceRotation >= 1 && pieceRotation<=3)
		{
			//decrease the number by 1 to make a counter clockwise rotation
			pieceRotation--;
		}
		else {
			pieceRotation = pieceRotation;
		}
	}
}
