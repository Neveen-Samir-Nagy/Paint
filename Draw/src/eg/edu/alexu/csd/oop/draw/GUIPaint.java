package eg.edu.alexu.csd.oop.draw;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class GUIPaint extends Application{

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Tools.fxml"));
		Scene scence = new Scene(root);
		primaryStage.setTitle("Paint");
		primaryStage.setScene(scence);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}


}
