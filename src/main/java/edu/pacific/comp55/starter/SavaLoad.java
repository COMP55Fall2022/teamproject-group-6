package edu.pacific.comp55.starter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import org.checkerframework.checker.units.qual.s;

import main.Console;

public class SavaLoad {
	Console gp;
	
	public SaveLoad (Console gp) {
		this.gp = gp;
	}
	
	public void save() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
			DataStorage ds = new DataStorage(); 
			
			ds.level = gp.character.level;
			ds.maxLife = gp.character.maxLife;
			ds.life = gp.character.life;
			ds.strength = gp.character.strength;
			ds.exp = gp.character.exp;
			ds.coin = gp.character.coin;
			
			for (int i = 0; i < gp.chracter.inventory.size(); i++) {
				ds.itemNames.add(gp.character.inventory.get(i).name);
				ds.itemAmounts.add(gp.character.inventory.get(i).amount);
			}
			oos.writeObject(ds);
			
		}
		catch(Exception e) {
			System.out.println("Save Exception!");
		}
	}
		
	public void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
			DataStorage ds = (DataStorage)ois.readObject();
			
			gp.character.level = ds.level;
			gp.character.maxLife = ds.maxLife;
			gp.character.life = ds.life;
			gp.character.strength = ds.strength;
			gp.character.exp = ds.exp;
			gp.character.coin = ds.coin;
		}
		catch(Exception e) {
			System.out.println("Load Exception!");
	}
}
