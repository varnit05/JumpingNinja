package game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JumpingNinja extends JPanel {
	public JFrame frame;
	
	public static final int WIDTH = 2000;
	public static final int HEIGHT = 3000;


	public static void main(String[] args) {

		JumpingNinja ninja = new JumpingNinja();
		ninja.setup();

	}

	public JumpingNinja() {
		frame = new JFrame();
		
	}

	void setup() {
		
	
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		NinjaGamePanel game = new NinjaGamePanel();
		frame.addKeyListener(game);
		frame.add(game);
		frame.pack();
		
	
	}

}