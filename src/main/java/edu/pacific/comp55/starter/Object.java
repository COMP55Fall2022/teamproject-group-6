package edu.pacific.comp55.starter;

public class Object {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean visible;
	
	public Object(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
	
	public boolean isVisible() {
        return visible;
    }
	
	public void setVisible(Boolean visible) {
        this.visible = visible;
    }
	
}
