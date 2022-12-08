package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class PresetRoom {
	
	private RoomType type;

	public PresetRoom(RoomType type) {
		this.setType(type);
		
	}
	
	private void setType(RoomType type) {
		//get monster
		//this.objects.add(o);
		//get the player
		
		
		if (type == RoomType.COMBAT) {
			
		}
		
		else if (type == RoomType.EMPTY) {
			return;
		}
		
		else if(type == RoomType.ITEM) {
			
		}
		
		else if (type == RoomType.BOSS) {
			//Room.getBoss = boss;
		}
	}
	
	
	public RoomType getType() {
		return type;
	}
	
	
	private ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<Monster> monster = new ArrayList<Monster>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	/*
	newRoom CombatRoom1
	room.setplayer
	room.setmonster
	
	add to arraylist in constructor
	in preset 
	
	constructor getter and setter for arraylist
	
*/	
	//arrayList & getter & setter
	//
	
	public void traverseMonsterArrayList(ArrayList<Monster> list) {
		for(Monster m:list) {
			if(m.isDead() == true) {
				list.remove(m);
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
