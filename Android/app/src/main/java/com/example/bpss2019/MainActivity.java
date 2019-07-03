package com.example.bpss2019;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_2);
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandrechts_2);
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_2);
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_2);
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdreheuhrzeiger_2);
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_2);
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_2);
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_2);
                    break;
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            switch (v.getId()) {
                case R.id.fliessbandLinks:
                    fliessbandLinks.setImageResource(R.drawable.fliessbandlinks_1);
                    break;
                case R.id.fliessbandRechts:
                    fliessbandRechts.setImageResource(R.drawable.fliessbandlechts_1);
                    break;
                case R.id.schaufel:
                    schaufel.setImageResource(R.drawable.schaufel_1);
                    break;
                case R.id.licht:
                    licht.setImageResource(R.drawable.licht_1);
                    break;
                case R.id.notAus:
                    notAus.setImageResource(R.drawable.notaus);
                    break;
                case R.id.armDrehenUhrzeiger:
                    turmDrehenUhrzeiger.setImageResource(R.drawable.armdrehenuhrzeiger_1);
                    break;
                case R.id.armDrehenGegenUhrzeiger:
                    turmDrehenGegeneUhrzeiger.setImageResource(R.drawable.armdrehengegenuhrzeiger_1);
                    break;
                case R.id.armHeben:
                    armHeben.setImageResource(R.drawable.armheben_1);
                    break;
                case R.id.armSenken:
                    armSenken.setImageResource(R.drawable.armsenken_1);
                    break;
            }
        }
        return true;
    }
}
