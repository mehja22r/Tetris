/**creates board for the game
 * holds info about current piece in Tetris game
 * the position of the grid
 * **/
import java.lang.Object;
import java.util.Random;

/**class that creates game logic**/
public class TetrisBoard {

	/**number of columns in the board grid**/
	public final static int COLUMNS = 10;	

	/**number of rows in the board grid**/
	public final static int ROWS = 18;

	/**blockMatrix is a boolean 2D Array that forms the board grid**/
	public boolean[][] blockMatrix = new boolean[ROWS][COLUMNS];   

	/**an instance to store the Tetris piece**/
	TetrisPiece currentPiece;  

	/**an array that holds the Tetris piece's placement on the board**/
	int [] currentGridPosition = new int[2];  

	/**checks if piece has landed**/
	boolean landed = false;

	private int numCols = COLUMNS;
	private int numRows = ROWS;

	/**instance to keep track of the number of lines cleared**/
	private int linesCount = 0; 

	/**instance to keep track of the number of Tetrises cleared**/
	private int tetrisesCount = 0;

	//private boolean [][] refreshArray = new boolean[10][18];

	/**constructor
	 * adds a new Tetris piece
	 */
	public TetrisBoard() {
		addNewPiece();
	}

	/**initialize the 2D board array to have all false values**/
	private void creatingBoard () 
	{String board  = "";
	for (int i=0; i<ROWS; i++)
	{

		for (int j=0; j<COLUMNS; j++)
		{
			if (blockMatrix[i][j] == false) {
				board += "-";
			}

			else 
				board += "x";
		}
	}
	//System.out.println(board);
	//System.out.println("blockMatrix in TetrisBoard now false");
	}

	/**add a new random Tetris piece to the board at grid position (0,3)**/


	/**method selects a Tetris piece at random**/
	public void addNewPiece() {

		landed = false;
		//an instance to hold the randomized number
		double genRandom;

		//Math.random*6.9 because there are 7 pieces and we want numbers from 0-6 after rounding off
		genRandom = Math.random()*6.9;

		//an int instance to get the an integer out of the randomized number
		int genWork = (int) genRandom;

		System.out.println(genWork);

		//case switch to call a Tetris piece for each integer
		switch(genWork)
		{
		case 0: currentPiece = new TetrisSquare();
		System.out.println("TetrisSquare");
		break;
		case 1:currentPiece =  new TetrisL1();
		System.out.println("TetrisL1");
		break;
		case 2: currentPiece = new TetrisL2();
		System.out.println("TetrisL2");
		break;
		case 3: currentPiece = new TetrisS1();
		System.out.println("TetrisS1");
		break;
		case 4: currentPiece =  new TetrisS2();
		System.out.println("TetrisS2");
		break;
		case 5: currentPiece = new TetrisStick();
		System.out.println("TetrisStick");
		break;
		case 6: currentPiece = new TetrisT();
		System.out.println("TetrisT");
		break;		 
		}

		//initialize current grid position to hold the Tetris piece's position
		initCurrentGP();
		//blankSpace();
	}


