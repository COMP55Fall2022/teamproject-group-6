package edu.pacific.comp55.starter;
import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Object {
	private Point startPoint;
	private int width;
	private int height;
	private int health;
	//private JLabel label;
	
    public Object(int startX, int startY, int width, int height, int health) {
		super();
		this.startPoint = new Point(startX, startY);
		this.width = width;
		this.height = height;
		this.health = health;
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
	
	Image img = new ImageIcon(this.getClass().getResource("/crate front.png")).getImage();
}
