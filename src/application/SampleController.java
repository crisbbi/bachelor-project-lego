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
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.SPACE) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getNotAusImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.J) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getLichtImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getArmSenkenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.BACK_SPACE) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getEinstellungenImageView().setImage(image);
			}
			// ENTER-key
			else {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getKiImageView().setImage(image);
			}
		});
		
		view.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.SPACE) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getNotAusImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.J) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getLichtImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getArmSenkenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.BACK_SPACE) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getEinstellungenImageView().setImage(image);
			}
			// ENTER-key
			else {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getKiImageView().setImage(image);
			}
		});
	}
	
	public SampleView getSampleView() {
		return view;
	}
}
