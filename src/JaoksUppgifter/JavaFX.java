package JaoksUppgifter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFX extends Application {

	Scene scene;
	final double WIDTH = 600;
	final double HEIGHT = 600;

	@Override
	public void start(Stage primaryStage) throws Exception {

		scene = upg5();

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public Scene upg0() {

		Group root0 = new Group();

		Scene scene = new Scene(root0, WIDTH, HEIGHT);

		Rectangle rect = new Rectangle(300, 200);
		rect.setTranslateX(WIDTH / 2 - rect.getWidth() / 2);
		rect.setTranslateY(HEIGHT / 2 - rect.getHeight() / 2);
		rect.setFill(Color.RED);

		root0.getChildren().add(rect);

		return scene;
	}

	public Scene upg1() {

		Group root1 = new Group();
		Scene scene = new Scene(root1, WIDTH, HEIGHT);

		for (int i = 0; i < 1; i++) {

			Circle cir = new Circle(50);

			root1.getChildren().add(cir);

			cir.setTranslateX(WIDTH / 2);
			cir.setTranslateY(HEIGHT / 2);

			cir.setFill(Color.RED);
		}

		return scene;

	}

	public Scene upg2() {

		Group root2 = new Group();
		Scene scene = new Scene(root2, WIDTH, HEIGHT);

		for (int i = 0; i < 50; i++) {

			Circle cir = new Circle(50);

			root2.getChildren().add(cir);

			cir.setTranslateX(WIDTH * Math.random());
			cir.setTranslateY(HEIGHT * Math.random());

			cir.setFill(Color.RED);
		}

		return scene;

	}

	public Scene upg3() {

		Group root3 = new Group();
		Scene scene = new Scene(root3, WIDTH, HEIGHT);

		int size = 150;

		Rectangle rect1 = new Rectangle(0, 0, size, size);
		Rectangle rect2 = new Rectangle(0, scene.getHeight() - size, size, size);
		Rectangle rect3 = new Rectangle(scene.getWidth() - size, 0, size, size);
		Rectangle rect4 = new Rectangle(scene.getWidth() - size, scene.getHeight() - size, size, size);

		rect1.setFill(Color.RED);
		rect2.setFill(Color.BLUE);
		rect3.setFill(Color.GREEN);
		rect4.setFill(Color.YELLOW);

		root3.getChildren().addAll(rect1, rect2, rect3, rect4);

		return scene;
	}

	public Scene upg4() {

		Group root4 = new Group();
		Scene scene = new Scene(root4, 1600, 1000, Color.YELLOW);

		Rectangle rect1 = new Rectangle(0, 0, 500, 400);
		Rectangle rect2 = new Rectangle(0, scene.getHeight() - 400, 500, 400);
		Rectangle rect3 = new Rectangle(scene.getWidth() - 900, 0, 900, 400);
		Rectangle rect4 = new Rectangle(scene.getWidth() - 900, scene.getHeight() - 400, 900, 400);

		rect1.setFill(Color.BLUE);
		rect2.setFill(Color.BLUE);
		rect3.setFill(Color.BLUE);
		rect4.setFill(Color.BLUE);

		root4.getChildren().addAll(rect1, rect2, rect3, rect4);

		return scene;
	}

	public Scene upg5() {

		Group root5 = new Group();
		Scene scene = new Scene(root5, 500, 500);

		Rectangle rect1 = new Rectangle(scene.getWidth() / 2, scene.getHeight() / 2, 50, 50);

		Rectangle rect2 = new Rectangle(scene.getWidth() / 2, scene.getHeight() / 2, 50, 50);

		rect1.setFill(Color.MEDIUMVIOLETRED);
		rect2.setFill(Color.LIME);

		scene.setFill(Color.BLACK);

		scene.setOnKeyPressed(event -> {

			if ( event.getCode() == KeyCode.W ) {
				rect1.setTranslateY(rect1.getTranslateY() - 10);
			}
			if ( event.getCode() == KeyCode.D ) {
				rect1.setTranslateX(rect1.getTranslateX() + 10);
			}
			if ( event.getCode() == KeyCode.A ) {
				rect1.setTranslateX(rect1.getTranslateX() - 10);
			}
			if ( event.getCode() == KeyCode.S ) {
				rect1.setTranslateY(rect1.getTranslateY() + 10);
			}

			if ( event.getCode() == KeyCode.UP ) {
				rect2.setTranslateY(rect2.getTranslateY() - 10);
			}
			if ( event.getCode() == KeyCode.RIGHT ) {
				rect2.setTranslateX(rect2.getTranslateX() + 10);
			}
			if ( event.getCode() == KeyCode.LEFT ) {
				rect2.setTranslateX(rect2.getTranslateX() - 10);
			}
			if ( event.getCode() == KeyCode.DOWN ) {
				rect2.setTranslateY(rect2.getTranslateY() + 10);
			}

		});

		root5.getChildren().addAll(rect1, rect2);

		return scene;
	}

	public Scene upg6() {

		Group root6 = new Group();
		Scene scene = new Scene(root6, 500, 500);

		Circle cir = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, 50);

		cir.setFill(Color.BROWN);

		scene.setOnKeyPressed(event -> {

			if (event.getCode() == KeyCode.W) {
				cir.setTranslateY(cir.getTranslateY() - 10);
			}
			if (event.getCode() == KeyCode.D) {
				cir.setTranslateX(cir.getTranslateX() + 10);
			}
			if (event.getCode() == KeyCode.A) {
				cir.setTranslateX(cir.getTranslateX() - 10);
			}
			if (event.getCode() == KeyCode.S) {
				cir.setTranslateY(cir.getTranslateY() + 10);
			}

		});
		
		root6.getChildren().add(cir);

		return scene;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
