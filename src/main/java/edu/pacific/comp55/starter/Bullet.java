package edu.pacific.comp55.starter;

public class Bullet {
	private Point startPoint;
	private int width = 100;
	private int height = 100;
	private int speed;
	private boolean isVertical;
	private Point[] collisionDetectionPoints = new Point[8];
	
	public Bullet(int startX, int startY, int speed, boolean isVertical,
			Point[] collisionDetectionPoints) {
		super();
		this.startPoint = new Point(startX, startY);
		this.speed = speed;
		this.isVertical = isVertical;
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
	
}
