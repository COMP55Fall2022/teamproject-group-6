package edu.pacific.comp55.starter;

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
	
}	
