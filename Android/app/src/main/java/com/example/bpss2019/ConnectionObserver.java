package com.example.bpss2019;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;

public class ConnectionObserver implements Runnable {

    Socket socket;
    String address;
    String message;
    boolean showToast = false;

    public ConnectionObserver(String ip) {
        address = ip;
    }

    @Override
    public void run() {
        // state machine
        while (true) {
            if (socket == null || !socket.isConnected()) {
                try {
                    tryConnection();
                    if (!socket.isConnected()) {
                        Thread.sleep(1000);
                    } else {
                        showToast = true;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void tryConnection() throws IOException {
        socket = new Socket(address, 80);
    }
}
