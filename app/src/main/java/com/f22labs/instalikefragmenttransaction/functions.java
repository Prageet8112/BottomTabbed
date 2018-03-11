package com.f22labs.instalikefragmenttransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.*;
import com.f22labs.instalikefragmenttransaction.SignUpActivity;
import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Zonoid on 3/10/2018.
 */

public class functions {
    String name,roll,branch,sem,mobile,email,password;
    DatabaseReference db,us;
    com.f22labs.instalikefragmenttransaction.Users gg;
    String uid;
    static HSSFSheet sheet;
    HSSFWorkbook workbook;
    ArrayList<String> str,team;
    ArrayList<com.f22labs.instalikefragmenttransaction.Users> user;
    protected functions(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid().toString();
        us=FirebaseDatabase.getInstance().getReference("Users");
        us.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    if(userSnapshot.getValue().equals(uid)){
                        for (DataSnapshot childEventSnapshot : userSnapshot.getChildren()) {
                            gg = childEventSnapshot.getValue(com.f22labs.instalikefragmenttransaction.Users.class);
                            name=gg.getName();
                            roll=gg.getRoll();
                            branch=gg.getBranch();
                            sem=gg.getSem();
                            mobile=gg.getMobile();
                            email=gg.getEmail().replace(',','.');
                            password=gg.getPassword();
                        }
                    }


                }}

            @Override
            public void onCancelled(DatabaseError databaseError) {
                return; }
        });
    }
    protected void feed(String event, String team){
        event=event.replace('.',',');
        team=team.replace('.',',');
        db= FirebaseDatabase.getInstance().getReference("Events").child(event);
        db.child(team+"_"+uid).setValue(gg);
        us.child(uid).child("event").setValue(event+"_"+team);

    }
    protected ArrayList<String> retrieveformyactivity(){

        us=us.child(uid).child("event");
        str=new ArrayList<>() ;
        us.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    str.add(ds.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return str;
    }
    protected ArrayList<com.f22labs.instalikefragmenttransaction.Users> retrieve(String event){
        event=event.replace('.',',');
        user=new ArrayList<>();
        team=new ArrayList<>();
        db=FirebaseDatabase.getInstance().getReference("Events").child(event);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot id : dataSnapshot.getChildren()){
                    user.add(id.getValue(com.f22labs.instalikefragmenttransaction.Users.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return user;
    }
protected void download(String event){
    workbook = new HSSFWorkbook();
    sheet = workbook.createSheet("FirstSheet");
    HSSFRow rowhead = sheet.createRow((short) 0);
    rowhead.createCell((short) 0).setCellValue("No.");
    rowhead.createCell((short) 1).setCellValue("Name");
    rowhead.createCell((short) 2).setCellValue("Rollno");
    rowhead.createCell((short) 3).setCellValue("Sem");
    rowhead.createCell((short) 4).setCellValue("Branch");
    rowhead.createCell((short) 5).setCellValue("Email");
    rowhead.createCell((short) 6).setCellValue("Contact");
    functions f=new functions();
    f.retrieve(event);
    int i = 1;
    for (com.f22labs.instalikefragmenttransaction.Users s : user) {
        HSSFRow row = sheet.createRow((short) i);
        row.createCell((short) 0).setCellValue(i++);
        row.createCell((short) 1).setCellValue(s.name);
        row.createCell((short) 2).setCellValue(s.roll);
        row.createCell((short) 3).setCellValue(s.sem);
        row.createCell((short) 4).setCellValue(s.branch);
        row.createCell((short) 5).setCellValue(s.email.replace(',', '.'));
        row.createCell((short) 6).setCellValue(s.mobile);

    }

    File file = new File(Environment.getExternalStorageDirectory(), event+".xls");  //EventActivity replace with
    FileOutputStream os = null;

    try {
        os = new FileOutputStream(file);
        workbook.write(os);
        //         Log.w("FileUtils", "Writing file" + file);
 //       Toast.makeText(getApplicationContext(),"File stored in Android/data/com.examplea.prageet.myapplication/files folder.", Toast.LENGTH_LONG).show();

    } catch (IOException e) {
        //          Log.w("FileUtils", "Error writing " + file, e);
    } catch (Exception e) {
        //          Log.w("FileUtils", "Failed to save file", e);
    } finally {
        try {
            if (null != os)
                os.close();
        } catch (Exception ex) {
        }
    }

}

}
