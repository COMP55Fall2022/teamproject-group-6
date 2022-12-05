package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton rect1;
//	private GButton rect2;
	private GButton rect3;
	private GButton rect4;

	public MenuPane(MainApplication app) {
		super();
		program = app;
		rect1 = new GButton("Start", 300, 100, 200, 100);
		rect1.setFillColor(Color.RED);
//		rect2 = new GButton("Volume", 300, 200, 200, 100);
//		rect1.setFillColor(Color.RED);
		rect3 = new GButton("Settings", 300, 250, 200, 100);
		rect1.setFillColor(Color.RED);
		rect4 = new GButton("Quit", 300, 400, 200, 100);
		rect1.setFillColor(Color.RED);
	}

	@Override
	public void showContents() {
		program.add(rect1);
//		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
	}

	@Override
	public void hideContents() {
		program.remove(rect1);
//		program.remove(rect2);
		program.remove(rect3);
		program.remove(rect4);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect1) {
			program.switchToSome();
		}
//		else if (obj == rect2) {
//			//TODO 
//		}
		else if (obj == rect3) {
			program.switchToSetting();
		}
		else if (obj == rect4) {
			program.save();
			System.exit(0);
		}
	}
}
