package com.fallingstar.lab1;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    int imgIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView)findViewById(R.id.firstImg);
        image2 = (ImageView)findViewById(R.id.secondImg);
    }


    public void onButton1Clicked(View v){
        changeImage();
    }

    private void changeImage(){
        if (imgIdx == 0){
            Animation anim = AnimationUtils.loadAnimation(
                    getApplicationContext(), // 현재 화면의 제어권자
                    R.anim.anim_rotate);    // 설정한 에니메이션 파일
            image1.startAnimation(anim);
            image1.bringToFront();

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    image1.setVisibility(View.INVISIBLE);
                    image2.setVisibility(View.VISIBLE);
                    imgIdx = 1;

                }
            }, 6000);// 0.5초 정도 딜레이를 준 후 시작
        }else{
            Animation anim = AnimationUtils.loadAnimation(
                    getApplicationContext(), // 현재 화면의 제어권자
                    R.anim.anim_rotate);    // 설정한 에니메이션 파일
            image2.startAnimation(anim);
            image2.bringToFront();

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    image1.setVisibility(View.VISIBLE);
                    image2.setVisibility(View.INVISIBLE);
                    imgIdx = 0;
                }
            }, 6000);// 0.5초 정도 딜레이를 준 후 시작



        }
    }
}
