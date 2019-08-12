package com.example.bpss2019;

import java.io.PrintWriter;

/**
 * CommandSender sends a command, passed from setCommandToSend(command), and sends it over a Wifi connection (attached to a PrintWriter), which is passed to the constructor.
 */
public class CommandSender implements Runnable {

    private String commandToSend;
    private PrintWriter printWriter;

    /**
     * The constructor takes a PrintWriter, which is connected with a Socket.
     *
     * @param out The PrintWriter that is connected to a Socket
     */
    public CommandSender(PrintWriter out) {
        printWriter = out;
    }

    /**
     * Sets the command/the message that shall be sent over Wifi.
     *
     * @param command The command to be sent.
     */
    public void setCommandToSend(String command) {
        commandToSend = command;
    }

    @Override
    public void run() {
        System.out.println("[CLIENT]Sending Command to Server : " + commandToSend);
        System.out.println(printWriter);
        printWriter.println(commandToSend);
        printWriter.flush();
    }
}
