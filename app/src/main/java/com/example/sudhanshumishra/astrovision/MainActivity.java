package com.example.sudhanshumishra.astrovision;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences sp = null;
    SharedPreferences.Editor se = null;
    EditText edt_password, edt_id, edt_dd, edt_mm, edt_yyyy, edt_name, edt_mobile;
    Button btn_login;
    String id, mobile;
    String password, dd, mm, yyyy, name;
    TextView RandomNumber;
    int year, date, day, month;
    int int_date, int_mm,int_yy;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sp = getSharedPreferences("userinfo", MODE_PRIVATE);
        se = sp.edit();
        edt_id = (EditText) findViewById(R.id.edt_id);        //txtUsername
        edt_password = (EditText) findViewById(R.id.edt_password);  //txtPassword
        edt_name = (EditText) findViewById(R.id.edt_name);              //txtEmail
        edt_dd = (EditText) findViewById(R.id.edt_dd);
        edt_mm = (EditText) findViewById(R.id.edt_mm);
        edt_yyyy = (EditText) findViewById(R.id.edt_yyyy);
        edt_mobile = (EditText) findViewById(R.id.edt_mobile);
        btn_login = (Button) findViewById(R.id.btn_login);          //buttonReg2





        //date code begins here
        Calendar now = Calendar.getInstance();//invoke object
        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH); //zero based
        day = now.get(Calendar.DAY_OF_MONTH);
        date = now.get(Calendar.DATE);

        //date code ends here

    };

    public void contactme(View v)
    {
        Intent i=new Intent(this,ContactMe.class);
        startActivity(i);

    }

    public void aboutme(View v)
    {
    Intent i=new Intent(this,AboutMe.class);
        startActivity(i);

    }


    public void save(View v) {

        id = edt_id.getText().toString().trim();
        password = edt_password.getText().toString().trim();
        dd = edt_dd.getText().toString().trim();
        mm = edt_mm.getText().toString().trim();
        yyyy = edt_yyyy.getText().toString().trim();
        name = edt_name.getText().toString().trim();
        mobile = edt_mobile.getText().toString().trim();
        int_date = Integer.parseInt(dd);
        int_mm = Integer.parseInt(mm);
        int_yy = Integer.parseInt(yyyy);


        se.putString("userid", id);
        se.putString("userpassword", password);
        se.putString("username", name);
        se.putString("userdd", dd);
        se.putString("userdd", mm);
        se.putString("userdd", yyyy);
        se.putString("usermobile", mobile);
        se.commit();
        Toast.makeText(this, "Credentials Saved in Shared Preference", Toast.LENGTH_LONG).show();


    }

    public void login(View v) {



        if(TextUtils.isEmpty(id)) {
            edt_id.setError("Fill in the vaid credential");

        }
        else if(TextUtils.isEmpty(password)|| password.length()<8 ){
            edt_password.setError("Minimum 8 characters");

        }

        else if(TextUtils.isEmpty(name)) {
            edt_name.setError("Fill in the vaid credential");

        }

        else if(TextUtils.isEmpty(dd)|| int_date<1 || int_date>31) {
            edt_dd.setError("Fill in the vaid credential");

        }

        else if(TextUtils.isEmpty(mm)|| int_mm<1 || int_mm>12) {
            edt_mm.setError("Fill in the vaid credential");

        }

        else if(TextUtils.isEmpty(yyyy)|| int_yy<1900 ) {
            edt_yyyy.setError("Year should be greater than or equal to 1900");

        }

        else if(TextUtils.isEmpty(mobile) || mobile.length()!=10){
            edt_mobile.setError("Mobile number invalid");

        }


        else if ((date == int_date) && ((month+1) == int_mm))           //checking birthday
        {
            sp = getSharedPreferences("userinfo", MODE_PRIVATE);
            String userid = sp.getString("userid", "");//here default value is blank
            String userpassword = sp.getString("userpassword", "");
            String username = sp.getString("username", "");
            String userdob = sp.getString("userdob", "");
            String usermobile = sp.getString("usermobile", "");
            Toast.makeText(this, userid + " ", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Welcome.class);
            i.putExtra("id", id);
            i.putExtra("password", password);
            i.putExtra("dd", dd);
            i.putExtra("mm", mm);
            i.putExtra("yyyy", yyyy);
            i.putExtra("mobile", mobile);
            i.putExtra("name", name);
            startActivity(i);
            finish();
        }
        else if((int_mm==3 && int_date>=21 && int_date<=31)||(int_mm==4 && int_date>=1 && int_date<=19))
        {
            Intent i = new Intent(this, Aries.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==4 && int_date>=20 && int_date<=30)||(int_mm==5 && int_date>=1 && int_date<=20))
        {
            Intent i = new Intent(this, Pisces.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }


        else if((int_mm==5 && int_date>=21 && int_date<=31)||(int_mm==6 && int_date>=1 && int_date<=20))
        {
            Intent i = new Intent(this, Gemini.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==6 && int_date>=21 && int_date<=30)||(int_mm==7 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Cancer.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==7 && int_date>=23 && int_date<=31)||(int_mm==8 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Leo.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==8 && int_date>=23 && int_date<=31)||(int_mm==9 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Virgo.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==9 && int_date>=23 && int_date<=30)||(int_mm==10 && int_date>=1 && int_date<=22))
        {
            Intent i = new Intent(this, Libra.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==10 && int_date>=23 && int_date<=31)||(int_mm==11 && int_date>=1 && int_date<=21))
        {
            Intent i = new Intent(this, Scorpio.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==11 && int_date>=22 && int_date<=30)||(int_mm==12 && int_date>=1 && int_date<=21))
        {
            Intent i = new Intent(this, Sagittarius.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==12 && int_date>=22 && int_date<=31)||(int_mm==1 && int_date>=1 && int_date<=19))
        {
            Intent i = new Intent(this, Capricorn.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==1 && int_date>=20 && int_date<=31)||(int_mm==2 && int_date>=1 && int_date<=18))
        {
            Intent i = new Intent(this, Aquarius.class);
            i.putExtra("mobile2", mobile);
            startActivity(i);
            finish();
        }

        else if((int_mm==2 && int_date>=19 && int_date<=29)||(int_mm==3 && int_date>=1 && int_date<=20))
        {
            Intent i = new Intent(this, Pisces.class);
            i.putExtra("mobile", mobile);
            startActivity(i);
            finish();
        }


    }


}




