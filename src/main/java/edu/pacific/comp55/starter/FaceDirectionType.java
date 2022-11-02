package edu.pacific.comp55.starter;

public enum FaceDirectionType {
	UP, DOWN, LEFT, RIGHT;
	
	public String toString() {
		switch(this) {
			case UP: return "up";
			case DOWN: return "down";
			case LEFT: return "left";
			case RIGHT: return "right";
		}
		return "n/a";
	}
}