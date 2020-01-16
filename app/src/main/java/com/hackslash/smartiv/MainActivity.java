package com.hackslash.smartiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String masterID = "user001";
    String masterPass = "123";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);

    }

    public void checkCred(View view) {
        EditText pass = (EditText) findViewById(R.id.password);
        TextView failView = (TextView) findViewById(R.id.invalid);
        String id = ((EditText) findViewById(R.id.userid)).getText().toString();
        String password = pass.getText().toString();
        if(!id.isEmpty() && !password.isEmpty()){
            if (masterID.equals(id) && masterPass.equals(password)) {
                Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, PostLoginActivity.class));
                finish();
            }
            else {
                failView.setText("UserID/Password Incorrect");
            }
        }
        else
            failView.setText("UserID/Password Required");



    }
}

