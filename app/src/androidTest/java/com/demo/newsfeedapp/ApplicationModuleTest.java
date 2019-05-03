package com.demo.newsfeedapp;

import android.app.Application;

import com.demo.newsfeedapp.dagger.modules.ApplicationModule;

import dagger.Module;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class ApplicationModuleTest extends ApplicationModule {


    public ApplicationModuleTest(Application mApplication) {
        super(mApplication);
    }

    @Override
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
