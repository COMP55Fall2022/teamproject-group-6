package edu.pacific.comp55.starter;

public class Monster extends Character {
	private boolean isTrackingPlayer;
	

	
	public Monster(CharacterType charType, DirectionType faceDirection, int startX, int startY, int width,
			int height, int health, int rateOfFire, int speed, int speedOfBullet, int damage, boolean isTrackingPlayer) {
		super(charType, faceDirection, startX, startY, width, height, health, rateOfFire, speed, speedOfBullet, damage);
		this.isTrackingPlayer = isTrackingPlayer;
		
		
	}
	public int shootingdetection(Character player) {
			//checks for player character in 4 directions, 
			//returns 0 if not found,
			//1-2-3-4 if found+ what direction
			//if()
		return 0;
	}
}

