package edu.pacific.comp55.starter;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class Monster extends Character {

	public Monster(CharacterType charType, String image, double x, double y, double width, double height) {
		super(charType, image, x, y, width, height);
		setFaceDirection(faceDirection);
	}
	
	public void animate() {
		super.animate();
	}
	
	@Override 
	public void handleCollision(Object o) {
		//check the type of your object
		//take damage if needed
		//set dead if needed
	}
	
	public DirectionType getDirectionToward(Object o) {
		// change direction to aim the given point

		// checks for player character in 4 directions,
		// returns 0 if not found,
		// 1-2-3-4 if found+ what direction
		double o_x2 = o.getX() + o.getWidth();
		double monster_x2 = getX() + getWidth();
		double o_y2 = o.getY() + o.getHeight();
		double monster_y2 = getY() + getHeight();
		if (o_x2 > getX() && o.getX() < monster_x2) {
			if (o.getY() > monster_y2) {
				return DirectionType.DOWN;
			} else if (o_y2 < getY()) {
				return DirectionType.UP;
			} else {
				// Collision ???
				return DirectionType.NONE;
			}
		} else if (o_y2 > getY() && o.getY() < monster_y2) {
			if (o.getX() > monster_x2) {
				return DirectionType.RIGHT;
			} else if (o_x2 < getX()) {
				return DirectionType.LEFT;
			} else {
				// Collision ???
				return DirectionType.NONE;
			}			
		}
		return DirectionType.NONE;
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
