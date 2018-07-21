
package game;

import java.awt.Color;
import java.awt.Graphics;

public class Zombies extends NinjaGameObject {

	public Zombies(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	void update() {
	
		x-= 10;
		super.update();

	}

		
	   void draw(Graphics g) {
			g.drawImage(NinjaGamePanel.zombieImg,x, y, width, height, null);
			g.setColor(Color.BLUE);
			g.drawRect( collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		}

	}


