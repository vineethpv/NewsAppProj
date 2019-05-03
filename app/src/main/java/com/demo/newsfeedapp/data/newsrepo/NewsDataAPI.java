package com.demo.newsfeedapp.data.newsrepo;


import com.demo.newsfeedapp.data.models.NewsData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsDataAPI {

    @GET("1.json")
    Call<NewsData> getNewsData(@Query("api-key") String apiKey);
}
