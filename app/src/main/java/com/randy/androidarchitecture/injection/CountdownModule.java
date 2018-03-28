package com.randy.androidarchitecture.injection;

import android.arch.persistence.room.Room;

import com.randy.androidarchitecture.MyApplication;
import com.randy.androidarchitecture.data.dao.EventDao;
import com.randy.androidarchitecture.data.db.EventDatabase;
import com.randy.androidarchitecture.repository.EventRepository;
import com.randy.androidarchitecture.repository.EventRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import timber.log.Timber;

/**
 * @author randy
 * @since 3/28/18 11:03 AM
 */
@Module(includes = {AndroidInjectionModule.class, ViewModelModule.class})
public class CountdownModule {
    @Provides
    EventRepository providesEventRepository(EventDao eventDao) {
        Timber.d("providesEventRepository:%s", eventDao);
        return new EventRepositoryImpl(eventDao);
    }

    @Provides
    @Singleton
    EventDao providesEventDao(EventDatabase eventDatabase) {
        Timber.d("providesEventDao:%s", eventDatabase);
        return eventDatabase.eventDao();
    }

    @Provides
    @Singleton
    EventDatabase providesEventDatabase(MyApplication application) {
        return Room.databaseBuilder(application, EventDatabase.class, "event_db").build();
    }
}
