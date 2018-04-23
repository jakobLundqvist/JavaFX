package JaoksUppgifter;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Studsboll extends Circle {

	private static ArrayList<Studsboll> bollar = new ArrayList<Studsboll>();
	private static AnimationTimer gravity;
	private static double g = 0.28;

	private double speedY;
	private double speedX;

	public Studsboll() {

		this.setRadius(30);
		this.speedY = 0;
		this.speedX = Math.random() * 10;
		this.setFill(new Color(Math.random(), Math.random(), Math.random(), 0.8));

		bollar.add(this);

	}

	public static void startGravity() {

		if (gravity == null) {
			gravity = new AnimationTimer() {

				@Override
				public void handle(long now) {

					for (Studsboll studsboll : bollar) {
						studsboll.fall();
					}
				}
			};
		}
		gravity.start();
	}

	public void fall() {

		this.speedY += g;

		if (this.getTranslateY() + speedY > bRuta.WINDOW_HEIGHT - this.getRadius()) {
			speedY *= -1;
		} else {
			this.setTranslateY(this.getTranslateY() + speedY);
		}

		
		if (this.getTranslateX() + speedX > bRuta.WINDOW_WIDTH - this.getRadius()) {
			speedX *= -1;
		} else if (this.getTranslateX() + speedX < 0 + this.getRadius()) {
			speedX *= -1;
		} else {
			this.setTranslateX(this.getTranslateX() + speedX );
		}
		
		

	}

}
