package com.hackslash.smartiv;

import java.io.Serializable;

public class patData implements Serializable {
    private String mDocName;
    private String mDripName;
    private String mPatName;
    private String mRoomNumber;
    private String mBedNumber;
    private boolean mDripEmpty;

    public patData(String patName, String roomNumber, String bedNumber, String docName, String dripName, boolean dripEmpty) {
        mPatName = patName;
        mRoomNumber = roomNumber;
        mBedNumber = bedNumber;
        mDocName = docName;
        mDripName = dripName;
        mDripEmpty = dripEmpty;
    }

    public String getmDocName() {
        return mDocName;
    }

    public String getmPatName() {
        return mPatName;
    }

    public String getmDripName() {
        return mDripName;
    }

    public String getmRoomNumber(){
        return  mRoomNumber;
    }
    public String getmBedNumber(){
        return  mBedNumber;
    }


    public boolean isDripEmpty() {
        return mDripEmpty;
    }
}
