package edu.pacific.comp55.starter;

import java.util.ArrayList;

import acm.graphics.GImage;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private ArrayList<Room> rooms;
	private ArrayList<Room> combat;
	private MenuPane menu;
	private SettingPane setting;
//	private EndingPane ending;
	protected  Player player;
	private int count;
	private DataStorage data = new DataStorage();

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		player = new Player();
		load();
		setupRooms();
		player.setRoom(rooms.get(0));
	}
	//comment to submit
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setupRooms() {
		rooms = new ArrayList<Room>();
		ArrayList<Monster> monsters = new ArrayList<Monster>();

		monsters.add(new MonsterChaser(100, 200, 50, 50));
		monsters.add(new MonsterChaser(250, 425, 50, 50));
		monsters.add(new MonsterChaser(400, 500, 50, 50));
		monsters.add(new MonsterSentry(425, 150, 50, 50));
		monsters.add(new MonsterSentry(500, 275, 50, 50));


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
		
		ArrayList<Point> path2 = new ArrayList<Point>();
		path2.add(new Point (50, 150));
		path2.add(new Point (100, 150));
		path2.add(new Point (100, 50));
		path2.add(new Point (200, 50));
		path2.add(new Point (400, 200));
		path2.add(new Point (600, 200));
		path2.add(new Point (600, 400));
		path2.add(new Point (300, 400));
		path2.add(new Point (150, 200));
		
		ArrayList<Point> path3 = new ArrayList<Point>();
		path2.add(new Point (200, 175));
		path2.add(new Point (200, 200));
		path2.add(new Point (300, 200));
		path2.add(new Point (300, 400));
		path2.add(new Point (500, 450));
		path2.add(new Point (350, 350));
		path2.add(new Point (100, 100));
		path2.add(new Point (50, 100));
		path2.add(new Point (250, 250));
		
  		MonsterPatroller patroler1 = new MonsterPatroller(150, 400, 62.5, 62.5);
		MonsterPatroller patroler2 = new MonsterPatroller(275, 150, 62.5, 62.5);
		MonsterPatroller patroler3 = new MonsterPatroller(600, 500, 62.5, 62.5);

		patroler1.setPath(path);
		patroler2.setPath(path2);
		patroler3.setPath(path3);
		monsters.add(patroler1);
		monsters.add(patroler2);
		monsters.add(patroler3);
		
		ArrayList<Object> objects = new ArrayList<Object>();
		
		Object box = new Object("robot head.jpg", 300, 400, 50, 50);
		objects.add(box);
		box = new Object("robot head.jpg", 45, 510, 50, 50);
		objects.add(box);

		GImage background = new GImage("room1.png", 0, 0); 
		add(background);
		Room room1 = new Room(1, this, RoomType.EMPTY, player, monsters, objects);

		rooms.add(room1);
		
		monsters = new ArrayList<Monster>();
		monsters.add(new MonsterChaser(500, 250, 50, 50));
		monsters.add(new MonsterChaser(300, 300, 50, 50));
		monsters.add(new MonsterSentry(200, 375, 50, 50));
		monsters.add(new MonsterSentry(275, 200, 50, 50));
		monsters.add(new MonsterSentry(350, 325, 50, 50));



		objects = new ArrayList<Object>();
		//box = new Object("robot head.jpg", 30, 40, 50, 50);
		//objects.add(box);
		box = new Object("robot head.jpg", 45, 100, 50, 50);
		objects.add(box);
		
		Room room2 = new Room(2, this, RoomType.BOSS, player, monsters, objects);
		rooms.add(room2);
		
		monsters = new ArrayList<Monster>();
		monsters.add(new MonsterChaser(500, 250, 50, 50));
		monsters.add(new MonsterChaser(300, 300, 50, 50));
		monsters.add(new MonsterSentry(200, 375, 50, 50));
		monsters.add(new MonsterSentry(275, 200, 50, 50));
		monsters.add(new MonsterSentry(350, 325, 50, 50));
		objects = new ArrayList<Object>();
		box = new Object("robot head.jpg", 45, 100, 50, 50);
		objects.add(box);
		
		Room room3 = new Room(3, this, RoomType.BOSS, player, monsters, objects);
		rooms.add(room3);
		
		monsters = new ArrayList<Monster>();
		monsters.add(new MonsterChaser(500, 250, 50, 50));
		monsters.add(new MonsterChaser(300, 300, 50, 50));
		monsters.add(new MonsterSentry(200, 375, 50, 50));
		monsters.add(new MonsterSentry(275, 200, 50, 50));
		monsters.add(new MonsterSentry(350, 325, 50, 50));
		objects = new ArrayList<Object>();
		box = new Object("robot head.jpg", 45, 100, 50, 50);
		objects.add(box);
		
		Room room4 = new Room(4, this, RoomType.BOSS, player, monsters, objects);
		rooms.add(room4);
		
		monsters = new ArrayList<Monster>();
		monsters.add(new MonsterChaser(500, 250, 50, 50));
		monsters.add(new MonsterChaser(300, 300, 50, 50));
		monsters.add(new MonsterSentry(200, 375, 50, 50));
		monsters.add(new MonsterSentry(275, 200, 50, 50));
		monsters.add(new MonsterSentry(350, 325, 50, 50));
		objects = new ArrayList<Object>();
		box = new Object("robot head.jpg", 45, 100, 50, 50);
		objects.add(box);
		
		Room room5 = new Room(5, this, RoomType.BOSS, player, monsters, objects);
		rooms.add(room5);
		
		Room[] neighbors1 = {null, room2, null, null};
		room1.setNeighbors(neighbors1);

		Room[] neighbors2 = {room3, null, null, room1};
		room2.setNeighbors(neighbors2);
		
		Room[] neightbors3 = {null, null, room2, room4}; 
		room3.setNeighbors(neightbors3);
		
		Room[] neightbors4 = {room5, room3, null, null}; 
		room4.setNeighbors(neightbors4);
		
		Room[] neightbors5 = {null, null, room4, null}; 
		room5.setNeighbors(neightbors5);
	}

	public void run() {
		//load();
		menu = new MenuPane(this);
		setting = new SettingPane(this);
		//ending = new EndingPane(this);
		setupInteractions();
		switchToMenu();
		
		animate();
	}

	public void switchToMenu() {
		playRandomSound();
		count++;
		switchToScreen(menu);
	}
	
	public void switchToSetting() {
		switchToScreen(setting);
	}

	public void switchToRoom() {
		playRandomSound();
		if (player.isDead() != true) {
			switchToScreen(player.getRoom());
		}
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public void save(Player player) {
		data.maxHP = player.maxHP;
//		data.damage = player.damage;
//		data.shield = player.shield();
		data.coin = player.coin;
		if (data.timeOfComplete > player.time) {
			data.timeOfComplete = player.time;
		}
		data.writeSaveFile();
	}
	//merge
	public void load() {
		int dataRecieved[] = new int[5];
		dataRecieved = data.readSaveFile();
		player.maxHP = dataRecieved[0];
		player.setHealth(player.maxHP);
//		player.damage = dataRecieved[1];
//		player.shield = dataRecieved[2];
		player.coin = dataRecieved[3];
		player.time = dataRecieved[4];
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}
