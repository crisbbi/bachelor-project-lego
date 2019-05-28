package application;

import javafx.stage.Stage;

public class SampleController {
	Stage primaryStage;
	SampleView view = new SampleView();

	public SampleController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		view.show(primaryStage);
	}
	
}
