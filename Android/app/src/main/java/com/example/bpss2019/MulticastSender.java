package com.example.bpss2019;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * MulticastSender provides the functionality to find the Server IP, as a thread. It uses UDP multicast, in a specified multicast group, and makes the discovered IP accessible.
 */
public class MulticastSender implements Runnable {

    /**
     * The UDP Socket for the Multicast.
     */
    private DatagramSocket datagramSocket;

    /**
     * The Multicast address group, where the Server listens for the Multicast.
     */
    private InetAddress multicastGroup;

    /**
     * The message sent via Multicast that finds the correct Server like a handshake.
     */
    private byte[] message;

    /**
     * The address to locate the devices that respond to Multicast.
     */
    private String multicastAddress = "224.0.0.1";

    /**
     * The Server IP address.
     */
    private String serverIP = "";

    /**
     * Sets the message, which shall be sent over Wifi.
     *
     * @param messageToSend The message to be sent over Wifi
     */
    public void setMessageToMulticast(String messageToSend) {
        message = messageToSend.getBytes();
    }

    /**
     * Return the Server IP address, which has been discovered by multicast.
     *
     * @return serverIP The Server IP
     */
    public synchronized String getDiscoveredAddress() {
        return serverIP;
    }

    /**
     * Searches the Server using UDP and checks for a correct response.
     */
    public void searchServer() {
        try {
            datagramSocket = new DatagramSocket();
            multicastGroup = InetAddress.getByName(multicastAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DatagramPacket udpPacket = new DatagramPacket(message, message.length, multicastGroup, 5012);
        while (true) {
            //used for debugging
            System.out.println("Send packet with message \"" + Arrays.toString(message) + "\"");
            // send multicast
            try {
                datagramSocket.send(udpPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // used for debugging
            System.out.println("Wait for reply...");

            byte[] answer = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(answer, answer.length);
            // check multicast answer
            try {
                datagramSocket.setSoTimeout(1000);
                datagramSocket.receive(receivePacket);
                //used for debugging
                System.out.println("Multicast response from server: " + receivePacket.getAddress().getHostAddress());

                String message = new String(receivePacket.getData()).trim();

                if (message.equals("Hi Client")) {
                    // used for debugging
                    System.out.println("Server is located at: " + receivePacket.getAddress().getHostAddress());
                    serverIP = receivePacket.getAddress().getHostAddress();
                    break;
                }

                // pause before repeating
                Thread.sleep(1000);
            } catch (SocketTimeoutException e) {
                System.out.println("Socket time out.");
                setDiscoveredAddress("");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set the discovered Server IP from the multicast.
     *
     * @param IP The discovered Server IP from the multicast
     */
    public synchronized void setDiscoveredAddress(String IP) {
        serverIP = IP;
    }

    @Override
    public void run() {
        searchServer();
    }

    /**
     * Return the Server IP address.
     *
     * @return the Server IP address
     */
    public String getIP () {
        return serverIP;
    }
}
