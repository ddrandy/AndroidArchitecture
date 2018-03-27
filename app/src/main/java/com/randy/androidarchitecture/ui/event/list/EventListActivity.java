package com.randy.androidarchitecture.ui.event.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.randy.androidarchitecture.R;
import com.randy.androidarchitecture.injection.Injectable;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author randy
 * @since 3/27/18 4:00 PM
 */
public class EventListActivity extends AppCompatActivity implements HasSupportFragmentInjector,
        Injectable {
    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
