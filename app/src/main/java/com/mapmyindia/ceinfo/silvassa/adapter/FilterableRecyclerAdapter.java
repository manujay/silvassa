package com.mapmyindia.ceinfo.silvassa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;

import java.util.ArrayList;

/**
 * Created by ceinfo on 08-03-2017.
 */

public class FilterableRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private ArrayList<String> mArrayList;
    private ArrayList<String> mFilteredArrayList;
    private Context mActivityContext;
    private CustomFilter mFilter;

    public FilterableRecyclerAdapter(Context mActivityContext, ArrayList<String> mArrayList) {
        this.mActivityContext = mActivityContext;
        this.mArrayList = mArrayList;
        this.mFilteredArrayList = mArrayList;
        this.mFilter = new CustomFilter(FilterableRecyclerAdapter.this);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mActivityContext).inflate(R.layout.layout_recycler_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).itemTextView.setText(mFilteredArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return null != mFilteredArrayList && mFilteredArrayList.size() > 0 ? mFilteredArrayList.size() : 0;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public class CustomFilter extends Filter {

        FilterableRecyclerAdapter mAdapter;

        public CustomFilter(FilterableRecyclerAdapter adapter) {
            super();
            this.mAdapter = adapter;
        }

        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            ArrayList<String> temp = new ArrayList<>();
            final Filter.FilterResults results = new Filter.FilterResults();
            if (constraint.length() == 0) {
                temp.addAll(mArrayList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (String item : mArrayList) {
                    if (item.toLowerCase().trim().contains(filterPattern)) {
                        temp.add(item);
                    }
                }
            }

            results.values = temp;
            results.count = temp.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {

            if (results.count > 0) {
                mFilteredArrayList.clear();
                mFilteredArrayList.addAll((ArrayList<String>) results.values);
            }

            this.mAdapter.notifyDataSetChanged();
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTextView;

        private ItemViewHolder(View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
