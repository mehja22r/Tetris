/**a Tetris piece class that generates shape and rotations the piece**/

public class TetrisL1 extends TetrisPiece{

	//private boolean[][][] filledSquares = new boolean[4][4][4];
	
	public TetrisL1() {
		filledSquares = new boolean[][][]  {
							{
								{true, true, false, false},
								{true, false, false, false},
								{true, false, false, false},
								{false, false, false, false}
							},
							{
								{true, true, true, false},
								{false, false, true, false},
								{false, false, false, false},
								{false, false, false, false}
							},
							{
								{false, false, true, false},
								{true, true, true, false},
								{false, false, false, false},
								{false, false, false, false}
							},
							{
								{true, false, false, false},
								{true, true, true, false},
								{false, false, false, false},
								{false, false, false, false}
							}
						};
	}

}
