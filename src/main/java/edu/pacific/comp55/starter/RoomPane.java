package edu.pacific.comp55.starter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class RoomPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	public static final int BREAK_MS = 100;

	private GImage img;
	private GParagraph para;
	
	private Player player;
	
	private ArrayList<AnimatedObject> animatedObjects;

	public RoomPane(MainApplication app) {
		this.program = app;
//		img = new GImage("robot head.jpg", 100, 100);
//		para = new GParagraph("welcome\nto my\nsecret room!", 150, 300);
//		para.setFont("Arial-24");
		animatedObjects = new ArrayList<AnimatedObject>();
	}

	@Override
	public void showContents() {
		System.out.println("showContent RoomPane");
		if (player != null) {
			program.add(player);
		}
//		program.add(img);
//		program.add(para);
	}

	@Override
	public void hideContents() {
		System.out.println("hideContent RoomPane");
		if (player != null) {
			program.remove(player);
		}
		//		program.remove(img);
//		program.remove(para);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		para.setText("you need\nto click\non the eyes\nto go back");
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == img) {
			program.switchToMenu();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
		if (!animatedObjects.contains(player)) {
			animatedObjects.add(player);
			program.add(player);
		}
	}
	
	public void removePlayer() {
		if (animatedObjects.contains(player)) {
			animatedObjects.remove(player);
			program.remove(player);
		}
		this.player = null;
	}
	
	@Override
	public void animateMoves() {
		for(AnimatedObject object:animatedObjects) {
			object.move();
			checkCollisions(object);
		}
	}
	
	private void checkCollisions(AnimatedObject object) {
	}

	public void keyPressed(KeyEvent e) {
		if (player != null) {
			player.keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
		if (player != null) {
			player.keyReleased(e);
		}		
	}
	public void keyTyped(KeyEvent e) {
		if (player != null) {
			player.keyTyped(e);
		}
	}
}
