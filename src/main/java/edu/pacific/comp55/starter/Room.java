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
	private boolean isCompleted = false;
	private int width = ROOMWIDTH;
	private int height = ROOMHEIGHT;
	private Character player;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Object> objects = new ArrayList<Object>();
	
	
	public Room(RoomType type, Character player, ArrayList<Monster> monsters, ArrayList<Object> objects) {
		super();
		this.type = type;
		this.player = player;
		this.monsters = monsters;
		this.objects = objects;
	}

	public void addPlayer(Character player) {
		this.player = player;
	}
	
	public void addBullet(Bullet b) {
		this.bullets.add(b);
	}
	
	public void deleteBullet(Bullet b) {
		this.bullets.remove(b);
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
	
	public void characterShoot(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.shoot(DirectionType.UP);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.shoot(DirectionType.DOWN);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.shoot(DirectionType.LEFT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			player.shoot(DirectionType.RIGHT);
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
					deleteBullet(b);
				}
				if (p.getY() <= 0 || p.getY() >= ROOMHEIGHT) {
					deleteBullet(b);
				}
			}
		}
	}

	private void getDoorNum() {
		// TODO Auto-generated method stub
		this.getDoorNum();
	}
}
