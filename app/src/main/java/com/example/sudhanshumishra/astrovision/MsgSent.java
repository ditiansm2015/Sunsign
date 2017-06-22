package com.example.sudhanshumishra.astrovision;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MsgSent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_sent);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.msgs);
        mp.start();
    }
}
