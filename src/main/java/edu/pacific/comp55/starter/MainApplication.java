package edu.pacific.comp55.starter;

import java.util.ArrayList;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private ArrayList<RoomPane> rooms;
	private SomePane somePane;
	private MenuPane menu;
	private SettingPane setting;
	private Player player;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		player = new Player();
		setupRooms();
		
	}
	
	public void setupRooms() {
		rooms = new ArrayList<RoomPane>();
		RoomPane r1 = new RoomPane(this);
		
		rooms.add(r1);
	}

	public void run() {
		System.out.println("Hello, world!");
		somePane = new SomePane(this);
		menu = new MenuPane(this);
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

	public void switchToSome() {
		playRandomSound();
		switchToScreen(rooms.get(0));
		rooms.get(0).setPlayer(player);
	}

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}
