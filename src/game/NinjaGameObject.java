package game;

import java.awt.Color;
import java.awt.Graphics;

public class NinjaGameObject {
	int x;
	int y;
	int width;
	int height;
	

	public NinjaGameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
	}

	void update() {

	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect( x, y, width, height);
	}
}

