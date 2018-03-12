package com.f22labs.instalikefragmenttransaction.listview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.f22labs.instalikefragmenttransaction.Data.ImageItem;
import com.f22labs.instalikefragmenttransaction.R;

import java.util.ArrayList;

/**
 * Created by prage on 3/10/2018.
 */

public class GridVIewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public GridVIewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.gridtext);
            holder.image = (ImageView) row.findViewById(R.id.gridimage);


            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = (ImageItem) data.get(position);

         Bitmap bitmap4 = BitmapFactory.decodeResource(context.getResources(),item.getImage());
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(context.getResources(),bitmap4);
        rbd1.setCircular(true);
        holder.image.setImageDrawable(rbd1);

        holder.imageTitle.setText(item.getTitle());
        //holder.image.setImageResource(item.getImage());


        return row;
    }


    static class ViewHolder {
        TextView imageTitle;
        ImageView image;
    }
}