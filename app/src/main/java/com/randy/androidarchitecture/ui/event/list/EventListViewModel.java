package com.randy.androidarchitecture.ui.event.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.randy.androidarchitecture.data.entity.Event;
import com.randy.androidarchitecture.repository.EventRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author randy
 * @since 3/28/18 1:43 PM
 */
public class EventListViewModel extends ViewModel {
    @Inject
    EventRepository mEventRepository;

    @Inject
    public EventListViewModel() {
    }

    LiveData<List<Event>> getEvents() {
        return mEventRepository.getEvents();
    }

    void deleteEvent(Event event) {
        mEventRepository.deleteEvent(event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Timber.d("onComplete - delete event");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError - delete event");
                    }
                });
    }
}
