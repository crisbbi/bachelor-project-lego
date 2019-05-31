package application;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SampleController {

	SampleView view;

	public SampleController(SampleView sampleView) {
		view = sampleView;

		view.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getltImageView().setImage(image);
			}
		});
		
		view.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getltImageView().setImage(image);
			}
		});
	}
	
	public SampleView getSampleView() {
		return view;
	}
}
