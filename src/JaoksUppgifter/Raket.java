package JaoksUppgifter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Raket extends Group {

	Polygon fire;
	public Raket() {
		this(75d);
	}

	public Raket(double width) {

		Rectangle top = new Rectangle(width / 3, 3 * width / 3);
		
		top.setFill(Color.GREY);

		Polygon righttriangle = new Polygon();
		righttriangle.getPoints().addAll(new Double[] { 25.0, 75.0, 25.0, 40.0, 60.0, 95.0 });
		righttriangle.setFill(Color.GREY);
		
		Polygon lefttriangle = new Polygon();
		lefttriangle.getPoints().addAll(new Double[] { 0.0, 75.0, 0.0, 40.0, -35.0, 95.0 });
		lefttriangle.setFill(Color.GREY);
		
		Polygon toptriangle = new Polygon();
		toptriangle.getPoints().addAll(new Double[] { 25.0, 0.0, 0.0, 0.0, 12.5, -35.0 });
		toptriangle.setFill(Color.GREY);
		
		fire = new Polygon();
		fire.getPoints().addAll(new Double[] { 0.0, 75.0, 25.0, 75.0, 12.5, 100.0 });
		fire.setFill(Color.TRANSPARENT);
		
		
		this.getChildren().addAll(top, righttriangle, lefttriangle, toptriangle, fire);

	}

	public void moveUp() {
		double deg = this.getRotate()-90;
		deg = Math.toRadians(deg);

		this.setTranslateY(this.getTranslateY() + Math.sin(deg) * 5);
		this.setTranslateX(this.getTranslateX() + Math.cos(deg) * 5);

	}

}

