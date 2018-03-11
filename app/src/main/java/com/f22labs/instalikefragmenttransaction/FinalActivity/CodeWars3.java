package com.f22labs.instalikefragmenttransaction.FinalActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.fragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CodeWars3 extends BaseFragment {
    @BindView(R.id.download)
    Button download;
    @BindView(R.id.register)
    Button register;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_code_wars_3, container, false);

        ButterKnife.bind(this, rootView);

        ImageView img1 = (ImageView) rootView.findViewById(R.id.subactimage1);

        Bitmap bitmap1 = BitmapFactory.decodeResource(rootView.getResources(),R.drawable.logo1);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(rootView.getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Download",Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Register",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;


    }

    public static CodeWars3 newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        CodeWars3 fragment = new CodeWars3();
        fragment.setArguments(args);
        return fragment;
    }
}
