package edu.pacific.comp55.starter;

import java.util.ArrayList;

import acm.graphics.GImage;

public class MonsterChaser extends Monster {


	public MonsterChaser(double x, double y, double width, double height) {
		super(CharacterType.MONSTER1, "fatrobot.png", x, y, width, height);
		health = 200;
		rateOfFire = 0;
		speedOfBullet = 0;
		damage = 50;
	}


	public void animate() {
		if (room.getPlayer() != null) {

			super.animate();
			// Logic to follow the given path

				if (getX() > room.getPlayer().getX()) {
					updateSpeedAndDirection(10, DirectionType.LEFT);
				} else if (getX() < room.getPlayer().getX()) {
					updateSpeedAndDirection(10, DirectionType.RIGHT);
				} else { // getX() == np.getX()
					if (getY() > room.getPlayer().getY()) {
						updateSpeedAndDirection(10, DirectionType.UP);
					} else if (getY() < room.getPlayer().getY()) {
						updateSpeedAndDirection(10, DirectionType.DOWN);
					}
				}
			
		DirectionType direction = getDirectionToward(room.getPlayer());
//			updateSpeedAndDirection(10, direction);
//			System.out.println("update chaser speed and direction " + 10 + ":" + direction + "->" + xVelocity + "," + yVelocity);
//			super.animate();
		}
	}


}
