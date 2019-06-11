package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * @author Hendrik Kolterjahn, Simon Buchholz
 *
 */
public class Server {
	Socket socket;

	/** Creates an Open Socket Connection on the specified Port. When connected reads incoming messages
	 * @param port
	 */
	public Server(int port) {

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			socket = waitForLogin(serverSocket);
			while (socket.isConnected()) {
				String message = readMessage();
				// TODO handle message
			}
		} catch (IOException e) {
			System.out.println("Socket setup failed (IO Exception)");
			e.printStackTrace();
		}

	}

	private Socket waitForLogin(ServerSocket serverSocket) throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	String readMessage() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// TODO set proper buffer size
		char[] buffer = new char[200];
		int charCount = bufferedReader.read(buffer, 0, 200);
		String message = new String(buffer, 0, charCount);
		return message;
	}

}
