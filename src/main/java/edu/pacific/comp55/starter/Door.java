package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class Door {
	
	private int position;
	private int locationX;
	private int locationY;
	private int startPoint;
	public boolean isActive = false;
	//private int width = 100;
	//private int height = 150;
	//redo height & width
	

	public int getStartPoint() {
		return startPoint;
	}
	
	
	
	public int getPosition() {
		return position;
	}
	
	//constructor
	//inputs for location points x & y
	//for door to show up at those locations???
	public Door(int locationX, int locationY) {
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	
	private void getDoorNum(int doorNum) {
		// TODO Auto-generated method stub
		if(doorNum == 0) {
			String doorLocation = "Left";	
		}
		else if(doorNum == 1) {
			String doorLocation = "Top";
		}
		else if(doorNum == 2) {
			String doorLocation = "Right";
			
		}
		else if(doorNum == 3) {
			String doorLocation = "Bottom";
		}
	}	
}
		
	
	/*
if (isActive = false) {
	return isActive;
	else {
		break;
	}
}

*/	

	
/*	
newDoor;

// get Position in character class
//character position
//bool true or false
//

DoorList.getPosition() {

}
if (position =  )
*/

