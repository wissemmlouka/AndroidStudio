package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
EditText username,mdp,cmdp;
Button registerbtn;
String username_in,pass_in,cpass_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        username= (EditText) findViewById(R.id.reg_username);
        mdp=(EditText) findViewById(R.id.reg_mpd);
        cmdp=(EditText) findViewById(R.id.reg_cmpd);
        registerbtn= (Button) findViewById(R.id.btn_register);


        AlertDialog alertDialog = new AlertDialog.Builder(Register.this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setMessage("password incorret ! ");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username_in=username.getText().toString();
                pass_in=mdp.getText().toString();
                cpass_in=cmdp.getText().toString();
                if(pass_in.equalsIgnoreCase(cpass_in)){
                Intent i = new Intent(Register.this, HomeActivity.class);
                i.putExtra("username",username.getText().toString());
                i.putExtra("pass",mdp.getText().toString());
                i.putExtra("cpass",cmdp.getText().toString());

                startActivity(i);

            }else {
                alertDialog.show();
            }
        }
        });
    }
  }
