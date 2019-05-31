package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		SampleView sampleView = new SampleView();
		SampleController sampleController = new SampleController(sampleView);
		Scene scene = new Scene(sampleController.getSampleView());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
		scene.getRoot().requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
