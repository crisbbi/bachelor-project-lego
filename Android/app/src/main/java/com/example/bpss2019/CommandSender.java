package com.example.bpss2019;

import java.io.PrintWriter;

public class CommandSender implements Runnable {

    private String commandToSend;
    private PrintWriter printWriter;

    public CommandSender(PrintWriter out) {
        printWriter = out;
    }


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
