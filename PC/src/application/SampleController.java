package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class SampleController {

	SampleView view;
	Client client;
	public SampleController(SampleView sampleView) {
		view = sampleView;

		view.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.Q) {
				client.sendMessage("KettelinksvorAN");
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_2.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				client.sendMessage("KettelinkszurueckAN");
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackZurueck_2.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				client.sendMessage("KetterechtsvorAN");
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackVor_2.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				client.sendMessage("KetterechtszurueckAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackZurueck_2.png"));
				view.getRechterTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.D) {
				//client.sendMessage("KettelinksvorAN");
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
				client.sendMessage("SchaufelradAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/schaufel_2.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				client.sendMessage("BaggerarmrechtsAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenUhrzeiger_2.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				client.sendMessage("BaggerarmlinksAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenGegenUhrzeiger_2.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				client.sendMessage("SchaufelradAUFAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armHeben_2.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				client.sendMessage("SchaufelradABAN");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/armSenken_2.png"));
				view.getArmSenkenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.G) {
				client.sendMessage("FliessbandDREHENLINKS");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/fliessbandLinks_2.png"));
				view.getFliessBandLinksImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.H) {
				client.sendMessage("FliessbandDREHENRECHTS");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/fliessbandRechts_2.png"));
				view.getFliessBandRechtsImageView().setImage(image);
			}
		});
		
		view.setOnKeyReleased(event -> {
			if (event.getCode() == KeyCode.Q) {
				client.sendMessage("KettelinksvorAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
				view.getLinkerTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.A) {
				client.sendMessage("KettelinkszurueckAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackZurueck_1.png"));
				view.getLinkerTrackZurueckImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.W) {
				client.sendMessage("KetterechtsvorAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/rechterTrackVor_1.png"));
				view.getRechterTrackVorImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.S) {
				client.sendMessage("KetterechtszurueckAUS");
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
				client.sendMessage("SchaufelradAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/schaufel_1.png"));
				view.getSchaufelRadImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.I) {
				client.sendMessage("BaggerarmrechtsAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenUhrzeiger_1.png"));
				view.getDrehenMitUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.K) {
				client.sendMessage("BaggerarmlinksAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/armDrehenGegenUhrzeiger_1.png"));
				view.getDrehenGegenUhrzeigerImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.O) {
				client.sendMessage("SchaufelradAUFAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/armHeben_1.png"));
				view.getArmHebenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.L) {
				client.sendMessage("SchaufelradABAUS");
				Image image = new Image(getClass().getResourceAsStream("pictures/armSenken_1.png"));
				view.getArmSenkenImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.G) {
				client.sendMessage("FliessbandDrehenLinksAUS");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/fliessbandLinks_1.png"));
				view.getFliessBandLinksImageView().setImage(image);
			}
			else if (event.getCode() == KeyCode.H) {
				client.sendMessage("FliessbandDrehenRechtsAUS");
				// TODO Bildadresse einfügen
				Image image = new Image(getClass().getResourceAsStream("pictures/fliessbandRechts_1.png"));
				view.getFliessBandRechtsImageView().setImage(image);
			}
		});
	}
	
	public SampleView getSampleView() {
		return view;
	}
}
