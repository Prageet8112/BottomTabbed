package com.f22labs.instalikefragmenttransaction.listview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.Data.Contact_Data;
import com.f22labs.instalikefragmenttransaction.R;

import java.util.ArrayList;

/**
 * Created by prage on 10/21/2017.
 */

public class CustomAdapterContacts extends BaseAdapter {

    Context c;
    ArrayList<Contact_Data> arrayContacts;
    LayoutInflater inflater;

    public CustomAdapterContacts(Context c, ArrayList<Contact_Data> arrayContacts) {
        this.c = c;
        this.arrayContacts = arrayContacts;
    }

    @Override
    public int getCount() {
        return arrayContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (view == null) {
            view = inflater.inflate(R.layout.contact_model, viewGroup, false);

        }
        TextView nametxt = (TextView) view.findViewById(R.id.name1);
        ImageView img1 = (ImageView) view.findViewById(R.id.contact_image);
        TextView numbertxt = (TextView) view.findViewById(R.id.desig);
        ImageView img2 = (ImageView) view.findViewById(R.id.call_image);


        final String name = arrayContacts.get(i).getName();
        final String number = arrayContacts.get(i).getNumber();
        int image1 = arrayContacts.get(i).getImage1();
        int image2 = arrayContacts.get(i).getImage2();

        nametxt.setText(name);
        numbertxt.setText(number);
        img1.setImageResource(image1);
        img2.setImageResource(image2);

        Bitmap bitmap1 = BitmapFactory.decodeResource(view.getResources(),R.drawable.tab_profile);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(view.getResources(),R.drawable.call);
        RoundedBitmapDrawable rbd2 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap2);
        rbd2.setCircular(true);
        img2.setImageDrawable(rbd2);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"+91"+number));
                try {
                    c.startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(c, "Could not Load Number to place the call.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
