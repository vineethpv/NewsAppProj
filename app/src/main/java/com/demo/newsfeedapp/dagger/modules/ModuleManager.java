package com.demo.newsfeedapp.dagger.modules;


import com.demo.newsfeedapp.data.newsrepo.NewsDataRepository;
import com.demo.newsfeedapp.mvpcontract.HomeScreenContract;
import com.demo.newsfeedapp.presenter.HomeScreenPresenter;

import dagger.Module;
import dagger.Provides;


public class ModuleManager {

    @Module
    public static class HomeScreenModule {
        @Provides
        HomeScreenContract.Presenter providesPresenter(NewsDataRepository repository) {
            return new HomeScreenPresenter(repository);
        }
    }
}