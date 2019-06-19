package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Options builds on top of a {@link StackPane} and creates a User Interface for the main PC application
 */
public class Options extends StackPane {

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
	public Options() {
		
		// --------------------------- lower controls box ---------------------------------
		Label ipTitle = new Label("IP Adresse des Baggers:");
		ipTitle.setStyle("-fx-font-size: 2em; -fx-text-fill: white");
		Label firstDot = new Label(".");
		Label secondDot = new Label(".");
		Label thirdDot = new Label(".");
		TextField ipFirst = new TextField();
		TextField ipSecond = new TextField();
		TextField ipThird = new TextField();
		TextField ipFourth = new TextField();
		
		// left track-control box
		HBox ipSettings = new HBox(ipTitle, ipFirst, firstDot, ipSecond, secondDot, ipThird, thirdDot, ipFourth);
		
		BorderPane mainBorderPane = new BorderPane();
		mainBorderPane.setCenter(ipSettings);
		
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
