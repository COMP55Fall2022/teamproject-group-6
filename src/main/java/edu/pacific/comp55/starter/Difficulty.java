package edu.pacific.comp55.starter;

public class Difficulty {

	int selection = 0;
	private int damage;
	private int health;
	
	public Difficulty(int damage, int health ) {
		if(selection == 0) {
			this.damage = damage;
			this.health = health;
			
		}
		else if(selection == 1) {
			this.damage = damage + 1;
			this.health = health - 1;
		//remove certain upgrades
		}
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
