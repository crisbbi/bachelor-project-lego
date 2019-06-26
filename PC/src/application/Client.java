package application;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
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
	 * @throws  
	 */
	//:sout=#transcode{vcodec=WMV2,vb=800,acodec=wma2,ab=128,channels=2,samplerate=44100,scodec=none}:http{dst=:8080/moin.wmv} :no-sout-all :sout-keep
	public Client(String ip, int port)   {

		try {

			 socket = new Socket(ip, port);

		} catch (Exception e) {
			System.out.println("Couldnt connect to PI");

		}

	}

	/**
	 * Sends a message to the Host (PI)
	 * 
	 * @param message the message to send
	 */
	void sendMessage(String message) {
		PrintWriter printWriter;
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