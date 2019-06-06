package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import driver.BluetoothDriver;


/**
 * author Fabian Daum
 */
public class KeyManager extends JFrame implements KeyListener {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
		
	public KeyManager(Controller controller){
		controller.setMotorStatus(1, -1);
		this.controller = controller;
		JFrame frame = new JFrame();
		JPanel p = new JPanel();
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("KeyManager");
		p.add(label);
		add(p);
		addKeyListener(this);
		setSize(100,100);
		setVisible(true);
		
	}

	public void keyPressed(KeyEvent e) {
		//###########################################################################################
		// Schaufelrad AB/AUF  	MOTOR 0	SBRICK 0
		//###########################################################################################
		//Schaufelrad AB
		if (e.getKeyCode() == controller.getButtonSchaufelradAb()){
			if(controller.getMotorStatus(0) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 0 : AN ABWAERTS");
					}
				controller.setMotorStatus(0, -1);
			}
		}
		//Schaufelrad AUF
		if (e.getKeyCode() == controller.getButtonSchaufelradAuf()){
			if(controller.getMotorStatus(0) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 0 : AN AUFWAERTS");
				}
				controller.setMotorStatus(0, 1);
			}
		}
		//###########################################################################################
		// Foerderband links/rechts  	MOTOR 2	SBRICK 0
		//###########################################################################################
		//Foerderband links
		if (e.getKeyCode() == controller.getButtonFoerderbandLinks()){
			if(controller.getMotorStatus(2) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 2 : AN LINKS");
				}
				controller.setMotorStatus(2, -1);
			}
		}
		
		//Foerderband rechts
		if (e.getKeyCode() == controller.getButtonFoerderbandRechts()){
			if(controller.getMotorStatus(2) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 2 : AN RECHTS");
				}
				controller.setMotorStatus(2, 1);
			}
		}
		//###########################################################################################
		// Baggerarm links/rechts  	MOTOR 3	SBRICK 0
		//###########################################################################################
		//Baggerarm links
		if (e.getKeyCode() == controller.getButtonBaggerarmLinks()){
			if(controller.getMotorStatus(3) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 3 : AN LINKS");
				}
				controller.setMotorStatus(3, -1);
			}
		}
		
		//Baggerarm rechts
		if (e.getKeyCode() == controller.getButtonBaggerarmRechts()){
			if(controller.getMotorStatus(3) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 3 : AN RECHTS");
				}
				controller.setMotorStatus(3, 1);
			}
		}
		//###########################################################################################
		// Kette links  	MOTOR 4	SBRICK 1
		//###########################################################################################
		//Kette links vor
		if (e.getKeyCode() == controller.getButtonKetteLinksVor()){
			if(controller.getMotorStatus(4) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 4 : AN VORWAERTS");
				}
				controller.setMotorStatus(4, 1);
			}
		}
		
		//Kette links zurueck
		if (e.getKeyCode() == controller.getButtonKetteLinksZurueck()){
			if(controller.getMotorStatus(4) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 4 : AN RUECKWAERTS");
				}
				controller.setMotorStatus(4, -1);
			}
		}
		
		//###########################################################################################
		// Kette rechts  	MOTOR 5	SBRICK 1
		//###########################################################################################
		//Kette rechts vor
		if (e.getKeyCode() == controller.getButtonKetteRechtsVor()){
			if(controller.getMotorStatus(5) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 5 : AN VORWAERTS");
				}
				controller.setMotorStatus(5, 1);
			}
		}
		//Kette rechts zurueck
		if (e.getKeyCode() == controller.getButtonKetteRechtsZurueck()){
			if(controller.getMotorStatus(5) == 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 5 : AN RUECKWAERTS");
				}
				controller.setMotorStatus(5, -1);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//###########################################################################################
		// Schaufelrad AB/AUF  	MOTOR 0	SBRICK 0
		//###########################################################################################
		//Schaufelrad AB
		if (e.getKeyCode() == controller.getButtonSchaufelradAb()){
			if(controller.getMotorStatus(0) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 0 : AUS");
				}
				controller.setMotorStatus(0, 0);
			}
		}
		//Schaufelrad AUF
		if (e.getKeyCode() == controller.getButtonSchaufelradAuf()){
			if(controller.getDebug()) {
				if(controller.getMotorStatus(0) != 0){
					System.out.println("[KeyManager] Motor 0 : AUS");
				}
				controller.setMotorStatus(0, 0);
			}
		}
		//###########################################################################################
		// Foerderband links/rechts  	MOTOR 2	SBRICK 0
		//###########################################################################################
		//Foerderband links
		if (e.getKeyCode() == controller.getButtonFoerderbandLinks()){
			if(controller.getMotorStatus(2) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 2 : AUS");
				}
				controller.setMotorStatus(2, 0);
			}
		}
		
		//Foerderband rechts
		if (e.getKeyCode() == controller.getButtonFoerderbandRechts()){
			if(controller.getMotorStatus(2) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 2 : AUS");
				}
				controller.setMotorStatus(2, 0);
			}
		}
		//###########################################################################################
		// Baggerarm links/rechts  	MOTOR 3	SBRICK 0
		//###########################################################################################
		//Baggerarm links
		if (e.getKeyCode() == controller.getButtonBaggerarmLinks()){
			if(controller.getMotorStatus(3) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 3 : AUS");
				}
				controller.setMotorStatus(3, 0);
			}
		}
		
		//Baggerarm rechts
		if (e.getKeyCode() == controller.getButtonBaggerarmRechts()){
			if(controller.getMotorStatus(3) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 3 : AUS");
				}
				controller.setMotorStatus(3, 0);
			}
		}
		//###########################################################################################
		// Kette links  	MOTOR 4	SBRICK 1
		//###########################################################################################
		//Kette links vor
		if (e.getKeyCode() == controller.getButtonKetteLinksVor()){
			if(controller.getMotorStatus(4) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 4 : AUS");
				}
				controller.setMotorStatus(4, 0);
			}
		}
		
		//Kette links zurueck
		if (e.getKeyCode() == controller.getButtonKetteLinksZurueck()){
			if(controller.getMotorStatus(4) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 4 : AUS");
				}
				controller.setMotorStatus(4, 0);
			}
		}		
		//###########################################################################################
		// Kette rechts  	MOTOR 5	SBRICK 1
		//###########################################################################################
		//Kette rechts vor
		if (e.getKeyCode() == controller.getButtonKetteRechtsVor()){
			if(controller.getMotorStatus(5) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 5 : AUS");
				}
				controller.setMotorStatus(5, 0);
			}
		}		
		//Kette rechts zurueck
		if (e.getKeyCode() == controller.getButtonKetteRechtsZurueck()){
			if(controller.getMotorStatus(5) != 0){
				if(controller.getDebug()) {
					System.out.println("[KeyManager] Motor 5 : AUS");
				}
				controller.setMotorStatus(5, 0);
			}
		}
		//###########################################################################################
		// Schaufelrad AN/AUS  	MOTOR 1 SBRICK 0
		//###########################################################################################
		//Schaufelrad AN
		if (e.getKeyCode() == controller.getButtonSchaufelradToggle()){
			if (controller.getMotorStatus(1) == 0){
				controller.setMotorStatus(1, 1);
			}
			else {
				controller.setMotorStatus(1, 0);
			}
		}
		
		//###########################################################################################
		// RECONNECT
		//###########################################################################################
		if (e.getKeyCode() == controller.getButtonReconnect()){
			controller.setConnectionStatus(false);
		}
	}
	
	public void keyTyped(KeyEvent e) {

	}
}
