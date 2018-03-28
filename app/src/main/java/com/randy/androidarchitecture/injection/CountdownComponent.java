package com.randy.androidarchitecture.injection;

import com.randy.androidarchitecture.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author randy
 * @since 3/28/18 2:06 PM
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        CountdownModule.class,
        ActivityBuildersModule.class
})
public interface CountdownComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);

        CountdownComponent build();
    }
}
