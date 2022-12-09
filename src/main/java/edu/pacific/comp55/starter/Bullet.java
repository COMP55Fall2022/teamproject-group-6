package edu.pacific.comp55.starter;

public class Bullet extends AnimatedObject {
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	private DirectionType direction;
	private long timeOfExplosion;
	private boolean exploded;

	public Bullet(double x, double y, double speed, DirectionType direction) {
		super("bullet.png", x, y, WIDTH, HEIGHT);
		
		this.direction = direction;
		updateSpeedAndDirection(speed, direction);
		this.timeOfExplosion = 0;
		this.exploded = false;
//		for (int i = 0; i < 8; ++i) {
//			collisionDetectionPoints[i] = new Point(0, 0);
//		}
//		this.updateCollisionDetectionPoints();
	}
	
	
	public void handleCollision(Object o) {
		super.handleCollision(o);
		if(!exploded && !(o instanceof Bullet)) {
			exploded = true;
			timeOfExplosion = super.ticks;
			setImage("explosion.png");
			setBounds(getX(), getY(), WIDTH, HEIGHT);
			System.out.println("exploded, " + o);
		}
	}
	
	public void animate() {
		if (!exploded) {
			super.animate();
			
		}
		else {
			timeOfExplosion++;
			if(timeOfExplosion > 10) {
				setLocation(-1, -1);
				setVisible(false);
				System.out.println("delete me");
			}
				
		}
	}
	
	@Override
	public String toString() {
		return "Bullet [startPoint=" + getX() + ", speed=(" + xVelocity + "/" + yVelocity + "), direction=" + direction + "]";
	}

	//Tests
	public static void main(String[] args) {
//		Bullet b1 = new Bullet(0, 0, 800, DirectionType.RIGHT);
//		System.out.println(b1);
//		Point[] points = b1.getCollisionDetectionPoints();
//		for (int i = 0; i < 8; ++i) {
//			System.out.println(points[i]);
//		}
//		b1.animate();
//		System.out.println(b1);
//		for (int i = 0; i < 8; ++i) {
//			System.out.println(points[i]);
//		}
		/*Bullet b2 = new Bullet(800, 0, 800, DirectionType.LEFT);
		Bullet b3 = new Bullet(0, 0, 800, DirectionType.UP);
		Bullet b4 = new Bullet(0, 800, 800, DirectionType.DOWN);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		b1.move();
		b2.move();
		b3.move();
		b4.move();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);*/
		
	}
}
