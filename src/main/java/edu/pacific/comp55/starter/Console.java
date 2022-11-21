package edu.pacific.comp55.starter;

import java.awt.event.ActionListener;

import acm.program.GraphicsProgram;

public abstract class Console extends MainApplication implements ActionListener {
	

private Object play;
private Object settings;
private Object exit;
private Object mainMenu;


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
}
