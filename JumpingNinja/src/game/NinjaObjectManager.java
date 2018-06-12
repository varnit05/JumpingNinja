package game;

import java.awt.Graphics;

public class NinjaObjectManager  {
	
	Ninja ninja;
	
	public NinjaObjectManager(Ninja ninja) {
	this.ninja = ninja;
	
	}
	public void draw(Graphics g) {
		ninja.draw(g);
	}
	public void update() {
		
	}
}
