package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
Button login,register ;
    String username,pass,cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        login = (Button) findViewById(R.id.btn1);
        register = (Button) findViewById(R.id.btn2);
        login.setEnabled(false);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("username").isEmpty()==false && extras.getString("pass").isEmpty()==false && extras.getString("cpass").isEmpty()==false) {
            username = extras.getString("username").toString();
            pass = extras.getString("pass").toString();
            cpass = extras.getString("cpass").toString();
            if(pass.equalsIgnoreCase(cpass)) {
                login.setEnabled(true);
            }
        }
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(HomeActivity.this, Login.class);
                    i.putExtra("username",username);
                    i.putExtra("pass",pass);
                    startActivity(i);
                }
            });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, Register.class);
                startActivity(i);
                //finish();

            }
        });

    }
}