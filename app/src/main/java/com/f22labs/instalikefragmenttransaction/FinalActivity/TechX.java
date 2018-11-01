package com.f22labs.instalikefragmenttransaction.FinalActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.ContactsArray;
import com.f22labs.instalikefragmenttransaction.R;
import com.f22labs.instalikefragmenttransaction.fragments.BaseFragment;
import com.f22labs.instalikefragmenttransaction.functions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TechX extends BaseFragment {

    @BindView(R.id.download)
    Button download;
    @BindView(R.id.register)
    Button register;
    String team_name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_techx, container, false);

        ButterKnife.bind(this, rootView);

        ImageView img1 = (ImageView) rootView.findViewById(R.id.subactimage1);

        Bitmap bitmap1 = BitmapFactory.decodeResource(rootView.getResources(),R.drawable.techx);
        RoundedBitmapDrawable rbd1 = RoundedBitmapDrawableFactory.create(rootView.getResources(),bitmap1);
        rbd1.setCircular(true);
        img1.setImageDrawable(rbd1);

        final ArrayList<String> arrayList = new ContactsArray().getArrayList();
        final String uid= FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Techvibes").child("Users").child(uid);
        databaseReference= FirebaseDatabase.getInstance().getReference("Techvibes").child("Users").child(uid);
        Log.d("dry",databaseReference.toString());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("dry", dataSnapshot.toString());
                String strn[]=new String[7];
                String s[] = dataSnapshot.getValue().toString().split(", ");
                for (int i = 0; i < 7; i++) {
                    strn[i] = s[i].substring(s[i].indexOf('=') + 1);

                }

                if (arrayList.contains(strn[2])) {
                    download.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {new functions().retrieve("TechX",view.getContext());
                Toast.makeText(view.getContext(),"Saved at Android/data/com.f22labs.instalike/files/",Toast.LENGTH_LONG).show();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater factory = LayoutInflater.from(TechX.this.getContext());
                final View textEntryView = factory.inflate(R.layout.text_edit, null);
//text_entry is an Layout XML file containing two text field to display in alert dialog
                final EditText input1 = (EditText) textEntryView.findViewById(R.id.EditText1);
                //   final EditText input2 = (EditText) textEntryView.findViewById(R.id.EditText2);
                input1.setText("", TextView.BufferType.EDITABLE);
                //   input2.setText("", TextView.BufferType.EDITABLE);
                final AlertDialog.Builder alert = new AlertDialog.Builder(TechX.this.getContext());


                alert.setTitle("Enter the Details")
                        .setView(textEntryView)
                        .setPositiveButton("Submit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        team_name = input1.getText().toString();
//                                        captain_name = input2.getText().toString();
                                        if(team_name.equals(""))
                                        {
                                            Toast.makeText(TechX.this.getContext(),"Enter the Value in Team Name",Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            new functions().feed("TechX",team_name);
                                            Toast.makeText(TechX.this.getContext(),"Registered for the event",Toast.LENGTH_SHORT).show();

                                        }
                    /* User clicked OK so do some stuff */
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                    }
                                });
                alert.show();

                //   Toast.makeText(view.getContext(),"Register",Toast.LENGTH_SHORT).show();

            }
        });



        return rootView;


    }

    public static TechX newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        TechX fragment = new TechX();
        fragment.setArguments(args);
        return fragment;
    }
}
