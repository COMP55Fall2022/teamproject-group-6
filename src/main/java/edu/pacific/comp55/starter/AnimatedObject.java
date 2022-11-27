package edu.pacific.comp55.starter;

import acm.graphics.GCompound;

public class AnimatedObject extends GCompound {

	protected double x, y;
	protected double width, height;
	protected double xVelocity, yVelocity;
	protected Point[] collisionDetectionPoints = new Point[8];

	public AnimatedObject(double x, double y, double width, double height) {
		super();
		setLocation(x, y);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		xVelocity = 0;
		yVelocity = 0;
	}

	public void updateSpeedAndDirection(double speed, DirectionType direction) {
		
		switch (direction) {
		case DOWN:
			xVelocity = 0;
			yVelocity = speed;
			break;
		case UP:
			xVelocity = 0;
			yVelocity =-speed;
			break;
		case LEFT:
			xVelocity = -speed;
			yVelocity = 0;
			break;
		case RIGHT:
			xVelocity = speed;
			yVelocity = 0;
			break;
		}
		System.out.println("update speed and direction " + speed + ":" + direction + "->" + xVelocity + "," + yVelocity);
	}

	public void move() {
		move(xVelocity, yVelocity);
		System.out.println("movement has occured ur going this fast " + xVelocity + "," + yVelocity);
//		if (direction == DirectionType.UP) {
//			this.startPoint.setY(startPoint.getY() + speed);
//		}
//		else if (direction == DirectionType.DOWN) {
//			this.startPoint.setY(startPoint.getY() - speed);
//		}
//		else if (direction == DirectionType.LEFT) {
//			this.startPoint.setX(startPoint.getX() - speed);
//		}
//		else if (direction == DirectionType.RIGHT) {
//			this.startPoint.setX(startPoint.getX() + speed);
//		}
//		this.updateCollisionDetectionPoints();
	}

	public Point[] getCollisionDetectionPoints() {
		return collisionDetectionPoints;
	}

}