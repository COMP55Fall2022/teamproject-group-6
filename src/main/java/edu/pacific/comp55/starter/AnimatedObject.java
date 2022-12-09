package edu.pacific.comp55.starter;

import acm.graphics.GImage;

public class AnimatedObject extends Object {

	protected double xVelocity, yVelocity;
	protected Point[] collisionDetectionPoints = new Point[8];
	protected long ticks;
	protected Room room;

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


	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public DirectionType getDirection() {
		if (xVelocity < 0) {
			return DirectionType.LEFT;
		} else if (xVelocity > 0) {
			return DirectionType.RIGHT;
		} else if (yVelocity < 0) {
			return DirectionType.UP;
		} else if (yVelocity > 0) {
			return DirectionType.DOWN;
		} else {
			return DirectionType.NONE;
		}
	}
	
	public void animate() {
		ticks++;
		move(xVelocity, yVelocity);
//		System.out.println("movement has occured ur going this fast " + xVelocity + "," + yVelocity + " : " + getX() + "x" + getY());
	}
	
	@Override 
	public void handleCollision(Object o) {
		super.handleCollision(o);

	}


	public Point[] getCollisionDetectionPoints() {
		return collisionDetectionPoints;
	}

}