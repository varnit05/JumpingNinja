package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class NinjaGamePanel extends JPanel implements ActionListener {
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

}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public void StartGame() {
	
}
public void update() {
	
}
public void draw(Graphics g) {
	g.setColor(Color.CYAN);
	g.fillRect(0, 0, JumpingNinja.WIDTH, JumpingNinja.HEIGHT);
}
}
