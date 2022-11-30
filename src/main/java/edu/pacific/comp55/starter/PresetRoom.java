package edu.pacific.comp55.starter;

public class PresetRoom {
	
	private RoomType type;

	public PresetRoom(RoomType type) {
		this.setType(type);
		
	}
	
	private void setType(RoomType type) {
		if(type == RoomType.COMBAT || type == RoomType.ITEM || type == RoomType.PUZZLE) {
			//are private variables in Room class
			//this.monsters.add(m);
			//this.objects.add(o);
		}
		this.type = type;
	}
	
	public RoomType getType() {
		return type;
	}
	
	
	
	/*
	
	public void CombatRoom(RoomType Type) {
		if(type == COMBAT) {
			
		}
	}
	
	//add monsters
	//add objects

*/



//	private void setType(RoomType type2) {
		// TODO Auto-generated method stub
		
	}

	