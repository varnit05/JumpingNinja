package game;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;

public class NinjaObjectManager {

	long enemyTimer = 0;
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
	
		manageEnemies();
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



	public void manageEnemies() {
		System.out.println(System.currentTimeMillis() - enemyTimer);
		System.out.println();
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addZombies(new Zombies(new Random().nextInt(NinjaGamePanel.WIDTH), 120, 200, 200));

			enemyTimer = System.currentTimeMillis();
			System.out.println("h");
		}
	}
	void addZombies(Zombies a) {
		zombiesList.add(a);


	}
}
