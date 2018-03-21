package JaoksUppgifter;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class bRuta extends Application {

	public static final double WINDOW_HEIGHT = 800;
	public static final double WINDOW_WIDTH = 1000;
	
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		Group root = new Group();
		
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		scene.setFill(Color.SKYBLUE);
		
		for (int i = 0; i < 50; i++){
			Studsboll boll = new Studsboll();
			boll.setTranslateX((WINDOW_WIDTH - boll.getRadius() * 2) * Math.random() + boll.getRadius());
			boll.setTranslateY((WINDOW_HEIGHT - 200) * Math.random() + boll.getRadius());
			root.getChildren().add(boll);
		}
		
		Studsboll.startGravity();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
