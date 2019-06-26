package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketAddress;

import mainPackage.Controller;

/**
 * @author Hendrik Kolterjahn, Simon Buchholz
 * 
 */
public class Server implements Runnable {
	Socket socket;
	ServerSocket serverSocket;
	public Controller controller;

	/**
	 * Creates an Open Socket Connection on the specified Port. When connected
	 * reads incoming messages
	 * 
	 * @param port
	 */
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I bims 1 server am start auf "
				+ Integer.toString(port) + " vong port her");

	}

	private Socket waitForLogin(ServerSocket serverSocket) throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	String readMessage() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		// TODO set proper buffer size
		
		char[] buffer = new char[200];
		int charCount = bufferedReader.read(buffer, 0, 200);
		if (charCount < 1) {
			return "";
		}
		String message = new String(buffer, 0, charCount);
		return message;
		//return bufferedReader.readLine();
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for Client");
				socket = waitForLogin(serverSocket);
				System.out.println("Client connected to me");
				LED.setWhiteOn();
				while (socket.isConnected()) {
					String message = readMessage();
					//System.out.println(message);
					// TODO handle message
					String[] messages = message.split(" ");
					for (int i = 0; i < messages.length; i++) {
						message = messages[i];
						if (message.length() > 1) {
							System.out.println(message);
						} else {
							break;
						}
						if (message.equals("SchaufelradABAN")) {
							if (controller.getMotorStatus(0) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 0 : AN ABWAERTS");
								}
								controller.setMotorStatus(0, 1);
							}
						}
						if (message.equals("SchaufelradAUFAN")) {
							if (controller.getMotorStatus(0) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 0 : AN AUFWAERTS");
								}
								controller.setMotorStatus(0, -1);
							}
						}
						if (message.equals("FliessbandDREHENLINKS")) {
							if (controller.getMotorStatus(2) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 2 : AN LINKS");
								}
								controller.setMotorStatus(2, -1);
							}
						}
						if (message.equals("FliessbandDREHENRECHTS")) {
							if (controller.getMotorStatus(2) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 2 : AN RECHTS");
								}
								controller.setMotorStatus(2, 1);
							}
						}
						if (message.equals("BaggerarmlinksAN")) {
							if (controller.getMotorStatus(3) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 3 : AN LINKS");
								}
								controller.setMotorStatus(3, 1);
							}
						}
						if (message.equals("LICHT")) {
							LED.setOff();
						}
						if (message.equals("BaggerarmrechtsAN")) {
							if (controller.getMotorStatus(3) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 3 : AN RECHTS");
								}
								controller.setMotorStatus(3, -1);
							}
						}
						if (message.equals("KettelinksvorAN")) {
							if (controller.getMotorStatus(4) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 4 : AN VORWAERTS");
								}
								controller.setMotorStatus(4, 1);
							}
						}
						if (message.equals("KettelinkszurueckAN")) {
							if (controller.getMotorStatus(4) == 0) {
								LED.setOrangeOn();
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 4 : AN RUECKWAERTS");
								}
								controller.setMotorStatus(4, -1);
							}
						}
						if (message.equals("KetterechtsvorAN")) {
							if (controller.getMotorStatus(5) == 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 5 : AN VORWAERTS");
								}
								controller.setMotorStatus(5, 1);
							}
						}
						if (message.equals("KetterechtszurueckAN")) {
							if (controller.getMotorStatus(5) == 0) {
								LED.setOrangeOn();
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 5 : AN RUECKWAERTS");
								}
								controller.setMotorStatus(5, -1);
							}
						}

						if (message.equals("SchaufelradABAUS")) {
							if (controller.getMotorStatus(0) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 0 : AUS");
								}
								controller.setMotorStatus(0, 0);
							}
						}
						if (message.equals("SchaufelradAUFAUS")) {
							if (controller.getDebug()) {
								if (controller.getMotorStatus(0) != 0) {
									System.out
											.println("[KeyManager] Motor 0 : AUS");
								}
								controller.setMotorStatus(0, 0);
							}
						}
						if (message.equals("FliessbandDrehenLinksAUS")) {
							if (controller.getMotorStatus(2) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 2 : AUS");
								}
								controller.setMotorStatus(2, 0);
							}
						}
						if (message.equals("FliessbandDrehenRechtsAUS")) {
							if (controller.getMotorStatus(2) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 2 : AUS");
								}
								controller.setMotorStatus(2, 0);
							}
						}
						if (message.equals("BaggerarmlinksAUS")) {
							if (controller.getMotorStatus(3) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 3 : AUS");
								}
								controller.setMotorStatus(3, 0);
							}
						}
						if (message.equals("BaggerarmrechtsAUS")) {
							if (controller.getMotorStatus(3) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 3 : AUS");
								}
								controller.setMotorStatus(3, 0);
							}
						}
						if (message.equals("KettelinksvorAUS")) {
							if (controller.getMotorStatus(4) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 4 : AUS");
								}
								controller.setMotorStatus(4, 0);
							}
						}
						if (message.equals("KettelinkszurueckAUS")) {
							if (controller.getMotorStatus(4) != 0) {
								LED.setOff();
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 4 : AUS");
								}
								controller.setMotorStatus(4, 0);
							}
						}
						if (message.equals("KetterechtsvorAUS")) {
							if (controller.getMotorStatus(5) != 0) {
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 5 : AUS");
								}
								controller.setMotorStatus(5, 0);
							}
						}
						if (message.equals("KetterechtszurueckAUS")) {
							if (controller.getMotorStatus(5) != 0) {
								LED.setOff();
								if (controller.getDebug()) {
									System.out
											.println("[KeyManager] Motor 5 : AUS");
								}
								controller.setMotorStatus(5, 0);
							}
						}
						if (message.equals("SchaufelradAN")) {
							if (controller.getMotorStatus(1) == 0) {
								controller.setMotorStatus(1, 1);
							} else {
								controller.setMotorStatus(1, 0);
							}
						}
						if (message.equals("SchaufelradAUS")) {
							if (controller.getMotorStatus(1) == 0) {
								controller.setMotorStatus(1, 0);
							} else {
								controller.setMotorStatus(1, 0);
							}
						}
					}
					if (message.equals("END")) {
						System.out.println("Brudder er muste los");
						socket = waitForLogin(serverSocket);
					}

				}
				System.out.println("COnection gone :c");
			} catch (Exception e) {
				System.out.println("Client disconnected");
				
			}
		}
	}

}
