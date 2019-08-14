package com.example.bpss2019;

import android.webkit.WebView;

public class WebViewCamera implements Runnable {

    private WebView webView;
    private Client client;
    private boolean videoLoaded = false;

    public WebViewCamera(Client passedClient, WebView wv) {
        client = passedClient;
        webView = wv;
    }

    @Override
    public void run() {
        while(true) {
            if(!client.getIP().equals("") && !videoLoaded) {
                webView.loadUrl("http://" + client.getIP() + ":8083/javascript_simple.html");
                videoLoaded = true;
            } else {
                videoLoaded = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
