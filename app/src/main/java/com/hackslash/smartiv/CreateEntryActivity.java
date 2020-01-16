package com.hackslash.smartiv;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateEntryActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_create_entry);
    }

    public void updateDetails(View view) {

        String patName = ((EditText) findViewById(R.id.pat_name)).getText().toString();
        String roomNumber = ((EditText) findViewById(R.id.room_number)).getText().toString();
        String bedNumber = ((EditText) findViewById(R.id.bed_number)).getText().toString();
        String docName = ((EditText) findViewById(R.id.doc_name)).getText().toString();
        String dripName = ((EditText) findViewById(R.id.drip_name)).getText().toString();
        // patData newData = new patData(patName,roomNumber,bedNumber,docName,dripName);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference patientDetails = database.getReference("ROOM_NUMBER_" + roomNumber + "/BED_NUMBER_" + bedNumber);
        patientDetails.child("PATIENT_NAME").setValue(patName);
        patientDetails.child("DOCTOR_NAME").setValue(docName);
        patientDetails.child("DRIP_NAME").setValue(dripName);
        patientDetails.child("IS_EMPTY").setValue(false);


        Toast.makeText(this, "Successfully Added!", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, PostLoginActivity.class);
        startActivity(i);
        finish();
    }

    public void logOut(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}
