package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class SampleController {

	SampleView view;

	public SampleController(SampleView sampleView) {
		view = sampleView;

		view.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackZurueck_2.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackVor_2.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackZurueck_2.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/licht_2.png"));
				view.getLichtImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.SPACE) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/notAus.png"));
				view.getNotAusImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.J) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/schaufel_2.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenUhrzeiger_2.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenGegenUhrzeiger_2.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armHeben_2.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armSenken_2.png"));
				view.getArmSenkenImageView().setImage(image);
			}
		});
		
		view.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackZurueck_1.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackVor_1.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackZurueck_1.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				Image image = new Image(getClass().getResourceAsStream("pictures/licht_1.png"));
				view.getLichtImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.SPACE) {
				Image image = new Image(getClass().getResourceAsStream("pictures/notAus.png"));
				view.getNotAusImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.J) {
				Image image = new Image(getClass().getResourceAsStream("pictures/schaufel_1.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenUhrzeiger_1.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenGegenUhrzeiger_1.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				Image image = new Image(getClass().getResourceAsStream("pictures/armHeben_1.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				Image image = new Image(getClass().getResourceAsStream("pictures/armSenken_1.png"));
				view.getArmSenkenImageView().setImage(image);
			}
		});
	}
	
	public SampleView getSampleView() {
		return view;
	}
}
