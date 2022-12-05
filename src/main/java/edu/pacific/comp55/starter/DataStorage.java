package edu.pacific.comp55.starter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorage implements Serializable{
	//int level;
	int maxHP;
	//int life; 
	//int strength;
	//int exteraHealth;
	int damage;
	int shield;
	//int exp;
	//int nextLevelExp;
	int coin;
	int timeOfComplete = 0;
	
	ArrayList<String> itemNames = new ArrayList<>();
	ArrayList<Integer> itemAmounts = new ArrayList<>();
	
	String mapObjectNames[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootName[][];
	boolean mapObjectOpened[][];
	int dataRecieved[] = new int[5];
	
	public void createSaveFile() {
			try {
		      File myObj = new File("save.txt");
		      if (myObj.createNewFile()) {
		    	  System.out.println("File created: " + myObj.getName());
		    	  FileWriter myWriter = new FileWriter("save.txt");
			      myWriter.write(maxHP + "\n" + damage + "\n" + shield + "\n" + coin + "\n" + timeOfComplete);
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			  } else {
				  System.out.println("File already exists.");
			  }
			  } catch (IOException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
			  }
	}
	
	public void readSaveFile() {
			try {
		      File myObj = new File("save.txt");
		      Scanner myReader = new Scanner(myObj);
		      int count = 0;
		      while (myReader.hasNextLine()) {
		    	String data = myReader.nextLine();
		        dataRecieved[count] = Integer.parseInt(data);
		        count++;
		      }
		      myReader.close();
		      maxHP = dataRecieved[0];
		      damage = dataRecieved[1];
		      shield = dataRecieved[2];
		      coin = dataRecieved[3];
		      timeOfComplete = dataRecieved[4];
		      System.out.println("HP: " + maxHP + "\n" + "Damage: " + damage + "\n"  + "Shield: " + shield + "\n" 
		      + "Coin: " + coin + "\n"  + "TimeOfComplete: " + timeOfComplete);
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void writeSaveFile() {
			try {
		      FileWriter myWriter = new FileWriter("save.txt");
		      myWriter.write(maxHP + "\n" + damage + "\n" + shield + "\n" + coin + "\n" + timeOfComplete);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	//Test
	public static void main(String[] args) {
		
	}
}
