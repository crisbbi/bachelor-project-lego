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

    /**
     * The ImageView for turning the assembly line counter clockwise
     */
    private ImageView fliessbandLinks;

    /**
     * The ImageView for turning the assembly line clockwise
     */
    private ImageView fliessbandRechts;

    /**
     * The ImageView for activating the paddle wheel
     */
    private ImageView schaufel;

    /**
     * The ImageView for the light
     */
    private ImageView licht;

    /**
     * The ImageView for the emergency stop
     */
    private ImageView notAus;

    /**
     * The ImageView for turning the tower clockwise
     */
    private ImageView turmDrehenUhrzeiger;

    /**
     * The ImageView for turning the tower counter clockwise
     */
    private ImageView turmDrehenGegeneUhrzeiger;

    /**
     * The ImageView for lifting the paddle wheel
     */
    private ImageView armHeben;

    /**
     * The ImageView for lowering the paddle wheel
     */
    private ImageView armSenken;

    /**
     * The ImageView for moving the left track forward
     */
    private ImageView linkerTrackVor;

    /**
     * The ImageView for moving the left track backwards
     */
    private ImageView linkerTrackZurueck;

    /**
     * The ImageView for moving the right track forward
     */
    private ImageView rechterTrackVor;

    /**
     * The ImageView for moving the right track backwards
     */
    private ImageView rechterTrackZurueck;

    /**
     * The ImageView for the microphone
     */
    private ImageView microphone;

    /**
     * Serves as the background of the application, either to load the camera stream or to display
     * a placeholder image
     */
    private WebView webView;

    /**
     * Delegates finding the Server and sending the commands to it
     */
    private Client client;

    /**
     * Is responsible for finding the Server via Multicast on the same network
     */
    private MulticastSender multicastSender;

    /**
     * Runs the Client as a separate thread to not block the main UI thread
     */
    private Thread clientThread;

    /*
     * Commands as constants that are sent to the Server via button or speech
     */
    private static final String STOPP = "STOPP";
    private static final String SCHAUFELRADABAN = "SchaufelradABAN";
    private static final String SCHAUFELRADABAUS = "SchaufelradABAUS";
    private static final String SCHAUFELRADAUFAN = "SchaufelradAUFAN";
    private static final String SCHAUFELRADAUFAUS = "SchaufelradAUFAUS";
    private static final String FLIESSBANDDREHENLINKS = "FliessbandDREHENLINKS";
    private static final String FLIESSBANDDREHENLINKSAUS = "FliessbandDrehenLinksAUS";
    private static final String FLIESSBANDDREHENRECHTS = "FliessbandDrehenRECHTS";
    private static final String FLIESSBANDDREHENRECHTSAUS = "FliessbandDrehenRechtsAUS";
    private static final String BAGGERARMLINKSAN = "BaggerarmlinksAN";
    private static final String BAGGERARMLINKSAUS = "BaggerarmlinksAUS";
    private static final String KETTELINKSVORAN = "KettelinksvorAN";
    private static final String KETTELINKSZURUECKAN = "KettelinkszurueckAN";
    private static final String KETTELINKSVORAUS = "KettelinksvorAUS";
    private static final String KETTELINKSZURUECKAUS = "KettelinkszurueckAUS";
    private static final String KETTERECHTSVORAN = "KetterechtsvorAN";
    private static final String KETTERECHTSZURUECKAN = "KetterechtszurueckAN";
    private static final String KETTERECHTSVORAUS = "KetterechtsvorAUS";
    private static final String KETTERECHTSZURUECKAUS = "KetterechtszurueckAUS";
    private static final String NOTAUS = "NOTAUS";
    private static final String SCHAUFELRADAN = "SchaufelradAN";
    private static final String SCHAUFELRADAUS = "SchaufelradAUS";
    private static final String BRUDERAN = "BRUDERAN";
    private static final String BRUDERAUS = "BRUDERAUS";
    private static final String DISCONNECTING = "DISCONNECTING";
    private static final String LICHTAUS = "LICHTAUS";
    private static final String LICHTAN = "LICHTAN";
    private static final String BAGGERARMRECHTSAN = "BaggerarmrechtsAN";
    private static final String BAGGERARMRECHTSAUS = "BaggerarmrechtsAUS";

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
        clientThread = new Thread(client);
        clientThread.start();

        // Set up WebView to be displayed in-app and not to open an extra Browser window and support
        // JavaScript for the camera stream.
        webView.setWebViewClient(new InnerBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /**
     * Defines an extra InnerBrowser as a WebViewClient to prevent that the app opens the standard
     * Browser window on any device.
     */
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
                    sendCommandIfConnectedOrShowToast(KETTELINKSVORAN);
                    break;
                case R.id.leftTrackDown:
                    linkerTrackZurueck.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast(KETTELINKSZURUECKAN);
                    break;
                case R.id.rightTrackUp:
                    rechterTrackVor.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast(KETTERECHTSVORAN);
                    break;
                case R.id.rightTrackDown:
                    rechterTrackZurueck.setImageResource(R.drawable.pfeil_2);
                    sendCommandIfConnectedOrShowToast(KETTERECHTSZURUECKAN);
                    break;
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_2);
                    sendCommandIfConnectedOrShowToast(FLIESSBANDDREHENLINKS);
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandrechts_2);
                    sendCommandIfConnectedOrShowToast(FLIESSBANDDREHENRECHTS);
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_2);
                    sendCommandIfConnectedOrShowToast(SCHAUFELRADAN);
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_2);
                    sendCommandIfConnectedOrShowToast(LICHTAN);
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    sendCommandIfConnectedOrShowToast(NOTAUS);
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdreheuhrzeiger_2);
                    sendCommandIfConnectedOrShowToast(BAGGERARMRECHTSAN);
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_2);
                    sendCommandIfConnectedOrShowToast(BAGGERARMLINKSAN);
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_2);
                    sendCommandIfConnectedOrShowToast(SCHAUFELRADAUFAN);
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_2);
                    sendCommandIfConnectedOrShowToast(SCHAUFELRADABAN);
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
                    sendCommandIfConnected(KETTELINKSVORAUS);
                    break;
                case R.id.leftTrackDown:
                    linkerTrackZurueck.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected(KETTELINKSZURUECKAUS);
                    break;
                case R.id.rightTrackUp:
                    rechterTrackVor.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected(KETTERECHTSVORAUS);
                    break;
                case R.id.rightTrackDown:
                    rechterTrackZurueck.setImageResource(R.drawable.pfeil_1);
                    sendCommandIfConnected(KETTERECHTSZURUECKAUS);
                    break;
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_1);
                    sendCommandIfConnected(FLIESSBANDDREHENLINKSAUS);
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandlechts_1);
                    sendCommandIfConnected(FLIESSBANDDREHENRECHTSAUS);
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_1);
                    sendCommandIfConnected(SCHAUFELRADAUS);
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_1);
                    // TODO sendCommandIfConnected(LICHTAUS); ???
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdrehenuhrzeiger_1);
                    sendCommandIfConnected(BAGGERARMRECHTSAUS);
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_1);
                    sendCommandIfConnected(BAGGERARMLINKSAUS);
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_1);
                    sendCommandIfConnected(SCHAUFELRADABAUS);
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_1);
                    sendCommandIfConnected(SCHAUFELRADAUFAUS);
                    break;
            }
        }
        return true;
    }

    /**
     * Send the given command as a message via the Client if the connection to the Server exists.
     *
     * @param command the command to be sent as a message
     */
    private void sendCommandIfConnected(String command) {
        if (!client.isIPempty()) {
            client.sendMessage(command);
        }
    }

    /**
     * Sends the given command if the Client is connected to the Server, otherwise show an error
     * Toast.
     *
     * @param command the command to be sent as a message
     */
    private void sendCommandIfConnectedOrShowToast(String command) {
        if (!client.isIPempty()) {
            client.sendMessage(command);
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

    /**
     * Takes a list of recognized words from speech as input and sends the corresponding commands
     * via the Client.
     *
     * @param input the list of recognized words from speech
     */
    private void sendCommandsFromList(ArrayList<String> input) {
        // used for debugging
        System.out.println(input);

        // store every single recognized word possible in a new list
        ArrayList<String> splitInput = new ArrayList<>();
        for(String partOfStringList: input) {
            splitInput.addAll(Arrays.asList(partOfStringList.split(" ")));
        }
        // used for debugging
        System.out.println(splitInput);
        input = splitInput;

        // set all recognized words to lower case
        for(String word: input) {
            input.set(input.indexOf(word), word.toLowerCase());
        }
        System.out.println(input);

        if (input.contains("fahre") && ((input.contains("geradeaus")) || input.contains("vorne"))) {
            System.out.println("*Nach vorne Fahr Gerausche*");
            client.sendMessage(KETTERECHTSVORAN);
            client.sendMessage(KETTELINKSVORAN);
        }
        if (input.contains("fahre") && (input.contains("rückwärts") || input.contains("zurück"))) {
            System.out.println("*Nach hinten Fahr Gerausche*");
            client.sendMessage(KETTERECHTSZURUECKAN);
            client.sendMessage(KETTELINKSZURUECKAN);
        }
        if (!input.contains("turm") && !input.contains("band") && input.contains("links")) {
            client.sendMessage(KETTERECHTSVORAN);
            client.sendMessage(KETTELINKSZURUECKAN);
        }
        if (!input.contains("turm") && !input.contains("band") && input.contains("rechts")) {
            client.sendMessage(KETTERECHTSZURUECKAN);
            client.sendMessage(KETTELINKSVORAN);
        }
        if (input.contains("turm") && input.contains("links")) {
            client.sendMessage(BAGGERARMLINKSAN);
        }
        if (input.contains("turm") && input.contains("rechts")) {
            client.sendMessage(BAGGERARMRECHTSAN);
        }
        if (input.contains("turm") && (input.contains("anhalten") || (input.contains("halt") && input.contains("an")))) {
            client.sendMessage(BAGGERARMLINKSAUS);
            client.sendMessage(BAGGERARMRECHTSAUS);
        }
        if (input.contains("schaufel") && (input.contains("oben") || input.contains("hoch") || input.contains("heben") || input.contains("höher"))) {
            client.sendMessage(SCHAUFELRADAUFAN);
        }
        if (input.contains("schaufel") && (input.contains("unten") || input.contains("runter") || input.contains("senken") || input.contains("tiefer"))) {
            client.sendMessage(SCHAUFELRADABAN);
        }
        if (input.contains("schaufel") && ((input.contains("drehe") || input.contains("an"))) || input.contains("starte")) {
            client.sendMessage(SCHAUFELRADAN);
        }
        if (input.contains("schaufel") && ((input.contains("anhalten") || input.contains("an"))) || input.contains("halt")) {
            client.sendMessage(SCHAUFELRADAUS);
        }
        if (((input.contains("schaufel") && input.contains("arm")) || input.contains("schaufelarm")) && input.contains("anhalten")) {
            client.sendMessage(SCHAUFELRADABAUS);
            client.sendMessage(SCHAUFELRADAUFAUS);
        }
        if (input.contains("band") && input.contains("links")) {
            client.sendMessage(FLIESSBANDDREHENLINKS);
        }
        if (input.contains("band") && input.contains("rechts")) {
            client.sendMessage(FLIESSBANDDREHENRECHTS);
        }
        if (input.contains("band") && input.contains("anhalten")) {
            client.sendMessage(FLIESSBANDDREHENLINKSAUS);
            client.sendMessage(FLIESSBANDDREHENRECHTSAUS);
        }
        if (input.contains("not") && input.contains("aus")) {
            client.sendMessage(NOTAUS);
        }
        if ((input.contains("stopp") || input.contains("halt") || input.contains("anhalten")) && !input.contains("turm")) {
            client.sendMessage(STOPP);
        }
        if (input.contains("licht") && (input.contains("an") || input.contains("anschalten"))) {
            client.sendMessage(LICHTAN);
        }
        if (input.contains("licht") && (input.contains("aus") || input.contains("ausschalten"))) {
            client.sendMessage(LICHTAUS);
        }
        if (input.contains("bruder") && input.contains("an")) {
            client.sendMessage(BRUDERAN);
        }
        if (input.contains("bruder") && input.contains("aus")) {
            client.sendMessage(BRUDERAUS);
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        // Update MainActivity as Observer of Client
        if(o.toString().equals("connected")){
            webView.loadUrl("http://" + client.getIP() + ":8083/stream_simple.html");
            //webView.loadUrl("http://live.daserste.de");
        } else {
            webView.loadUrl("file:///android_asset/Loading.html");
            //webView.loadUrl("https://www.google.de/");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        multicastSender = new MulticastSender();
        client = new Client(multicastSender, 5013, this);
        clientThread = new Thread(client);
        clientThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        client.sendMessage("DISCONNECTING");
    }
}
