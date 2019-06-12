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
	public Client(String ip, int port)   {

		String ipnew = ip;
		
	        ProcessBuilder builder = new ProcessBuilder(
	                "cmd.exe", "/c", "arp -a");
	            builder.redirectErrorStream(true);
	            Process p = null;
				try {
					p = builder.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            String line = null;
	            while (true) {
	                try {
						line = r.readLine();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                if (line == null) { break; }
	                String[] lines = line.split("        ");
					if(lines.length > 1 && lines[1].equals("b8-27-eb-86-d3-08     dynamisch ")) {
						ipnew = lines[0];
						ipnew = ipnew.substring(2, ipnew.length());
						System.out.println(ipnew);
						 break;
					}
	             
	            }
	     socket = new Socket();
		try {
			socket.connect(new InetSocketAddress(ipnew, port), 1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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