	public void printPiece() {

		//addNewPiece();
		String pieceString = "";
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				//System.out.println(currentPiece.isFilled(currentPiece.getPieceRotation(), i, j));
				if (currentPiece.isFilled(0, i, j) == true)
				{
					pieceString += "x";
				}

				else 
					pieceString += "";
			}
			System.out.println(pieceString);
			// System.out.println(currentPiece.isFilled(currentPiece.getPieceRotation(), i, j));				   
		}
	}

	/**return the board grid**/
	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}

	/**method returns current Tetris piece**/
	public TetrisPiece getCurrentPiece() {
		//addNewPiece();
		//System.out.println("Current Piece is created");
		return currentPiece;
	}

	public int getPieceRotation() {
		return currentPiece.getPieceRotation();
	}
	/**intializing current grid position of the piece
	 * piece is at row 0 and column 3
	 */
	private void initCurrentGP() {
		currentGridPosition[0] = 0;
		currentGridPosition[1] = 3;
		//System.out.println(currentGridPosition[0]+" "+currentGridPosition[1]);
	}

	/**returns the current position of the piece on the board**/
	public int[] getCurrentGridPosition() {
		return currentGridPosition;
	}

	/**returns columns of board**/
	public int getNumCols() {
		return numCols;
	}

	/**returns rows of boards**/
	public int getNumRows() {
		return numRows;
	}

	/**,methods checks if there is a Tetris**/
	public boolean hasTetris(int row, int col) {
		int rot = currentPiece.getPieceRotation();
		if (currentPiece.isFilled(rot, row, col))
		{
			//there is a tetris
			return true;
		}
		//there is so Tetris
		return false;
	}

	/**check if there is a block in row or column**/
	public boolean hasBlock(int row, int col) 
	{
		//loop through piece array
		for (int i =0; i<4; i++) {
			for (int j = 0; j<4; j++)
			{
				//if the board is filled in the row & col passed in
				if (i+currentGridPosition[0] == row && j+currentGridPosition[1] == col) 
				{
					//return where current Piece is true
					return currentPiece.isFilled(currentPiece.getPieceRotation(), i, j);

				}
			}
		}
		//otherwise return false
		return false;
	}

	/**method to land a piece after it cannot move down anymore**/
	public void landPiece() {
		landed = true;
		//if (checkMoveDown()==false) {
		for (int i=0; i<4; i++) { 
			for (int j=0; j<4; j++) {
				if(currentPiece.isFilled(currentPiece.getPieceRotation(), i, j)) 
				{
					blockMatrix[i+currentGridPosition[0]][j+currentGridPosition[1]] = true;
				}
			}
		}
		addNewPiece();
	}

	/**check if piece can move left**/
	public boolean checkMoveLeft() {
		//if it's valid to move the piece by reducing it's column number by 1
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]-1) == true) {
			System.out.println("left true");

			return true;
		}
		else {
			System.out.println("left false");
			return false;
		}

	}

	/**move the piece left if the checkMoveLeft methods returns true**/
	public void moveLeft() {
		if (checkMoveLeft()) {
			//currentGridPosition[1] --;
			currentGridPosition[1] = currentGridPosition[1]-1;
		}
	}

	/*check if moving right is valid**/
	public boolean checkMoveRight() {

		//if piece can move to the right by increasing column by 1
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1] + 1) == true) {
			System.out.println("right true");
			//System.out.println("check move right before"+currentGridPosition[1]);

			return true;
		}
		else {
			System.out.println("right false");
			return false;
		}
	}

	/**move piece right if checkMoveRight returns true**/
	public void moveRight() {
		if (checkMoveRight()) {
			System.out.println("move right before"+currentGridPosition[1]);
			currentGridPosition[1] = currentGridPosition[1] +1 ;
		}
	}

	/**check if moving counter-clockwise is valid**/
	public boolean setRotateCCW() {

		//if it's valid to move rotate the piece
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]) == true) {
			System.out.println("ccw true");
			return true;
		}
		else {
			currentPiece.clockwise();
			System.out.println("ccw false");
			return false;
		}

	}

	/**move piece ccw after checking if setRotateCCW is true**/
	public void rotateCCW() {
		currentPiece.counterClockwise();
		if (setRotateCCW()) {

		}
	}


	/**check if moving clockwise is valid**/
	public boolean setRotateCW() {

		//if moving piece cw is valid
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]) == true) {
			//System.out.println("this is what is in the parameter ="+currentPiece.getPieceRotation());
			System.out.println("cw true");
			return true;
		}
		else {
			currentPiece.counterClockwise();
			System.out.println("cw false");
			return false;
		}

	}
	/**rotate piece cw after checking it it's true**/
	public void rotateCW() {
		currentPiece.clockwise();
		if (setRotateCW()){
			System.out.println("from rotateCW= "+currentPiece.pieceRotation);

		}
	}


	/**check if moving down is valid**/
	public boolean checkMoveDown() {
		//System.out.println(validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0], currentGridPosition[1]));
		if (validMove(currentPiece, currentPiece.getPieceRotation(), currentGridPosition[0]+1, currentGridPosition[1]) == true) {
			//currentGridPosition[0] ++;
			System.out.println("down true");
			return true;
		}
		else {
			System.out.println("down false");
			return false;
		}
	}

	/**move piece down if checkMoveDown returns true**/
	public void moveDown() {
		if (checkMoveDown()) {
			currentGridPosition[0] ++;
		}
		//landPiece();
	}


	/**when a line in the board gets
	 * filled and it has to be cleared
	 */
	public void clearLine()
	{
		//an int to hold the number of deletedlines
		int deleteLine =0;

		//for all the rows 
		for (int i=0; i<18; i++) {

			//check if they are filled
			boolean checkVar = checkRow(i);

			//if they are filled
			if (checkVar==true)
			{

				//increment deleteLine
				deleteLine++;

				//run a for loop for the columns and set them false at that row
				for (int j = 0; j<10; j++){
					blockMatrix[i][j] = false;
				}

				//move down the row, after one line disappears move the previous row down to its place and move its previous row down etc.
				for (int j = i; j>0; j--) {
					for (int k = 0; k<10; k++) {
						blockMatrix[j][k] = blockMatrix[j-1][k];

					}
				}
				//for all the columns
				for (int j=0; j<10; j++)
				{
					//set the first row false and blank
					blockMatrix[0][j] = false;
				}
			}
		}

		linesCount += deleteLine;         //the number of deletedLines become the linesCount var
		tetrisesCount += deleteLine/4;   //number of tetrices deleted
	}

	/**return number of lines cleared**/
	public int getClearedLines() {
		return linesCount;
	}

	/**return number of tetrices cleared**/
	public int getTetrisCount() {
		return tetrisesCount;
	}

	/**remove the line at row in the model**/
	private void removeLine(int row) {
		//one line disappear move down
		//4 rows in a row filled remove all of them and increase tetriscount by 1
	}


	/**the board gets filled 
	 * the game ends
	 */
	public void gameOver() {
		//when there is a teris that go down below (0,3) where it appears orginally
	}


	/**check if row is filled**/
	public boolean checkRow(int numRow) {

		//int to keep check of the row; at first no row is filled
		int checkRow =0;

		//for loop running through column
		for (int i =0; i<10; i++){

			//is the board filled at every column for the row we are checking
			if (blockMatrix[numRow][i] == true)

				//increment checkRow every time the board is filled at a column in the row
				checkRow += 1;
		}
		//if the entire row is filled at the column
		if (checkRow == 10)
		{
			return true;
		}

		return false;
	}

	/**check if piece is going out of bounds**/
	public boolean detectOutOfBounds(TetrisPiece currentPiece, int rot, int row, int col) {

		//for the rows and cols of piece array
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<4; j++) {

				//if the piece is true and the row and col is at its limit
				if (((currentPiece.isFilled(rot, i, j) && i+row >= 18) || (currentPiece.isFilled(rot, i, j) && j+col >= 10) || j+col<0))
				{
					
					return true;    //is out of bounds
				}
			}
		}
		return false;    //it's not out of bounds
	}


	/**check if the move is valid**/
	public boolean validMove(TetrisPiece currentPiece, int rot, int row, int col) {

		//default assumption is there is no collision or outOfBounds(oob)
		boolean collision = false;     
		boolean oob = false;
		boolean tempValid = false;
		//try {
		//collision = checkCollision(currentPiece, rot, row, col);
		oob = detectOutOfBounds(currentPiece, rot, row, col);
		System.out.println("boolean vals = "+oob);
		//do
		//{
		//if piece is out of bounds
		if (oob==true) 
		{
			//then return false as move is not valid
			tempValid = false;
			
			return false;   //not valid
		}
		//if it's not out of bounds
		else if (oob==false)  {

			//check collision to see if it's valid; if there is a collision
			if (checkCollision(currentPiece, rot, row, col)==true) {

				//move is not valid
				return false;
			}
		}

		//if out of bounds and check collison are false; then move is valid
		else {
			tempValid = true;   
			return true;    //is valid
		}
		//}
		//while (tempValid == true);
		//}
		//catch (ArrayIndexOutOfBoundsException e) 
		//{
		//System.out.println("try catch exception used");
		return true;
	}


	/**check if there is a collision on the board**/
	private boolean checkCollision(TetrisPiece piece, int rot, int gridRow, int gridCol)
	{
		creatingBoard();
		System.out.println("grid position: "+gridCol);
		//System.out.println(blockMatrix[0][3]);

		boolean collide=false;     //initialize collision to false
		boolean[][] board2=new boolean[18][10]; //copy of current board

		//search the piece array
		for (int i=0;i<4;i++)//for every row
		{
			for (int j=0;j<4;j++)//every col
			{
				//if the piece is filled 
				if (piece.isFilled(currentPiece.getPieceRotation(), i, j)) {

					//if blockMatrix is already filled in those spaces
					if (blockMatrix[i+gridRow][j+gridCol]==true) 
					{
						//collision is true
						System.out.println("new print "+blockMatrix[i+gridRow][j+gridCol]);
						System.out.println("collide is true");
						collide = true;     //there is a collision
					}
				}
			}
		}

		//if there is collision
		if (collide==true) {
			System.out.println("land piece is called");
			
		}
		System.out.println("collision is :"+collide);
		//return true or false collision
		return collide;
	}

}
