package com.newsproj.newsproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer mysong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_splash);

        mysong=MediaPlayer.create(getApplicationContext(), R.raw.newssound);
        mysong.start();
        mysong.setLooping(true);


        Thread myThread = new Thread(){
            @Override
            public void run(){

                try {
                    sleep(2000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                }catch (InterruptedException e){

                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysong.release();

        finish();
    }
}
