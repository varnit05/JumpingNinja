package game;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;

public class NinjaObjectManager {
	public static long startTime;
	long enemyTimer = 0;
	int enemySpawnTime = 2000;
	Ninja ninja;
	int score = 0;
	Random x = new Random();
	int getScore() {
		return score;

	}

static	ArrayList<Zombies> zombiesList;

	public NinjaObjectManager(Ninja ninja) {
		zombiesList = new ArrayList<Zombies>();
		this.ninja = ninja;
		startTime = System.currentTimeMillis();
		

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
			addZombies(new Zombies(JumpingNinja.WIDTH-100, 150*x.nextInt(2) + 400, 120, 200));

			enemyTimer = System.currentTimeMillis();
			System.out.println("h");
		}
	}
	void addZombies(Zombies a) {
		zombiesList.add(a);


	}
}
