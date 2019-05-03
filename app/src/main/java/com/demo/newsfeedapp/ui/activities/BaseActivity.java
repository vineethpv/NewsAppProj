package com.demo.newsfeedapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.demo.newsfeedapp.NewsFeedApplication;
import com.demo.newsfeedapp.dagger.components.DaggerViewComponent;
import com.demo.newsfeedapp.dagger.components.ViewComponent;
import com.demo.newsfeedapp.mvpcontract.MVPPresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    ViewComponent mViewComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
        mViewComponent = null;
        super.onDestroy();
    }

    protected abstract MVPPresenter getPresenter();

    public ViewComponent viewComponent() {
        if (mViewComponent == null) {
            mViewComponent = DaggerViewComponent.builder()
                    .applicationComponent(NewsFeedApplication.get(this).getComponent())
                    .build();
        }
        return mViewComponent;
    }

    public void launchActivity(Bundle bundle, Class className) {
        Intent intent = new Intent(this, className);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void launchActivity(Intent intent) {
        startActivity(intent);
    }

    public void showProgressView() {

    }

    public void hideProgressView() {

    }
}
