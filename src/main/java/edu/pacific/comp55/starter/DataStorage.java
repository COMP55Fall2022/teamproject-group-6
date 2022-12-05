package edu.pacific.comp55.starter;
import java.io.File;
import java.io.IOException;
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
	
	public void createSaveFile() {
		try {
		      File myObj = new File("save.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	//Test
	public static void main(String[] args) {
		DataStorage d1 = new DataStorage();
		d1.createSaveFile();
	}
}
