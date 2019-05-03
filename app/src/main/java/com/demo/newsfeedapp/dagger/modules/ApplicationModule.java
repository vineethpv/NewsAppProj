package com.demo.newsfeedapp.dagger.modules;

import android.app.Application;
import android.content.Context;


import com.demo.newsfeedapp.data.newsrepo.NewsDataAPI;
import com.demo.newsfeedapp.data.newsrepo.NewsDataRepository;
import com.demo.newsfeedapp.data.newsrepo.NewsDataRepositoryImpl;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.demo.newsfeedapp.helpers.APIConstants.BASE_URL;


@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Named("applicationContext")
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient okHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    NewsDataRepository weatherRepository(NewsDataAPI weatherDataAPI) {
        return new NewsDataRepositoryImpl(weatherDataAPI);
    }

    @Provides
    @Singleton
    NewsDataAPI weatherDataAPI(Retrofit retrofit) {
        return retrofit.create(NewsDataAPI.class);
    }
}
