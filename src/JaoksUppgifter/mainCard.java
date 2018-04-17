package JaoksUppgifter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class mainCard extends Application {

	public static final double MARGIN = 10;
	public static final double WIDTH = BJCard.WIDTH + MARGIN;
	public static final double HEIGHT = BJCard.HEIGHT + MARGIN;


	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		Group root = new Group();
		
		BJPlayer.deck.shuffle();
		
		BJPlayer player1 = new BJPlayer();
		root.getChildren().add(player1);
		
		BJPlayer player2 = new BJPlayer();
		player2.setTranslateY(BJCard.HEIGHT+50);
		
		
		root.getChildren().add(player2);
		Scene scene = new Scene(root, 1000, 1000, Color.SKYBLUE);

		scene.setOnKeyPressed(event -> {

			if (event.getCode() == KeyCode.DIGIT1) {

				player1.hit();
			
			}
			if (event.getCode() == KeyCode.DIGIT2) {

				player2.hit();
			
			}
			
		});

		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
