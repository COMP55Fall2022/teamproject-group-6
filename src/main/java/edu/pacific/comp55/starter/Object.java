package edu.pacific.comp55.starter;
import java.awt.*;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Object {
	//private ObjectType type;
	protected int startX;
	protected int startY;
	private Point startPoint;
	private int width;
	private int height;
	private int health;
	protected boolean visible;
    protected Image image;
    
    public Object(int startX, int startY, int width, int height, int health) {
		//this.type = type;
    	this.startPoint = new Point(startX, startY);
		this.width = width;
		this.height = height;
		visible = true;
	}
    
    //public ObjectType getObjectType() {
		//return type;
	//}
    
    protected void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
    //protected void loadImage(String imageName) {
        //ImageIcon ii = new ImageIcon(imageName);
        //image = ii.getImage();
    //}
    
    public Image getImage() {
        return image;
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
	
	public boolean isVisible() {
        return visible;
    }
	
	public void setVisible(Boolean visible) {
        this.visible = visible;
    }
	
	public Rectangle getBounds() {
        return new Rectangle (startX, startY, width, height);
    }

	public void addActionListener(Console console) {
		// TODO Auto-generated method stub
		
	}

}
