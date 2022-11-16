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
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	//TODO: Constructor
	
	public void addPlayer(Character player) {
		this.player = player;
	}
	
	
	
//	public void characterMovement(KeyEvent e) {
//		if(//if one key is pressed)	
//			if (e.getKeyCode() == KeyEvent.VK_W) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_A) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_S) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_D) {
//				// TODO
//			}
//		if(//if 2 keys are pressed)	
//			if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D) {
//				// TODO
//			}
//			if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_W) {
//				// TODO
//			}
//	}
	
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
	public void traverseMonsterArraylist(ArrayList<Monster> list) {
		for(Monster m:list) {
			if(m.isDead() == true) {
				list.remove(m);
			}
		}
	}

//	public void traverseBulletArraylist(ArrayList<Bullet> list) {
//		for(Bullet b:list) {
//			if(b.getCollisionDetectionPoints())
//		}
//	}
}
