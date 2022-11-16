package edu.pacific.comp55.starter;

public class Monster extends Character {
	private boolean isTrackingPlayer;

	public Monster(CharacterType charType, DirectionType faceDirection, int startX, int startY, int width, int height,
			int health, int rateOfFire, int speed, int speedOfBullet, int damage, boolean isTrackingPlayer) {
		super(charType, faceDirection, startX, startY, width, height, health, rateOfFire, speed, speedOfBullet, damage);
		this.isTrackingPlayer = isTrackingPlayer;

	}

	public int shootingdetection(Character player) {
		// checks for player character in 4 directions,
		// returns 0 if not found,
		// 1-2-3-4 if found+ what direction
		if ((player.getStartX() <= this.getStartX() && player.getStartX() >= this.getStartX() + this.getWidth())
				|| ((player.getStartX() + player.getWidth()) <= this.getStartX()
						&& (player.getStartX() + player.getWidth()) >= this.getStartX() + this.getWidth())) {
			if (player.getStartY() < this.getStartY()) {
				return 1;
			} else
				return 3;
		} else if ((player.getStartY() <= this.getStartY() && player.getStartY() >= this.getStartY() + this.getHeight())
				|| ((player.getStartY() + player.getHeight()) <= this.getStartY()
						&& (player.getStartY() + player.getHeight()) >= this.getStartY() + this.getHeight())) {
			if (player.getStartX() < this.getStartX()) {
				return 4;
			} else
				return 2;
		}
		return 0;
	}
}
