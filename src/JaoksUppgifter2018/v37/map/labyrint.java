package JaoksUppgifter2018.v37.map;

import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class labyrint extends Application {

	int count = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Map map = MapInterpreter.interpretMap(new File("map.txt"));

		Scene scene = new Scene(map, map.getWidth(), map.getHeight());

		MapSolver solver = new MapSolver(map.getStartX(), map.getStartY(), map);

		primaryStage.setScene(scene);
		primaryStage.show();

		new AnimationTimer() {

			long before = 0;

			public void handle(long now) {
				if (now - before >= 1_0_000_0000) {
					before = now;
					if (count < solver.path.size()) {

						map.getChildren().add(solver.path.get(count));
						count++;
					} else {

						System.out.println(solver.path.size());
						this.stop();
					}
				}
			}

		}.start();
	}

	public static void main(String[] args) {
		launch();
	}
}