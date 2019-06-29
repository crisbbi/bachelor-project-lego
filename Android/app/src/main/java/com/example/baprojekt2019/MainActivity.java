package com.example.baprojekt2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ImageView fliessbandLinks = (ImageView) findViewById(R.id.fliessbandLinks);
        ImageView fliessbandRechts = (ImageView) findViewById(R.id.fliessbandRechts);
        ImageView schaufel = (ImageView) findViewById(R.id.schaufel);
        ImageView licht = (ImageView) findViewById(R.id.licht);
        ImageView notAus = (ImageView) findViewById(R.id.notAus);
        ImageView turmDrehenUhrzeiger = (ImageView) findViewById(R.id.armDrehenUhrzeiger);
        ImageView turmDrehenGegeneUhrzeiger = (ImageView) findViewById(R.id.armDrehenGegenUhrzeiger);
        ImageView armHeben = (ImageView) findViewById(R.id.armHeben);
        ImageView armSenken = (ImageView) findViewById(R.id.armSenken);
    }

}
