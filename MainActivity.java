package com.example.raine.javasliderpuzzle;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button tutorialButton;
    private Button playButton;
    private CheckBox EasyMode, MediumMode, HardMode;
    private MediaPlayer ButtonClickSound;
    private MediaPlayer BackgroundMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tutorialButton = (Button) findViewById(R.id.tutorialButton);
        tutorialButton.setOnClickListener((tutorialButtonListener));
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(playButtonListener);
        EasyMode = (CheckBox) findViewById(R.id.EasyMode);
        EasyMode.setOnClickListener(EasyModeListener);
        MediumMode = (CheckBox) findViewById(R.id.MediumMode);
        MediumMode.setOnClickListener(MediumModeListener);
        HardMode = (CheckBox) findViewById(R.id.HardMode);
        HardMode.setOnClickListener(HardModeListener);

        ButtonClickSound =MediaPlayer.create(this, R.raw.s1);
        BackgroundMusic= MediaPlayer.create(this,R.raw.miles_away);
        BackgroundMusic.start();
        BackgroundMusic.setLooping(true); //this will keep going in a loop.
    }


    public OnClickListener tutorialButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            BackgroundMusic.stop();
            //go to tutorial activity
            ButtonClickSound.start();
            startActivity(new Intent(MainActivity.this, TutorialLevel.class));
        }
    };

    public OnClickListener playButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            BackgroundMusic.stop();
            //first check what Difficulty is checked. By default easy is checked.
            //go to checked activity
            ButtonClickSound.start();
            if(MediumMode.isChecked()){
                    startActivity(new Intent(MainActivity.this, MediumLevel.class));
            }
            else if(HardMode.isChecked()){
                    startActivity(new Intent(MainActivity.this, ExpertLevel.class));
            }
            else{
                startActivity(new Intent(MainActivity.this, EasyLevel.class));
            }

        }
    };

    public OnClickListener EasyModeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (EasyMode.isChecked()) {
                MediumMode.setChecked(false);
                HardMode.setChecked(false);
            } else if (EasyMode.isChecked() == false && MediumMode.isChecked() == false && HardMode.isChecked() == false) {
                EasyMode.setChecked(true);
            }
        }
    };

    public OnClickListener MediumModeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (MediumMode.isChecked()) {
                EasyMode.setChecked(false);
                HardMode.setChecked(false);
            } else if (EasyMode.isChecked() == false && MediumMode.isChecked() == false && HardMode.isChecked() == false) {
                EasyMode.setChecked(true);
            }
        }
    };

    public OnClickListener HardModeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (HardMode.isChecked()) {
                EasyMode.setChecked(false);
                MediumMode.setChecked(false);
            } else if (EasyMode.isChecked() == false && MediumMode.isChecked() == false && HardMode.isChecked() == false) {
                EasyMode.setChecked(true);
            }
        }
    };
}


