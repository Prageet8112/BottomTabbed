package com.f22labs.instalikefragmenttransaction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Developers2 extends AppCompatActivity {

    ImageView devImg1 , devImg2 , devImg3;
    TextView getDevName1 , getDevName2 , getDevName3 , getDevCon1 , getDevCon2 , getDevCon3;
    int fragCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers);

        devImg1 = (ImageView) findViewById(R.id.devimage1);
        devImg2 = (ImageView) findViewById(R.id.devimage2);
        devImg3 = (ImageView) findViewById(R.id.devimage3);

        getDevCon1 = (TextView) findViewById(R.id.devcontact1);
        getDevCon2 = (TextView) findViewById(R.id.devcontact2);
        getDevCon3 = (TextView) findViewById(R.id.devcontact3);
        getDevName1 = (TextView) findViewById(R.id.devname1);
        getDevName2 = (TextView) findViewById(R.id.devname2);
        getDevName3 = (TextView) findViewById(R.id.devname3);

        getSupportActionBar().setTitle("Developers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDevName1.setText("Prageet N. Gupta");
        getDevCon1.setText("+91-8741940380");

        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.prageet);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(this.getResources(),bitmap1);
        rbd1.setCircular(true);
        devImg1.setImageDrawable(rbd1);

        getDevName2.setText("Apoorv Gaurav Agarwal");
        getDevCon2.setText("+91-9610161917");

        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.apoorv);
        RoundedBitmapDrawable rbd2 = RoundedBitmapDrawableFactory.create(this.getResources(),bitmap2);
        rbd2.setCircular(true);
        devImg2.setImageDrawable(rbd2);

        getDevName3.setText("Deepesh Gupta");
        getDevCon3.setText("+91-9166765231");

        Bitmap bitmap3 = BitmapFactory.decodeResource(this.getResources(),R.drawable.deepesh);
        RoundedBitmapDrawable rbd3 = RoundedBitmapDrawableFactory.create(this.getResources(),bitmap3);
        rbd3.setCircular(true);
        devImg3.setImageDrawable(rbd3);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
