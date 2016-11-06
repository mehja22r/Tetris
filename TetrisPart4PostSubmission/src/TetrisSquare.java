/**a Tetris piece class that generates shape and rotations for the piece**/
public class TetrisSquare extends TetrisPiece
{
	
	public TetrisSquare() {
		filledSquares = new boolean[][][] {
											{
												{true, true, false, false},
												{true, true, false, false},
												{false, false, false, false},
												{false, false, false, false}
											},
											{
												{true, true, false, false},
												{true, true, false, false},
												{false, false, false, false},
												{false, false, false, false}
											},
											{
												{true, true, false, false},
												{true, true, false, false},
												{false, false, false, false},
												{false, false, false, false}
											},
											{
												{true, true, false, false},
												{true, true, false, false},
												{false, false, false, false},
												{false, false, false, false}
											}
											};
		}
}
