package com.example.bpss2019;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Client represents a manager that starts a multicast with MulticastSender to search for the Server as a thread and delegates the commands to be sent by a CommandSender,
 * which is also launched as a separate thread.
 */
public class Client implements Runnable {

    Socket socket;
    PrintWriter printWriter;
    String address;
    int port;
    String message;
    MulticastSender multicastSender;

    /**
     * The constructor takes the Multicast sender and a port.
     * 
     * @param sender The Multicast object
     * @param passedPort The port for the socket connection
     */
    public Client(MulticastSender sender, int passedPort) {
        multicastSender = sender;
        port = passedPort;
        sender.setMessageToMulticast("Hi Server");
        Thread senderThread = new Thread(multicastSender);
        senderThread.start();
    }

    /**
     * Sets the message that the Client Thread shall send to the Server.
     */
    public void sendMessage(String messageToSend) {
        CommandSender commandSender = new CommandSender(printWriter);
        commandSender.setCommandToSend(messageToSend);

        Thread sendCommandThread = new Thread(commandSender);
        sendCommandThread.start();
    }

    @Override
    public void run() {
        String data = "";
        while (true) {
            try {
                socket = new Socket(multicastSender.getDiscoveredAddress(), port);
                System.out.println("Socket: " + socket);
                System.out.println("[CLIENT]Connected to Server: " + socket.getInetAddress() + ":" + socket.getPort());

                printWriter = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Sucessfully connected");

                while ((data = in.readLine()) != null) {
                    System.out.println(data);
                }
            } catch (SocketException e) {
                System.out.println("Server lost.");
                multicastSender.setDiscoveredAddress("");
                multicastSender.searchServer();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isIPempty(){
        return multicastSender.getDiscoveredAddress().equals("");
    }
}