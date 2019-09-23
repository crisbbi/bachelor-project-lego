package com.example.bpss2019;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, Observer {

    private ImageView fliessbandLinks;
    private ImageView fliessbandRechts;
    private ImageView schaufel;
    private ImageView licht;
    private ImageView notAus;
    private ImageView turmDrehenUhrzeiger;
    private ImageView turmDrehenGegeneUhrzeiger;
    private ImageView armHeben;
    private ImageView armSenken;
    private ImageView linkerTrackVor;
    private ImageView linkerTrackZurueck;
    private ImageView rechterTrackVor;
    private ImageView rechterTrackZurueck;
    private ImageView microphone;

    private WebView webView;

    private Client client;
    private MulticastSender multicastSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        fliessbandLinks = findViewById(R.id.fliessbandLinks);
        fliessbandRechts = findViewById(R.id.fliessbandRechts);
        schaufel = findViewById(R.id.schaufel);
        licht = findViewById(R.id.licht);
        notAus = findViewById(R.id.notAus);
        turmDrehenUhrzeiger = findViewById(R.id.armDrehenUhrzeiger);
        turmDrehenGegeneUhrzeiger = findViewById(R.id.armDrehenGegenUhrzeiger);
        armHeben = findViewById(R.id.armHeben);
        armSenken = findViewById(R.id.armSenken);
        linkerTrackVor = findViewById(R.id.leftTrackUp);
        linkerTrackZurueck = findViewById(R.id.leftTrackDown);
        rechterTrackVor = findViewById(R.id.rightTrackUp);
        rechterTrackZurueck = findViewById((R.id.rightTrackDown));
        microphone = findViewById(R.id.imageView4);

        webView = findViewById(R.id.webView);

        fliessbandLinks.setOnTouchListener(this);
        fliessbandRechts.setOnTouchListener(this);
        schaufel.setOnTouchListener(this);
        licht.setOnTouchListener(this);
        notAus.setOnTouchListener(this);
        turmDrehenUhrzeiger.setOnTouchListener(this);
        turmDrehenGegeneUhrzeiger.setOnTouchListener(this);
        armHeben.setOnTouchListener(this);
        armSenken.setOnTouchListener(this);
        linkerTrackVor.setOnTouchListener(this);
        linkerTrackZurueck.setOnTouchListener(this);
        rechterTrackVor.setOnTouchListener(this);
        rechterTrackZurueck.setOnTouchListener(this);
        microphone.setOnTouchListener(this);

        multicastSender = new MulticastSender();
        client = new Client(multicastSender, 5013, this);
        Thread clientThread = new Thread(client);
        clientThread.start();

        webView.setWebViewClient(new InnerBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
    }

    private class InnerBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (v.getId()) {
                case R.id.leftTrackUp:
                    linkerTrackVor.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast("KettelinksvorAN");
                    break;
                case R.id.leftTrackDown:
                    linkerTrackZurueck.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast("KettelinkszurueckAN");
                    break;
                case R.id.rightTrackUp:
                    rechterTrackVor.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast("KetterechtsvorAN");
                    break;
                case R.id.rightTrackDown:
                    rechterTrackZurueck.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast("KetterechtszurueckAN");
                    break;
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_2);
                    sendCommandIfConnectedOrShowToast("FliessbandDREHENLINKS");
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandrechts_2);
                    sendCommandIfConnectedOrShowToast("FliessbandDREHENRECHTS");
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_2);
                    sendCommandIfConnectedOrShowToast("SchaufelradAN");
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_2);
                    sendCommandIfConnectedOrShowToast("LICHTAN");
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    sendCommandIfConnectedOrShowToast("NOTAUS");
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdreheuhrzeiger_2);
                    sendCommandIfConnectedOrShowToast("BaggerarmrechtsAN");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_2);
                    sendCommandIfConnectedOrShowToast("BaggerarmlinksAN");
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_2);
                    sendCommandIfConnectedOrShowToast("SchaufelradAUFAN");
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_2);
                    sendCommandIfConnectedOrShowToast("SchaufelradABAN");
                    break;
                case R.id.imageView4:
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Befehl an den Bagger:");
                    startActivityForResult(intent, 1);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case R.id.leftTrackUp:
                    linkerTrackVor.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected("KettelinksvorAUS");
                    break;
                case R.id.leftTrackDown:
                    linkerTrackZurueck.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected("KettelinkszurueckAUS");
                    break;
                case R.id.rightTrackUp:
                    rechterTrackVor.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected("KetterechtsvorAUS");
                    break;
                case R.id.rightTrackDown:
                    rechterTrackZurueck.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected("KetterechtszurueckAUS");
                    break;
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_1);
                    sendCommandIfConnected("FliessbandDrehenLinksAUS");
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandlechts_1);
                    sendCommandIfConnected("FliessbandDrehenRechtsAUS");
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_1);
                    sendCommandIfConnected("SchaufelradAUS");
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_1);
                    sendCommandIfConnected("LICHTAUS");
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdrehenuhrzeiger_1);
                    sendCommandIfConnected("BaggerarmrechtsAUS");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_1);
                    sendCommandIfConnected("BaggerarmlinksAUS");
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_1);
                    sendCommandIfConnected("SchaufelradABAUS");
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_1);
                    sendCommandIfConnected("SchaufelradAUFAUS");
                    break;
            }
        }
        return true;
    }

    private void sendCommandIfConnected(String command) {
        if (!client.isIPempty()) {
            client.sendMessage(command);
        }
    }

    private void sendCommandIfConnectedOrShowToast(String command) {
        if (!client.isIPempty()) {
            client.sendMessage(command);

            //webView.setWebViewClient(new InnerBrowser());
            //webView.getSettings().setJavaScriptEnabled(true);
            //webView.loadUrl("http://google.de");
        } else {
            Toast.makeText(this, "Keine Verbindung zum Bagger", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> speechResult = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            sendCommandsFromList(speechResult);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void sendCommandsFromList(ArrayList<String> input) {
            System.out.println(input);
            ArrayList<String> splitInput = new ArrayList<>();
            for(String partOfStringList: input) {
                splitInput.addAll(Arrays.asList(partOfStringList.split(" ")));
            }
            System.out.println(splitInput);
            input = splitInput;

            // set all recognized words to lower case
            for(String word: input) {
                input.set(input.indexOf(word), word.toLowerCase());
            }
            System.out.println(input);

        if (input.contains("fahre") && ((input.contains("geradeaus")) || input.contains("vorne"))) {
            System.out.println("*Nach vorne Fahr Gerausche*");
            client.sendMessage("KetterechtsvorAN");
            client.sendMessage("KettelinksvorAN");
        }
        if (input.contains("fahre") && (input.contains("rückwärts") || input.contains("zurück"))) {
            System.out.println("*Nach hinten Fahr Gerausche*");
            client.sendMessage("KetterechtszurueckAN");
            client.sendMessage("KettelinkszurueckAN");
        }
        if (!input.contains("turm") && !input.contains("band") && input.contains("links")) {
            client.sendMessage("KetterechtsvorAN");
            client.sendMessage("KettelinkszurueckAN");
        }
        if (!input.contains("turm") && !input.contains("band") && input.contains("rechts")) {
            client.sendMessage("KetterechtszurueckAN");
            client.sendMessage("KettelinksvorAN");
        }
        if (input.contains("turm") && input.contains("links")) {
            client.sendMessage("BaggerarmlinksAN");
        }
        if (input.contains("turm") && input.contains("rechts")) {
            client.sendMessage("BaggerarmrechtsAN");
        }
        if (input.contains("turm") && (input.contains("anhalten") || (input.contains("halt") && input.contains("an")))) {
            client.sendMessage("BaggerarmlinksAUS");
            client.sendMessage("BaggerarmrechtsAUS");
        }
        if (input.contains("schaufel") && (input.contains("oben") || input.contains("hoch") || input.contains("heben") || input.contains("höher"))) {
            client.sendMessage("SchaufelradAUFAN");
        }
        if (input.contains("schaufel") && (input.contains("unten") || input.contains("runter") || input.contains("senken") || input.contains("tiefer"))) {
            client.sendMessage("SchaufelradABAN");
        }
        if (input.contains("schaufel") && ((input.contains("drehe") || input.contains("an"))) || input.contains("starte")) {
            client.sendMessage("SchaufelradAN");
        }
        if (input.contains("schaufel") && ((input.contains("anhalten") || input.contains("an"))) || input.contains("halt")) {
            client.sendMessage("SchaufelradAUS");
        }
        if (((input.contains("schaufel") && input.contains("arm")) || input.contains("schaufelarm")) && input.contains("anhalten")) {
            client.sendMessage("SchaufelradABAUS");
            client.sendMessage("SchaufelradAUFAUS");
        }
        if (input.contains("band") && input.contains("links")) {
            client.sendMessage("FliessbandDREHENLINKS");
        }
        if (input.contains("band") && input.contains("rechts")) {
            client.sendMessage("FliessbandDREHENRECHTS");
        }
        if (input.contains("band") && input.contains("anhalten")) {
            client.sendMessage("FliessbandDrehenLinksAUS");
            client.sendMessage("FliessbandDrehenRechtsAUS");
        }
        if (input.contains("not") && input.contains("aus")) {
            client.sendMessage("NOTAUS");
        }
        if ((input.contains("stopp") || input.contains("halt") || input.contains("anhalten")) && !input.contains("turm")) {
            client.sendMessage("STOPP");
        }
        if (input.contains("licht") && (input.contains("an") || input.contains("anschalten"))) {
            client.sendMessage("LICHTAN");
        }
        if (input.contains("licht") && (input.contains("aus") || input.contains("ausschalten"))) {
            client.sendMessage("LICHTAUS");
        }
        if (input.contains("bruder") && input.contains("an")) {
            client.sendMessage("BRUDERAN");
        }
        if (input.contains("bruder") && input.contains("aus")) {
            client.sendMessage("BRUDERAUS");
        }
    }



    @Override
    public void update(Observable observable, Object o) {
        // Update MainActivity as Observer of Client
        if(o.toString().equals("connected")){
            //webView.loadUrl("http://" + client.getIP() + ":8083/stream_simple.html");
            webView.loadUrl("http://live.daserste.de");
        } else {
            webView.loadUrl("file:///android_asset/Loading.html");
            //webView.loadUrl("https://www.google.de/");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        client.sendMessage("DISCONNECTING");
    }
}
