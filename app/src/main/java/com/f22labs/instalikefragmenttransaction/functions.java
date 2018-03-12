package com.f22labs.instalikefragmenttransaction;

import android.content.Context;
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
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by Zonoid on 3/10/2018.
 */

public class functions {
    String name,roll,branch,sem,mobile,email,password;
    DatabaseReference db,us;
    String uid;
    static HSSFSheet sheet;
    static HSSFWorkbook workbook;
    static ArrayList<String> str,team;
    Users gg;
    String strn[]=new String[7];
    static ArrayList<com.f22labs.instalikefragmenttransaction.Users> user;

    public void feed( String event, String team){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        final String e=event.replace('.',',');
        final String t=team.replace('.',',');
        uid=user.getUid().toString();
        us=FirebaseDatabase.getInstance().getReference("Techvibes").child("Users").child(uid);
      //  Log.d("dry",us.toString());
        us.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                   // Log.d("dry",dataSnapshot.toString());
                String s[]=dataSnapshot.getValue().toString().split(", ");
                for(int i=0;i<7;i++){
                    strn[i]=s[i].substring(s[i].indexOf('=')+1);
               //     Log.d("dry",i+" "+strn[i]);
                }
                strn[6].replace('}',' ').trim();
                gg=new Users(strn[4],strn[5],strn[1],strn[6],strn[2],strn[3],strn[0]);
             //   Log.d("dryrunt",gg.getName());

                //  Log.d("dry",g.getName());
                db= FirebaseDatabase.getInstance().getReference().child("Events").child(e);
                db.child(t+"_"+uid).setValue(gg);
                    }





            @Override
            public void onCancelled(DatabaseError databaseError) {
                return; }
        });
        us=FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        us.child(e).setValue(e);


    }
    public ArrayList retrieveregistered(){
      //  Log.d("dry","entered");
     //   Log.d("dry",FirebaseDatabase.getInstance().getReference().toString());
     //   Log.d("dry",FirebaseDatabase.getInstance().getReference().child("Users").toString());
     //   Log.d("dry",FirebaseDatabase.getInstance().getReference().child("Users").child(uid).toString());
        Log.d("dryrun","afetr all that");
        ArrayList<String> chutiyap=new ArrayList<>();
        for(String s:str){
            Log.d("dryrun",s);
            chutiyap.add(s);
            if(s.equals(""))
                Log.d("dry","nulla");
        }

        Log.d("dryrun","afetr or before??");
        us=FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        str=new ArrayList<>() ;
        Log.d("dry",us.toString());
        us.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("dry",dataSnapshot.toString());
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    Log.d("dry",ds.toString());
                    functions.str.add(ds.getValue().toString());
                    Log.d("dry etry",ds.getValue().toString());

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return chutiyap;
    }
    public void retrieve( String event, final Context c){

        final String vent=event.replace('.',',');
        functions.user=new ArrayList<>();
        Log.d("downn",user.size()+"");
team=new ArrayList<>();

        db=FirebaseDatabase.getInstance().getReference("Events").child(event);

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("qwe",dataSnapshot.toString());
                ArrayList<Users> user=new ArrayList<>();
                for(DataSnapshot id : dataSnapshot.getChildren()){
                    if(id.getKey()!=null){
                    Log.d("qwe",id.getKey().split("_")[0]);
                    team.add(id.getKey().toString());
                    String s[]=id.getValue().toString().split(", ");
                    for(int i=0;i<7;i++){
                        strn[i]=s[i].substring(s[i].indexOf('=')+1);
                             Log.d("down",i+" "+strn[i]);
                    }
                    strn[6].replace('}',' ').trim();
                    Users a=new Users(strn[4],strn[5],strn[1],strn[6],strn[2],strn[3],strn[0]);
                    user.add(a);
                }}
                functions.download(vent,team,user,c);
                Log.d("downbn",user.size()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Log.d("downan",user.size()+"");

    }
public static void download(String event,ArrayList<String>t, ArrayList<Users> list, Context c){
    Log.d("download run","Just entered");
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
    rowhead.createCell((short) 6).setCellValue("Teamname");
    Log.d("download run","sheet created");

    Log.d("download run","function calling");
    int i = 1;
    for(Users u:list){
        Log.d("download run", u.getName());
        String s[]=t.get(i-1).split("_");
        HSSFRow row = sheet.createRow((short) i);
        row.createCell((short) 0).setCellValue(i++);
        row.createCell((short) 1).setCellValue(u.name);
        row.createCell((short) 2).setCellValue(u.roll);
        row.createCell((short) 3).setCellValue(u.sem.replace('}',' '));
        row.createCell((short) 4).setCellValue(u.branch);
        row.createCell((short) 5).setCellValue(u.email.replace(',', '.'));
        row.createCell((short) 6).setCellValue(u.mobile);
        row.createCell((short) 7).setCellValue(s[0]);

    }

    File file = new File(c.getExternalFilesDir(null), event+".xls");
    FileOutputStream os = null;

    try {
        os = new FileOutputStream(file);
        workbook.write(os);
        Log.w("FileUtils", "Writing file" + file);

    } catch (IOException e) {
        Log.w("FileUtils", "Error writing " + file, e);
    } catch (Exception e) {
        Log.w("FileUtils", "Failed to save file", e);
    } finally {
        try {
            if (null != os)
                os.close();
        } catch (Exception ex) {
        }
    }
}

}
