package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class SampleView extends StackPane {

	private ImageView linkerTrackVorImageView;
	private ImageView linkerTrackZurueckImageView;
	private ImageView rechterTrackVorImageView;
	private ImageView rechterTrackZurueckImageView;
	private ImageView lichtImageView;
	private ImageView schaufelRadImageView;
	private ImageView drehenGegenUhrzeigerImageView;
	private ImageView drehenMitUhrzeigerImageView;
	private ImageView armHebenImageView;
	private ImageView armSenkenImageView;
	private ImageView einstellungenImageView;
	private ImageView kiImageView;
	private ImageView notAusImageView;

	public SampleView() {
		Image image = new Image(getClass().getResourceAsStream("pictures/linkerTrackVor_1.png"));
		linkerTrackVorImageView = new ImageView(image);
		image = new Image(getClass().getResourceAsStream("pictures/Bilder alt/linkerTrackVor_1.png"));
		linkerTrackZurueckImageView = new ImageView(image);
		rechterTrackVorImageView = new ImageView(image);
		rechterTrackZurueckImageView = new ImageView(image);
		lichtImageView = new ImageView(image);
		schaufelRadImageView = new ImageView(image);
		drehenGegenUhrzeigerImageView = new ImageView(image);
		drehenMitUhrzeigerImageView = new ImageView(image);
		armHebenImageView = new ImageView(image);
		armSenkenImageView = new ImageView(image);
		einstellungenImageView = new ImageView(image);
		kiImageView = new ImageView(image);
		notAusImageView = new ImageView(image);

		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setCenter(linkerTrackVorImageView);
		getChildren().add(mainBorderPane);
	}

	public ImageView getLinkerTrackZurueckImageView() {
		return linkerTrackZurueckImageView;
	}

	public ImageView getRechterTrackVorImageView() {
		return rechterTrackVorImageView;
	}

	public ImageView getRechterTrackZurueckImageView() {
		return rechterTrackZurueckImageView;
	}

	public ImageView getLichtImageView() {
		return lichtImageView;
	}

	public ImageView getSchaufelRadImageView() {
		return schaufelRadImageView;
	}

	public ImageView getDrehenGegenUhrzeigerImageView() {
		return drehenGegenUhrzeigerImageView;
	}

	public ImageView getDrehenMitUhrzeigerImageView() {
		return drehenMitUhrzeigerImageView;
	}

	public ImageView getArmHebenImageView() {
		return armHebenImageView;
	}

	public ImageView getArmSenkenImageView() {
		return armSenkenImageView;
	}

	public ImageView getEinstellungenImageView() {
		return einstellungenImageView;
	}

	public ImageView getKiImageView() {
		return kiImageView;
	}

	public ImageView getNotAusImageView() {
		return notAusImageView;
	}

	public ImageView getltImageView() {
		return linkerTrackVorImageView;
	}
}
