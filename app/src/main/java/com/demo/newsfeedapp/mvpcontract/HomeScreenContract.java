package com.demo.newsfeedapp.mvpcontract;

import com.demo.newsfeedapp.data.models.Result;

import java.util.List;

public interface HomeScreenContract {
    interface Presenter extends MVPPresenter<HomeScreenContract.View> {

        void fetchNewsData();

        void launchDetailsScreen(Result result);
    }

    interface View extends MVPView {

        void setNewsData(List<Result> results);

        void onNewsDataLoadFailed();
    }
}
