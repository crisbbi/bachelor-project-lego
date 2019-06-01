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
			else if (event.getCode() == KeyCode.ENTER) {
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getKiImageView().setImage(image);
			}
		});
		
		view.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.Q) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/linkerTrackVor.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/linkerTrackZurueck.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/rechterTrackVor.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/rechterTrackZurueck.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/schaufel.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.SPACE) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/notAus.png"));
				view.getNotAusImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.J) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/licht.png"));
				view.getLichtImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/armDrehenUhrzeiger.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/armDrehenGegenUhrzeiger.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/armHeben.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/armSenken.png"));
				view.getArmSenkenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.BACK_SPACE) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/einstellungen.png"));
				view.getEinstellungenImageView().setImage(image);
			}
			// ENTER-key
			else if (event.getCode() == KeyCode.ENTER) {
				Image image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/ki.png"));
				view.getKiImageView().setImage(image);
			}
		});
	}
	
	public SampleView getSampleView() {
		return view;
	}
}
