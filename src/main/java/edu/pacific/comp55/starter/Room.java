package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.graphics.GRoundRect;

import java.awt.event.MouseEvent;

public class Room extends GCompound {
	private static final int ROOMWIDTH = 800;
	private static final int ROOMHEIGHT = 600;
	private RoomType type;
	private boolean isCompleted = false;
	private int width = ROOMWIDTH;
	private int height = ROOMHEIGHT;
	private Player player;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Object> objects = new ArrayList<Object>();
	
	
	public Room(RoomType type, Player player, ArrayList<Monster> monsters, ArrayList<Object> objects) {
		super();
		this.type = type;
		this.player = player;
		this.monsters = monsters;
		this.objects = objects;
//		GRect rect = new GRect(0, 0, width, height);
//		rect.setFilled(false);
//		add(rect);
		if (player != null) {
			player.setRoom(this);
			add(player);
		}
		for (Monster m:monsters) {
			m.setRoom(this);
			add(m);
		}
		for (Object o:objects) {
			add(o);
		}
	}

	public void setPlayer(Player player) {
		if (this.player != null) {
			this.player.setRoom(null);
			remove(this.player);
		}
		this.player = player;
		this.player.setRoom(this);
		add(this.player);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addBullet(Bullet b) {
		add(b);
	}
	
	public void deleteBullet(AnimatedObject b) {
		remove(b);
	}
	
	public void animate() {
		for (GObject ao:this) {
			if (ao instanceof AnimatedObject) {
				AnimatedObject animatedObject = (AnimatedObject)ao;
				animatedObject.animate();
				System.out.println("animated object: " + animatedObject);
				for (GObject o:this) {
					if (o instanceof Object && ao != o) {
						Object other = (Object)o;
						if (animatedObject.getBounds().intersects(other.getBounds())) {
							// Collision
							animatedObject.handleCollision(other);
							other.handleCollision(animatedObject);
						}
					}
				}
			}
		}
	}
	
	public void addMonsters(Monster m) {
		this.monsters.add(m);
	}
	public void deleteMonsters(Monster m) {
		this.monsters.remove(m);
	}
	public void addObjects(Object o) {
		this.objects.add(o);
	}
	public void deleteObjects(Object o) {
		this.objects.remove(o);
	}

	public void characterMovement(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_W && e.getKeyCode() == KeyEvent.VK_A) {
				player.move(-1, 1);
				System.out.println("up left");
			}
			else if (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_S) {
				player.move(-1, -1);
				System.out.println("down left");
			}
			else if (e.getKeyCode() == KeyEvent.VK_S && e.getKeyCode() == KeyEvent.VK_D) {
				player.move(1, -1);
				System.out.println("down right");
			}
			else if (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_W) {
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
		for(AnimatedObject b:list) {
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
	
	public void checkCompleted() {
		if (monsters.size() == 0) {
			this.isCompleted = true; 
		}
	}

	private void getDoorNum() {
		// TODO Auto-generated method stub
		this.getDoorNum();
	}
}
