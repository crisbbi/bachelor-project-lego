package com.example.baprojekt2019;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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

        fliessbandLinks.setId(1);
        fliessbandRechts.setId(2);
        schaufel.setId(3);
        licht.setId(4);
        notAus.setId(5);
        turmDrehenUhrzeiger.setId(6);
        turmDrehenGegeneUhrzeiger.setId(7);
        armHeben.setId(8);
        armSenken.setId(9);

        fliessbandLinks.setOnTouchListener(this);
        fliessbandRechts.setOnTouchListener(this);
        schaufel.setOnTouchListener(this);
        licht.setOnTouchListener(this);
        notAus.setOnTouchListener(this);
        turmDrehenUhrzeiger.setOnTouchListener(this);
        turmDrehenGegeneUhrzeiger.setOnTouchListener(this);
        armHeben.setOnTouchListener(this);
        armSenken.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            switch(v.getId()) {
                case 1:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_2);
                    break;
                case 2:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandrechts_2);
                    break;
                case 3:
                    schaufel.setImageResource(R.drawable.schaufel_2);
                    break;
                case 4:
                    licht.setImageResource(R.drawable.licht_2);
                    break;
                case 5:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case 6:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdreheuhrzeiger_2);
                    break;
                case 7:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_2);
                    break;
                case 8:
                    armHeben.setImageResource(R.drawable.armheben_2);
                    break;
                case 9:
                    armSenken.setImageResource(R.drawable.armsenken_2);
                    break;
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case 1:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_1);
                    break;
                case 2:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandlechts_1);
                    break;
                case 3:
                    schaufel.setImageResource(R.drawable.schaufel_1);
                    break;
                case 4:
                    licht.setImageResource(R.drawable.licht_1);
                    break;
                case 5:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case 6:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdrehenuhrzeiger_1);
                    break;
                case 7:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_1);
                    break;
                case 8:
                    armHeben.setImageResource(R.drawable.armheben_1);
                    break;
                case 9:
                    armSenken.setImageResource(R.drawable.armsenken_1);
                    break;
            }
        }
        return false;
    }
}
