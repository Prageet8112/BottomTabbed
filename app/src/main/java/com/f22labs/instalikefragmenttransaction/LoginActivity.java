package com.f22labs.instalikefragmenttransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

import com.f22labs.instalikefragmenttransaction.activities.MainActivity;
import com.f22labs.instalikefragmenttransaction.SignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    String email,password;
    EditText Email,Password;
    ProgressBar p;
    Button login ,reg;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
   //     Log.d("dryrun", "before mauth initalization");
        mAuth=FirebaseAuth.getInstance();
        login=(Button)findViewById(R.id.LoginButton);
        reg=(Button)findViewById(R.id.toSignUp);
        Email=(EditText)findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.password);
        p=(ProgressBar)findViewById(R.id.progress);
        getSupportActionBar().hide();
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.logo3);
        RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        rbd.setCircular(true);
        imageView.setImageDrawable(rbd);

        findViewById(R.id.toSignUp).setOnClickListener(this);
        findViewById(R.id.LoginButton).setOnClickListener(this);
  //      Log.d("dryrun", "end of login activity create");
    }
    private void login(){
        email=Email.getText().toString();
        password=Password.getText().toString();
  //      Log.d("dryrun", "login start "+email+" "+password);
        if(email.isEmpty()||password.isEmpty()){
   //         Log.d("dryrun", "empty fields");
            Toast.makeText(this, "All fields are required.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!email.endsWith(".com") || !email.contains("@")){
            Email.setError("Please enter a valid email.");
            Email.requestFocus();
            login();
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
      //  Log.d("dryrun", "starting signin");
        p.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    p.setVisibility(View.GONE);
                   // Log.d("dryrun", "found it");
                    Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    //Fetching to be done here????
                    //to Activity
                }
                else
                    Toast.makeText(getApplicationContext(),"Email id or password incorrect.", Toast.LENGTH_SHORT).show();
            }});
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("dryrun", "onstart before checking");
        if(mAuth.getCurrentUser()!= null){
            Log.d("onstart", "onstart checking");
            Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            //home activity startactivity here

        }

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.toSignUp){
       //     Log.d("dryrun", "going to another, Signup");
            startActivity(new Intent(this, SignUpActivity.class));
        }
        if(view.getId()==R.id.LoginButton){
       //     Log.d("dryrun", "login button click");

            login();
       //     Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
       //     finish();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();

    }
}