package com.demo.newsfeedapp;

import android.app.Application;
import android.content.Context;

import com.demo.newsfeedapp.dagger.components.ApplicationComponent;
import com.demo.newsfeedapp.dagger.components.DaggerApplicationComponent;
import com.demo.newsfeedapp.dagger.modules.ApplicationModule;


public class NewsFeedApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationModule(new ApplicationModule(this));
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setApplicationModule(ApplicationModule module) {
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(module).build();
    }

    public static NewsFeedApplication get(Context context) {
        return (NewsFeedApplication) context.getApplicationContext();
    }
}
