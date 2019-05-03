package com.demo.newsfeedapp.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsData {

    @SerializedName("status")
    private String status;
    @SerializedName("copyright")
    private String copyright;
    @SerializedName("num_results")
    private int numResults;
    @SerializedName("results")
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }
}
