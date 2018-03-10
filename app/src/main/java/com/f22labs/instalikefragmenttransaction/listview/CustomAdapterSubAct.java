package com.f22labs.instalikefragmenttransaction.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.Data.Event_Data;
import com.f22labs.instalikefragmenttransaction.Data.SubActData;
import com.f22labs.instalikefragmenttransaction.FinalActivity.TopCoder;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.fragments.BaseFragment;
import com.f22labs.instalikefragmenttransaction.fragments.CodeItOut;
import com.f22labs.instalikefragmenttransaction.fragments.HomeFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by prage on 3/9/2018.
 */

public class CustomAdapterSubAct extends BaseAdapter {
    Context c;
    ArrayList<SubActData> subAct;
    LayoutInflater inflater;

    public CustomAdapterSubAct(Context c , ArrayList<SubActData> subAct)
    {
        this.c = c;
        this.subAct = subAct;
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
            view = inflater.inflate(R.layout.sub_act_model,viewGroup,false);

        }

        final TextView subacttext= (TextView)view.findViewById(R.id.subacttext);
        final ImageView subactimage = (ImageView) view.findViewById(R.id.subactimage);


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

        TextView textView = (TextView) view.findViewById(R.id.subacttext);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name1.equalsIgnoreCase("top coder event"))
                {
                    Toast.makeText(c,"Top Coder Event",Toast.LENGTH_SHORT).show();
                    MainActivity ma = new MainActivity();
                    TopCoder topCoder = new TopCoder();
                    BaseFragment.mFragmentNavigation.pushFragment(topCoder.newInstance(4));

                }
            }
        });


        return view;
    }



}
