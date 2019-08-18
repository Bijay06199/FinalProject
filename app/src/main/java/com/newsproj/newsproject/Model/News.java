package com.newsproj.newsproject.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 8/18/2019.
 */

public class News implements Parcelable {
public News(){

}

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Description")
    @Expose
    private String decription;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("ShortDescription")
    @Expose
    private String shortdesc;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("PublishDate")
    @Expose
    private String pubAt;
    @SerializedName("CreatedDate")
    @Expose
    private String createdAt;


    protected News(Parcel in) {

        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.shortdesc = ((String) in.readValue((String.class.getClassLoader())));
        this.decription = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.pubAt = ((String) in.readValue((String.class.getClassLoader())));
    }
    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPubAt() {
        return pubAt;
    }

    public void setPubAt(String pubAt) {
        this.pubAt = pubAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(decription);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(shortdesc);
        dest.writeString(userName);
        dest.writeString(pubAt);
        dest.writeString(createdAt);
    }


}
