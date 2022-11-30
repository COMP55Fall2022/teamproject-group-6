package edu.pacific.comp55.starter;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GRoundRect;

public class MonsterPatroller extends Monster {
	private ArrayList<Point> path;
	private int nextPoint;
	

	public MonsterPatroller(double x, double y, double width, double height) {
		super(CharacterType.MONSTER2, "patrolrobot.png", x, y, width, height);
		setFaceDirection(DirectionType.NONE);
		path = new ArrayList<Point>();
		nextPoint = 0;
		health = 75;
		rateOfFire = 1;
		speedOfBullet = 1;
		damage = 25;
	}

	public ArrayList<Point> getPath() {
		return path;
	}

	public void setPath(ArrayList<Point> path) {
		this.path = path;
	}
	
	public void animate() {
		super.animate();
		// Logic to follow the given path
		if (path.size() > 0) {
			Point np = path.get(nextPoint);
			if (getX() == np.getX() && getY() == np.getY()) {
				nextPoint++;
				if (nextPoint >= path.size()) {
					nextPoint = 0;
				}
				np = path.get(nextPoint);
			}
			if (getX() > np.getX()) {
				updateSpeedAndDirection(10, DirectionType.LEFT);
			} else if (getX() < np.getX()) {
				updateSpeedAndDirection(10, DirectionType.RIGHT);
			} else { // getX() == np.getX()
				if (getY() > np.getY()) {
					updateSpeedAndDirection(10, DirectionType.UP);
				} else if (getY() < np.getY()) {
					updateSpeedAndDirection(10, DirectionType.DOWN);
				}
			}
		}
	}
}
