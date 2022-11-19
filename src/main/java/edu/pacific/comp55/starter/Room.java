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
	

	public void characterMovement(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A) {
				player.move(-1, 1);
				System.out.println("up left");
			}
			else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_S) {
				player.move(-1, -1);
				System.out.println("down left");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D) {
				player.move(1, -1);
				System.out.println("down right");
			}
			else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_W) {
				player.move(1, 1);
				System.out.println("up right");
			}
			else if (e.getKeyCode() == KeyEvent.VK_W) {
				player.move(0, 1);
				System.out.println("up ");
			}
			else if (e.getKeyCode() == KeyEvent.VK_A) {
				player.move(0, -1);
				System.out.println(" left");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S) {
				player.move(-1, 0);
				System.out.println("down");
			}
			else if (e.getKeyCode() == KeyEvent.VK_D) {
				player.move(1, 0);
				System.out.println("right");
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
	public void traverseMonsterArraylist(ArrayList<Monster> list) {
		for(Monster m:list) {
			if(m.isDead() == true) {
				list.remove(m);
			}
		}
	}

	private void getDoorNum() {
		// TODO Auto-generated method stub
		this.getDoorNum();
	}
}
