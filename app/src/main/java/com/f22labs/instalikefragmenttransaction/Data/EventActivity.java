package com.f22labs.instalikefragmenttransaction.Data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.f22labs.instalikefragmenttransaction.R;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.event_model);

        TextView nametxt1= (TextView)findViewById(R.id.eventname1);
        ImageView img1 = (ImageView) findViewById(R.id.event1);
        TextView nametxt2= (TextView)findViewById(R.id.eventname2);
        ImageView img2 = (ImageView) findViewById(R.id.event2);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.bg6);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.login1);
        RoundedBitmapDrawable rbd2 = RoundedBitmapDrawableFactory.create(getResources(),bitmap2);
        rbd2.setCircular(true);
        img2.setImageDrawable(rbd2);

    }
}
