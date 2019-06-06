package application;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;

/**
 * @author Hendrik Kolterjahn
 *
 */
public class Client {
	private Socket socket;

	/** Creates a Client with a Socket connection with the specified IP and Port
	 * @param ip
	 * @param port
	 */
	public Client(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			System.out.println("Couldnt Connect to Host");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Couldnt Connect to Host (IO)");
			e.printStackTrace();
		}
	}

	/**Sends a message to the Host (PI)
	 * @param message the message to send
	 */
	void schreibeNachricht(String message) {
		PrintWriter printWriter ;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			printWriter.print(message);
			printWriter.flush();
		} catch (IOException e) {
			System.out.println("Couldnt send Message to Host");
			e.printStackTrace();
		}
		
	}
}