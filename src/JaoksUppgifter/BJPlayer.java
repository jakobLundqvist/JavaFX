package JaoksUppgifter;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BJPlayer extends Group {

	static CardDeck deck = new CardDeck();

	Text hit;
	Text handValue;

	ArrayList<BJCard> hand = new ArrayList<BJCard>();
	boolean hasStopped = false;

	public BJPlayer() {
		handValue = new Text();
		hit();
		hit();

	}

	public int getHandValue() {
		int sum = 0;

		// for(BJCard c : hand){
		for (int i = 0; i < hand.size(); i++) {
			BJCard c = hand.get(i);
			sum += c.getValue();
		}
		return sum;
	}

	public void hit() {

		if (!hasStopped && getHandValue() < 21) {

			BJCard c = deck.Draw();
			c.setTranslateX(hand.size() * (BJCard.WIDTH + 10));
			hand.add(c);
			this.getChildren().add(c);
			handValue.setText("Value: " + getHandValue());

			if (getHandValue() > 21) {
				stand();
			}
		}
	}

	public void stand() {
		hasStopped = true;
		hit.setOnMouseClicked(event -> {

		});

		if (mainCard.players.size() > 0) {
			mainCard.players.get(0).activate();
		}
	}

	public void playerBoard() {

		Circle cir1 = new Circle(30);

		cir1.setTranslateX(200);
		cir1.setTranslateY(BJCard.HEIGHT + 70);
		cir1.setFill(Color.FORESTGREEN);

		cir1.setStroke(Color.BLACK);
		cir1.setStrokeWidth(5);

		Circle cir2 = new Circle(30);

		cir2.setTranslateX(300);
		cir2.setTranslateY(BJCard.HEIGHT + 70);
		cir2.setFill(Color.RED);

		cir2.setStroke(Color.BLACK);
		cir2.setStrokeWidth(5);

		this.getChildren().addAll(cir1, cir2);


		hit = new Text();

		hit.setText("H");

		hit.setFill(Color.BLACK);

		hit.setTranslateX(185);
		hit.setTranslateY(BJCard.HEIGHT + 85);

		hit.setFont(new Font(40));

		this.getChildren().add(hit);

		Text stand = new Text();

		stand.setText("S");

		stand.setFill(Color.BLACK);

		stand.setTranslateX(290);
		stand.setTranslateY(BJCard.HEIGHT + 85);

		stand.setFont(new Font(40));

		this.getChildren().add(stand);

		
		stand.setOnMouseClicked(event -> {

			stand();

		});
		
		Rectangle rect = new Rectangle(200, 60);

		rect.setTranslateX(390);
		rect.setTranslateY(BJCard.HEIGHT + 40);
		rect.setFill(Color.BURLYWOOD);

		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(5);

		this.getChildren().add(rect);

		handValue = new Text();

		handValue.setText("Value: " + getHandValue());

		handValue.setFill(Color.BLACK);

		handValue.setTranslateX(400);
		handValue.setTranslateY(BJCard.HEIGHT + 85);

		handValue.setFont(new Font(45));

		this.getChildren().add(handValue);

	}

	public void activate() {

		hit.setOnMouseClicked(event -> {

			hit();

		});

	}
}
