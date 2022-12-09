package edu.pacific.comp55.starter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.google.common.base.Objects;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class RoomPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	public static final int BREAK_MS = 100;

	private Room room; 
	private GParagraph para;
	
	private MonsterChaser chaser1;
	private MonsterPatroller patroler1;
	private MonsterSentry sentry1;
	private MonsterChaser chaser2;
	private MonsterPatroller patroler2;
	private MonsterSentry sentry2;
	private MonsterChaser chaser3;
	private MonsterPatroller patroler3;
	private MonsterSentry sentry3;
	private MonsterChaser chaser4;
	private MonsterPatroller patroler4;
	private MonsterSentry sentry4;
	private MonsterChaser chaser5;
	private MonsterPatroller patroler5;
	private MonsterSentry sentry5;
	private Player player;
	
	private ArrayList<AnimatedObject> animatedObjects;

	public RoomPane(MainApplication app, Player player) {
		this.program = app;
		this.player = player;
		ArrayList<Monster> monsters = new ArrayList<Monster>();

		chaser1 = new MonsterChaser(100, 100, 60, 60);
		chaser2 = new MonsterChaser(250, 250, 75, 75);
		chaser3 = new MonsterChaser(400, 100, 25, 75);
		chaser4 = new MonsterChaser(500, 250, 100, 50);
		chaser5 = new MonsterChaser(300, 300, 150, 100);
		patroler1 = new MonsterPatroller(100, 100, 60, 60);
		patroler2 = new MonsterPatroller(200, 200, 50, 50);
		patroler3 = new MonsterPatroller(175, 175, 200, 50);
		patroler4 = new MonsterPatroller(400, 100, 50, 100);
		patroler5 = new MonsterPatroller(250, 250, 100, 50);
		sentry1 = new MonsterSentry(200, 200, 60, 60);
		sentry2 = new MonsterSentry(350, 350, 25, 75);
		sentry3 = new MonsterSentry(100, 400, 100, 100);
		sentry4 = new MonsterSentry(150, 150, 75, 25);
		sentry5 = new MonsterSentry(425, 75, 125, 125);
		ArrayList<Point> path = new ArrayList<Point>();
		path.add(new Point(100, 100));
		path.add(new Point(50, 100));
		path.add(new Point(50, 50));
		path.add(new Point(150, 50));
		path.add(new Point(400, 100));
		path.add(new Point(200, 100));
		path.add(new Point(300, 300));
		path.add(new Point(350, 300));
		path.add(new Point(600, 100));
		patroler1.setPath(path);
		monsters.add(chaser1);
		monsters.add(chaser2);
		monsters.add(chaser3);
		monsters.add(chaser4);
		monsters.add(chaser5);
		monsters.add(patroler1);
		monsters.add(patroler2);
		monsters.add(patroler3);
		monsters.add(patroler4);
		monsters.add(patroler5);
		monsters.add(sentry1);
		monsters.add(sentry2);
		monsters.add(sentry3);
		monsters.add(sentry4);
		monsters.add(sentry5);
		
		ArrayList<Object> objects = new ArrayList<Object>();

		room = new Room(program, RoomType.BOSS, player, monsters, objects);
			
	}
	
	public RoomPane(MainApplication app, Player Player, Room combat2) {
		
	}
	
	@Override
	public void showContents() {
		System.out.println("showContent RoomPane");
		room.showContents();
	}

	@Override
	public void hideContents() {
		System.out.println("hideContent RoomPane");
		room.hideContents();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		//if (obj == room) {
			//program.switchToMenu();
		//}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
		room.setPlayer(player);
	}
	
	public void removePlayer() {
//		room.removePlayer();
		this.player = null;
	}
	
	@Override
	public void animate() {
		room.animate();
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
		System.out.println("-----------------------");
		switch (e.getKeyChar()) {
		case 27:
			program.switchToMenu();
			break;
		default: 
			if (player != null) {
				player.keyTyped(e);
			}
			break;
		}
	}
}
