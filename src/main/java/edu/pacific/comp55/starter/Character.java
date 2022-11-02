package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class Character {
	private CharacterType charType;
	private FaceDirectionType faceDirection;
	private int startX;
	private int startY;
	private int width;
	private int height;
	private int health;
	private int rateOfFire;
	private int speed;
	private int speedOfBullet;
	private int damage;
	private ArrayList<Character> characters = new ArrayList();
	
	public CharacterType getType() {
		return charType;
	}
	public void setType(CharacterType charType) {
		this.charType = charType;
	}
	public int getStartX() {
		return startX;
	}
	public void setStartX(int startX) {
		this.startX = startX;
	}
	public int getStartY() {
		return startY;
	}
	public void setStartY(int startY) {
		this.startY = startY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getRateOfFire() {
		return rateOfFire;
	}
	public void setRateOfFire(int rateOfFire) {
		this.rateOfFire = rateOfFire;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeedOfBullet() {
		return speedOfBullet;
	}
	public void setSpeedOfBullet(int speedOfBullet) {
		this.speedOfBullet = speedOfBullet;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public FaceDirectionType getFaceDirection() {
		return faceDirection;
	}
	public void setFaceDirection(FaceDirectionType faceDirection) {
		this.faceDirection = faceDirection;
	}
	
	
	
	
}
