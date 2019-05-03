package com.demo.newsfeedapp.dagger.components;

import android.content.Context;

import com.demo.newsfeedapp.dagger.modules.ApplicationModule;
import com.demo.newsfeedapp.data.newsrepo.NewsDataRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @Named("applicationContext")
    Context context();

    NewsDataRepository newsDataRepository();
}
