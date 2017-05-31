package com.fallingstar.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer myMediaPlayer;
    private LinearLayout music1Linear, music2Linear;
    private TextView timeTxt1, timeTxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music1Linear = (LinearLayout)findViewById(R.id.audio1);
        music2Linear = (LinearLayout)findViewById(R.id.audio2);
        timeTxt1 = (TextView)findViewById(R.id.musicTimeTxt1);
        timeTxt2 = (TextView)findViewById(R.id.musicTimeTxt2);

        setTextTime();
        initWidgets();
    }

    /*
    purpose : initialize widgets and listeners
     */
    private void initWidgets(){
        music1Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(v);
                music1Linear.setBackgroundColor(Color.GRAY);
                music2Linear.setBackgroundColor(Color.WHITE);
            }
        });
        music2Linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(v);
                music1Linear.setBackgroundColor(Color.WHITE);
                music2Linear.setBackgroundColor(Color.GRAY);
            }
        });
    }

    /*
    purpose : play appropriate music by checking view's tag
     */
    public void playMusic(View v){
        try {
            /*
            Get tag and play appropriate music with Media player
             */
            int audioId;
            String tag = (String)v.getTag();
            audioId = getResources().getIdentifier(tag, "raw", getPackageName());

            /*
            Before playing the music, kill previous media player instance if available
             */
            killMediaPlayer();
            myMediaPlayer = MediaPlayer.create(this, audioId);
            myMediaPlayer.start();
        }catch (Exception e){
            Log.e("EXCPT", e.getLocalizedMessage());
        }
    }

    /*
    purpose : Kill current media player instance if exist.
     */
    private void killMediaPlayer(){
        if (myMediaPlayer != null){
            try {
                myMediaPlayer.release();
            }catch (Exception e){
                Log.e("EXCPT", e.getLocalizedMessage());
            }
        }
    }

    /*
    purpose : Kill media player when destroy.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }

    /*
    purpose : Set text time by getting duration of music file
     */
    private void setTextTime(){
        int nowSec, min, sec;
        String timeStr;
        int audioId1 = getResources().getIdentifier((String)music1Linear.getTag(), "raw", getPackageName());
        int audioId2 = getResources().getIdentifier((String)music2Linear.getTag(), "raw", getPackageName());

        /*
        For music 1
        Get milli seconds, so change it to minutes and seconds
         */
        timeStr = "";
        myMediaPlayer = MediaPlayer.create(this, audioId1);
        nowSec = myMediaPlayer.getDuration()/1000;
        min = (nowSec % 3600) / 60;
        sec = (nowSec % 60);
        if (min < 10){
            timeStr += "0"+min;
        }else {
            timeStr += min;
        }
        if (sec < 10){
            timeStr += ":0"+sec;
        }else{
            timeStr += ":"+sec;
        }
        timeTxt1.setText(timeStr);

        /*
        For music 2
        Get milli seconds, so change it to minutes and seconds
         */
        timeStr = "";
        myMediaPlayer = MediaPlayer.create(this, audioId2);
        nowSec = myMediaPlayer.getDuration()/1000;
        min = (nowSec % 3600) / 60;
        sec = (nowSec % 60);
        if (min < 10){
            timeStr += "0"+min;
        }else {
            timeStr += min;
        }
        if (sec < 10){
            timeStr += ":0"+sec;
        }else{
            timeStr += ":"+sec;
        }
        timeTxt2.setText(timeStr);
    }
}
