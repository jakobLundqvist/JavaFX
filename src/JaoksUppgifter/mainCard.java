package JaoksUppgifter;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class mainCard extends Application {

	public static final double MARGIN = 10;
	public static final double WIDTH = BJCard.WIDTH + MARGIN;
	public static final double HEIGHT = BJCard.HEIGHT + MARGIN;

	public static ArrayList<BJPlayer> players = new ArrayList<BJPlayer>();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		BJPlayer.deck.shuffle();

		BJPlayer player1 = new BJPlayer();
		root.getChildren().add(player1);

		players.add(player1);

		player1.playerBoard();
		for (int i = 1; i < 3; i++) {

			BJBot player2 = new BJBot();

			player2.setTranslateY(BJCard.HEIGHT*i + 150*i);

			players.add(player2);

			player2.playerBoard();
			root.getChildren().add(player2);

		}

		players.get(0).activate();
		players.remove(0);

		Scene scene = new Scene(root, 1000, 1000, Color.SKYBLUE);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
