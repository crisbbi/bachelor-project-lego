package application;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SampleController {
	Stage primaryStage;
	SampleView view = new SampleView();
	
	public SampleController() {
	}

	public SampleController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		view.show(primaryStage);
	}
	
	@FXML
	public void handleKeyPressed(KeyEvent e) {
		if(e.getCode() == KeyCode.Q) {
			view.updateKeyPressed();
		}
	}
}
