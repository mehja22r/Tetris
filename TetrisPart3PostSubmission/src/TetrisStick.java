/**a Tetris piece class that generates shape and rotations for the individual**/
public class TetrisStick extends TetrisPiece
{
	public TetrisStick() {
		filledSquares = new boolean[][][]  {
							{
								{true, false, false, false},
								{true, false, false, false},
								{true, false, false, false},
								{true, false, false, false}
							},
							{
								{true, true, true, true},
								{false, false, false, false},
								{false, false, false, false},
								{false, false, false, false}
							},
							{
								{true, false, false, false},
								{true, false, false, false},
								{true, false, false, false},
								{true, false, false, false}
							},
							{
								{true, true, true, true},
								{false, false, false, false},
								{false, false, false, false},
								{false, false, false, false}
							}
						};
	}
	
}
