package com.randy.androidarchitecture.injection;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.randy.androidarchitecture.injection.annotation.ViewModelKey;
import com.randy.androidarchitecture.ui.event.list.EventListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author randy
 * @since 3/28/18 2:32 PM
 */
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(EventListViewModel.class)
    abstract ViewModel bindEventListViewModel(EventListViewModel eventListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(CountdownViewModuleFactory factory);
}
