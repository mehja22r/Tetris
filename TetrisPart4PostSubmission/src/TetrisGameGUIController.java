
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**GUI conrtoller class
 * extends JPanel
 * and implements key listsner**/
public class TetrisGameGUIController extends JPanel implements KeyListener{


	/**keeps track of time*/
	private Timer time;

	/**the rate at which piece falls**/
	public static final int DROP = 1000;

	//instance of the tetris board
	private TetrisBoard board;

	//instance of the view 
	private TetrisBoardGUIView view;

	private TetrisGame game;

	/**show number of lines and tetrices cleared**/
	private JLabel score;

	public TetrisGameGUIController(){
		super(new BorderLayout());
		//board = new TetrisBoard();
		game = new TetrisGame();
		view = new TetrisBoardGUIView(game.getTetrisBoard());

		score = new JLabel("Number of Lines: "+ Integer.toString(game.getClearedLines())
				+"\n" + "Number of Tetrices: " + Integer.toString(game.getTetrisCount()));

		this.add(score, BorderLayout.NORTH);
		this.add(view, BorderLayout.CENTER);
		this.setFocusable(true);
		addKeyListener(this);
		setupTimer();

		view.setView(game.getBlockMatrix(), game.getTetrisCount(), game.getClearedLines());

	}

	/**create timer**/
	public void setupTimer(){
		//System.out.println("time set!");

		//time is set to 1000
		time = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//move piece down with time
				game.moveDown();

				//get the view board from GUI viwew class
				view.setView(game.getBlockMatrix(), game.getTetrisCount(), game.getClearedLines());
				//this repaints the view 
				view.repaint();
			}

		});

		//adds the timer
		time.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) 		{
		case 39:
			game.moveRight();
			break;
		case 37:
			game.moveLeft();
			break;
		case 40:
			game.moveDown();
			break;
		case 90:
			game.rotateCW();
			break;
		case 88:
			game.rotateCCW();
		}

		this.repaint();
		score.setText("Number of lines: "+ Integer.toString(game.getClearedLines())
				+"\n" + "Number of Tetrices: " + Integer.toString(game.getTetrisCount()));
	}

	public void refreshDisplay(){
		game.endRound();
		this.repaint();

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

