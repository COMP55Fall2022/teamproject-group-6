package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private ArrayList<RoomPane> rooms;
	private ArrayList<Room> combat;
	private MenuPane menu;
	private SettingPane setting;
	private Player player;
	private int count;
	private DataStorage data = new DataStorage();

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		player = new Player();
		setupRooms();
		
	}
	
	public void setupRooms() {
		rooms = new ArrayList<RoomPane>();
		RoomPane r1 = new RoomPane(this, player, combat.get(0));
		RoomPane r2 = new RoomPane(this, player, combat.get(1));
		RoomPane r3 = new RoomPane(this, player, combat.get(2));
		RoomPane r4 = new RoomPane(this, player, combat.get(3));
		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
	}

	public void run() {
		System.out.println("Hello, world!");
		menu = new MenuPane(this);
		setting = new SettingPane(this);
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
		switchToScreen(rooms.get(0));
		//rooms.get(0).setPlayer(player);
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public void save() {
		data.maxHP = player.getHealth();
		data.damage = player.getDamage();
//		data.shield = player.shield();
//		data.coin = player.getCoin();
//		data.timeOfComplete = player.time();
		data.writeSaveFile();
	}
	
	public void load() {
		int dataRecieved[] = new int[5];
		dataRecieved = data.readSaveFile();
		player.health = dataRecieved[0];
		player.damage = dataRecieved[1];
//		player.shield = dataRecieved[2];
//		player.coin = dataRecieved[3];
//		player.time = dataRecieved[4];
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}
