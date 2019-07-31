package com.example.bpss2019;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Client represents a new Socket Thread that connects to the Server and sends a message to it.
 */
public class Client implements Runnable {

    Socket socket;
    PrintWriter printWriter;
    String address;
    int port;
    String message;

    /**
     * The constructor takes an IP address. 
     * 
     * @param ip
     */
    public Client(String ip, int passedPort) {
        address = ip;
        port = passedPort;
    }

    /**
     * Sets the message that the Client Thread shall send to the Server.
     */
    public void setMessage(String messageToSend) {
        message = messageToSend;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(address, port);
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write(message);
            
            printWriter.flush();
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}