package edu.pacific.comp55.starter;

import java.awt.event.ActionListener;

import acm.program.GraphicsProgram;

public abstract class Console extends MainApplication implements ActionListener {
	

private Object play;
private Object settings;
private Object exit;
private Object mainMenu;
private int selection = 0;
	

	public void addButtons() {
		play.addActionListener(this);
		settings.addActionListener(this);
		exit.addActionListener(this);
		mainMenu.addActionListener(this);
	}
}
/*
	public void whichButton() {
		if(selection == 1) {
			
		}
	}

*/