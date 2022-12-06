package edu.pacific.comp55.starter;
import java.awt.*;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

public class Object extends GImage {
	//private ObjectType type;
    public Object(String image, double x, double y, double width, double height) {
		super(image);
		setLocation(x, y);
		setSize(width, height);
	}
    
    //public ObjectType getObjectType() {
		//return type;
	//}
    
	public void addActionListener(Console console) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleCollision(Object o) {
		
	}

}
