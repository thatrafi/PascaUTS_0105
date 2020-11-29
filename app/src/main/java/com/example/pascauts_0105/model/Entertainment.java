package com.example.pascauts_0105.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Entertainment implements Parcelable {
    @SerializedName("original_name")
    private String title_tv;
    @SerializedName("title")
    private String title_movie;
    @SerializedName("overview")
    private String desc;
    @SerializedName("backdrop_path")
    private String img;
    @SerializedName("vote_average")
    private float rating;
    @SerializedName("release_date")
    private String date;
    @SerializedName("first_air_date")
    private String firstair;
    @SerializedName("original_title")
    private String title_reminder;


    private int flag;

    public String getTitle_reminder() {
        return title_reminder;
    }

    public void setTitle_reminder(String title_reminder) {
        this.title_reminder = title_reminder;
    }

    public String getFirstair() {
        return firstair;
    }

    public void setFirstair(String firstair) {
        this.firstair = firstair;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Entertainment(String title_tv, String title_movie, String desc, String img, float rating, String date,int flag,String firstair,String title_reminder) {
        this.title_tv = title_tv;
        this.title_movie = title_movie;
        this.desc = desc;
        this.img = img;
        this.rating = rating;
        this.date = date;
        this.flag = flag;
        this.firstair =firstair;
        this.title_reminder=title_reminder;
    }

    protected Entertainment(Parcel in) {
        title_tv = in.readString();
        title_movie = in.readString();
        desc = in.readString();
        img = in.readString();
        rating = in.readFloat();
        date = in.readString();
        flag = in.readInt();
        firstair = in.readString();
        title_reminder=in.readString();
    }

    public static final Creator<Entertainment> CREATOR = new Creator<Entertainment>() {
        @Override
        public Entertainment createFromParcel(Parcel in) {
            return new Entertainment(in);
        }

        @Override
        public Entertainment[] newArray(int size) {
            return new Entertainment[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle_tv() {
        return title_tv;
    }

    public void setTitle_tv(String title_tv) {
        this.title_tv = title_tv;
    }

    public String getTitle_movie() {
        return title_movie;
    }

    public void setTitle_movie(String title_movie) {
        this.title_movie = title_movie;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title_tv);
        parcel.writeString(title_movie);
        parcel.writeString(desc);
        parcel.writeString(img);
        parcel.writeFloat(rating);
        parcel.writeString(date);
        parcel.writeInt(flag);
        parcel.writeString(firstair);
        parcel.writeString(title_reminder);
    }
}