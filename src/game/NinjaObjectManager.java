
	import java.awt.Graphics;
	import java.util.ArrayList;
	import java.util.Random;

	public class NinjaObjectManager {

		long enemyTimer;
		int enemySpawnTime = 700;
	
		int score = 0;

		int getScore() {
			return score;

		}

		ArrayList<Zombies> ZombiesList = new ArrayList<Zombies>();


		public NinjaObjectManager() {
			this.ZombiesList = ZombiesList;

		}

		public void update() {
	
			for (Zombies a : ZombiesList) {
				a.update();
			}

		}

		public void draw(Graphics g) {
	
			for (Zombies a: ZombiesList) {
				a.draw(g);
			}

		}



	

		void addAlien(Zombies a) {
			ZombiesList.add(a);

		}

		public void manageEnemies() {
			if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
				addZombies(new Zombies(new Random().nextInt(NinjaGamePanel.WIDTH), 0, 80, 80));

				enemyTimer = System.currentTimeMillis();
			}
		}

		private void addZombies(Zombies zombies) {
			// TODO Auto-generated method stub
			
		}
	}

	

	
