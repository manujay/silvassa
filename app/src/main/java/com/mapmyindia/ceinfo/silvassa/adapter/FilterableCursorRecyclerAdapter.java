package com.mapmyindia.ceinfo.silvassa.adapter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.utils.INTENT_PARAMETERS;

/**
 * Created by ceinfo on 21-03-2017.
 */

public class FilterableCursorRecyclerAdapter extends CursorRecyclerAdapter<RecyclerView.ViewHolder> {

    private Bundle mExtras;

    public FilterableCursorRecyclerAdapter(Context context, Cursor cursor) {
        super(cursor);
    }

    public FilterableCursorRecyclerAdapter setBundleExtras(Bundle extras) {
        this.mExtras = extras;
        return this;
    }

    @Override
    public void onBindViewHolderCursor(RecyclerView.ViewHolder holder, Cursor cursor) {
        if (null != mExtras && mExtras.containsKey(INTENT_PARAMETERS._PREFILL_KEY)) {

            String preString = mExtras.getString(INTENT_PARAMETERS._PREFILL_KEY);

            PropertyCursor propertyCursor = new PropertyCursor(cursor);

            if (null != preString && preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OWNER)) {

                String ownerName = (propertyCursor.getPropertyowner() == null ? "" : propertyCursor.getPropertyowner());

                ((ViewHolder) holder).mItemTextView.setText(ownerName);

            } else if (null != preString && preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_OCCUPIER)) {

                String occupierName = (propertyCursor.getPropertyoccupiername() == null ? "" : propertyCursor.getPropertyoccupiername());

                ((ViewHolder) holder).mItemTextView.setText(occupierName);

            } else if (null != preString && preString.equalsIgnoreCase(INTENT_PARAMETERS._PREFILL_PROPERTYID)) {

                String propertyId = (propertyCursor.getPropertyuniqueid() == null ? "" : propertyCursor.getPropertyuniqueid());

                ((ViewHolder) holder).mItemTextView.setText(propertyId);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_single_item, parent, false);
        return new ViewHolder(itemView);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            mItemTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
