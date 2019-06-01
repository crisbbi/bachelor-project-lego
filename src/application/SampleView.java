package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
		
		Label leftLabel = new Label("L");
		leftLabel.setStyle("-fx-font-size: 2em; -fx-text-fill: white");
		Label rightLabel = new Label("R");
		rightLabel.setStyle("-fx-font-size: 2em; -fx-text-fill: white");

		VBox leftTrack = (VBox) buildVBox(linkerTrackVorImageView, linkerTrackZurueckImageView, 5);
		VBox rightTrack = (VBox) buildVBox(rechterTrackVorImageView, rechterTrackZurueckImageView, 5);
		VBox leftLabelAndTrack = (VBox) buildVBox(leftLabel, leftTrack, 10);
		VBox rightLabelAndTrack = (VBox) buildVBox(rightLabel, rightTrack, 10);
		HBox leftControls = (HBox) buildHBox(leftLabelAndTrack, rightLabelAndTrack, 5);
		leftControls.setPadding(new Insets(10));

		BorderPane bottomBar = new BorderPane();
		bottomBar.setStyle("-fx-background-color: #000");
		bottomBar.setLeft(leftControls);
		bottomBar.setAlignment(leftControls, Pos.CENTER);
		
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setBottom(bottomBar);
		getChildren().add(mainBorderPane);
	}
	
	private Node buildHBox(Node leftItem, Node rightItem, int spacing) {
		HBox hbox = new HBox(leftItem, rightItem);
		hbox.setSpacing(spacing);
		return hbox;
	}

	private Node buildVBox(Node upperItem, Node lowerItem, int spacing) {
		VBox vbox = new VBox(upperItem, lowerItem);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(spacing);
		return vbox;
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
		imageView.setFitHeight(75);
		imageView.setFitWidth(75);
		imageView.setPreserveRatio(true);
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
