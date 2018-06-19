package game;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;

public class NinjaObjectManager {

	long enemyTimer;
	int enemySpawnTime = 700;
	Ninja ninja;
	int score = 0;

	int getScore() {
		return score;

	}

	ArrayList<Zombies> zombiesList;

	public NinjaObjectManager(Ninja ninja) {
		zombiesList = new ArrayList<Zombies>();
		this.ninja = ninja;
		

	}

	public void update() {

		for (Zombies a : zombiesList) {
			a.update();
		}

	}

	public void draw(Graphics g) {

		for (Zombies a : zombiesList) {
			a.draw(g);
		}
		ninja.draw(g);

	}

	void addAlien(Zombies a) {
		zombiesList.add(a);

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addZombies(new Zombies(new Random().nextInt(NinjaGamePanel.WIDTH), 0, 80, 80));

			enemyTimer = System.currentTimeMillis();
		}
	}

        void addZombies(Zombies zombies) {
		// TODO Auto-generated method stub
        	zombiesList.add(zombies);
	}
}
