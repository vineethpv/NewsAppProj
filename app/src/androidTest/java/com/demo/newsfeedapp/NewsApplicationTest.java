package com.demo.newsfeedapp;

import com.demo.newsfeedapp.dagger.components.ApplicationComponent;
import com.demo.newsfeedapp.dagger.components.DaggerApplicationComponent;

public class NewsApplicationTest extends NewsFeedApplication {

    @Override
    public ApplicationComponent getComponent() {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModuleTest(this)).build();
    }
}
