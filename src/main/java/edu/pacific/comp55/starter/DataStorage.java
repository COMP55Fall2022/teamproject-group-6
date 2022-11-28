package edu.pacific.comp55.starter;
import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable{
	int level;
	int maxLife;
	int life; 
	int strength;
	int exteraHealth;
	int shield;
	int exp;
	int nextLevelExp;
	int coin;
	
	ArrayList<String> itemNames = new ArrayList<>();
	ArrayList<Integer> itemAmounts = new ArrayList<>();
	
	String mapObjectNames[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootName[][];
	boolean mapObjectOpened[][];
}
