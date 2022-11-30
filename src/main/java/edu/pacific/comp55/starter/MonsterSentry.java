package edu.pacific.comp55.starter;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class MonsterSentry extends Monster {

	public MonsterSentry(CharacterType charType, DirectionType faceDirection, double x, double y, double width, double height) {
		super(CharacterType.MONSTER3, "shootingrobot.png", x, y, width, height);
		setFaceDirection(faceDirection);
		health = 50;
		rateOfFire = 2;
		speedOfBullet = 2;
		damage = 25;
	}

	
	public void animate() {
		super.animate();
	}
	
}
