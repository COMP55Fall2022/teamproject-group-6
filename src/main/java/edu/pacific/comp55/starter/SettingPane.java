package edu.pacific.comp55.starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class SettingPane extends GraphicsPane {
	private MainApplication program;
	
	private GButton rect1;
	private GButton rect2;
	private GButton rect3;
	private GButton rect4;
	
	public SettingPane(MainApplication app) {
		super();
		program = app;
		rect1 = new GButton("Easy", 300, 100, 200, 100);
		rect1.setFillColor(Color.RED);
		rect2 = new GButton("Normal", 300, 200, 200, 100);
		rect1.setFillColor(Color.RED);
		rect3 = new GButton("Hard", 300, 250, 200, 100);
		rect1.setFillColor(Color.RED);
		rect4 = new GButton("Back", 300, 400, 200, 100);
		rect1.setFillColor(Color.RED);
	}
	
	@Override
	public void showContents() {
		program.add(rect1);
		program.add(rect2);
		program.add(rect3);
		program.add(rect4);
	}

	@Override
	public void hideContents() {
		program.remove(rect1);
		program.remove(rect2);
		program.remove(rect3);
		program.remove(rect4);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == rect1) {
			//TODO
		}
		else if (obj == rect2) {
			//TODO 
		}
		else if (obj == rect3) {
			//TODO
		}
		else if (obj == rect4) {
			program.switchToMenu();
		}
	}
}
