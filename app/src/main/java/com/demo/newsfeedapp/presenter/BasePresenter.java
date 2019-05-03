package com.demo.newsfeedapp.presenter;

import com.demo.newsfeedapp.mvpcontract.MVPPresenter;
import com.demo.newsfeedapp.mvpcontract.MVPView;

import java.lang.ref.WeakReference;

import androidx.annotation.CallSuper;

 abstract class BasePresenter<T extends MVPView> implements MVPPresenter<T> {

    private WeakReference<T> mMvpView;

    @CallSuper
    @Override
    public void attachView(T mvpView) {
        this.mMvpView = new WeakReference<>(mvpView);
    }

    @CallSuper
    @Override
    public void detachView() {
        this.mMvpView = null;
    }

    public T getMvpView() {
        return mMvpView == null ? null : mMvpView.get();
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }
}
