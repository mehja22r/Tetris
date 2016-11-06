/**a Tetris piece class that generates shape and rotations for the piece**/
public class TetrisS1 extends TetrisPiece{

	public TetrisS1() {
		filledSquares = new boolean[][][] {
											{
												{true, false, false, false},
												{true, true, false, false},
												{false, true, false, false},
												{false, false, false, false}
											},
											{
												{false, true, true, false},
												{true,true,false, false},
												{false, false, false, false},
												{false,false,false,false}
											},
											{
												{true, false, false, false},
												{true, true, false, false},
												{false, true, false, false},
												{false, false, false, false}
											},
											{
												{false, true, true, false},
												{true, true, false, false},
												{false, false, false, false},
												{false, false, false, false}
											}
											};
		}
	
}