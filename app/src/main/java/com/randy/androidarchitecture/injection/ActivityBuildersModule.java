package com.randy.androidarchitecture.injection;

import com.randy.androidarchitecture.ui.event.list.EventListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author randy
 * @since 3/28/18 2:07 PM
 */
@Module
public abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract EventListActivity bindEventListActivity();
}
