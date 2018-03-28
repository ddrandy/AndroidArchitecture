package com.randy.androidarchitecture.repository;

import android.arch.lifecycle.LiveData;

import com.randy.androidarchitecture.data.dao.EventDao;
import com.randy.androidarchitecture.data.entity.Event;

import org.threeten.bp.LocalDateTime;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;

/**
 * @author randy
 * @since 3/28/18 2:42 PM
 */
public class EventRepositoryImpl implements EventRepository {
    @Inject
    EventDao mEventDao;

    public EventRepositoryImpl(EventDao eventDao) {
        mEventDao = eventDao;
    }

    @Override
    public Completable addEvent(Event event) {
        if (event == null) {
            return Completable.error(new IllegalArgumentException("Event cannot be null."));
        }
        return Completable.fromAction(() -> mEventDao.addEvent(event));
    }

    @Override
    public LiveData<List<Event>> getEvents() {
        // Here is where we would do more complex logic, like getting event from a cache
        // then insert into the database etc. In this example we just go straight to the dao.
        return mEventDao.getEvents(LocalDateTime.now());
    }

    @Override
    public Completable deleteEvent(Event event) {
        if (event == null) {
            return Completable.error(new IllegalArgumentException("Event cannot be null."));
        }
        return Completable.fromAction(() -> mEventDao.deleteEvent(event));
    }
}
