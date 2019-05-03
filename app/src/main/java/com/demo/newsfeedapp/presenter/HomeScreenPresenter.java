package com.demo.newsfeedapp.presenter;

import android.os.Bundle;

import com.demo.newsfeedapp.data.models.NewsData;
import com.demo.newsfeedapp.data.models.Result;
import com.demo.newsfeedapp.data.newsrepo.Callback;
import com.demo.newsfeedapp.data.newsrepo.NewsDataRepository;
import com.demo.newsfeedapp.mvpcontract.HomeScreenContract;
import com.demo.newsfeedapp.ui.activities.DetailsActivity;

import static com.demo.newsfeedapp.ui.activities.DetailsActivity.KEY_DETAILS;

public class HomeScreenPresenter extends BasePresenter<HomeScreenContract.View> implements HomeScreenContract.Presenter, Callback {
    private NewsDataRepository mNewsDataRepository;

    public HomeScreenPresenter(NewsDataRepository newsDataRepository) {
        this.mNewsDataRepository = newsDataRepository;
    }

    @Override
    public void attachView(HomeScreenContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void fetchNewsData() {
        if (isViewAttached()) {
            mNewsDataRepository.getNewsData(this);
        }
    }

    @Override
    public void launchDetailsScreen(Result result) {
        if(isViewAttached()) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_DETAILS, result.get_abstract());
            getMvpView().launchActivity(bundle, DetailsActivity.class);
        }
    }

    @Override
    public void onSuccess(NewsData newsData) {
        if (isViewAttached()) {
            getMvpView().setNewsData(newsData.getResults());
        }
    }

    @Override
    public void onFailure() {
        if (isViewAttached()) {
            getMvpView().onNewsDataLoadFailed();
        }
    }

}
