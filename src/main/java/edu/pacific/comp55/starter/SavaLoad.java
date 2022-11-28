package edu.pacific.comp55.starter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
		}
		catch(Exception e) {
			System.out.println("Save Exception!");
		}
	}
		
	public void load() {
		
	}
}
