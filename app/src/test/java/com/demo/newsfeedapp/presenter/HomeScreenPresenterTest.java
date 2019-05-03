package com.demo.newsfeedapp.presenter;

import com.demo.newsfeedapp.data.models.NewsData;
import com.demo.newsfeedapp.data.models.Result;
import com.demo.newsfeedapp.data.newsrepo.NewsDataRepository;
import com.demo.newsfeedapp.mvpcontract.HomeScreenContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenPresenterTest {

    private HomeScreenPresenter presenter;

    @Mock
    private NewsDataRepository newsDataRepository;

    @Mock
    private HomeScreenContract.View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new HomeScreenPresenter(newsDataRepository));
        presenter.attachView(view);
    }

    @Test
    public void fetchNewsDataTest() {
        presenter.fetchNewsData();
        Mockito.verify(newsDataRepository, Mockito.times(1)).getNewsData(presenter);
    }

    @Test
    public void onSuccessTest() {
        NewsData newsData = Mockito.mock(NewsData.class);
        Result result = Mockito.mock(Result.class);

        List<Result> results = new ArrayList<>();
        results.add(new Result());
        results.add(new Result());
        results.add(new Result());

        Mockito.doReturn(results).when(newsData).getResults();
        Mockito.doReturn("some title").when(result).getTitle();
        Mockito.doReturn("By DAVID PERLMUTT and JULIE TURKEWITZ").when(result).getByline();
        Mockito.doReturn("2019-05-01").when(result).getPublishedDate();
        presenter.onSuccess(newsData);
        Mockito.verify(view, Mockito.times(1)).setNewsData(newsData.getResults());
    }

    @Test
    public void onFailureTest() {
        presenter.onFailure();
        Mockito.verify(view, Mockito.times(1)).onNewsDataLoadFailed();
    }
}