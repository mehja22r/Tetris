import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisGameGUIApplication {

	private static TetrisGameGUIController TGGC;
	public static void main(String[] args) {

		// create a new JFrame to hold a new controller instance
		JFrame tetrisFrame = new JFrame("Tetris");

		// set size
		tetrisFrame.setSize( 375, 710 );   //400, 800

		// make a new controller instance and add it
		//TGGC = new TetrisGameGUIController();
		tetrisFrame.add(new TetrisGameGUIController() );

		// exit normally on closing the window
		tetrisFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		tetrisFrame.setVisible( true );	

	}

}
