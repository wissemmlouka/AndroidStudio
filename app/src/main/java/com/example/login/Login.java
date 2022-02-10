package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class Login extends AppCompatActivity {
    EditText username_login,mdp_login;
    Button submit;
    String username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        username_login= (EditText) findViewById(R.id.log_username);
        mdp_login=(EditText) findViewById(R.id.log_mpd);
        submit=(Button) findViewById(R.id.btn_submit);

        AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setMessage(" username or passwod is incorrect ! ");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    username = extras.getString("username").toString();
                    pass = extras.getString("pass");
                    if(username.equalsIgnoreCase(username_login.getText().toString()) && pass.equalsIgnoreCase(mdp_login.getText().toString()) ){
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                    }else{
                          alertDialog.show();
                    }
                }

                //finish();

            }
        });
    }
}