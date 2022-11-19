package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class Room {
	private static final int ROOMWIDTH = 800;
	private static final int ROOMHEIGHT = 600;
	private RoomType type;
	private boolean isCompleted;
	private int width = ROOMWIDTH;
	private int height = ROOMHEIGHT;
	private Character player;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	//TODO: Constructor
	
	public void addPlayer(Character player) {
		this.player = player;
	}
	
	public void addBullet(Bullet b) {
		this.bullets.add(b);
	}
	
	public void deleteBullet(Bullet b) {
		this.bullets.remove(b);
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
	public void traverseMonsterArrayList(ArrayList<Monster> list) {
		for(Monster m:list) {
			if(m.isDead() == true) {
				list.remove(m);
			}
		}
	}
	
	public void traverseBulletsArrayList(ArrayList<Bullet> list) {
		for(Bullet b:list) {
			Point[] collisionDetectionPoints = new Point[8];
			collisionDetectionPoints = b.getCollisionDetectionPoints();
			for (Point p:collisionDetectionPoints) {
				if (p.getX() <= 0 || p.getX() >= ROOMWIDTH) {
					//TODO
				}
				if (p.getY() <= 0 || p.getY() >= ROOMHEIGHT) {
					//TODO
				}
			}
		}
	}

	private void getDoorNum() {
		// TODO Auto-generated method stub
		this.getDoorNum();
	}

}
