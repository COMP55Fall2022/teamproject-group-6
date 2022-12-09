package edu.pacific.comp55.starter;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRoundRect;

public class Character extends AnimatedObject {
	private CharacterType charType;
	protected DirectionType faceDirection;
	protected int health;
	protected int rateOfFire;
	protected int speedOfBullet = 100;
	protected int damage;
	protected boolean dead;
	protected long lastFiredBulletTick;
	protected long lastCollisionTick;
	
	public Character(CharacterType charType, String image, double x, double y, double width, double height) {
		super(image, x, y, width, height);
		this.charType = charType;
		this.faceDirection = DirectionType.DOWN;
		this.dead = false;
	}

	public CharacterType getType() {
		return charType;
	}
	public void setType(CharacterType charType) {
		this.charType = charType;
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
//	public int getSpeed() {
//		return speed;
//	}
//	public void setSpeed(int speed) {
//		this.speed = speed;
//	}
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
	public DirectionType getFaceDirection() {
		return faceDirection;
	}
	public void setFaceDirection(DirectionType faceDirection) {
		this.faceDirection = faceDirection;
	}
	
	public boolean isDead() {
		return dead;
	}
	public void setDead(boolean deadOrNot) {
		if (this.getType() != CharacterType.PLAYER) {
			//TODO
		}
		this.dead = deadOrNot;
	}
	
//	// Meaning -1: move in negative direction, 1: positive direction, 0: not moving
//	public void move(int moveInX, int moveInY) {
//		switch(moveInX) {
//			case -1: this.setStartX(this.getStartX() - this.getSpeed());
//			case 0: this.setStartX(this.getStartX());	
//			case 1: this.setStartX(this.getStartX() + this.getSpeed());
//		}
//		switch(moveInY) {
//			case -1: this.setStartY(this.getStartY() - this.getSpeed());
//			case 0: this.setStartY(this.getStartY());
//			case 1: this.setStartY(this.getStartY() + this.getSpeed());
//		}
//		//perfect it if have time, works fine now
//		this.updateCollisionDetectionPoints();
//	}
	

	public void isHit(int damage) {
		this.health = this.health - damage;
		if (this.health <= 0) {
			this.setDead(true);
			this.setLocation(1000, 1000);
		}
		
	}
	
	//Use 8 points to detect collision for all moving things
//	public void updateCollisionDetectionPoints() {
//		collisionDetectionPoints[0] = this.startPoint;	// botLeft
//		collisionDetectionPoints[1].setXY(getStartX(), getStartY() + this.height / 2);	//midLeft
//		collisionDetectionPoints[2].setXY(getStartX(), getStartY() + this.height);	//upLeft
//		collisionDetectionPoints[3].setXY(getStartX() + this.width / 2, getStartY() + this.height);	//upMid
//		collisionDetectionPoints[4].setXY(getStartX() + this.width, getStartY() + this.height);	//upRight
//		collisionDetectionPoints[5].setXY(getStartX() + this.width, getStartY() + this.height / 2); //midRight
//		collisionDetectionPoints[6].setXY(getStartX() + this.width, getStartY());	//botRight
//		collisionDetectionPoints[7].setXY(getStartX() + this.width / 2, getStartY());	//botMid
//	}
	
	public Point[] getCollisionDetectionPoints() {
		return collisionDetectionPoints;
	}
	
	public Bullet shoot(DirectionType direction) {
		this.faceDirection = direction;
		Bullet bullet = null;
//		Point p = new Point(0,0);
		if (direction == DirectionType.UP) {
			//p.setXY(this.getX() + this.getWidth() / 2, this.getY());
			bullet = new Bullet(this.getX() + this.getWidth() / 4, 
					this.getY() - 1 - Bullet.HEIGHT,
								15, this instanceof Player,
								direction);
		}
		else if (direction == DirectionType.DOWN) {
			
			//p.setXY(this.getLocation().getX() + this.getWidth() / 2, this.getLocation().getY() + this.getHeight());
			bullet = new Bullet(this.getLocation().getX() + this.getWidth() / 4, 
					this.getLocation().getY() + this.getHeight() + 1, 
					15, this instanceof Player,
					direction);
		}
		else if (direction == DirectionType.LEFT) {
			//p.setXY(this.getX(), this.getY() + this.getHeight() / 2);
			bullet = new Bullet(this.getX() - 1 - Bullet.WIDTH, 
					this.getY() + this.getHeight() / 4,  
					15, this instanceof Player,
					direction);
		}
		else if (direction == DirectionType.RIGHT) {
			//p.setXY(this.getX() + this.getWidth(), this.getY() + this.getHeight() / 2);
			bullet = new Bullet(this.getX()+ 1 + this.getWidth(), 
					this.getY() + this.getHeight() / 4, 
					15, this instanceof Player,
					direction);
		}
		return bullet;
	}
	
	public void bang(DirectionType d) {
//		System.out.println(ticks + "----" + lastFiredBulletTick + "---"+ rateOfFire);
		if (ticks - lastFiredBulletTick > rateOfFire) {
			Bullet b = shoot(d);
//			System.out.println("=============================added bullet");
			room.addBullet(b);
			lastFiredBulletTick = ticks;
		}
	}
	
	@Override 
	public void handleCollision(Object o) {
		super.handleCollision(o);
	}

	
	
	@Override
	public String toString() {
		return "Character [charType=" + charType + ", faceDirection=" + faceDirection + ", startX=" + getX()
				+ ", startY=" + getY() + ", width=" + getWidth() + ", height=" + getHeight() + ", health=" + health
				+ ", rateOfFire=" + rateOfFire + ", speed=(" + xVelocity + "/" + yVelocity + "), speedOfBullet=" + speedOfBullet + ", damage="
				+ damage + "]";
	}

	//Tests
	public static void main(String[] args) {
		Character player = new Character(CharacterType.PLAYER, "robot head", 0, 0, 1000, 1000);
		player.isHit(25);
		System.out.println(player);
		/*Point[] points = player.getCollisionDetectionPoints();
		for (int i = 0; i < 8; ++i) {
			System.out.println(points[i]);
		}
		player.move(1, 1);
		System.out.println(player.isDead());
		System.out.println(player);
		points = player.getCollisionDetectionPoints();
		for (int i = 0; i < 8; ++i) {
			System.out.println(points[i]);
		}*/
		Bullet b1 = player.shoot(DirectionType.RIGHT);
		System.out.println(b1);
		Point[] points = b1.getCollisionDetectionPoints();
		for (int i = 0; i < 8; ++i) {
			System.out.println(points[i]);
		}
	}


}
