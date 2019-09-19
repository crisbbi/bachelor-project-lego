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
                    changeImageSendCommand_orNotify(linkerTrackVor, R.drawable.pfeil_2, "KettelinksvorAN");
                    break;
                case R.id.leftTrackDown:
                    changeImageSendCommand_orNotify(linkerTrackZurueck, R.drawable.pfeil_2, "KettelinkszurueckAN");
                    break;
                case R.id.rightTrackUp:
                    changeImageSendCommand_orNotify(rechterTrackVor, R.drawable.pfeil_2, "KetterechtsvorAN");
                    break;
                case R.id.rightTrackDown:
                    changeImageSendCommand_orNotify(rechterTrackZurueck, R.drawable.pfeil_2, "KetterechtszurueckAN");
                    break;
                case R.id.fliessbandLinks:
                    changeImageSendCommand_orNotify(fliessbandLinks, R.drawable.fliessbandlinks_2, "fliessbandLinksAN");
                    break;
                case R.id.fliessbandRechts:
                    changeImageSendCommand_orNotify(fliessbandRechts, R.drawable.fliessbandrechts_2, "fliessbandRechtsAN");
                    break;
                case R.id.schaufel:
                    changeImageSendCommand_orNotify(schaufel, R.drawable.schaufel_2, "schaufelAN");
                    break;
                case R.id.licht:
                    changeImageSendCommand_orNotify(licht, R.drawable.licht_2, "lichtAN");
                    break;
                case R.id.notAus:
                    changeImageSendCommand_orNotify(notAus, R.drawable.notaus, "notAUS");
                    break;
                case R.id.armDrehenUhrzeiger:
                    changeImageSendCommand_orNotify(turmDrehenUhrzeiger, R.drawable.armdreheuhrzeiger_2, "armDrehenUhrzeigerAN");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    changeImageSendCommand_orNotify(turmDrehenGegeneUhrzeiger, R.drawable.armdrehengegenuhrzeiger_2, "armDrehenGegenUhrzeigerAN");
                    break;
                case R.id.armHeben:
                    changeImageSendCommand_orNotify(armHeben, R.drawable.armheben_2, "armHebenAN");
                    break;
                case R.id.armSenken:
                    changeImageSendCommand_orNotify(armSenken, R.drawable.armsenken_2, "armSenkenAN");
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
                    changeImageSendCommand_notNotify(linkerTrackVor, R.drawable.pfeil_1, "KettelinksvorAUS");
                    break;
                case R.id.leftTrackDown:
                    changeImageSendCommand_notNotify(linkerTrackZurueck, R.drawable.pfeil_1, "KettelinkszurueckAUS");
                    break;
                case R.id.rightTrackUp:
                    changeImageSendCommand_notNotify(rechterTrackVor, R.drawable.pfeil_1, "KetterechtsvorAUS");
                    break;
                case R.id.rightTrackDown:
                    changeImageSendCommand_notNotify(rechterTrackZurueck, R.drawable.pfeil_1, "KetterechtszurueckAUS");
                    break;
                case R.id.fliessbandLinks:
                    changeImageSendCommand_notNotify(fliessbandLinks, R.drawable.fliessbandlinks_1, "fliessbandLinksAUS");
                    break;
                case R.id.fliessbandRechts:
                    changeImageSendCommand_notNotify(fliessbandRechts, R.drawable.fliessbandlechts_1, "fliessbandRechtsAUS");
                    break;
                case R.id.schaufel:
                    changeImageSendCommand_notNotify(schaufel, R.drawable.schaufel_1, "schaufelAUS");
                    break;
                case R.id.licht:
                    changeImageSendCommand_notNotify(licht, R.drawable.licht_1, "lichtAUS");
                    break;
                case R.id.notAus:
                    changeImageSendCommand_notNotify(notAus, R.drawable.notaus, "notAUS");
                    break;
                case R.id.armDrehenUhrzeiger:
                    changeImageSendCommand_notNotify(turmDrehenUhrzeiger, R.drawable.armdrehenuhrzeiger_1, "armDrehenUhrzeigerAUS");
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    changeImageSendCommand_notNotify(turmDrehenGegeneUhrzeiger, R.drawable.armdrehengegenuhrzeiger_1, "armDrehenGegenUhrzeigerAUS");
                    break;
                case R.id.armHeben:
                    changeImageSendCommand_notNotify(armHeben, R.drawable.armheben_1, "armHebenAUS");
                    break;
                case R.id.armSenken:
                    changeImageSendCommand_notNotify(armSenken, R.drawable.armsenken_1, "armSenkenAUS");
                    break;
            }
        }
        return true;
    }

    /**
     * Change the button image and send command via Wifi if the MulticastSender contains a Server-IP as String. Otherwise show a Toast.
     *
     * @param imageView The ImageView on which to replace the image
     * @param UIicon The new image
     * @param command The command to send via Wifi
     */
    private void changeImageSendCommand_orNotify(ImageView imageView, int UIicon, String command) {
        imageView.setImageResource(UIicon);
        if (!client.isIPempty()) {
            client.sendMessage(command);

            //webView.setWebViewClient(new InnerBrowser());
            //webView.getSettings().setJavaScriptEnabled(true);
            //webView.loadUrl("http://google.de");
        } else {
            Toast.makeText(this, "Keine Verbindung zum Bagger", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Change the button image and send command via Wifi if the MulticastSender contains a Server-IP as String.
     *
     * @param imageView The ImageView on which to replace the image
     * @param UIicon The new image
     * @param command The command to send via Wifi
     */
    private void changeImageSendCommand_notNotify(ImageView imageView, int UIicon, String command) {
        imageView.setImageResource(UIicon);
        if (!client.isIPempty()) {
            client.sendMessage(command);
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
        if (input.contains("schaufel") && (input.contains("oben") || input.contains("hoch") || input.contains("heben") || input.contains("höher"))) {
            client.sendMessage("SchaufelradAUFAN");
        }
        if (input.contains("schaufel") && (input.contains("unten") || input.contains("runter") || input.contains("senken") || input.contains("tiefer"))) {
            client.sendMessage("SchaufelradABAN");
        }
        if (input.contains("schaufel") && ((input.contains("drehe") || input.contains("an"))) || input.contains("starte")) {
            client.sendMessage("SchaufelradAN");
        }
        if (input.contains("schaufel") && input.contains("aus") || input.contains("anhalten")) {
            client.sendMessage("SchaufelradAUS");
        }
        if (input.contains("band") && input.contains("links")) {
            client.sendMessage("FliessbandDREHENLINKS");
        }
        if (input.contains("band") && input.contains("rechts")) {
            client.sendMessage("FliessbandDREHENRECHTS");
        }
        if (input.contains("not") && input.contains("aus")) {
            client.sendMessage("NOTAUS");
        }
        if ((input.contains("stopp") || input.contains("halt") || input.contains("anhalten"))) {
            client.sendMessage("STOPP");
        }
        if (input.contains("licht") && (input.contains("an") || input.contains("anschalten"))) {
            client.sendMessage("LICHTAN");
        }
        if (input.contains("licht") && (input.contains("aus") || input.contains("ausschalten"))) {
            client.sendMessage("LICHTAUS");
        }
    }



    @Override
    public void update(Observable observable, Object o) {
        // Update MainActivity as Observer of Client
        if(o.toString().equals("connected")){
            webView.loadUrl("http://" + client.getIP() + ":8083/stream_simple.html");
        } else {
            webView.loadUrl("file:///android_asset/Loading.html");
            //webView.loadUrl("https://www.google.de/");
        }
    }
}
