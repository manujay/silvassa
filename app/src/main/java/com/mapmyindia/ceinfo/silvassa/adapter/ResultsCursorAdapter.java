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
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Property Id", propertyCursor.getPropertyuniqueid()));

        ((ViewHolder) holder).mItemTextView1.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Owner", !StringUtils.isNullOrEmpty(propertyCursor.getPropertyowner()) ? propertyCursor.getPropertyowner() : ""));

        ((ViewHolder) holder).mItemTextView2.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Occupier", !StringUtils.isNullOrEmpty(propertyCursor.getPropertyoccupiername()) ? propertyCursor.getPropertyoccupiername() : ""));

        ((ViewHolder) holder).mItemTextView3.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Building", !StringUtils.isNullOrEmpty(propertyCursor.getPropertybuildingname()) ? propertyCursor.getPropertybuildingname() : ""));

        ((ViewHolder) holder).mItemTextView4.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "House Number", !StringUtils.isNullOrEmpty(propertyCursor.getPropertyhouseno()) ? propertyCursor.getPropertyhouseno() : ""));

        holder.itemView.setTag(propertyCursor.getPropertyuniqueid());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_single_item_results, parent, false);
        return new ResultsCursorAdapter.ViewHolder(itemView);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTextView0, mItemTextView1, mItemTextView2, mItemTextView3, mItemTextView4;

        private ViewHolder(View itemView) {
            super(itemView);
            mItemTextView0 = (TextView) itemView.findViewById(R.id.list_item_results0);
            mItemTextView1 = (TextView) itemView.findViewById(R.id.list_item_results1);
            mItemTextView2 = (TextView) itemView.findViewById(R.id.list_item_results2);
            mItemTextView3 = (TextView) itemView.findViewById(R.id.list_item_results3);
            mItemTextView4 = (TextView) itemView.findViewById(R.id.list_item_results4);
        }
    }
}
