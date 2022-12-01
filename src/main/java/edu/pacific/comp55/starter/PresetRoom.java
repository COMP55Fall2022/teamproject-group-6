package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class PresetRoom {
	
	private RoomType type;

	public PresetRoom(RoomType type) {
		this.setType(type);
		
	}
	
	private void setType(RoomType type) {
		if(type == RoomType.COMBAT || type == RoomType.ITEM || type == RoomType.PUZZLE || type == RoomType.EMPTY || type == RoomType.BOSS) {
			//are private variables in Room class
			//this.monsters.add(m);
			//this.objects.add(o);
			//get the player
		}
		this.type = type;
		
		if (type == RoomType.BOSS) {
			//Room.getBoss = boss;
		}
	}
	
	public RoomType getType() {
		return type;
	}
	
	
	private ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	
	
	public void traverseCharacterArrayList(ArrayList<Character> list) {
		for(Character c:list) {
			if(c.isDead() == true) {
				list.remove(c);
			}
		}
	}
	
	
	//array
	//add mob
	//give them points
	
	
	///array to store the stuff in the rooms
	//each room 3 lists for objects, characters, & doors for each of the rooms (8 or 9 rooms)
	//for animating them- monsters & players are characters
	//spawn points for doors
	
}	
