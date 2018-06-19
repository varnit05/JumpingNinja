
package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ninja extends NinjaGameObject {
	int speed;

	void draw(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(x, y, height, width);

	}

	public Ninja(int x, int y, int width, int height) {

		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 80;
	}

	public void Moveup() {
		y -= speed;

		x += speed;

		y += speed;

	}

	public void Movedown() {
		y += speed;
	}

	public void Moveleft() {
		x -= speed;
	}

	public void Moveright() {
		x += speed;
	}

	public void update() {
		// TODO Auto-generated method stub

	}
	public void jump1( ) {
		y -= speed;
	}
	public void jump2( ) {
		x += speed;
	}
	public void jump3( ) {
		y += speed;
	}
}