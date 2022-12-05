package edu.pacific.comp55.starter;

import acm.graphics.GImage;

public class AnimatedObject extends Object {

	protected double xVelocity, yVelocity;
	protected Point[] collisionDetectionPoints = new Point[8];
	protected long ticks;

	public AnimatedObject(String image, double x, double y, double width, double height) {
		super(image, x, y, width,  height);
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
		case NONE:
			xVelocity = 0;
			yVelocity = 0;
			break;
		}
//		System.out.println("update speed and direction " + speed + ":" + direction + "->" + xVelocity + "," + yVelocity);
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public void animate() {
		ticks++;
		move(xVelocity, yVelocity);
//		System.out.println("movement has occured ur going this fast " + xVelocity + "," + yVelocity + " : " + getX() + "x" + getY());
	}

	public Point[] getCollisionDetectionPoints() {
		return collisionDetectionPoints;
	}

}