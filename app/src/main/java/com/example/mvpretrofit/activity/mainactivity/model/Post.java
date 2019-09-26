package com.example.mvpretrofit.activity.mainactivity.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    String userid;
    @SerializedName("id")
    String id ;
    @SerializedName("body")
    String text;
    @SerializedName("title")
    String title;

    public Post(String userid, String id, String text, String title) {
        this.userid = userid;
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
