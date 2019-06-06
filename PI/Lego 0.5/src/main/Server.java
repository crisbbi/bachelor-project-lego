package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

/**
 * @author Hendrik Kolterjahn
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
			socket = warteAufAnmeldung(serverSocket);
			while (socket.isConnected()) {
				String Nachricht = leseNachricht();
				// TODO handle message
			}
		} catch (IOException e) {
			System.out.println("Setting up Socket failed somehow");
			e.printStackTrace();
		}

	}

	private Socket warteAufAnmeldung(ServerSocket serverSocket) throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	String leseNachricht() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// TODO set proper buffer size
		char[] buffer = new char[200];
		int anzahlZeichen = bufferedReader.read(buffer, 0, 200);
		String nachricht = new String(buffer, 0, anzahlZeichen);
		return nachricht;
	}

}
