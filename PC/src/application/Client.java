package application;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;

/**
 * @author Hendrik Kolterjahn, Simon Buchholz
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
			System.err.println("Couldn't connect to host: Unknown host");
			e.printStackTrace();
		} catch (SocketException e) {
			System.err.println("Couldn't connect to host (Socket Exception)");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't connect to host (other IO Exception)");
			e.printStackTrace();
		}
	}

	/**Sends a message to the Host (PI)
	 * @param message the message to send
	 */
	void sendMessage(String message) {
		PrintWriter printWriter ;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			printWriter.print(message);
			printWriter.flush();
		} catch (IOException e) {
			System.err.println("Couldn't send message to host");
			e.printStackTrace();
		}
		
	}
}