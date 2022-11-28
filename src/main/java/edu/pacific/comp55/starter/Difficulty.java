package edu.pacific.comp55.starter;

public class Difficulty {

	int selection = 0;
	private int damage;
	private int health;
	
	public Difficulty(int damage, int health ) {
		//Normal difficulty
		if(selection == 0) {
			this.damage = damage;
			this.health = health;
			
		}
		//Medium difficulty
		else if(selection == 1) {
			this.damage = damage + 1;
			this.health = health - 1;
		//remove certain upgrades
		}
		//Hard difficulty
		else if(selection == 2) {
			this.damage = damage + 2;
			this.health = health - 2;
		//remove certain upgrades
		}
		
	}

	public int getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}

	
}
