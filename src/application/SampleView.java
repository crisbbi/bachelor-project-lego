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
		
		// --------------------------- lower controls box ---------------------------------
		Label leftLabel = new Label("L");
		leftLabel.setStyle("-fx-font-size: 2em; -fx-text-fill: white");
		Label rightLabel = new Label("R");
		rightLabel.setStyle("-fx-font-size: 2em; -fx-text-fill: white");
		
		// left track-control box
		VBox leftTrack = (VBox) buildVBox(linkerTrackVorImageView, linkerTrackZurueckImageView, 5);
		VBox rightTrack = (VBox) buildVBox(rechterTrackVorImageView, rechterTrackZurueckImageView, 5);
		VBox leftLabelAndTrack = (VBox) buildVBox(leftLabel, leftTrack, 10);
		VBox rightLabelAndTrack = (VBox) buildVBox(rightLabel, rightTrack, 10);
		HBox leftControls = (HBox) buildHBox(leftLabelAndTrack, rightLabelAndTrack, 5);
		leftControls.setPadding(new Insets(10));
		
		// right tower-control box
		VBox baseTurning = (VBox) buildVBox(drehenMitUhrzeigerImageView, drehenGegenUhrzeigerImageView, 5);
		VBox armLift = (VBox) buildVBox(armHebenImageView, armSenkenImageView, 5);
		HBox rightControls = (HBox) buildHBox(baseTurning, armLift, 5);
		rightControls.setAlignment(Pos.BOTTOM_CENTER);
		rightControls.setPadding(new Insets(10));
		
		// light and paddle wheel in VBoxes for better alignment
		VBox schaufelRadBox = new VBox(schaufelRadImageView);
		schaufelRadBox.setPadding(new Insets(0, 0, 10, 0));
		schaufelRadBox.setAlignment(Pos.BOTTOM_LEFT);
		VBox lichtBox = new VBox(lichtImageView);
		lichtBox.setPadding(new Insets(0, 0, 32, 0));
		lichtBox.setAlignment(Pos.BOTTOM_LEFT);
		
		// put schaufel left, notAus central, licht right of center part of bottom bar
		BorderPane bottomCenteBorderPane = new BorderPane();
		bottomCenteBorderPane.setLeft(schaufelRadBox);
		bottomCenteBorderPane.setAlignment(schaufelRadBox, Pos.BOTTOM_LEFT);
		bottomCenteBorderPane.setRight(lichtBox);
		bottomCenteBorderPane.setAlignment(lichtBox, Pos.BOTTOM_RIGHT);
		bottomCenteBorderPane.setCenter(notAusImageView);
		
		// put all parts in bottom bar
		BorderPane bottomBarBorderPane = new BorderPane();
		bottomBarBorderPane.setStyle("-fx-background-color: #000");
		bottomBarBorderPane.setLeft(leftControls);
		bottomBarBorderPane.setCenter(bottomCenteBorderPane);
		bottomBarBorderPane.setRight(rightControls);
		bottomBarBorderPane.setAlignment(leftControls, Pos.CENTER);
		bottomBarBorderPane.setAlignment(rightControls, Pos.BOTTOM_CENTER);
		// --------------------------- lower controls box ---------------------------------
		
		// --------------------------- upper right controls ---------------------------------
		VBox upperRightVBox = (VBox) buildVBox(einstellungenImageView, kiImageView, 5);
		upperRightVBox.setAlignment(Pos.CENTER);
		upperRightVBox.setPadding(new Insets(10));
		BorderPane upperBorderPane = new BorderPane();
		upperBorderPane.setRight(upperRightVBox);
		// --------------------------- upper right controls ---------------------------------
		
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setBottom(bottomBarBorderPane);
		mainBorderPane.setTop(upperBorderPane);
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
		drehenGegenUhrzeigerImageView = initImageView("pictures/Bilder alt/armDrehenGegenUhrzeiger.png", drehenMitUhrzeigerImageView);
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

	public ImageView getLinkerTrackVorImageView() {
		return linkerTrackVorImageView;
	}
}
