package com.demo.newsfeedapp.data.newsrepo;


import com.demo.newsfeedapp.data.models.NewsData;

public interface Callback {
    void onSuccess(NewsData weatherData);

    void onFailure();
}
