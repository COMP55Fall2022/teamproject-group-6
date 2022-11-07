package edu.pacific.comp55.starter;
import java.awt.*;
import java.util.ArrayList;


public class Object {
	private Point startPoint;
	private int width;
	private int height;
	private int health;
	private int rateOfFire;
	private int speed;
	private int speedOfBullet;
	private int damage;
	private ArrayList<Character> characters = new ArrayList();
	private Point[] collisionDetectionPoints = new Point[8];
    
    public Object(int startX, int startY, int width, int height, int health, int rateOfFire, int speed, int speedOfBullet, int damage) {
		super();
		this.startPoint = new Point(startX, startY);
		this.width = width;
		this.height = height;
		this.health = health;
		this.rateOfFire = rateOfFire;
		this.speed = speed;
		this.speedOfBullet = speedOfBullet;
		this.damage = damage;
		for (int i = 0; i < 8; ++i) {
			collisionDetectionPoints[i] = new Point(0, 0);
		}
		this.updateCollisionDetectionPoints();
	}
    
}
