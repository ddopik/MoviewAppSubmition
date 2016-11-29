package com.example.new_one.HelperClasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ddopik_pc on 29/11/2016.
 */

public class ParcelableObject implements Parcelable {
    protected ParcelableObject(Parcel in) {
    }

    public static final Creator<ParcelableObject> CREATOR = new Creator<ParcelableObject>() {
        @Override
        public ParcelableObject createFromParcel(Parcel in) {
            return new ParcelableObject(in);
        }

        @Override
        public ParcelableObject[] newArray(int size) {
            return new ParcelableObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
