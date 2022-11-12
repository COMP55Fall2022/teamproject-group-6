package edu.pacific.comp55.starter;

public class Bullet {
	private Point startPoint;
	private int width = 100;
	private int height = 100;
	private int speed;
	private DirectionType direction;
	private Point[] collisionDetectionPoints = new Point[8];
	
	public Bullet(int startX, int startY, int speed, DirectionType direction) {
		super();
		this.startPoint = new Point(startX, startY);
		this.speed = speed;
		this.direction = direction;
		for (int i = 0; i < 8; ++i) {
			collisionDetectionPoints[i] = new Point(0, 0);
		}
		this.updateCollisionDetectionPoints();
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
	
	public void move() {
		if (direction == DirectionType.UP) {
			this.startPoint.setY(startPoint.getY() + speed);
		}
		else if (direction == DirectionType.DOWN) {
			this.startPoint.setY(startPoint.getY() - speed);
		}
		else if (direction == DirectionType.LEFT) {
			this.startPoint.setX(startPoint.getX() - speed);
		}
		else if (direction == DirectionType.RIGHT) {
			this.startPoint.setX(startPoint.getX() + speed);
		}
		this.updateCollisionDetectionPoints();
	}
	
	
	
	@Override
	public String toString() {
		return "Bullet [startPoint=" + startPoint + ", speed=" + speed + ", direction=" + direction + "]";
	}

	//Tests
	public static void main(String[] args) {
		Bullet b1 = new Bullet(0, 0, 800, DirectionType.RIGHT);
		Bullet b2 = new Bullet(800, 0, 800, DirectionType.LEFT);
		Bullet b3 = new Bullet(0, 0, 800, DirectionType.UP);
		Bullet b4 = new Bullet(0, 800, 800, DirectionType.DOWN);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		b1.move();
		b2.move();
		b3.move();
		b4.move();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
	}
}
