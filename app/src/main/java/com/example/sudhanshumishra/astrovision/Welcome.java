package com.example.sudhanshumishra.astrovision;



import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.jar.Manifest;

public class Welcome extends AppCompatActivity {
    TextView vv, date1;
    ImageView im;

    MediaPlayer mp;
    String data1, data2, data3, data4, data5,data6,data7,data8;

    TextView RandomNumber;
    Button GenRan;
    Random Number;
    int Rnumber;
    int int_date,int_mm;
    EditText edt_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Intent obj = getIntent();
        data1 = obj.getStringExtra("id");
        data2 = obj.getStringExtra("password");
        data3 = obj.getStringExtra("dd");
        data4 = obj.getStringExtra("mm");

        int_date=Integer.parseInt(data3);
        int_mm=Integer.parseInt(data4);

        data5 = obj.getStringExtra("yyyy");
        data6 = obj.getStringExtra("mobile");
        data7 = obj.getStringExtra("name");
        vv = (TextView) findViewById(R.id.vv);
        vv.setText("Many many happy returns of the day\n" +"\t"+data7 );


        edt_msg = (EditText) findViewById(R.id.edt_msg);
        data8 = edt_msg.getText().toString();




        //ANIMATION CONTENT   starts here

        im = (ImageView) findViewById(R.id.im);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadeinfadeout);
        im.startAnimation(a);

        //animation ends here


        //MUSIC CONTENT   starts here


        mp = MediaPlayer.create(this, R.raw.hb);
        mp.start();

        //  ends here


    }

    //CALL FUNCTION

    public void callme(View v) {
        mp.stop();
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

    //sms function
    public void smsme(View v) {

        mp.stop();
        SmsManager sm = SmsManager.getDefault();
        String msg = data7 + " !! Happy Birthday";
        String phono = data6;
        Intent obj = new Intent(this, MsgSent.class);
        PendingIntent pi = PendingIntent.getActivity(this, 1, obj, 0);
        sm.sendTextMessage(phono, null, msg, pi, null);//pending intent send details to sms manager(dest phno,source phno,msg,pi,pending intent delivered)
        Toast.makeText(this, "msg sent", Toast.LENGTH_LONG).show();
    }

    public void send(View v)
    {/* Intent i=new Intent(Intent.ACTION_VIEW);//Built-in-client used in mobile[Default sms client]
        i.putExtra("smsbody","type ur text");
        i.setType("vnd.android-dir/mms-sms");
        startActivity(i);*/
        mp.stop();
        SmsManager sm = SmsManager.getDefault();
        String msg = data8+" ";
        String phono = data6;
        Intent obj = new Intent(this, MsgSent.class);
        PendingIntent pi = PendingIntent.getActivity(this, 1, obj, 0);
        sm.sendTextMessage(phono, null, msg, pi, null);//pending intent send details to sms manager(dest phno,source phno,msg,pi,pending intent delivered)
        Toast.makeText(this, "msg sent", Toast.LENGTH_LONG).show();

    }

    public void details(View v)
    {
        mp.stop();
        if((int_mm==3 && int_date>=21 && int_date<=31)||(int_mm==4 && int_date>=1 && int_date<=19))
        {
            Intent i = new Intent(this, Aries.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }






        else if((int_mm==5 && int_date>=21 && int_date<=31)||(int_mm==6 && int_date>=1 && int_date<=20))
        {
            Intent i = new Intent(this, Gemini.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==6 && int_date>=21 && int_date<=30)||(int_mm==7 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Cancer.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==7 && int_date>=23 && int_date<=31)||(int_mm==8 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Leo.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==8 && int_date>=23 && int_date<=31)||(int_mm==9 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Virgo.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==9 && int_date>=23 && int_date<=30)||(int_mm==10 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Libra.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==10 && int_date>=23 && int_date<=31)||(int_mm==11 && int_date>=1 && int_date<=21))
        {
            Intent i = new Intent(this, Scorpio.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==11 && int_date>=22 && int_date<=30)||(int_mm==12 && int_date>=1 && int_date<=21))
        {
            Intent i = new Intent(this, Sagittarius.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==12 && int_date>=22 && int_date<=31)||(int_mm==1 && int_date>=1 && int_date<=19))
        {
            Intent i = new Intent(this, Capricorn.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==1 && int_date>=20 && int_date<=31)||(int_mm==2 && int_date>=1 && int_date<=18))
        {
            Intent i = new Intent(this, Aquarius.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }

        else if((int_mm==2 && int_date>=19 && int_date<=29)||(int_mm==3 && int_date>=1 && int_date<=20))
        {
            Intent i = new Intent(this, Pisces.class);
            i.putExtra("mobile", data6);
            startActivity(i);
        }




    }


    public void onBackPressed() {
        if (mp.isPlaying()) {
           mp.stop();
        }
        mp.release();
        super.onBackPressed();
    }

    public void signout(View v)
    {
        mp.stop();
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
        finish();


    }



}

