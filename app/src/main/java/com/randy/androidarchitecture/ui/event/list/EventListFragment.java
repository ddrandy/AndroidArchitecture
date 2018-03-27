package com.randy.androidarchitecture.ui.event.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.randy.androidarchitecture.R;
import com.randy.androidarchitecture.injection.Injectable;

/**
 * @author randy
 * @since 3/27/18 4:05 PM
 */
public class EventListFragment extends Fragment implements Injectable {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_event, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list_events);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
