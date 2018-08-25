package game;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NinjaGamePanel extends JPanel implements ActionListener, KeyListener {
	AudioClip lose = loadSound("youlose.wav");
	AudioClip start = loadSound("gamemusic.wav");
	public static long endTime;
	static final int MENU_STATE = 0;
	static final int GAME_STATE = 1;
	static final int END_STATE = 2;
	static int currentState = MENU_STATE;
	Ninja ninja;
	Timer timer;
	NinjaObjectManager nom;
	int jstate;
	int dstate;
	private final int jup = 1;
	private final int jacross = 2;
	private final int jdown = 3;

	private final int ddown = 1;
	private final int dacross = 2;
	private final int dup = 3;
	Zombies zombie;
	public static BufferedImage rainforestImg;
	public static BufferedImage zombieImg;
	public static BufferedImage ninjaImg;

	public NinjaGamePanel() {
		timer = new Timer(1000 / 15, this);
		timer.start();
		ninja = new Ninja(250, 470, 175, 175, this);
		nom = new NinjaObjectManager(ninja);

		try {

			zombieImg = ImageIO.read(this.getClass().getResourceAsStream("zombie.gif"));

			ninjaImg = ImageIO.read(this.getClass().getResourceAsStream("ninja.gif"));

			rainforestImg = ImageIO.read(this.getClass().getResourceAsStream("rainforest.jpg"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	public void GameOver() {
		NinjaGamePanel.currentState = NinjaGamePanel.END_STATE;
		NinjaGamePanel.endTime = System.currentTimeMillis();
		start.stop();
		lose.play();
	}

	public AudioClip loadSound(String fileName) {
		return JApplet.newAudioClip(getClass().getResource(fileName));
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
				ninja = new Ninja(250, 470, 175, 175, this);
				nom = new NinjaObjectManager(ninja);
				currentState = MENU_STATE;
				nom.score = 0;

			}
			if (currentState == GAME_STATE) {
				start.play();
				
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			JOptionPane.showMessageDialog(null,
					"the goal of the game is to jump or duck to avoid getting hit by the zombies. To jump you have to press the up arrow, to duck you have to hit the down arrow. Also you can move back and forth with the left and right arrow. GOOD LUCK!!!!!");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			if (ninja.y == 470) {
				System.out.println("hi");
				jstate = jup;
				ninja.jump1();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (ninja.y == 470) {
				System.out.println("yo");
				dstate = ddown;
				ninja.duck1();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ninja.Moveright();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ninja.Moveleft();

		}

		System.out.println("With The");
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
		g.drawImage(NinjaGamePanel.rainforestImg, NinjaGamePanel.WIDTH, NinjaGamePanel.HEIGHT, null);
		nom.draw(g);
	}

	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.RED);
		g.fillRect(0, 0, JumpingNinja.WIDTH, JumpingNinja.HEIGHT);

		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		g.drawString("GAME OVER", 760, 300);

		g.drawString("You survived" + (endTime - NinjaObjectManager.startTime) / 1000 + "seconds", 600, 550);
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

		if (jstate == jup) {
			jstate = jacross;
			ninja.jump2();
		} else if (jstate == jacross) {
			jstate = jdown;
			ninja.jump3();
			jstate = 0;

		}
		if (dstate == ddown) {
			dstate = dacross;
			ninja.duck2();
		} else if (dstate == dacross) {
			dstate = dup;
			ninja.duck3();
			dstate = 0;

		}
		repaint();

	}

	private void updateEndState() {
		// TODO Auto-generated method stub

	}

	private void updateGameState() {
		// TODO Auto-generated method stub
		ninja.update();
		nom.update();
	}

	private void updateMenuState() {
		// TODO Auto-generated method stub

	}

	public void StartGame() {

	}

	public void update() {

	}

	public void draw(Graphics g) {

		if (currentState == GAME_STATE) {

		} else if (currentState == END_STATE) {

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
