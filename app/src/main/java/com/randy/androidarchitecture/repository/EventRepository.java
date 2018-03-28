package com.randy.androidarchitecture.repository;

import android.arch.lifecycle.LiveData;

import com.randy.androidarchitecture.data.entity.Event;

import java.util.List;

import io.reactivex.Completable;

/**
 * @author randy
 * @since 3/28/18 1:44 PM
 */
public interface EventRepository {
    Completable addEvent(Event event);

    LiveData<List<Event>> getEvents();

    Completable deleteEvent(Event event);
}
