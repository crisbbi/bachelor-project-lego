package com.example.bpss2019;

import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

/**
 * Client represents a manager that starts a multicast with MulticastSender to search for the Server as a thread and delegates the commands to be sent by a CommandSender,
 * which is also launched as a separate thread.
 */
public class Client extends Observable implements Runnable {

    private Socket socket;
    private PrintWriter printWriter;
    String address;
    private int port;
    String message;
    private MulticastSender multicastSender;

    /**
     * The constructor takes the Multicast sender and a port.
     * 
     * @param sender The Multicast object
     * @param passedPort The port for the socket connection
     */
    public Client(MulticastSender sender, int passedPort, MainActivity mainActivity) {
        multicastSender = sender;
        port = passedPort;
        addObserver(mainActivity);
        sender.setMessageToMulticast("Hi Server");
        Thread senderThread = new Thread(multicastSender);
        senderThread.start();
    }

    /**
     * Sets the message that the Client Thread shall send to the Server.
     */
    public void sendMessage(String messageToSend) {
        if(!isIPempty()) {
            CommandSender commandSender = new CommandSender(printWriter);
            commandSender.setCommandToSend(messageToSend);

            Thread sendCommandThread = new Thread(commandSender);
            sendCommandThread.start();
        }
    }

    @Override
    public void run() {
        String data;

        // Prepare thread loop for Handler to communicate with UI thread
        Looper.prepare();
        Handler handler = new Handler(Looper.getMainLooper());

        while (true) {
            try {
                socket = new Socket(multicastSender.getDiscoveredAddress(), port);
                System.out.println("Socket: " + socket);
                System.out.println("[CLIENT]Connected to Server: " + socket.getInetAddress() + ":" + socket.getPort());

                printWriter = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Successfully connected");

                // handler sends updates of successful connection to UI thread via Observer pattern
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setChanged();
                        notifyObservers("connected");
                    }
                });

                while ((data = in.readLine()) != null) {
                    System.out.println(data);
                }
            } catch (SocketException e) {
                System.out.println("Server lost.");
                multicastSender.setDiscoveredAddress("");

                // handler sends updates of failed connection to UI thread via Observer pattern
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setChanged();
                        notifyObservers("not connected");
                    }
                });

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

    public String getIP () {
        return multicastSender.getDiscoveredAddress();
    }
}