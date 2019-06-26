package mainPackage;

import java.awt.event.KeyEvent;
import java.io.IOException;

import mainPackage.KeyManager;


import driver.BluetoothDriver;

/**
 * author Fabian Daum
 */
public class Controller {
	
	//Controller 
	static Controller controller;
	
	//DEBUG-Mode
	private boolean debug = true;
	
	//Initialisierung der benoetigten Treiber fuer die SBricks
	
	static BluetoothDriver SBrick0;
	static BluetoothDriver SBrick1;

	
	//Festlegung der PC-Steuertasten 
	
	private static int buttonSchaufelradAuf = KeyEvent.VK_UP;
	private int buttonSchaufelradAb = KeyEvent.VK_DOWN;
	private int buttonSchaufelradToggle = KeyEvent.VK_1;
	private int buttonFoerderbandLinks = KeyEvent.VK_A;
	private int buttonFoerderbandRechts = KeyEvent.VK_F;
	private int buttonBaggerarmRechts = KeyEvent.VK_R;
	private int buttonBaggerarmLinks = KeyEvent.VK_Q;
	private int buttonKetteLinksVor = KeyEvent.VK_W;
	private int buttonKetteLinksZurueck = KeyEvent.VK_S;
	private int buttonKetteRechtsVor = KeyEvent.VK_D;
	private int buttonKetteRechtsZurueck = KeyEvent.VK_E;
	private int buttonReconnect = KeyEvent.VK_2;
	
	private static boolean connectionStatus;
	
	//Festlegung der MAC-Adressen
	
	private static String MAC_0 = "88:6B:0F:40:65:A4";
	private static String MAC_1 = "88:6B:0F:40:64:39";
	
	//Festlegung der Bluetooth Service ID�s
		
	private String RemoteControllServiceID = "02b8cbcc-0e25-4bda-8790-a15f53e6010f";
	private static String RemoteControllService0 = "/org/bluez/hci0/dev_88_6B_0F_40_65_A4/service0018/char0019";
	private static String RemoteControllService1 = "/org/bluez/hci0/dev_88_6B_0F_40_64_39/service0018/char0019";
	
	
	private String QickDriveServiceID = "489a6ae0-c1ab-4c9c-bdb2-11d373c1b7fb";
	private String QickDriveService = "/org/bluez/hci0/dev_88_6B_0F_40_65_A4/service0018/char001d";	
	
	private String OTAServiceID = "1d14d6ee-fd63-4fa1-bfa4-8f47b42119f0";
	private String OTAServiceControllID = "f7bf3564-fb6d-4e53-88a4-5e37e0326063";
	
	//Initialisierung der Motor-Stati
	
	private static int[] motorStatus = new int[8];
	
	public static void main(String[] args) throws IOException, InterruptedException {
		controller = new Controller();
		KeyManager keyManager = new KeyManager(controller);
		
		initializeThreads();
	}
	
	private static void initializeThreads() throws IOException, InterruptedException{
		motorStatus[1] = 0;
		SBrick0 = new BluetoothDriver(0, 0, MAC_0, controller, RemoteControllService0);
		SBrick1 = new BluetoothDriver(0, 4, MAC_1, controller, RemoteControllService1);

		Thread threadSBrick0 = new Thread(SBrick0);
		Thread threadSBrick1 = new Thread(SBrick1);
		Server server = new Server(5013);
		server.controller = controller; 
		Thread serverThread = new Thread(server);
		
		threadSBrick0.start();
		threadSBrick1.start();
		serverThread.start();
		
		connectionStatus = true;
		
		while(true){
			Thread.sleep(30000);
			System.out.println("brudder mus neu staaten");
			threadSBrick0.stop();
			threadSBrick1.stop();
		
			 threadSBrick0 = new Thread(SBrick0);
			 threadSBrick1 = new Thread(SBrick1);
			 threadSBrick0.start();
				threadSBrick1.start();
			if(connectionStatus == false){
				System.out.println("[RECONNECT]");
				SBrick0.reconnect();
				SBrick1.reconnect();
				connectionStatus = true;
			}
		}
	}
	
	//###########################################################################################
	// GETTER
	//###########################################################################################
	
	//Motor-Stati auslesen
	public static int getMotorStatus(int i) {
		return motorStatus[i];
	}
	
	//Taste fuer Schaufelrad-Auf
	public static int getButtonSchaufelradAuf() {
		return buttonSchaufelradAuf;
	}
	
	//Taste fuer Schaufelrad-Ab
	public int getButtonSchaufelradAb() {
		return buttonSchaufelradAb;
	}
	
	//Taste fuer Schaufelrad-An/Aus
	public int getButtonSchaufelradToggle() {
		return buttonSchaufelradToggle;
	}

	//Taste fuer Foederband-Links
	public int getButtonFoerderbandLinks() {
		return buttonFoerderbandLinks;
	}
	
	//Taste fuer Foederband-Rechts
	public int getButtonFoerderbandRechts() {
		return buttonFoerderbandRechts;
	}
	
	//Taste fuer Baggerarm-Links
	public int getButtonBaggerarmLinks() {
		return buttonBaggerarmLinks;
	}
	
	//Taste fuer Baggerarm-Rechts
	public int getButtonBaggerarmRechts() {
		return buttonBaggerarmRechts;
	}
	
	//Taste fuer KetteLinks-Vor
	public int getButtonKetteLinksVor() {
		return buttonKetteLinksVor;
	}
	
	//Taste fuer KetteLinks-Zurueck
	public int getButtonKetteLinksZurueck() {
		return buttonKetteLinksZurueck;
	}
	
	//Taste fuer KetteRechts-Vor
	public int getButtonKetteRechtsVor() {
		return buttonKetteRechtsVor;
	}
	
	//Taste fuer KetteRechts-Zurueck
	public int getButtonKetteRechtsZurueck() {
		return buttonKetteRechtsZurueck;
	}
	
	//Taste fuer Reconnect
	public int getButtonReconnect() {
		return buttonReconnect;
	}
	
	public boolean getConnectionStatus() {
		return connectionStatus;
	}

	//DBEUG-Status
	public boolean getDebug() {
		return debug;
	}
	
	//Remote Service Path
	public static String getRemoteControllService() {
		return RemoteControllService0;
	}
	//###########################################################################################
	// SETTER
	//###########################################################################################
	 public void setMotorStatus(int motor, int value) {
		 motorStatus[motor] = value;
	 }
	 
	public void setConnectionStatus(boolean i) {
		connectionStatus = i;
	}
	
	

}
