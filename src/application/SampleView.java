package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SampleView {

	public void show (Stage stage) {
		try {
			StackPane root = (StackPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setMaximized(true);
			stage.show();
			root.requestFocus();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	ImageView linkerTrackVor;

	public void updateKeyPressed() {
		System.out.println("Pressed");
		linkerTrackVor.setImage(null);
	}
}
