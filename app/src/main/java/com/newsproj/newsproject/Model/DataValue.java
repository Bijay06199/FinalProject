package com.newsproj.newsproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hp on 8/17/2019.
 */

public class DataValue implements Parcelable {

    public DataValue() {
    }

    @SerializedName("value")
    @Expose
    List<News> dataValueList = null;


    public static final Creator<DataValue> CREATOR = new Creator<DataValue>() {
        @Override
        public DataValue createFromParcel(Parcel in) {
            return new DataValue(in);
        }

        @Override
        public DataValue[] newArray(int size) {
            return new DataValue[size];
        }
    };

    protected DataValue(Parcel in) {
        in.readList(this.dataValueList, (DataValue.class.getClassLoader()));
    }

    public List<News> getDataValueList() {
        return dataValueList;
    }

    public void setDataValueList(List<News> dataValueList) {
        this.dataValueList = dataValueList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(dataValueList);
    }
}
