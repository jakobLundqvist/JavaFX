package JaoksUppgifter;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class main extends Application {

	public static final double WINDOW_WIDTH = 1000;
	public static final double WINDOW_HEIGHT = 800;
	public static final double raket_SIZE = 75;

	public static final ArrayList<KeyCode> keys = new ArrayList<KeyCode>();

	public static void main1(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();

		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);

		Raket raket = new Raket(raket_SIZE);

		root.getChildren().add(raket);

		scene.setOnKeyPressed(event -> {

			if (!keys.contains(event.getCode())) {
				keys.add(event.getCode());
			}

		});

		

		scene.setOnKeyReleased(event -> {

			if (keys.contains(event.getCode())) {

				keys.remove(event.getCode());
			}

			KeyCode key = event.getCode();

			switch (key) {

			case SPACE:
				raket.moveUp();
				raket.fire.setFill(Color.TRANSPARENT);
				break;
			default:
				break;
			}
		});

		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {

				for (int i = 0; i < keys.size(); i++) {

					KeyCode key = keys.get(i);

					switch (key) {

					case W:
						raket.moveUp();
						break;
					case D:
						raket.setRotate(raket.getRotate() + 2);
						break;
					case A:
						raket.setRotate(raket.getRotate() - 2);
						break;
					default:
						break;

					case SPACE:
						raket.moveUp();
						raket.fire.setFill(Color.RED);
						break;
					}

					if (raket.getTranslateX() > WINDOW_WIDTH) {
						raket.setTranslateX(0 - raket_SIZE);
					} else if (raket.getTranslateX() < -raket_SIZE) {
						raket.setTranslateX(WINDOW_WIDTH);
					}

					if (raket.getTranslateY() > WINDOW_HEIGHT) {
						raket.setTranslateY(0 - raket_SIZE);
					} else if (raket.getTranslateY() < -raket_SIZE) {
						raket.setTranslateY(WINDOW_HEIGHT);
					}

				}

			}

		};

		at.start();

		primaryStage.setScene(scene);
		primaryStage.show();
		
		for (int i = 0; i < 120; i++) {

			Circle cir = new Circle(0.6);

			root.getChildren().add(cir);

			cir.setTranslateX(WINDOW_WIDTH * Math.random());
			cir.setTranslateY(WINDOW_HEIGHT * Math.random());

			cir.setFill(Color.YELLOW);
		}

		for (int i = 0; i < 8; i++) {

			Circle cir = new Circle(Math.random() * 30 + 50);

			root.getChildren().add(cir);

			cir.setTranslateX(WINDOW_WIDTH * Math.random());
			cir.setTranslateY(WINDOW_HEIGHT * Math.random());

			cir.setFill(Color.CHOCOLATE);
		}

	}

}
