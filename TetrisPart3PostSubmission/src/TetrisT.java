/**a Tetris piece class that generates shape and rotations for the individual**/

public class TetrisT extends TetrisPiece
{

	public TetrisT() {
		filledSquares = new boolean[][][]  {
							{
								{false, true, false, false},
								{true, true, true, false},
								{false, false, false, false},
								{false, false, false, false}
							},
							{
								{true, false, false, false},
								{true, true, false, false},
								{true, false, false, false},
								{false, false, false, false}
							},
							{
								{true, true, true, false},
								{false, true, false, false},
								{false, false, false, false},
								{false, false, false, false}
							},
							{
								{false, true, false, false},
								{true, true, false, false},
								{false, true, false, false},
								{false, false, false, false}
							}
						};
	}
}
