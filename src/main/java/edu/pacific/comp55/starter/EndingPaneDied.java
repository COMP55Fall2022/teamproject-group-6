package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

import acm.graphics.GLabel;
import acm.graphics.GObject;

public class EndingPaneDied extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect1;
	private GLabel p1;

	public EndingPaneDied(MainApplication app) {
		super();
		program = app;
		rect1 = new GButton("Quit", 300, 400, 200, 100);
		p1 = new GLabel("You died!", 300, 100);
		p1.setFont(new Font("Arial", Font.PLAIN, 30));	
	}

	@Override
	public void showContents() {
		program.add(rect1);
		program.add(p1);
	}

	@Override
	public void hideContents() {
		program.remove(rect1);
		program.remove(p1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect1) {
			System.exit(0);
		}
	}
}
