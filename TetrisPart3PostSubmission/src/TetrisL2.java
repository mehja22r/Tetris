/**a Tetris piece class that generates shape and rotations for the individual**/
 public class TetrisL2 extends TetrisPiece{

public TetrisL2() {
		filledSquares = new boolean[][][] {
											{
												{true, true, false, false},
												{false, true, false, false},
												{false, true, false, false},
												{false, false, false, false}
											},
											{
												{false, false, true, false},
												{true, true, true, false},
												{false, false, false, false},
												{false,false,false,false}
											},
											{
												{true, false, false, false},
												{true, false, false, false},
												{true, true, false, false},
												{false, false, false, false}
											},
											{
												{true, true, true, false},
												{true, false, false, false},
												{false, false, false, false},
												{false, false, false, false}
											}
											};
		}

}
