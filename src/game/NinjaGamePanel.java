package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class NinjaGamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Timer timer;
	

	public NinjaGamePanel() {
		timer = new Timer(1000 / 60, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		draw(g);

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}

		if (currentState == GAME_STATE) {
			drawGameState(g);
		}

		if (currentState == END_STATE) {
			drawEndState(g);
		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("hi");
			currentState++;
			if (currentState > END_STATE) {

				currentState = MENU_STATE;
			
		}
		}
	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, JumpingNinja.WIDTH, JumpingNinja.HEIGHT);



		g.setColor(Color.ORANGE);
		g.setFont(new Font("Arial", Font.BOLD, 70));
		g.drawString("NinjaJump", 760, 300);

		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start ", 600, 550);
		g.drawString("Press SPACE for instructions ", 505, 750);
		g.setFont(new Font("Arial", Font.PLAIN, 70));

	}

	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
	
		g.fillRect(0, 0, JumpingNinja.WIDTH, JumpingNinja.HEIGHT);
		g.setColor(Color.BLACK);
	}

	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillRect(0, 0, JumpingNinja.WIDTH, JumpingNinja.HEIGHT);
		
		
		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.drawString("GAME OVER", 760, 300);
	
		g.drawString("You Killed __ enemies ", 600, 550);
		g.drawString("Press Enter to restart ", 630, 750);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		}

		if (currentState == GAME_STATE) {
			updateGameState();
		}

		if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	
	}
	private void updateEndState() {
		// TODO Auto-generated method stub
		
	}

	private void updateGameState() {
		// TODO Auto-generated method stub
		
	}

	private void updateMenuState() {
		// TODO Auto-generated method stub
		
	}
	

	public void StartGame() {

	}

	public void update() {

	}

	public void draw(Graphics g) {
		
		if (currentState == GAME_STATE ) {

		}
		else if(currentState == END_STATE ) {
		
		}
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
