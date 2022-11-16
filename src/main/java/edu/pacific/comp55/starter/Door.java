package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class Door {
	
	private int screen;
	private int position;
	private int startPoint;
	public boolean isActive = false;
	//private int width = 0;
	//private int height = 0;
	//redo height & width
	

	public int getStartPoint() {
		return startPoint;
	}
	
	
	
	public int getPosition() {
		return position;
	}
	
	
	
	private void getDoorNum(int doorNum) {
		// TODO Auto-generated method stub
		if(doorNum == 1) {
			String doorLocation = "Left";
			
		}
		else if(doorNum == 2) {
			String doorLocation = "Top";
		}
		else if(doorNum == 3) {
			String doorLocation = "Right";
			
		}
		else if(doorNum == 4) {
			String doorLocation = "Bottom";
		}
	}	
	
	
	public void setActive(boolean isActive) {
		isActive = true;
	}
	
	
	public boolean isActive() {
		return isActive;
	}
	
}	
	