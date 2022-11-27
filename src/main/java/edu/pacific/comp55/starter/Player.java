package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class Player extends Character implements Serializable {
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
		super(CharacterType.PLAYER, x, y, width, height);
		health = 100;
		rateOfFire = 1;
		speedOfBullet = 1;
		damage = 25;
		GRoundRect rect = new GRoundRect(0, 0, width, height);
		rect.setFilled(true);
		rect.setFillColor(Color.GREEN);
		add(rect);
		GImage img = new GImage("robot head.jpg", 0, 0);
		img.setSize(width, height);
		add(img);
	}


	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed code: " + e.getKeyCode());
	}
	public void keyReleased(KeyEvent e) {
		System.out.println("key released code: " + e.getKeyCode());
	}
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w':
			updateSpeedAndDirection(20, DirectionType.UP);
			break;
		case 'a':
			updateSpeedAndDirection(20, DirectionType.LEFT);
			break;
		case 's':
			updateSpeedAndDirection(20, DirectionType.DOWN);
			break;
		case 'd':
			updateSpeedAndDirection(20, DirectionType.RIGHT);
			break;
		}
		System.out.println("key typed code: " + e.getKeyChar());	
	}
	
	
}
