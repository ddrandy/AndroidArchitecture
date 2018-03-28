package com.randy.androidarchitecture.injection;

import com.randy.androidarchitecture.ui.event.list.EventListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author randy
 * @since 3/28/18 2:09 PM
 */
@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract EventListFragment contributesEventListFragment();
}
