package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
		leftControls.setStyle("-fx-background-color: #000");
		
		// right tower-control box
		VBox baseTurning = (VBox) buildVBox(drehenMitUhrzeigerImageView, drehenGegenUhrzeigerImageView, 5);
		VBox armLift = (VBox) buildVBox(armHebenImageView, armSenkenImageView, 5);
		HBox rightControls = (HBox) buildHBox(baseTurning, armLift, 5);
		rightControls.setAlignment(Pos.BOTTOM_CENTER);
		rightControls.setPadding(new Insets(10));
		rightControls.setStyle("-fx-background-color: #000");
		
		// light and paddle wheel in VBoxes for better alignment
		VBox schaufelRadBox = new VBox(schaufelRadImageView);
		schaufelRadBox.setPadding(new Insets(10, 0, 10, 0));
		schaufelRadBox.setAlignment(Pos.BOTTOM_RIGHT);
		VBox lichtBox = new VBox(lichtImageView);
		lichtBox.setPadding(new Insets(10, 0, 10, 0));
		lichtBox.setAlignment(Pos.BOTTOM_LEFT);
		
		// put schaufel left, notAus central, licht right in BorderPane
		BorderPane bottomCenterBottomBorderPane = new BorderPane();
		bottomCenterBottomBorderPane.setRight(schaufelRadBox);
		bottomCenterBottomBorderPane.setAlignment(schaufelRadBox, Pos.BOTTOM_LEFT);
		bottomCenterBottomBorderPane.setLeft(lichtBox);
		bottomCenterBottomBorderPane.setAlignment(lichtBox, Pos.BOTTOM_RIGHT);
		bottomCenterBottomBorderPane.setCenter(notAusImageView);
		bottomCenterBottomBorderPane.setStyle("-fx-background-color: #000");
		
		// put bottomCenterBottomBorderPane on bottom part of the center of the bottom border panel
		BorderPane bottomCenteBorderPane = new BorderPane();
		bottomCenteBorderPane.setBottom(bottomCenterBottomBorderPane);
		
		// put all parts in bottom bar
		BorderPane bottomBarBorderPane = new BorderPane();
		bottomBarBorderPane.setLeft(leftControls);
		bottomBarBorderPane.setCenter(bottomCenteBorderPane);
		bottomBarBorderPane.setRight(rightControls);
		bottomBarBorderPane.setAlignment(leftControls, Pos.CENTER);
		bottomBarBorderPane.setAlignment(rightControls, Pos.BOTTOM_CENTER);
		bottomBarBorderPane.setMargin(rightControls, new Insets(40, 0, 0, 0));
		// --------------------------- lower controls box ---------------------------------
		
		// --------------------------- upper right controls ---------------------------------
		
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setBottom(bottomBarBorderPane);
		
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.load("https://youtube.de");
		getChildren().add(webView);
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
		linkerTrackVorImageView = initImageView("pictures/linkerTrackVor_1.png", linkerTrackVorImageView);
		linkerTrackZurueckImageView = initImageView("pictures/linkerTrackZurueck_1.png", linkerTrackZurueckImageView);
		rechterTrackVorImageView = initImageView("pictures/rechterTrackVor_1.png", rechterTrackVorImageView);
		rechterTrackZurueckImageView = initImageView("pictures/rechterTrackZurueck_1.png", rechterTrackZurueckImageView);
		lichtImageView = initImageView("pictures/licht_1.png", lichtImageView);
		schaufelRadImageView = initImageView("pictures/schaufel_1.png", schaufelRadImageView);
		drehenMitUhrzeigerImageView = initImageView("pictures/armDrehenUhrzeiger_1.png", drehenMitUhrzeigerImageView);
		drehenGegenUhrzeigerImageView = initImageView("pictures/armDrehenGegenUhrzeiger_1.png", drehenMitUhrzeigerImageView);
		armHebenImageView = initImageView("pictures/armHeben_1.png", armHebenImageView);
		armSenkenImageView = initImageView("pictures/armSenken_1.png", armSenkenImageView);
		notAusImageView = initImageView("pictures/notAus.png", notAusImageView);
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

	public ImageView getNotAusImageView() {
		return notAusImageView;
	}

	public ImageView getLinkerTrackVorImageView() {
		return linkerTrackVorImageView;
	}
}
