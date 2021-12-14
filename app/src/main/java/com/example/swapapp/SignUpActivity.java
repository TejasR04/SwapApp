package com.example.swapapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    String name, username, password;

    private ArrayList<String> username_info = new ArrayList<>();
    private ArrayList<String> password_info = new ArrayList<>();
    private ArrayList<String> name_info = new ArrayList<>();

    private FirebaseAuth mAuth;

    EditText prompt_name;
    EditText prompt_username;
    EditText prompt_password;

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        RelativeLayout signUpXml = (RelativeLayout) findViewById(R.id.signUpXml);
        Snackbar fieldsBlank = Snackbar.make(signUpXml, "Field(s) are blank", Snackbar.LENGTH_SHORT);

        prompt_name = (EditText) findViewById(R.id.prompt_name);
        prompt_username = (EditText) findViewById(R.id.prompt_username);
        prompt_password = (EditText) findViewById(R.id.prompt_password);

        Bundle e = getIntent().getExtras();

        username_info = e.getStringArrayList("username_info");
        password_info = e.getStringArrayList("password_info");
        name_info = e.getStringArrayList("name_info");

        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = prompt_username.getText().toString();
                password = prompt_password.getText().toString();
                name = prompt_name.getText().toString();

                if (name.length() > 0 && username.length() > 0 && password.length() > 0) {

                    openMainActivity();
                }
                else {
                    fieldsBlank.show();
                }
            }
        });
    }
    public void openMainActivity() {
        Intent r = new Intent();
        r.putExtra("username_info", username_info);
        r.putExtra("password_info", password_info);
        r.putExtra("name_info", name_info);
        setResult(Activity.RESULT_OK, r);
        finish();
    }
}
