package com.example.bpss2019;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    ImageView linkerTrackVor;
    ImageView linkerTrackZurueck;
    ImageView rechterTrackVor;
    ImageView rechterTrackZurueck;

    Client client;
    MulticastSender multicastSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        fliessbandLinks = (ImageView) findViewById(R.id.fliessbandLinks);
        fliessbandRechts = (ImageView) findViewById(R.id.fliessbandRechts);
        schaufel = (ImageView) findViewById(R.id.schaufel);
        licht = (ImageView) findViewById(R.id.licht);
        notAus = (ImageView) findViewById(R.id.notAus);
        turmDrehenUhrzeiger = (ImageView) findViewById(R.id.armDrehenUhrzeiger);
        turmDrehenGegeneUhrzeiger = (ImageView) findViewById(R.id.armDrehenGegenUhrzeiger);
        armHeben = (ImageView) findViewById(R.id.armHeben);
        armSenken = (ImageView) findViewById(R.id.armSenken);
        linkerTrackVor = (ImageView) findViewById(R.id.leftTrackUp);
        linkerTrackZurueck = (ImageView) findViewById(R.id.leftTrackDown);
        rechterTrackVor = (ImageView) findViewById(R.id.rightTrackUp);
        rechterTrackZurueck = (ImageView) findViewById((R.id.rightTrackDown));

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

        multicastSender = new MulticastSender();
        client = new Client(multicastSender, 5013);
        Thread clientThread = new Thread(client);
        clientThread.start();
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
    public void changeImageSendCommand_orNotify(ImageView imageView, int UIicon, String command) {
        imageView.setImageResource(UIicon);
        if (!client.isIPempty()) {
            client.sendMessage(command);
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
    public void changeImageSendCommand_notNotify(ImageView imageView, int UIicon, String command) {
        imageView.setImageResource(UIicon);
        if (!client.isIPempty()) {
            client.sendMessage(command);
        }
    }
}
