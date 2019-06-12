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

	/**
	 * Creates a Client with a Socket connection with the specified IP and Port
	 * 
	 * @param ip
	 * @param port
	 */
	public Client(String ip, int port) {

		String ipnew = ip;
		for (int i = 0; i < 256; i++) {
			try {
				ipnew = ip;
				ipnew += Integer.toString(i);
				socket = new Socket(ipnew, port);
				System.out.println("Richtiger boi ist bei: "+ipnew);
				break;
			} catch (Exception e) {
				System.err.println("falscher boi :c");
				e.printStackTrace();
			}
		}

	}

	/**
	 * Sends a message to the Host (PI)
	 * 
	 * @param message
	 *            the message to send
	 */
	void sendMessage(String message) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			printWriter.print(message);
			printWriter.flush();
		} catch (IOException e) {
			System.err.println("Couldn't send message to host");
			e.printStackTrace();
		}

	}
}