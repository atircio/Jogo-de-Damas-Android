package com.atm.dama.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.atm.dama.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityHome();
            }
        },3000);

    }

    private void ActivityHome(){
        Intent n = new Intent(this, HomeActivity.class);
        startActivity(n);
        finish();
    }
}