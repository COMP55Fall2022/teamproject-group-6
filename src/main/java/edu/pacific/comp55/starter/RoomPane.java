//package edu.pacific.comp55.starter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//
//import com.google.common.base.Objects;
//
//import acm.graphics.GImage;
//import acm.graphics.GObject;
//import acm.graphics.GOval;
//
//public class RoomPane extends GraphicsPane {
//	private MainApplication program; // you will use program to get access to
//										// all of the GraphicsProgram calls
//	public static final int BREAK_MS = 100;
//
//	private Room room; 
//	private GParagraph para;
//	
//	private MonsterChaser chaser1;
//	private MonsterPatroller patroler1;
//	private MonsterSentry sentry1;
//	private MonsterChaser chaser2;
//	private MonsterPatroller patroler2;
//	private MonsterSentry sentry2;
//	private MonsterChaser chaser3;
//	private MonsterPatroller patroler3;
//	private MonsterSentry sentry3;
//	private MonsterChaser chaser4;
//	private MonsterPatroller patroler4;
//	private MonsterSentry sentry4;
//	private MonsterChaser chaser5;
//	private MonsterPatroller patroler5;
//	private MonsterSentry sentry5;
//	private Player player;
//	
//	private ArrayList<AnimatedObject> animatedObjects;
//
//	public RoomPane(MainApplication app, Player player) {
//		this.program = app;
//		this.player = player;
//		ArrayList<Monster> monsters = new ArrayList<Monster>();
//
//		chaser1 = new MonsterChaser(100, 200, 75, 75);
//		chaser2 = new MonsterChaser(250, 425, 75, 75);
//		chaser3 = new MonsterChaser(400, 500, 75, 75);
//		chaser4 = new MonsterChaser(500, 250, 75, 75);
//		chaser5 = new MonsterChaser(300, 300, 75, 75);
//		patroler1 = new MonsterPatroller(150, 400, 62.5, 62.5);
//		patroler2 = new MonsterPatroller(275, 200, 62.5, 62.5);
//		patroler3 = new MonsterPatroller(425, 175, 62.5, 62.5);
//		patroler4 = new MonsterPatroller(500, 300, 62.5, 62.5);
//		patroler5 = new MonsterPatroller(350, 250, 62.5, 62.5);
//		sentry1 = new MonsterSentry(200, 375, 50, 50);
//		sentry2 = new MonsterSentry(275, 200, 50, 50);
//		sentry3 = new MonsterSentry(350, 325, 50, 50);
//		sentry4 = new MonsterSentry(425, 150, 50, 50);
//		sentry5 = new MonsterSentry(500, 275, 50, 50);
//		ArrayList<Point> path = new ArrayList<Point>();
//		path.add(new Point(100, 100));
//		path.add(new Point(50, 100));
//		path.add(new Point(50, 50));
//		path.add(new Point(150, 50));
//		path.add(new Point(400, 100));
//		path.add(new Point(200, 100));
//		path.add(new Point(300, 300));
//		path.add(new Point(350, 300));
//		path.add(new Point(600, 100));
//		patroler1.setPath(path);
//		patroler2.setPath(path);
//		patroler3.setPath(path);
//		patroler4.setPath(path);
//		patroler5.setPath(path);
//		monsters.add(chaser1);
//		monsters.add(chaser2);
////		monsters.add(chaser3);
////		monsters.add(chaser4);
////		monsters.add(chaser5);
////		monsters.add(patroler1);
////		monsters.add(patroler2);
////		monsters.add(patroler3);
////		monsters.add(patroler4);
////		monsters.add(patroler5);
//		monsters.add(sentry1);
//		monsters.add(sentry2);
//		monsters.add(sentry3);
//		monsters.add(sentry4);
//		monsters.add(sentry5);
//		
//		
//		ArrayList<Object> objects = new ArrayList<Object>();
//		
//		Object box = new Object("robot head.jpg", 300, 400, 50, 50);
//		objects.add(box);
//		box = new Object("robot head.jpg", 45, 510, 50, 50);
//		objects.add(box);
//
//		room = new Room(program, RoomType.BOSS, player, monsters, objects);
//			
//	}
//	
//	public RoomPane(MainApplication app, Player Player, Room combat2) {
//		
//	}
//	
//	@Override
//	public void showContents() {
//		System.out.println("showContent RoomPane");
//		room.showContents();
//	}
//
//	@Override
//	public void hideContents() {
//		System.out.println("hideContent RoomPane");
//		room.hideContents();
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		GObject obj = program.getElementAt(e.getX(), e.getY());
//		//if (obj == room) {
//			//program.switchToMenu();
//		//}
//	}
//
//	public Player getPlayer() {
//		return player;
//	}
//
//	public void setPlayer(Player player) {
//		this.player = player;
//		room.setPlayer(player);
//	}
//	
//	public void removePlayer() {
////		room.removePlayer();
//		this.player = null;
//	}
//	
//	@Override
//	public void animate() {
//		room.animate();
//	}
//	
//	private void checkCollisions(AnimatedObject object) {
//	}
//
//	public void keyPressed(KeyEvent e) {
//		if (player != null) {
//			player.keyPressed(e);
//		}
//	}
//	public void keyReleased(KeyEvent e) {
//		if (player != null) {
//			player.keyReleased(e);
//		}		
//	}
//	public void keyTyped(KeyEvent e) {
//		System.out.println("-----------------------");
//		switch (e.getKeyChar()) {
//		case 27:
//			program.switchToMenu();
//			break;
//		default: 
//			if (player != null) {
//				player.keyTyped(e);
//			}
//			break;
//		}
//	}
//}
