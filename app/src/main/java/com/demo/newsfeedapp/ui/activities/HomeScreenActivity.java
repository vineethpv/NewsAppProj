package com.demo.newsfeedapp.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.demo.newsfeedapp.R;
import com.demo.newsfeedapp.dagger.modules.ModuleManager;
import com.demo.newsfeedapp.data.models.Result;
import com.demo.newsfeedapp.mvpcontract.HomeScreenContract;
import com.demo.newsfeedapp.mvpcontract.MVPPresenter;
import com.demo.newsfeedapp.ui.adapters.NewsFeedAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;

public class HomeScreenActivity extends BaseActivity implements HomeScreenContract.View {

    @Inject
    HomeScreenContract.Presenter mPresenter;

    private RecyclerView mNewsFeedRV;
    private TextView mTxtErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        viewComponent().plus(new ModuleManager.HomeScreenModule()).inject(this);
        mPresenter.attachView(this);
        mPresenter.fetchNewsData();
    }

    @Override
    protected MVPPresenter getPresenter() {
        return mPresenter;
    }

    private void initViews() {
        mNewsFeedRV = findViewById(R.id.rvNewsFeed);
        mTxtErrorMsg = findViewById(R.id.txtErrorMsg);
    }

    private void updateSuccessVisiblity(boolean success) {
        mNewsFeedRV.setVisibility(success ? View.VISIBLE: View.GONE);
        mTxtErrorMsg.setVisibility(success ? View.GONE: View.VISIBLE);
    }

    @Override
    public void setNewsData(List<Result> results) {
        updateSuccessVisiblity(true);
        mNewsFeedRV.setAdapter(new NewsFeedAdapter(results, new NewsFeedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Result item) {
                mPresenter.launchDetailsScreen(item);
            }
        }));
    }

    @Override
    public void onNewsDataLoadFailed() {
        updateSuccessVisiblity(false);
    }

}
