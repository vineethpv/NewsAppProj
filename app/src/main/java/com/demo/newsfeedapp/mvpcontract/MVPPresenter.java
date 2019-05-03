package com.demo.newsfeedapp.mvpcontract;

/**
 * Created by Vineeth on 4/13/2019.
 * <p>
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MVPPresenter<V extends MVPView> {

    void attachView(V mvpView);

    void detachView();
}
