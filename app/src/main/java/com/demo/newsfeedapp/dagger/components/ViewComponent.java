package com.demo.newsfeedapp.dagger.components;


import com.demo.newsfeedapp.dagger.customscopes.PerActivity;
import com.demo.newsfeedapp.dagger.modules.ActivityModule;
import com.demo.newsfeedapp.dagger.modules.ModuleManager;
import com.demo.newsfeedapp.ui.activities.BaseActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ViewComponent {

    void inject(BaseActivity baseActivity);

    ViewSubComponents.HomeScreenComponent plus(ModuleManager.HomeScreenModule homeScreenModule);
}
