package edu.pacific.comp55.starter;
import java.io.File;
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
			
			ds.level = gp.player.level;
			ds.maxLife = gp.player.maxLife;
			ds.life = gp.player.life;
			ds.strength = gp.player.strength;
			ds.exp = gp.player.exp;
			ds.coin = gp.player.coin;
			
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
			
			gp.player.level = ds.level;
			gp.player.maxLife = ds.maxLife;
			gp.player.life = ds.life;
			gp.player.strength = ds.strength;
			gp.player.exp = ds.exp;
			gp.player.coin = ds.coin;
		}
		catch(Exception e) {
			System.out.println("Load Exception!");
	}
}
