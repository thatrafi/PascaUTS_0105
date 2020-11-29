package com.example.pascauts_0105.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class EntertainmentEntity implements Parcelable {

    private int id;
    private float rating;
    private String title,date,desc,lang,type,img;

    public EntertainmentEntity(int id, String title, String date, String desc, float rating, String lang,String type,String img) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.desc = desc;
        this.rating = rating;
        this.lang = lang;
        this.type = type;
        this.img = img;
    }

    public EntertainmentEntity() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.desc);
        dest.writeFloat(this.rating);
        dest.writeString(this.lang);
        dest.writeString(this.type);
        dest.writeString(this.img);
    }

    protected EntertainmentEntity(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.date = in.readString();
        this.desc = in.readString();
        this.rating = in.readFloat();
        this.lang = in.readString();
        this.type = in.readString();
        this.img = in.readString();
    }

    public static final Creator<EntertainmentEntity> CREATOR = new Creator<EntertainmentEntity>() {
        @Override
        public EntertainmentEntity createFromParcel(Parcel source) {
            return new EntertainmentEntity(source);
        }

        @Override
        public EntertainmentEntity[] newArray(int size) {
            return new EntertainmentEntity[size];
        }
    };
}
