package com.example.djwalebabu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnLongClickListener, View.OnContextClickListener {
MediaPlayer mediaPlayer1,mediaPlayer2;
SoundPool soundPool;
Random random=new Random();
    @RequiresApi(api = Build.VERSION_CODES.M)

    int dhamaka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        View view=new View(this);

   //Events
        view.setOnContextClickListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        setContentView(view);
 //Sound pool
        soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        dhamaka=soundPool.load(this,R.raw.explosion,1);

  //Media playe resource linking
        mediaPlayer1=MediaPlayer.create(this,R.raw.backgroundmusic);
        mediaPlayer2=MediaPlayer.create(this,R.raw.soundtrack);
      //  mediaPlayer1.start();


   //Random background
        view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(264)));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (dhamaka!=0){
            soundPool.play(dhamaka,1,1,0,0,1);
            //Random background
            view.setBackgroundColor(Color.rgb(random.nextInt(268),random.nextInt(265),random.nextInt(264)));
        }
        return false;
    }

    @Override
    public boolean onLongClick(View view) {
        mediaPlayer2.start();
        return false;
    }

    @Override
    public boolean onContextClick(View view) {
        mediaPlayer1.start();
        return false;
    }
}
