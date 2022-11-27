package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class Monster extends Character {
	private boolean isTrackingPlayer;

	public Monster(CharacterType charType, DirectionType faceDirection, double x, double y, double width, double height) {
		super(charType, x, y, width, height);
		setFaceDirection(faceDirection);
		
		switch (charType) {
		case MONSTER1:
			health = 200;
			rateOfFire = 0;
			speedOfBullet = 0;
			damage = 50;
			isTrackingPlayer = true;
			break;
		case MONSTER2:
			health = 75;
			rateOfFire = 1;
			speedOfBullet = 1;
			damage = 25;
			isTrackingPlayer = false;
			break;
		case MONSTER3:
			health = 50;
			rateOfFire = 2;
			speedOfBullet = 2;
			damage = 25;
			isTrackingPlayer = false;
			break;
		}
	}
//
//	public int shootingdetection(Character player) {
//		// checks for player character in 4 directions,
//		// returns 0 if not found,
//		// 1-2-3-4 if found+ what direction
//		if ((player.getStartX() <= this.getStartX() && player.getStartX() >= this.getStartX() + this.getWidth())
//				|| ((player.getStartX() + player.getWidth()) <= this.getStartX()
//						&& (player.getStartX() + player.getWidth()) >= this.getStartX() + this.getWidth())) {
//			if (player.getStartY() < this.getStartY()) {
//				return 1;
//			} else
//				return 3;
//		} else if ((player.getStartY() <= this.getStartY() && player.getStartY() >= this.getStartY() + this.getHeight())
//				|| ((player.getStartY() + player.getHeight()) <= this.getStartY()
//						&& (player.getStartY() + player.getHeight()) >= this.getStartY() + this.getHeight())) {
//			if (player.getStartX() < this.getStartX()) {
//				return 4;
//			} else
//				return 2;
//		}
//		return 0;
//	}
}
