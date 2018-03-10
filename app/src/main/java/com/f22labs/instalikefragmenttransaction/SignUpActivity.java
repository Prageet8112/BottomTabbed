package com.f22labs.instalikefragmenttransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    String name,roll,branch,sem,mobile,email,password;
    EditText Name, Roll, Mobile,  Email, Password;
    FirebaseAuth mAuth;
    Spinner Branch, Sem;
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference us;
    Button sign;
    FirebaseUser user;
    FirebaseAuth r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        Log.d("dryrun", "signupactivity oncreate");
        //getSupportActionBar().hide();
        Name=(EditText)findViewById(R.id.name);
        Roll=(EditText)findViewById(R.id.rollno);
        Mobile=(EditText)findViewById(R.id.mobile);
        Branch=(Spinner)findViewById(R.id.branch);
        Sem=(Spinner)findViewById(R.id.sem);
        Email=(EditText)findViewById(R.id.emailadr);
        Password=(EditText)findViewById(R.id.password);
        sign=(Button)findViewById(R.id.SignUpButton);
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.logo3);
        RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        rbd.setCircular(true);
        imageView.setImageDrawable(rbd);
        mAuth=FirebaseAuth.getInstance();
        us= FirebaseDatabase.getInstance().getReference("Techvibes").child("Users");
        findViewById(R.id.SignUpButton).setOnClickListener(this);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Log.d("dryrun", "Checking user");
                user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    // User is signed in

                } else {
                    // User is signed out
                    Log.d("dryrun","Signing out");
                }
            }
        };

        //To the home activity


    }
    private void register(){
        email=Email.getText().toString();
        password=Password.getText().toString();
        name=Name.getText().toString();
        roll=Roll.getText().toString();
        mobile=Mobile.getText().toString();
        branch=Branch.getSelectedItem().toString();
        sem=Sem.getSelectedItem().toString();
        Log.d("dryrun", "email= "+email);
        Log.d("dryrun", "password= "+password);
        Log.d("dryrun", "name= "+name);
        Log.d("dryrun", "roll= "+roll);
        Log.d("dryrun", "mobile= "+mobile);
        Log.d("dryrun", "branch= "+branch);
        Log.d("dryrun", "sem= "+sem);
        if(email.isEmpty()||password.isEmpty()||name.isEmpty()||roll.isEmpty()||mobile.isEmpty()||branch.isEmpty()||sem.isEmpty()){
            Toast.makeText(this, "All fields are required.",Toast.LENGTH_SHORT).show();
            return;
        }
   /*     if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Please enter a valid email.");
            Email.requestFocus();
            return;
        }*/
        if(password.length()<6){
            Password.setError("Password length is too short.");
            Password.requestFocus();
            return;
        }
        Log.d("dryrun","here");
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("dryrun", "user created. Feeding in database");
                    user=FirebaseAuth.getInstance().getCurrentUser();
                    Log.d("dryrun","User id: "+user.getUid().toString());
                   Users obj=new Users(name,roll,branch,sem,mobile,email.replace('.',','),password);
                    us= FirebaseDatabase.getInstance().getReference("Techvibes").child("Users");
                    us.child(user.getUid()).setValue(obj);
                    Toast.makeText(getApplicationContext(),"Ho gaya kalyan",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(SignUpActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    System.out.println("dry run error occured "+ task.getException().getMessage());
                    return;}

            }

        });

    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.SignUpButton){
            register();
            Log.d("dryrun", "signup button pressed");}
    }
}