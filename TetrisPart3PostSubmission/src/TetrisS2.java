/**a Tetris piece class that generates shape and rotations for the piece**/
public class TetrisS2 extends TetrisPiece{

	public TetrisS2() {
			filledSquares = new boolean[][][] {
												{
													{false, true, false, false},
													{true, true, false, false},
													{true, false, false, false},
													{false, false, false, false}
												},
												{
													{true, true, false, false},
													{false,true,true, false},
													{false, false, false, false},
													{false,false,false,false}
												},
												{
													{false, true, false, false},
													{true, true, false, false},
													{true, false, false, false},
													{false, false, false, false}
												},
												{
													{true, true, false, false},
													{false, true, true, false},
													{false, false, false, false},
													{false, false, false, false}
												}
												};
			}
}
