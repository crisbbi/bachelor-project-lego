package com.example.bpss2019;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView fliessbandLinks;
    ImageView fliessbandRechts;
    ImageView schaufel;
    ImageView licht;
    ImageView notAus;
    ImageView turmDrehenUhrzeiger;
    ImageView turmDrehenGegeneUhrzeiger;
    ImageView armHeben;
    ImageView armSenken;

    Client client;

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        
        /*
        The goal of this line was to be able to store the application 
        context and to pass it to the Toast in the ConnectionObeserver.
        Wanted to show a Toast from the ConnectionObeserver thread to 
        show the state of the connection and found this approach as an 
        idea from StackOverflow, but it didn't work out and things became
        more and more complicated with a suggested Handler class.  
        */
        //context = getApplicationContext();

        fliessbandLinks = (ImageView) findViewById(R.id.fliessbandLinks);
        fliessbandRechts = (ImageView) findViewById(R.id.fliessbandRechts);
        schaufel = (ImageView) findViewById(R.id.schaufel);
        licht = (ImageView) findViewById(R.id.licht);
        notAus = (ImageView) findViewById(R.id.notAus);
        turmDrehenUhrzeiger = (ImageView) findViewById(R.id.armDrehenUhrzeiger);
        turmDrehenGegeneUhrzeiger = (ImageView) findViewById(R.id.armDrehenGegenUhrzeiger);
        armHeben = (ImageView) findViewById(R.id.armHeben);
        armSenken = (ImageView) findViewById(R.id.armSenken);

        fliessbandLinks.setOnTouchListener(this);
        fliessbandRechts.setOnTouchListener(this);
        schaufel.setOnTouchListener(this);
        licht.setOnTouchListener(this);
        notAus.setOnTouchListener(this);
        turmDrehenUhrzeiger.setOnTouchListener(this);
        turmDrehenGegeneUhrzeiger.setOnTouchListener(this);
        armHeben.setOnTouchListener(this);
        armSenken.setOnTouchListener(this);

        /*
        The goal of the ConnectionObeserver was to monitor the state of the wifi connection
        and to inform about it, as there is (for now) no other way for a normal user to know about it.
        Doesn't work out well yet, so left it as comment.  
        */ 
        //ConnectionObserver connectionObserver = new ConnectionObserver("192.168.2.120");
        //new Thread(connectionObserver).start();
        
        client = new Client("192.168.2.120");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_2);
                    sendMessage("fliessbandLinksAN");
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandrechts_2);
                    sendMessage("fliessbandRechtsAN");
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_2);
                    sendMessage("schaufelAN");
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_2);
                    sendMessage("lichtAN");
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    sendMessage("notAUS");
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdreheuhrzeiger_2);
                    sendMessage("armDrehenUhrzeigerAN");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_2);
                    sendMessage("armDrehenGegenUhrzeigerAN");
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_2);
                    sendMessage("armHebenAN");
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_2);
                    sendMessage("armSenkenAN");
                    break;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_1);
                    sendMessage("fliessbandLinksAUS");
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandlechts_1);
                    sendMessage("fliessbandRechtsAUS");
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_1);
                    sendMessage("schaufelAUS");
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_1);
                    sendMessage("lichtAUS");
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    sendMessage("notAUS");
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdrehenuhrzeiger_1);
                    sendMessage("armDrehenUhrzeigerAUS");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_1);
                    sendMessage("armDrehenGegenUhrzeigerAUS");
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_1);
                    sendMessage("armHebenAUS");
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_1);
                    sendMessage("armSenkenAUS");
                    break;
            }
        }
        return true;
    }

    /**
     * Sets the message that the Client shall send to the Server and starts the socket in the Client class as a new Thread
     * 
     * @param message The message to be sent.
     */
    public void sendMessage(String message) {
        client.setMessage(message);
        new Thread(client).start();
    }

    /**
     * Returns the static context of {@link MainActivity}
     * 
     * @return The static context of {@link MainActivity}
     */
    public static Context getMainContext(){
        return context;
    }
}
