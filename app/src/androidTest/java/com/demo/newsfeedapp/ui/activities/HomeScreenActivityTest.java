package com.demo.newsfeedapp.ui.activities;

import android.content.Intent;

import com.demo.newsfeedapp.MockServerDispatcher;
import com.demo.newsfeedapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;
import okhttp3.mockwebserver.MockWebServer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class HomeScreenActivityTest {

    @Rule
    public ActivityTestRule<HomeScreenActivity> activityRule =
            new ActivityTestRule<>(HomeScreenActivity.class, false, false);

    private MockWebServer webServer;

    @Before
    public void setup() throws Exception {

        webServer = new MockWebServer();
        webServer.start(8080);
    }

    @After
    public void tearDown() throws Exception {
        webServer.shutdown();
    }

    @Test
    public void setNewsData() {
        webServer.setDispatcher(new MockServerDispatcher.RequestDispatcher());
        activityRule.launchActivity(new Intent());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rvNewsFeed)).check(matches(isDisplayed()));
    }

    @Test
    public void onNewsDataLoadFailed() {
        webServer.setDispatcher(new MockServerDispatcher.ErrorDispatcher());
        activityRule.launchActivity(new Intent());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.txtErrorMsg)).check(matches(isDisplayed()));
    }
}