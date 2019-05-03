package com.demo.newsfeedapp.dagger.components;

import com.demo.newsfeedapp.dagger.modules.ModuleManager;
import com.demo.newsfeedapp.ui.activities.HomeScreenActivity;

import dagger.Subcomponent;

public interface ViewSubComponents {

    //@PerActivity
    @Subcomponent(modules = ModuleManager.HomeScreenModule.class)
    interface HomeScreenComponent {
        void inject(HomeScreenActivity homeScreenActivity);
    }
}
