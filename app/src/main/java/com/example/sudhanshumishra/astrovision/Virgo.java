package com.example.sudhanshumishra.astrovision;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Virgo extends AppCompatActivity {

    String data6,data8;
    EditText edt_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virgo);
        // RANDOM NUMBERS
        TextView RandomNumber = (TextView) findViewById(R.id.tv_luck);
        Random Number = new Random();
        int Rnumber = Number.nextInt(100);
        RandomNumber.setText("You Are " + Rnumber + " % LUCKY TODAY");
        Intent obj = getIntent();
        data6 = obj.getStringExtra("mobile");
        edt_msg = (EditText) findViewById(R.id.edt_msg);


    }

    //call function
    public void callme(View v) {
        String phono = data6;
        Intent obj = new Intent(Intent.ACTION_CALL);//implicit intent
        obj.setData(Uri.parse("tel:" + phono));//
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        //auto-generated
        {

            return;
        }
        startActivity(obj);
    }

    //messaging function
    public void send(View v)
    {
        data8 = edt_msg.getText().toString();
        SmsManager sm = SmsManager.getDefault();
        String msg = data8+" ";
        String phono = data6;
        Intent obj = new Intent(this, MsgSent.class);
        PendingIntent pi = PendingIntent.getActivity(this, 1, obj, 0);
        sm.sendTextMessage(phono, null, msg, pi, null);//pending intent send details to sms manager(dest phno,source phno,msg,pi,pending intent delivered)
        Toast.makeText(this, "msg sent", Toast.LENGTH_LONG).show();

    }

    public void signout(View v) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

}

