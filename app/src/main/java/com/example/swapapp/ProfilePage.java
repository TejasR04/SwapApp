package com.example.swapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfilePage extends AppCompatActivity {

    private ImageView ProfilePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ProfilePage.this, InfoActivity.class));
            }
        });
    }
}