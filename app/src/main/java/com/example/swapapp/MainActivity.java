package com.example.swapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String username, password;

    private ArrayList<String> username_info = new ArrayList<>();
    private ArrayList<String> password_info = new ArrayList<>();
    private ArrayList<String> name_info = new ArrayList<>();

    EditText username_input;
    EditText password_input;

    Button login;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout loginXml = (RelativeLayout) findViewById(R.id.loginXml);
        Snackbar signUpFirst = Snackbar.make(loginXml, "You must sign up first", Snackbar.LENGTH_SHORT);
        Snackbar tempWorking = Snackbar.make(loginXml, "Login works", Snackbar.LENGTH_SHORT);
        Snackbar passwordIncorrect = Snackbar.make(loginXml, "Password is incorrect", Snackbar.LENGTH_SHORT);
        Snackbar usernameIncorrect = Snackbar.make(loginXml, "Username is incorrect", Snackbar.LENGTH_SHORT);

        username_input = (EditText) findViewById(R.id.username);
        password_input = (EditText) findViewById(R.id.password);

        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username_input.getText().toString();
                password = password_input.getText().toString();
                int index;

                if (username_info.size() < 1) {
                    signUpFirst.show();
                }
                else {
                    if (username_info.contains(username)) {
                        index = username_info.indexOf(username);
                        if (password_info.get(index).equals(password)) {
                            tempWorking.show();
                            // open activity
                        } else {
                            passwordIncorrect.show();
                        }
                    } else {
                        usernameIncorrect.show();
                    }
                }
            }
        });

        signup = findViewById(R.id.signUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });

    }
    public void openSignUpActivity() {
        Intent i = new Intent(this, SignUpActivity.class);
        i.putExtra("username_info", username_info);
        i.putExtra("password_info", password_info);
        i.putExtra("name_info", name_info);
        startActivityForResult(i, 101);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle e = data.getExtras();
                username_info = e.getStringArrayList("username_info");
                password_info = e.getStringArrayList("password_info");
                name_info = e.getStringArrayList("name_info");
            }
        }
    }
}
