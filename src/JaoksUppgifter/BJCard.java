package JaoksUppgifter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BJCard extends Group {

	public static final double WIDTH = 100;
	public static final double HEIGHT = 150;

	private String suit;
	private int value;

	public BJCard(int suit, int value) {

		if (suit < 1)
			suit = 1;
		if (suit > 4)
			suit = 4;
		if (value < 2)
			value = 2;
		if (value > 14)
			value = 14;

		if (suit == 1)
			this.suit = "Hearts";
		if (suit == 2)
			this.suit = "Spades";
		if (suit == 3)
			this.suit = "Diamonds";
		if (suit == 4)
			this.suit = "Clubs";

		this.value = value;

		Text colorText = new Text();
		colorText.setText(this.suit);

		Text valueText = new Text();
		if (this.value == 11) {
			valueText.setText("J");
			this.value = 10;
		} else if (this.value == 12) {
			valueText.setText("Q");
			this.value = 10;
		} else if (this.value == 13) {
			valueText.setText("K");
			this.value = 10;
		} else if (this.value == 14) {
			valueText.setText("A");
			this.value = 11;
		} else
			valueText.setText(this.value + "");

		Rectangle background = new Rectangle(WIDTH, HEIGHT);
		background.setFill(Color.WHITE);
		background.setStroke(Color.BLACK);
		background.setStrokeWidth(5);

		colorText.setFont(new Font(20));
		valueText.setFont(new Font(50));

		colorText.setTranslateX(WIDTH / 2 - colorText.getBoundsInLocal().getWidth() / 2);
		valueText.setTranslateX(WIDTH / 2 - valueText.getBoundsInLocal().getWidth() / 2);

		colorText.setTranslateY(2 * HEIGHT / 3);
		valueText.setTranslateY(HEIGHT / 3);

		if (suit == 1) {
			colorText.setFill(Color.RED);
			valueText.setFill(Color.RED);
		} else if (suit == 3) {
			colorText.setFill(Color.BLUE);
			valueText.setFill(Color.BLUE);
		} else if (suit == 4) {
			colorText.setFill(Color.GREEN);
			valueText.setFill(Color.GREEN);
		}

		this.getChildren().addAll(background, colorText, valueText);

	}

	public int getValue() {
		return this.value;
	}

}