package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class SampleView extends StackPane {

	private Image image;
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
		initImageViews();
		
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setCenter(linkerTrackVorImageView);
		getChildren().add(mainBorderPane);
	}
	
	private void initImageViews() {
		linkerTrackVorImageView = initImageView("pictures/Bilder alt/linkerTrackVor.png", linkerTrackVorImageView);
		linkerTrackZurueckImageView = initImageView("pictures/Bilder alt/linkerTrackZurueck.png", linkerTrackZurueckImageView);
		rechterTrackVorImageView = initImageView("pictures/Bilder alt/rechterTrackVor.png", rechterTrackVorImageView);
		rechterTrackZurueckImageView = initImageView("pictures/Bilder alt/rechterTrackZurueck.png", rechterTrackZurueckImageView);
		lichtImageView = initImageView("pictures/Bilder alt/licht.png", lichtImageView);
		schaufelRadImageView = initImageView("pictures/Bilder alt/schaufel.png", schaufelRadImageView);
		drehenMitUhrzeigerImageView = initImageView("pictures/Bilder alt/armDrehenUhrzeiger.png", drehenMitUhrzeigerImageView);
		armHebenImageView = initImageView("pictures/Bilder alt/armHeben.png", armHebenImageView);
		armSenkenImageView = initImageView("pictures/Bilder alt/armSenken.png", armSenkenImageView);
		einstellungenImageView = initImageView("pictures/Bilder alt/einstellungen.png", einstellungenImageView);
		kiImageView = initImageView("pictures/Bilder alt/ki.png", kiImageView);
		notAusImageView = initImageView("pictures/Bilder alt/notAus.png", notAusImageView);
	}

	private ImageView initImageView(String imagePath, ImageView imageView) {
		image = new Image(getClass().getResourceAsStream(imagePath));
		imageView = new ImageView(image);
		return imageView;
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
