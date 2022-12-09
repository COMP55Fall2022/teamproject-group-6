package edu.pacific.comp55.starter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.graphics.GRoundRect;

import java.awt.event.MouseEvent;

public class Room extends GraphicsPane {
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
	private MainApplication screen;
	private GLabel HP;
	
	
	
	public Room(MainApplication screen, RoomType type, Player player, ArrayList<Monster> monsters, ArrayList<Object> objects) {
		super();
		this.type = type;
		this.player = player;
		this.monsters = monsters;
		this.objects = objects;
		this.screen = screen;
		Object left = new Object("bullet.png", 0, 0, 5, screen.getHeight());
		addObjects(left);
		Object right = new Object("bullet.png", screen.getWidth()-5, 0, 5, screen.getHeight());
		addObjects(right);
		Object top = new Object("bullet.png", 0, 0, screen.getWidth(), 5);
		addObjects(top);
		Object bottom = new Object("bullet.png", 0, screen.getHeight()-5, screen.getWidth(), 5);
		addObjects(bottom);
		if (player != null) {
			player.setRoom(this);
			HP = new GLabel("HP: " + player.getHealth(), 50, 50);
		}
		
	}

	public void setPlayer(Player player) {
		if (this.player != null) {
			this.player.setRoom(null);
			screen.remove(this.player);
		}
		this.player = player;
		this.player.setRoom(this);
		screen.add(this.player);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void deletePlayer() {
		
	}
	
	public void addBullet(Bullet b) {
		b.setRoom(this);
		this.bullets.add(b);
		screen.add(b);
	}
	
	public void deleteBullet(AnimatedObject b) {
		this.bullets.remove(b);
		screen.remove(b);
	}
	
	public void animate() {
		GPoint oldLocation = player.getLocation();
		player.animate();
		for(Object o: objects) {
			if(player.getBounds().intersects(o.getBounds())){
				player.setLocation(oldLocation);
				player.handleCollision(o);
			}
		}
		
		for (Monster m : monsters) {
			if(!m.isDead())	{
				oldLocation = m.getLocation();
				m.animate();
				for(Object o: objects) {
					if(m.getBounds().intersects(o.getBounds())){
						m.setLocation(oldLocation);
						m.handleCollision(o);
					}
				}

				for(Bullet b: bullets) {
					if(b.isVisible() && m.getBounds().intersects(b.getBounds())){
						m.setLocation(oldLocation);
						m.handleCollision(b);
						b.handleCollision(m);
					}
				}
				
				if(m.getBounds().intersects(player.getBounds())){
					m.setLocation(oldLocation);
					m.handleCollision(player);
					player.handleCollision(m);
				}
			}
		}
		
		for (Bullet b : bullets) {
			if(b.isVisible()) {
				oldLocation = b.getLocation();
				b.animate();
				for(Object o: objects) {
					if(b.getBounds().intersects(o.getBounds())){
						b.setLocation(oldLocation);
						b.handleCollision(o);
					}
				}

				for(Monster m : monsters) {
					if(!m.isDead() && m.getBounds().intersects(b.getBounds())){
						b.setLocation(oldLocation);
						m.handleCollision(b);
						b.handleCollision(m);
					}
				}
				
				if(b.getBounds().intersects(player.getBounds())){
					b.setLocation(oldLocation);
					b.handleCollision(player);
					player.handleCollision(b);
				}
			}
		}
		HP.setLabel("HP: " + player.getHealth());
		
		//traverseMonsterArrayList();
		//traverseBulletsArrayList();
	}
	
	public void addMonsters(Monster m) {
		this.monsters.add(m);
		this.screen.add(m);
	}
	public void deleteMonsters(Monster m) {
		this.monsters.remove(m);
		this.screen.remove(m);
	}
	public void addObjects(Object o) {
		this.objects.add(o);
		this.screen.add(o);
	}
	public void deleteObjects(Object o) {
		this.objects.remove(o);
		this.screen.remove(o);
	}
	
	public void characterShoot(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			bullets.add(player.shoot(DirectionType.UP));
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			bullets.add(player.shoot(DirectionType.DOWN));
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			bullets.add(player.shoot(DirectionType.LEFT));
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			bullets.add(player.shoot(DirectionType.RIGHT));
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
	public void traverseMonsterArrayList() {
		for(Monster m:monsters) {
			if(m.isDead() == true) {
				this.screen.remove(m);
				monsters.remove(m);
			}
		}
	}
	
	public void traverseBulletsArrayList() {
		for(AnimatedObject b:bullets) {
//			Point[] collisionDetectionPoints = new Point[8];
//			collisionDetectionPoints = b.getCollisionDetectionPoints();
//			for (Point p:collisionDetectionPoints) {
			GPoint p = b.getLocation();
				if (p.getX() <= 0 || p.getX() >= ROOMWIDTH) {
					deleteObjects(b);
				}
				if (p.getY() <= 0 || p.getY() >= ROOMHEIGHT) {
					deleteObjects(b);
				}
//			}
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
	
	@Override
	public void showContents() {
		if (player != null) {
			screen.add(player);
			screen.add(HP);
		}
		for (Monster m:monsters) {
			m.setRoom(this);
			screen.add(m);
		}
		for (Object o:objects) {
			screen.add(o);
		}

	}

	@Override
	public void hideContents() {
		if (player != null) {
			screen.remove(player);
		}
		for (Monster m:monsters) {
			screen.remove(m);
		}
		for (Object o:objects) {
			screen.remove(o);
		}
	}
	
	public void handleCollision(Object o) {
		//check the type of your object
		//take damage if needed
		//set dead if needed
		if (o instanceof Monster) {
			((Monster) o).isHit(25);
		}
		if (o instanceof Player) {
			((Player) o).isHit(25);
		}
	}
}
