package edu.pacific.comp55.starter;

public class Character {
	private CharacterType charType;
	private DirectionType faceDirection;
	private Point startPoint;
	private int width;
	private int height;
	private int health;
	private int rateOfFire;
	private int speed;
	private int speedOfBullet;
	private int damage;
	private boolean dead;
	private Point[] collisionDetectionPoints = new Point[8];
	
	
	public Character(CharacterType charType, DirectionType faceDirection, int startX, int startY, int width,
			int height, int health, int rateOfFire, int speed, int speedOfBullet, int damage) {
		super();
		this.charType = charType;
		this.faceDirection = faceDirection;
		this.startPoint = new Point(startX, startY);
		this.width = width;
		this.height = height;
		this.health = health;
		this.rateOfFire = rateOfFire;
		this.speed = speed;
		this.speedOfBullet = speedOfBullet;
		this.damage = damage;
		this.dead = false;
		for (int i = 0; i < 8; ++i) {
			collisionDetectionPoints[i] = new Point(0, 0);
		}
		this.updateCollisionDetectionPoints();
		
	}

	public CharacterType getType() {
		return charType;
	}
	public void setType(CharacterType charType) {
		this.charType = charType;
	}
	public int getStartX() {
		return startPoint.getX();
	}
	public void setStartX(int startX) {
		this.startPoint.setX(startX);
	}
	public int getStartY() {
		return startPoint.getY();
	}
	public void setStartY(int startY) {
		this.startPoint.setY(startY);
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
	public DirectionType getFaceDirection() {
		return faceDirection;
	}
	public void setFaceDirection(DirectionType faceDirection) {
		this.faceDirection = faceDirection;
	}
	
	public boolean getDead() {
		return dead;
	}
	public void setDead(boolean deadOrNot) {
		this.dead = deadOrNot;
	}
	
	// Meaning -1: move in negative direction, 1: positive direction, 0: not moving
	public void move(int moveInX, int moveInY) {
		switch(moveInX) {
			case -1: this.setStartX(this.getStartX() - this.getSpeed());
			case 0: this.setStartX(this.getStartX());	
			case 1: this.setStartX(this.getStartX() + this.getSpeed());
		}
		switch(moveInY) {
			case -1: this.setStartY(this.getStartY() - this.getSpeed());
			case 0: this.setStartY(this.getStartY());
			case 1: this.setStartY(this.getStartY() + this.getSpeed());
		}
		//perfect it if have time, works fine now
		this.updateCollisionDetectionPoints();
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void isHit(int damage) {
		this.health = this.health - damage;
		if (this.health <= 0) {
			this.setDead(true);
		}
	}
	
	//Use 8 points to detect collision for all moving things
	public void updateCollisionDetectionPoints() {
		collisionDetectionPoints[0] = this.startPoint;	// botLeft
		collisionDetectionPoints[1].setXY(getStartX(), getStartY() + this.height / 2);	//midLeft
		collisionDetectionPoints[2].setXY(getStartX(), getStartY() + this.height);	//upLeft
		collisionDetectionPoints[3].setXY(getStartX() + this.width / 2, getStartY() + this.height);	//upMid
		collisionDetectionPoints[4].setXY(getStartX() + this.width, getStartY() + this.height);	//upRight
		collisionDetectionPoints[5].setXY(getStartX() + this.width, getStartY() + this.height / 2); //midRight
		collisionDetectionPoints[6].setXY(getStartX() + this.width, getStartY());	//botRight
		collisionDetectionPoints[7].setXY(getStartX() + this.width / 2, getStartY());	//botMid
	}
	
	public Point[] getCollisionDetectionPoints() {
		return collisionDetectionPoints;
	}
	
	public Bullet shoot(DirectionType direction) {
		this.faceDirection = direction;
		Bullet bullet = null;
		if (direction == DirectionType.UP) {
			bullet = new Bullet(collisionDetectionPoints[3].getX(), 
								collisionDetectionPoints[3].getY(), 
								speedOfBullet, 
								direction);
		}
		else if (direction == DirectionType.DOWN) {
			bullet = new Bullet(collisionDetectionPoints[7].getX(), 
					collisionDetectionPoints[7].getY(), 
					speedOfBullet, 
					direction);
		}
		else if (direction == DirectionType.LEFT) {
			bullet = new Bullet(collisionDetectionPoints[1].getX(), 
					collisionDetectionPoints[1].getY(), 
					speedOfBullet, 
					direction);
		}
		else if (direction == DirectionType.RIGHT) {
			bullet = new Bullet(collisionDetectionPoints[5].getX(), 
					collisionDetectionPoints[5].getY(), 
					speedOfBullet, 
					direction);
		}
		return bullet;
	}
	
	
	
	@Override
	public String toString() {
		return "Character [charType=" + charType + ", faceDirection=" + faceDirection + ", startX=" + startPoint.getX()
				+ ", startY=" + startPoint.getY() + ", width=" + width + ", height=" + height + ", health=" + health
				+ ", rateOfFire=" + rateOfFire + ", speed=" + speed + ", speedOfBullet=" + speedOfBullet + ", damage="
				+ damage + "]";
	}

	//Tests
	public static void main(String[] args) {
		Character player = new Character(CharacterType.PLAYER, DirectionType.RIGHT, 0, 0, 1000,
				1000, 100, 60, 500, 750, 25);
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
