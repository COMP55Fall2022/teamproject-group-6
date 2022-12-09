package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class Door extends Object {
	protected Room nextRoom;
	

	//constructor
	//inputs for location points x & y
	//for door to show up at those locations???
	public Door(Room room, double x, double y, double width, double height) {
		super("bullet.png", x, y, width, height);
		nextRoom = room;
		if (nextRoom == null) {
			setLocation(-100, -100);
		}
	}

	public Room getNextRoom() {
		return nextRoom;
	}

	public void setNextRoom(Room nextRoom) {
		this.nextRoom = nextRoom;
		if (nextRoom == null) {
			setLocation(-100, -100);
		}
	}
	
	
}
/*		
	
	
/*	
	boolean isActive = false;
	if (isActive = false) {
		return isActive;
		else {
			break;
		}
	}
<<<<<<< HEAD
}
=======
/*


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

