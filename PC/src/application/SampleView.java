package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * SampleView builds on top of a {@link StackPane} and creates a User Interface for the main PC application
 */
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
	private ImageView fliessBandLinksImageView;
	private ImageView fliessBandRechtsImageView;

	/**
	 * The constructor, which builds the UI
	 */
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
		HBox fliessbandSchaufelBox = new HBox(fliessBandLinksImageView, fliessBandRechtsImageView, schaufelRadImageView);
		fliessbandSchaufelBox.setPadding(new Insets(10, 0, 10, 0));
		fliessbandSchaufelBox.setSpacing(5);
		fliessbandSchaufelBox.setAlignment(Pos.BOTTOM_RIGHT);
		VBox lichtBox = new VBox(lichtImageView);
		lichtBox.setPadding(new Insets(10, 0, 10, 0));
		lichtBox.setAlignment(Pos.BOTTOM_LEFT);
		
		// put schaufel left, notAus central, licht right in BorderPane
		BorderPane bottomCenterBottomBorderPane = new BorderPane();
		bottomCenterBottomBorderPane.setRight(fliessbandSchaufelBox);
		bottomCenterBottomBorderPane.setAlignment(fliessbandSchaufelBox, Pos.BOTTOM_LEFT);
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
		webEngine.load("http://141.83.149.233:8083/javascript_simple.html");
		getChildren().add(webView);
		getChildren().add(mainBorderPane);
	}
	
	/**
	 * Builds an HBox of leftItem and rightItem with spacing in between 
	 * 
	 * @param leftItem First item put in the box
	 * @param rightItem Second item put in the box
	 * @param spacing The free space between the items
	 * @return The constructed HBox as a Node
	 */
	private Node buildHBox(Node leftItem, Node rightItem, int spacing) {
		HBox hbox = new HBox(leftItem, rightItem);
		hbox.setSpacing(spacing);
		return hbox;
	}

	/**
	 * Builds a VBox of upperItem and lowerItem with spacing in between
	 * 
	 * @param upperItem First item put in the box
	 * @param lowerItem Second item put in the box
	 * @param spacing The free space between the items
	 * @return The constructed VBox as a Node
	 */
	private Node buildVBox(Node upperItem, Node lowerItem, int spacing) {
		VBox vbox = new VBox(upperItem, lowerItem);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(spacing);
		return vbox;
	}

	/**
	 * Constructs all ImageViews
	 */
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
		fliessBandLinksImageView = initImageView("pictures/fliessbandLinks_1.png", fliessBandLinksImageView);
		fliessBandRechtsImageView = initImageView("pictures/fliessbandRechts_1.png", fliessBandRechtsImageView);
	}

	/**
	 * Constructs an ImageView from the imagePath and builds a new ImageView object from the passed imageView
	 * 
	 * @param imagePath The image's String source path 
	 * @param imageView The ImageView variable
	 * @return The constructed ImageView
	 */
	private ImageView initImageView(String imagePath, ImageView imageView) {
		image = new Image(getClass().getResourceAsStream(imagePath));
		imageView = new ImageView(image);
		imageView.setFitHeight(75);
		imageView.setFitWidth(75);
		imageView.setPreserveRatio(true);
		return imageView;
	}

	/**
	 * Returns the ImageView linkeTrackZurueckImageView
	 * 
	 * @return ImageView linkeTrackZurueckImageView
	 */
	public ImageView getLinkerTrackZurueckImageView() {
		return linkerTrackZurueckImageView;
	}

	/**
	 * Returns the ImageView rechterTrackVorImageView
	 * 
	 * @return ImageView rechterTrackVorImageView
	 */
	public ImageView getRechterTrackVorImageView() {
		return rechterTrackVorImageView;
	}

	/**
	 * Returns the ImageView rechterTrackZurueckImageView
	 * 
	 * @return ImageView rechterTrackZurueckImageView
	 */
	public ImageView getRechterTrackZurueckImageView() {
		return rechterTrackZurueckImageView;
	}

	/**
	 * Returns the ImageView lichtImageView
	 * 
	 * @return ImageView lichtImageView
	 */
	public ImageView getLichtImageView() {
		return lichtImageView;
	}

	/**
	 * Returns the ImageView schaufelRadImageView
	 * 
	 * @return ImageView schaufelRadImageView
	 */
	public ImageView getSchaufelRadImageView() {
		return schaufelRadImageView;
	}

	/**
	 * Returns the ImageView drehenGegenUhrzeigerImageView
	 * 
	 * @return ImageView drehenGegenUhrzeigerImageView
	 */
	public ImageView getDrehenGegenUhrzeigerImageView() {
		return drehenGegenUhrzeigerImageView;
	}

	/**
	 * Returns the ImageView drehenMitUhrzeigerImageView
	 * 
	 * @return ImageView drehenMitUhrzeigerImageView
	 */
	public ImageView getDrehenMitUhrzeigerImageView() {
		return drehenMitUhrzeigerImageView;
	}

	/**
	 * Returns the ImageView armHebenImageView
	 * 
	 * @return ImageView armHebenImageView
	 */
	public ImageView getArmHebenImageView() {
		return armHebenImageView;
	}

	/**
	 * Returns the ImageView armSenkenImageView
	 * 
	 * @return ImageView armSenkenImageView
	 */
	public ImageView getArmSenkenImageView() {
		return armSenkenImageView;
	}

	/**
	 * Returns the ImageView notAusImageView
	 * 
	 * @return ImageView notAusImageView
	 */
	public ImageView getNotAusImageView() {
		return notAusImageView;
	}

	/**
	 * Returns the ImageView linkerTrackVorImageView
	 * 
	 * @return ImageView linkerTrackVorImageView
	 */
	public ImageView getLinkerTrackVorImageView() {
		return linkerTrackVorImageView;
	}

	/**
	 * Returns the ImageView fliessBandLinksImageView
	 * 
	 * @return ImageView fliessBandLinksImageView
	 */
	public ImageView getFliessBandLinksImageView() {
		return fliessBandLinksImageView;
	}

	/**
	 * Returns the ImageView fliessBandRechtsImageView
	 * 
	 * @return ImageView fliessBandRechtsImageView
	 */
	public ImageView getFliessBandRechtsImageView() {
		return fliessBandRechtsImageView;
	}
}
