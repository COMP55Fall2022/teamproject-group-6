package edu.pacific.comp55.starter;

public class PresetRoom {
	
	public enum RoomType {
		COMBAT, ITEM, PUZZLE, EMPTY, BOSS;
	}
	private RoomType type;

	public PresetRoom(RoomType type) {
		this.setType(type);
		
	}
	
	private void setType(RoomType type) {
		// TODO Auto-generated method stub
		
	}
	public RoomType getType() {
		return type;
	}
	
	/*
	

	public void setType(RoomType type) {
		this.type = type;
	}
	
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

	