package com.hackslash.smartiv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class DripAssistanceActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drip_assistance);

        //ArrayList<patData> patientList = (ArrayList<patData>) getIntent().getSerializableExtra("details");
        final ArrayList<patData> patientList = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference patientDetails = database.getReference();


        patientDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                patientList.clear();
                Iterator<DataSnapshot> roomNumbers = dataSnapshot.getChildren().iterator();
                while(roomNumbers.hasNext()) {
                    DataSnapshot roomNumber = roomNumbers.next();
                    Iterator<DataSnapshot> bedNumbers = roomNumber.getChildren().iterator();
                    while(bedNumbers.hasNext()) {
                        DataSnapshot bedNumber = bedNumbers.next();
                        patientList.add(new patData(
                                bedNumber.child("PATIENT_NAME").getValue().toString(),
                                roomNumber.getKey().toString().split("ROOM_NUMBER_")[1],
                                bedNumber.getKey().toString().split("BED_NUMBER_")[1],
                                bedNumber.child("DOCTOR_NAME").getValue().toString(),
                                bedNumber.child("DRIP_NAME").getValue().toString(),
                                (boolean) bedNumber.child("IS_EMPTY").getValue()

                        ));
                    }
                }
                Collections.sort(patientList, new Comparator<patData>() {
                    @Override
                    public int compare(patData o1, patData o2) {
                        if(!o1.isDripEmpty())
                            return 1;
                        else
                            return -1;
                    }
                });
                patAdapter adapter = new patAdapter(getApplicationContext(),patientList);
                ListView view = (ListView) findViewById(R.id.patientView);
                view.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });










    }
}
