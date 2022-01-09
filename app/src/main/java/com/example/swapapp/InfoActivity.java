package com.example.swapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {

    Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button profile = (Button) findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(InfoActivity.this, ProfilePage.class));
            }
        });
    }

}