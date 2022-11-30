package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class Player extends Character implements Serializable {
	public static final int MAX_VELOCITY = 100;
//	int level;
//	int maxLife;
//	int strength;
//	int exteraHealth;
//	int shield;
//	int coin;
	
//	ArrayList<String> itemNames = new ArrayList<>();
//	ArrayList<Integer> itemAmounts = new ArrayList<>();
//	
//	String mapObjectNames[][];
//	int mapObjectWorldX[][];
//	int mapObjectWorldY[][];
//	String mapObjectLootName[][];
//	boolean mapObjectOpened[][];
	
	public Player() {
		this(0, 0, 50, 50);
	}
	
	public Player(double x, double y, double width, double height) {
		super(CharacterType.PLAYER, "player.png",  x, y, width, height);
		setFaceDirection(DirectionType.UP);
		health = 100;
		rateOfFire = 1;
		speedOfBullet = 1;
		damage = 25;
	}

	public void increaseVelocity(double deltaxV, double deltayV) {
		xVelocity = Math.max(Math.min(xVelocity + deltaxV, MAX_VELOCITY), -MAX_VELOCITY);
		yVelocity = Math.max(Math.min(yVelocity + deltayV, MAX_VELOCITY), -MAX_VELOCITY);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			increaseVelocity(0, -10);
			break;
		case KeyEvent.VK_DOWN:
			increaseVelocity(0, 10);
			break;
		case KeyEvent.VK_LEFT:
			increaseVelocity(-10, 0);
			break;
		case KeyEvent.VK_RIGHT:
			increaseVelocity(10, 0);
			break;
		}
		System.out.println("key pressed code: " + e.getKeyCode());
		System.out.println("update speed and direction ->" + xVelocity + "," + yVelocity);
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			setyVelocity(0);
			break;
		case KeyEvent.VK_DOWN:
			setyVelocity(0);
			break;
		case KeyEvent.VK_LEFT:
			setxVelocity(0);
			break;
		case KeyEvent.VK_RIGHT:
			setxVelocity(0);
			break;
		}
		System.out.println("key released code: " + e.getKeyCode());
		System.out.println("update speed and direction ->" + xVelocity + "," + yVelocity);
	}
	public void keyTyped(KeyEvent e) {
//		switch (e.getKeyChar()) {
//		case 'w':
//			updateSpeedAndDirection(20, DirectionType.UP);
//			break;
//		case 'a':
//			updateSpeedAndDirection(20, DirectionType.LEFT);
//			break;
//		case 's':
//			updateSpeedAndDirection(20, DirectionType.DOWN);
//			break;
//		case 'd':
//			updateSpeedAndDirection(20, DirectionType.RIGHT);
//			break;
//		}
//		System.out.println("key typed code: " + e.getKeyChar());	
	}
	
	
}
