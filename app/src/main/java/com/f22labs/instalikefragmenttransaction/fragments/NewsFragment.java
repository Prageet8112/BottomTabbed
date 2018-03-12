package com.f22labs.instalikefragmenttransaction.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.utils.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsFragment extends BaseFragment{

    int fragCount;
    ArrayList<String> deta;
    DatabaseReference databaseReference;
    TextView tt1 , tt2 , tt3;
    String strn[]=new String[7];
    String name,roll,email;
    public static NewsFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args != null) {
            fragCount = args.getInt(ARGS_INSTANCE);
        }

        tt1 = (TextView) view.findViewById(R.id.name);
        tt2 = (TextView) view.findViewById(R.id.roll);
        tt3 = (TextView) view.findViewById(R.id.email);



        ImageView img1 = (ImageView) view.findViewById(R.id.user_profile);
        Bitmap bitmap1 = BitmapFactory.decodeResource(view.getResources(),R.drawable.user_icon);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(view.getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);
        deta=new ArrayList<>();
        final String uid= FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        databaseReference= FirebaseDatabase.getInstance().getReference("Techvibes").child("Users").child(uid);
        Log.d("dry",databaseReference.toString());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("dry",dataSnapshot.toString());
                String s[]=dataSnapshot.getValue().toString().split(", ");
                for(int i=0;i<7;i++){
                    strn[i]=s[i].substring(s[i].indexOf('=')+1);

                }
                tt1.setText(strn[4].toUpperCase());
                tt2.setText(strn[5].replace("be","BE"));
                tt3.setText(strn[3].replace(',','.'));
                name=strn[4];
                roll=strn[5].replace("be","BE");
                email=strn[3].replace(',','.');
                Log.d("dry",name+" "+roll+" "+email);
                DatabaseReference db= FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            deta.add(ds.getValue().toString());
                            Log.d("dry",ds.getValue().toString());
                        }
                        for(String a: deta) {
                            //from here add for every element a in deta
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    /*    btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFragmentNavigation != null) {
                    mFragmentNavigation.pushFragment(NewsFragment.newInstance(fragCount + 1));


                }
            }
        });


        ( (MainActivity)getActivity()).updateToolbarTitle((fragCount == 0) ? "MyActivity" : "Sub News "+fragCount);
        */


    }
}
