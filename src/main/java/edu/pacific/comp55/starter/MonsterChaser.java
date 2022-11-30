package edu.pacific.comp55.starter;

import java.util.ArrayList;

import acm.graphics.GImage;

public class MonsterChaser extends Monster {

	private Player player;
	
	public MonsterChaser(Player player, double x, double y, double width, double height) {
		super(CharacterType.MONSTER1, "fatrobot.png", x, y, width, height);
		this.player = player;
		health = 200;
		rateOfFire = 0;
		speedOfBullet = 0;
		damage = 50;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void animate() {
		if (player != null) {

			super.animate();
			// Logic to follow the given path

				if (getX() > player.getX()) {
					updateSpeedAndDirection(10, DirectionType.LEFT);
				} else if (getX() < player.getX()) {
					updateSpeedAndDirection(10, DirectionType.RIGHT);
				} else { // getX() == np.getX()
					if (getY() > player.getY()) {
						updateSpeedAndDirection(10, DirectionType.UP);
					} else if (getY() < player.getY()) {
						updateSpeedAndDirection(10, DirectionType.DOWN);
					}
				}
			
//			DirectionType direction = getDirectionToward(player);
//			updateSpeedAndDirection(10, direction);
//			System.out.println("update chaser speed and direction " + 10 + ":" + direction + "->" + xVelocity + "," + yVelocity);
//			super.animate();
		}
	}


}
