package edu.pacific.comp55.starter;

import java.awt.event.ActionListener;

import acm.program.GraphicsProgram;

public abstract class Console extends MainApplication implements ActionListener {
	

private Object play;
private Object settings;
private Object exit;
private Object mainMenu;
int selection = 0;
private int damage;
private int health;

//	MButton play = new MButton("play");
//	MButton settings = new MButton("settings");
//	MButton exit = new MButton("exit");
//	MButton mainMenu = new MButton("mainMenu");
	
	
	public void addButtons() {
		play.addActionListener(this);
		settings.addActionListener(this);
		exit.addActionListener(this);
		mainMenu.addActionListener(this);
	}
	
	public Console(int damage, int health ) {
		if(selection == 0) {
			this.damage = damage;
			this.health = health;
			
		}
		if(selection == 1) {
			this.damage = damage + 1;
			this.health = health - 1;
		//remove certain upgrades
		}
	}

	public int getDamage() {
		return damage;
	}

	public int getHealth() {
		return health;
	}

}
