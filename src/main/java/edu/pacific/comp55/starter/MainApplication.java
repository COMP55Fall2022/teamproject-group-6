package edu.pacific.comp55.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	protected Player player;
	private int count;
	private DataStorage data = new DataStorage();

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		player = new Player();
		load();
		setupRooms();
		player.setRoom(rooms.get(0));
	}
	// comment to submit

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Room loadRoom(int roomNumber, MainApplication screen, RoomType type, Player player, String configfile) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(configfile))) {
			ArrayList<Monster> monsters = new ArrayList<Monster>();
			ArrayList<Object> objects = new ArrayList<Object>();
			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				String[] collumns = line.split(",");
				if (collumns.length >= 6) {
					switch (collumns[0].trim()) {
					case "monster":

						double x = Double.parseDouble(collumns[2]);

						double y = Double.parseDouble(collumns[3]);

						double width = Double.parseDouble(collumns[4]);

						double height = Double.parseDouble(collumns[5]);

						switch (collumns[1].trim()) {

						case "chaser":
							monsters.add(new MonsterChaser(x, y, width, height));
							break;
						case "sentry":
							monsters.add(new MonsterSentry(x, y, width, height));
							break;
						case "patroller":
							ArrayList<Point> path = new ArrayList<Point>();
							for (int i = 6; i < collumns.length; i += 2) {
								double h = Double.parseDouble(collumns[i]);

								double g = Double.parseDouble(collumns[i + 1]);

								path.add(new Point(h, g));
							}
							MonsterPatroller m = new MonsterPatroller(x, y, width, height);
							m.setPath(path);
							monsters.add(m);
							break;
						}
						break;
					case "object":
						double ox = Double.parseDouble(collumns[2]);

						double oy = Double.parseDouble(collumns[3]);

						double owidth = Double.parseDouble(collumns[4]);

						double oheight = Double.parseDouble(collumns[5]);
						Object o = new Object(collumns[1].trim(), ox, oy, owidth, oheight);
						objects.add(o);
						break;
					}
				}
			}
			return new Room(roomNumber, screen, type, player, monsters, objects);
		} 
		catch (IOException e) {
			System.err.format("IOException: %s%n", e);
			return null;
		}
	}

	public void setupRooms() {
		rooms = new ArrayList<Room>();
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		Room room1 = loadRoom(1, this, RoomType.EMPTY, player, "room1.txt");
		rooms.add(room1);
		
		Room room2 = loadRoom(2, this, RoomType.BOSS, player, "room1.txt");
		rooms.add(room2);
		
		Room room3 = loadRoom(3, this, RoomType.BOSS, player, "room1.txt");
		rooms.add(room3);
		
		Room room4 = loadRoom(4, this, RoomType.BOSS, player, "room1.txt");
		rooms.add(room4);
		
		Room room5 = loadRoom(5, this, RoomType.BOSS, player, "room1.txt");
		rooms.add(room5);
		
	


//		Room room2 = new Room(2, this, RoomType.BOSS, player, monsters, objects);
//		rooms.add(room2);
//
//		monsters = new ArrayList<Monster>();
//		monsters.add(new MonsterChaser(500, 250, 50, 50));
//		monsters.add(new MonsterChaser(300, 300, 50, 50));
//		monsters.add(new MonsterSentry(200, 375, 50, 50));
//		monsters.add(new MonsterSentry(275, 200, 50, 50));
//		monsters.add(new MonsterSentry(350, 325, 50, 50));
//		objects = new ArrayList<Object>();
//		box = new Object("robot head.jpg", 45, 100, 50, 50);
//		objects.add(box);


		Room[] neighbors1 = { null, room2, null, null };
		room1.setNeighbors(neighbors1);

		Room[] neighbors2 = { room3, null, null, room1 };
		room2.setNeighbors(neighbors2);

		Room[] neightbors3 = { null, null, room2, room4 };
		room3.setNeighbors(neightbors3);

		Room[] neightbors4 = { room5, room3, null, null };
		room4.setNeighbors(neightbors4);

		Room[] neightbors5 = { null, null, room4, null };
		room5.setNeighbors(neightbors5);
	}

	public void run() {
		// load();
		menu = new MenuPane(this);
		setting = new SettingPane(this);
		// ending = new EndingPane(this);
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

	// merge
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
