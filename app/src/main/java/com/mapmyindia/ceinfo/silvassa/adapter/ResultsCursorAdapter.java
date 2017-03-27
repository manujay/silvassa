package com.mapmyindia.ceinfo.silvassa.adapter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;

import java.util.Locale;

/**
 * Created by ceinfo on 22-03-2017.
 */

public class ResultsCursorAdapter extends CursorRecyclerAdapter<RecyclerView.ViewHolder> {

    private Bundle extras;

    public ResultsCursorAdapter(Cursor cursor) {
        super(cursor);
    }

    public ResultsCursorAdapter setExtras(Bundle extras) {
        this.extras = extras;
        return this;
    }

    @Override
    public void onBindViewHolderCursor(RecyclerView.ViewHolder holder, Cursor cursor) {
        PropertyCursor propertyCursor = new PropertyCursor(cursor);
        ((ViewHolder) holder).mItemTextView.setText(String.format(Locale.getDefault(), "Property ID: %s", propertyCursor.getPropertyuniqueid()));
        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_item_results, parent, false);
        return new ResultsCursorAdapter.ViewHolder(itemView);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            mItemTextView = (TextView) itemView.findViewById(R.id.list_item_results);
        }
    }
}
