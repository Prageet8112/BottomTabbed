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

import com.f22labs.instalikefragmenttransaction.Data.SubActData;
import com.f22labs.instalikefragmenttransaction.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by prage on 3/9/2018.
 */

public class CustomAdapterSubAct extends BaseAdapter {
    Context c;
    ArrayList<SubActData> subAct;
    LayoutInflater inflater;
    @BindView(R.id.subactimage)
    public ImageView subactimage;

    public TextView subacttext;

    public CustomAdapterSubAct(Context c , ArrayList<SubActData> subAct , View view)
    {
        this.c = c;
        this.subAct = subAct;
        this.subactimage = (ImageView) view.findViewById(R.id.subactitemimage);
    }

    @Override
    public int getCount() {
        return subAct.size();
    }

    @Override
    public Object getItem(int i) {
        return subAct.get(i);
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
            view = inflater.inflate(R.layout.subact_item_layout,viewGroup,false);

        }

        subacttext= (TextView)view.findViewById(R.id.subactitemtext);
        subactimage = (ImageView) view.findViewById(R.id.subactitemimage);




        final String name1 = subAct.get(i).getName1();
        int image1 = subAct.get(i).getImage1();


        subacttext.setText(name1);
        subactimage.setImageResource(image1);

        Bitmap bitmap1 = BitmapFactory.decodeResource(view.getResources(),R.drawable.logo1);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap1);
        rbd1.setCircular(true);
        subactimage.setImageDrawable(rbd1);

      /*  subactimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TransitionDrawable) subactimage.getDrawable()).startTransition(3000);
            }
        });*/
        return view;
    }



}
