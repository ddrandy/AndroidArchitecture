package com.randy.androidarchitecture.ui.event.list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.randy.androidarchitecture.R;
import com.randy.androidarchitecture.data.entity.Event;
import com.randy.androidarchitecture.injection.CountdownViewModuleFactory;
import com.randy.androidarchitecture.injection.Injectable;

import java.util.ArrayList;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author randy
 * @since 3/27/18 4:05 PM
 */
public class EventListFragment extends Fragment implements Injectable {

    private EventAdapter mAdapter;
    @Inject
    CountdownViewModuleFactory mCountdownViewModuleFactory;
    private EventListViewModel mEventListViewModel;
    private View.OnClickListener mItemClickListener = view -> {
        Event event = (Event) view.getTag();

        Toast.makeText(getContext(), "Clicked: " + event.getName(), Toast.LENGTH_SHORT).show();
    };
    private View.OnClickListener mDeleteClickListener = view -> {
        Event event = (Event) view.getTag();

        mEventListViewModel.deleteEvent(event);
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_event, container, false);
        setupRecyclerView(view);

        mEventListViewModel = ViewModelProviders.of(this, mCountdownViewModuleFactory).get(EventListViewModel.class);
        mEventListViewModel.getEvents().observe(this, events -> {
            Timber.d("Events changed:" + events);
            mAdapter.setList(events);
        });
        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list_events);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new EventAdapter(new ArrayList<>(), mItemClickListener, mDeleteClickListener);
        recyclerView.setAdapter(mAdapter);
        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(itemDecoration);
    }
}
