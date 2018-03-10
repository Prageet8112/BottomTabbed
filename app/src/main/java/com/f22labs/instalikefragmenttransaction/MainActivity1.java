package com.f22labs.instalikefragmenttransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity1 extends AppCompatActivity {
DatabaseReference dara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("dryrun", "ll");
        setContentView(R.layout.activity_main);
        Log.d("dryrun", "oncreate");
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

        Log.d("dryrun", "end");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.menu, menu);

        return true;
    }
}
