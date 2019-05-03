package com.demo.newsfeedapp.data.models;


import com.google.gson.annotations.SerializedName;

public class Result {

    public String getByline() {
        return byline;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    @SerializedName("byline")
    private String byline;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;
    @SerializedName("abstract")
    private String _abstract;
    @SerializedName("published_date")
    private String publishedDate;

}
