package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class NinjaGameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	public NinjaGameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.collisionBox = new Rectangle(x,y,width,height);
	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect( x, y, width, height);
	}
}

