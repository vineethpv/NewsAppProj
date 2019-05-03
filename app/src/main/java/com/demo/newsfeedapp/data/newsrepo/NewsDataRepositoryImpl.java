package com.demo.newsfeedapp.data.newsrepo;

import com.demo.newsfeedapp.data.models.NewsData;

import retrofit2.Call;
import retrofit2.Response;

import static com.demo.newsfeedapp.helpers.APIConstants.API_AUTH_KEY;

public class NewsDataRepositoryImpl implements NewsDataRepository {
    private NewsDataAPI mNewsDataAPI;
    private Call<NewsData> mTaskExecutor;

    public NewsDataRepositoryImpl(NewsDataAPI newsDataAPI) {
        this.mNewsDataAPI = newsDataAPI;
    }

    @Override
    public void getNewsData(final Callback callback) {
        if (mTaskExecutor != null) {
            mTaskExecutor.cancel();
        }
        mTaskExecutor = mNewsDataAPI.getNewsData(API_AUTH_KEY);
        mTaskExecutor.enqueue(new retrofit2.Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure();
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
