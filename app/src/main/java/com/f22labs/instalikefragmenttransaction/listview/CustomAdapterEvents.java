package com.f22labs.instalikefragmenttransaction.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.fragments.BaseFragment;
import com.f22labs.instalikefragmenttransaction.fragments.CodeItOut;

import java.util.ArrayList;

/**
 * Created by prage on 3/7/2018.
 */

public class CustomAdapterEvents extends BaseAdapter  {

    Context c;
    ArrayList<Event_Data> events;
    LayoutInflater inflater;

    public CustomAdapterEvents(Context c , ArrayList<Event_Data> events)
    {
        this.c = c;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view==null)
        {
            view = inflater.inflate(R.layout.event_model,viewGroup,false);

        }


        final TextView nametxt1= (TextView)view.findViewById(R.id.eventname1);
        final ImageView img1 = (ImageView) view.findViewById(R.id.event1);
        final TextView nametxt2= (TextView)view.findViewById(R.id.eventname2);
        final ImageView img2 = (ImageView) view.findViewById(R.id.event2);



        final String name1 = events.get(i).getName1();
        int image1 = events.get(i).getImage1();
        final String name2 = events.get(i).getName2();
        int image2 = events.get(i).getImage2();


        nametxt1.setText(name1);
        img1.setImageResource(image1);
        nametxt2.setText(name2);
        img2.setImageResource(image2);

        Bitmap bitmap1 = BitmapFactory.decodeResource(view.getResources(),image1);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);

        Bitmap bitmap2 = BitmapFactory.decodeResource(view.getResources(),R.drawable.logo1);
        RoundedBitmapDrawable rbd2 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap2);
        rbd2.setCircular(true);
        img2.setImageDrawable(rbd2);

        nametxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(name1.equalsIgnoreCase("code it out"))
               {

                   Toast.makeText(c,"Code It Out",Toast.LENGTH_SHORT).show();
                    MainActivity ma = new MainActivity();
                    CodeItOut cd = new CodeItOut();
                    BaseFragment.mFragmentNavigation.pushFragment(cd.newInstance(2));


               }

               if(name1.equalsIgnoreCase("fun with bots"))
               {
                   Toast.makeText(c,"Fun With Bots",Toast.LENGTH_SHORT).show();
               }
            }
        });

       /* view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if(name1.equalsIgnoreCase("animated")) {
                    Toast.makeText(c,"Working 2",Toast.LENGTH_SHORT).show();
                }

                if(name2.equalsIgnoreCase("ecell"))
                {
                    Toast.makeText(c,"Working 1" , Toast.LENGTH_SHORT).show();
                }


            }
        });*/



        return view;
    }
}
