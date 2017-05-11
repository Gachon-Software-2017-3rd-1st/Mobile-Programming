package com.fallingstar.lab5;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button stateBtn;
    private ImageView dog1, dog2;
    private TextView logTxt;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateBtn = (Button)findViewById(R.id.stateBtn);
        dog1 = (ImageView)findViewById(R.id.dog1);
        dog2 = (ImageView)findViewById(R.id.dog2);
        logTxt = (TextView)findViewById(R.id.logTxt);

        stateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread thread1 = new DogThread(0);
                DogThread thread2 = new DogThread(1);

                thread1.start();
                thread2.start();
            }
        });
    }

    class DogThread extends Thread{
        int dogIdx, stateIdx;

        ArrayList<Integer> images = new ArrayList<>();

        public DogThread(int _idx) {
            dogIdx = _idx;
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_study);
        }

        @Override
        public void run() {
            super.run();
            stateIdx = 0;

            for (int i = 0; i < 9; i++) {
                final String msg = "dog #"+dogIdx+" state : "+stateIdx+"\n";

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        logTxt.append(msg);

                        if (dogIdx == 0){
                            dog1.setImageResource(images.get(stateIdx));
                        }else if (dogIdx == 1){
                            dog2.setImageResource(images.get(stateIdx));
                        }
                    }
                });

                try{
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                }catch (Exception e){
                    Log.e("Error", e.getLocalizedMessage());
                }

                stateIdx++;
                if (stateIdx >= images.size()){
                    stateIdx = 0;
                }
            }
        }
    }

    private int getRandomTime(int min, int max){
        return min + (int)(Math.random() * (max-min));
    }
}
