package edu.pacific.comp55.starter;

public enum RoomType {
	COMBAT, ITEM, PUZZLE, EMPTY, BOSS;
	
	public String toString() {
		switch(this) {
			case COMBAT: return "combat";
			case ITEM: return "item";
			case PUZZLE: return "puzzle";
			case EMPTY: return "empty";
			case BOSS: return "boss";
		}
		return "n/a";
	}
}
