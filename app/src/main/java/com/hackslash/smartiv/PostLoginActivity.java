package com.hackslash.smartiv;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PostLoginActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_post_login);
    }

    public void addEntry(View view) {
        Intent i = new Intent(this, CreateEntryActivity.class);
        startActivity(i);

        //Log.i("lul","heh");
    }

    public void checkDripAssistance(View view) {
        Intent i = new Intent(this, DripAssistanceActivity.class);
        startActivity(i);
    }

    public void logOut(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}
