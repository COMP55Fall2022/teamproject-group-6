package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class Room {
	private RoomType type;
	private boolean isCompleted;
	private Character player;
	private ArrayList<Character> characters = new ArrayList<Character>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	//TODO: Constructor
	
	public void addPlayer(Character player) {
		this.player = player;
	}//comment
	
	
	
	public void characterMovement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			// TODO
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			// TODO
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			// TODO
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			// TODO
		}
	}
	
	public void characterAbilities(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			// TODO
		}
		if (e.getKeyCode() == KeyEvent.VK_E) {
			// TODO
		}
	}
	
	public void quitGame(KeyEvent e1, MouseEvent e2) {
		//TODO
		//no more than 3 mouse clicks or key presses
	}

}
