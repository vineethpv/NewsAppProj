package com.demo.newsfeedapp.dagger.modules;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {
    private final WeakReference<Activity> mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }

    @Provides
    Activity provideActivity() {
        return mActivity.get();
    }

    @Provides
    @Named("activityContext")
    Context providesContext() {
        return mActivity.get();
    }
}
