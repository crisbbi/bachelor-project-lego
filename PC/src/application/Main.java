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
		//Initialize a new Client
		//TODO change to correct Port and IP
		Client client = new Client("127.0.0.1", 3000);
		samplseController.client = client;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
