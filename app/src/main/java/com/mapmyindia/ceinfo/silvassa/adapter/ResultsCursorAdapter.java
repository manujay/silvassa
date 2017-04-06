package com.mapmyindia.ceinfo.silvassa.adapter;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

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
        ((ViewHolder) holder).mItemTextView0.setText(
                String.format(Locale.getDefault(),
                        "Property ID : %-22s ",
                        propertyCursor.getPropertyuniqueid()));
        ((ViewHolder) holder).mItemTextView0.setTypeface(Typeface.MONOSPACE);
        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
        ((ViewHolder) holder).mItemTextView1.setText(
                String.format(Locale.getDefault(), "Owner : %-22s ",
                        propertyCursor.getPropertyowner()));
        ((ViewHolder) holder).mItemTextView1.setTypeface(Typeface.MONOSPACE);
        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
        ((ViewHolder) holder).mItemTextView2.setText(
                String.format(Locale.getDefault(), "Occupier : %-22s ",
                        propertyCursor.getPropertyoccupiername()));
        ((ViewHolder) holder).mItemTextView2.setTypeface(Typeface.MONOSPACE);
        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
        ((ViewHolder) holder).mItemTextView3.setText(
                String.format(Locale.getDefault(), "HouseNo/Building : %-22s ",
                        !StringUtils.isNullOrEmpty(propertyCursor.getPropertyhouseno()) ? propertyCursor.getPropertyhouseno() : propertyCursor.getPropertybuildingname()));
        ((ViewHolder) holder).mItemTextView3.setTypeface(Typeface.MONOSPACE);
        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_item_results, parent, false);
        return new ResultsCursorAdapter.ViewHolder(itemView);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTextView0, mItemTextView1, mItemTextView2, mItemTextView3;

        private ViewHolder(View itemView) {
            super(itemView);
            mItemTextView0 = (TextView) itemView.findViewById(R.id.list_item_results0);
            mItemTextView1 = (TextView) itemView.findViewById(R.id.list_item_results1);
            mItemTextView2 = (TextView) itemView.findViewById(R.id.list_item_results2);
            mItemTextView3 = (TextView) itemView.findViewById(R.id.list_item_results3);
        }
    }
}
