package com.randy.androidarchitecture.ui.event.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.randy.androidarchitecture.R;
import com.randy.androidarchitecture.data.entity.Event;

import java.util.List;

/**
 * @author randy
 * @since 3/28/18 11:20 AM
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> mList;
    private final View.OnClickListener mViewClickListener;
    private final View.OnClickListener mDeleteClickListener;

    EventAdapter(List<Event> list, View.OnClickListener viewClickListener, View.OnClickListener deleteClickListener) {
        mList = list;
        mViewClickListener = viewClickListener;
        mDeleteClickListener = deleteClickListener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = mList.get(position);
        holder.mTextViewEventName.setText(event.getName());
        holder.mTextViewCountdown.setText(holder.itemView.getContext().getString(R.string.days_until, event.getDaysUntil()));
        holder.mTextViewDescription.setText(event.getDescription());
        holder.itemView.setTag(event);
        holder.itemView.setOnClickListener(mViewClickListener);
        holder.mImageButtonDelete.setTag(event);
        holder.mImageButtonDelete.setOnClickListener(mDeleteClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<Event> list) {
        mList = list;
        notifyDataSetChanged();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextViewEventName;
        private final TextView mTextViewDescription;
        private final TextView mTextViewCountdown;
        private final ImageButton mImageButtonDelete;

        EventViewHolder(View itemView) {
            super(itemView);
            mTextViewEventName = itemView.findViewById(R.id.text_view_event_name);
            mTextViewDescription = itemView.findViewById(R.id.text_view_description);
            mTextViewCountdown = itemView.findViewById(R.id.text_view_countdown);
            mImageButtonDelete = itemView.findViewById(R.id.image_button_delete);
        }
    }
}
