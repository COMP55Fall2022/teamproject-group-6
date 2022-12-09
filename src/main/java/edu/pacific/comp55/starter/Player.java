package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class Player extends Character implements Serializable {
	public static final int MAX_VELOCITY = 15;
	int maxHP;
	int coin;
	int time;
	
	
	public Player() {
		this(200, 100, 50, 50);
	}
	
	public Player(double x, double y, double width, double height) {
		super(CharacterType.PLAYER, "player.png",  x, y, width, height);
		setFaceDirection(DirectionType.UP);
		health = maxHP;
		rateOfFire = 1;
		damage = 25;
	}
	

	@Override
	public void handleCollision(Object o) {
		//check the type of your object
		//take damage if needed
		//set dead if needed
		super.handleCollision(o);
		//check the type of your object
		//take damage if needed
		//set dead if needed
		if (o instanceof Bullet && ((Bullet) o).exploded != true) {
			isHit(25);
		} else if (o instanceof Door) {
			Door door = ((Door) o);
			Room nextRoom = door.getNextRoom();
			System.out.println("door hit");
			if(nextRoom != null) { 
//					&& getRoom().isCompleted())	{
				System.out.println("set room next door");
				setRoom(nextRoom);
				getRoom().getScreen().switchToRoom();
				System.out.println("set next room location before: " + getLocation());
				System.out.println("set next room location data: \n + " +
						"pl:" + getLocation() + "\n" + 
						"dl:" + door.getLocation() + "\n" + 
				"rm: " + room.getScreen().getWidth() + "x" + room.getScreen().getHeight() + "\n" +
				"dr: " + door.getWidth() + "x" + door.getHeight() + "\n" +	
				"pl: " + getWidth() + "x" + getHeight() + "\n");
				if(door.getY() == 0) {
					setLocation(getX(), room.getScreen().WINDOW_HEIGHT - door.getHeight() - getHeight() - 1 );
				}
				else if(door.getX() == 0) {
					setLocation(room.getScreen().WINDOW_WIDTH-door.getWidth() - getWidth() - 1, getY());
				}
				else if(door.getX() == (room.getScreen().WINDOW_WIDTH - door.getWidth())) {
					setLocation(door.getWidth() + 1, getY());
				}
				else {
					setLocation(getX(), door.getHeight() + 1);
				}
				System.out.println("set next room location after: " + getLocation());
			}
		}

	}	
	
	public void increaseVelocity(double deltaxV, double deltayV) {
		xVelocity = Math.max(Math.min(xVelocity + deltaxV, MAX_VELOCITY), -MAX_VELOCITY);
		yVelocity = Math.max(Math.min(yVelocity + deltayV, MAX_VELOCITY), -MAX_VELOCITY);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			increaseVelocity(0, -15);
			//this.move(0, -10);
			break;
		case KeyEvent.VK_DOWN:
			increaseVelocity(0, 15);
			//this.move(0, 10);
			break;
		case KeyEvent.VK_LEFT:
			increaseVelocity(-15, 0);
			//this.move(-10, 0);
			break;
		case KeyEvent.VK_RIGHT:
			increaseVelocity(15, 0);
			//this.move(10, 0);
			break;
		}
		//System.out.println("key pressed code: " + e.getKeyCode());
		//System.out.println("update speed and direction ->" + xVelocity + "," + yVelocity);
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			setyVelocity(0);
			break;
		case KeyEvent.VK_DOWN:
			setyVelocity(0);
			break;
		case KeyEvent.VK_LEFT:
			setxVelocity(0);
			break;
		case KeyEvent.VK_RIGHT:
			setxVelocity(0);
			break;
		}
		//System.out.println("key released code: " + e.getKeyCode());
		//System.out.println("update speed and direction ->" + xVelocity + "," + yVelocity);
	}
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 27:
			//System.out.println("key typed escape");
			break;
		case ' ':
			bang(getFaceDirection());
			break;
		case 'w':
			setFaceDirection(DirectionType.UP);
			bang(getFaceDirection());
			break;
		case 'a':
			setFaceDirection(DirectionType.LEFT);
			bang(getFaceDirection());
			break;
		case 's':
			setFaceDirection(DirectionType.DOWN);
			bang(getFaceDirection());
			break;
		case 'd':
			setFaceDirection(DirectionType.RIGHT);
			bang(getFaceDirection());
			break;
		}
		//System.out.println("key typed code: " + e.getKeyChar());	
	}
}
