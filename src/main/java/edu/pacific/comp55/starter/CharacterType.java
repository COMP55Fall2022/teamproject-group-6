package edu.pacific.comp55.starter;

public enum CharacterType {
	PLAYER, MONSTER1, MONSTER2, MONSTER3;
	
	public String toString() {
		switch(this) {
			case PLAYER: return "player";
			case MONSTER1: return "monster1";
			case MONSTER2: return "monster2";
			case MONSTER3: return "monster3";
		}
		return "n/a";
	}
}
