package com.demo.newsfeedapp.mvpcontract;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Vineeth on 4/13/2019.
 * <p>
 * Base interface that any class that wants to act as a View in the MVP (Model-View-Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MVPView {

    void launchActivity(Bundle bundle, Class className);

    void launchActivity(Intent intent);

    void finish();

    void showProgressView();

    void hideProgressView();
}
