package edu.pacific.comp55.starter;
import java.awt.*;
import java.util.ArrayList;


public class Object {
	//private ObjectType type;
	private Point startPoint;
	private int width;
	private int height;
	private int health;
	private Point[] collisionDetectionPoints = new Point[8];	
    
    public Object(int startX, int startY, int width, int height, int health) {
		//this.type = type;
    	this.startPoint = new Point(startX, startY);
		this.width = width;
		this.height = height;
		for (int i = 0; i < 8; ++i) {
			collisionDetectionPoints[i] = new Point(0, 0);
		}
	}
    
    //public ObjectType getObjectType() {
		//return type;
	//}
    
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
	
	
}
