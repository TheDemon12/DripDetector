package com.hackslash.smartiv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class patAdapter extends ArrayAdapter {

    public patAdapter(Context context, ArrayList<patData> patList) {

        super(context,0,patList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_details,parent,false);
        }

        patData currentPatData = (patData) getItem(position);

        TextView patientNameView = (TextView) convertView.findViewById(R.id.patientName);
        TextView patientRoomNumberView = (TextView) convertView.findViewById(R.id.patientRoomNumber);
        TextView patientBedNumberView = (TextView) convertView.findViewById(R.id.patientBedNumber);
        ImageView patientDripStatusView = (ImageView) convertView.findViewById(R.id.patientDripStatus);
        //   Log.e("lul", currentPatData.getmDocName());

        patientNameView.setText(currentPatData.getmPatName());
        patientRoomNumberView.setText("ROOM : " + currentPatData.getmRoomNumber());
        patientBedNumberView.setText("BED NUMBER : " + currentPatData.getmBedNumber());

        if(currentPatData.isDripEmpty())
        {
            patientDripStatusView.setImageResource(R.drawable.red);
        }
        else {
            patientDripStatusView.setImageResource(R.drawable.green);
        }


        return convertView;
    }
}
