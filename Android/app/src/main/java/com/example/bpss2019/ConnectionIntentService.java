package com.example.bpss2019;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionIntentService extends JobIntentService {

    private static final String DEBUGTAG = "ConnectionIntentService";
    String address;
    boolean connectedToastWasShown = false;
    boolean notConnectedToastWasShown = false;

    public Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler(Looper.getMainLooper());
        Log.d(DEBUGTAG, "onCreate");
    }

    static void enqueueWork(Context context, Intent intent){
        enqueueWork(context, ConnectionIntentService.class, 1, intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(DEBUGTAG, "onHandleWork");
        address = intent.getStringExtra("ipAddress");

        while(true){
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(address, 80), 1000);
                socket.close();
                if (connectedToastWasShown == false) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ConnectionIntentService.this, "Verbindung erfolgreich", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                connectedToastWasShown = true;
                notConnectedToastWasShown = false;
            } catch (IOException e) {
                if(notConnectedToastWasShown == false) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ConnectionIntentService.this, "Suche Verbindung zum Bagger", Toast.LENGTH_SHORT).show();
                        }
                    });
                    connectedToastWasShown = false;
                    notConnectedToastWasShown = true;
                }
            }
                /*String ipAddressString = InetAddress.getByName(address).getHostName();
                InetAddress ipAddress = InetAddress.getByName(address);
                Log.d("DEBUGTAG", "raw ip: " + ipAddress.toString());
                Log.d("DEBUGTAG", "ipAddressString: " + ipAddressString);
                if(ipAddress.isReachable(1000) && connectedToastWasShown == false){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ConnectionIntentService.this, "Verbindung erfolgreich", Toast.LENGTH_SHORT).show();
                        }
                    });
                    connectedToastWasShown = true;
                    notConnectedToastWasShown = false;
                } else if(!ipAddress.isReachable(1000) && notConnectedToastWasShown == false) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ConnectionIntentService.this, "Verbindung gescheitert", Toast.LENGTH_SHORT).show();
                        }
                    });
                    connectedToastWasShown = false;
                    notConnectedToastWasShown = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            if(isStopped()) return;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.d(DEBUGTAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(DEBUGTAG, "onStopCurrentWork");
        return super.onStopCurrentWork();
    }
}
