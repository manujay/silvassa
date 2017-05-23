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
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ceinfo on 08-03-2017.
 */

public class FilterableRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    private ArrayList<Model> mArrayList;
    private ArrayList<Model> mFilteredArrayList;
    private Context mActivityContext;
    private CustomFilter mFilter;

    public FilterableRecyclerAdapter(Context mActivityContext, ArrayList<Model> mArrayList) {
        this.mActivityContext = mActivityContext;
        this.mArrayList = mArrayList;
        this.mFilteredArrayList = mArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mActivityContext).inflate(R.layout.layout_single_item_results, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((ItemViewHolder) holder).mItemTextView0.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Property Id", mFilteredArrayList.get(position).getPropUniqueId()));

        ((ItemViewHolder) holder).mItemTextView1.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Owner", !StringUtils.isNullOrEmpty(mFilteredArrayList.get(position).getOwner()) ? mFilteredArrayList.get(position).getOwner() : ""));

        ((ItemViewHolder) holder).mItemTextView2.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Occupier", !StringUtils.isNullOrEmpty(mFilteredArrayList.get(position).getOccupier()) ? mFilteredArrayList.get(position).getOccupier() : ""));

        ((ItemViewHolder) holder).mItemTextView3.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "Building", !StringUtils.isNullOrEmpty(mFilteredArrayList.get(position).getBuilding()) ? mFilteredArrayList.get(position).getBuilding() : ""));

        ((ItemViewHolder) holder).mItemTextView4.setText(
                String.format(Locale.getDefault(), "%-16s : %s",
                        "House Number", !StringUtils.isNullOrEmpty(mFilteredArrayList.get(position).getHouseNo()) ? mFilteredArrayList.get(position).getHouseNo() : ""));

        ((ItemViewHolder) holder).itemView.setTag(mFilteredArrayList.get(position).getPropUniqueId());
    }

    @Override
    public int getItemCount() {
        return null != mFilteredArrayList && mFilteredArrayList.size() > 0 ? mFilteredArrayList.size() : 0;
    }

    @Override
    public Filter getFilter() {
        if (null == mFilter)
            mFilter = new CustomFilter();
        return mFilter;
    }

    class CustomFilter extends Filter {

        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Model> temp = new ArrayList<>();
            Filter.FilterResults results = new Filter.FilterResults();
            if (constraint.length() == 0) {
                results.count = mArrayList.size();
                results.values = mArrayList;
                return results;
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (Model item : mArrayList) {
                    if (!StringUtils.isNullOrEmpty(item.getPropUniqueId()) && item.getPropUniqueId().toLowerCase().trim().contains(filterPattern)) {
                        temp.add(item);
                    } else if (!StringUtils.isNullOrEmpty(item.getOccupier()) && item.getOccupier().toLowerCase().trim().contains(filterPattern)) {
                        temp.add(item);
                    } else if (!StringUtils.isNullOrEmpty(item.getOwner()) && item.getOwner().toLowerCase().trim().contains(filterPattern)) {
                        temp.add(item);
                    } else if (!StringUtils.isNullOrEmpty(item.getBuilding()) && item.getBuilding().toLowerCase().trim().contains(filterPattern)) {
                        temp.add(item);
                    } else if (!StringUtils.isNullOrEmpty(item.getHouseNo()) && item.getHouseNo().toLowerCase().trim().contains(filterPattern)) {
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
                mFilteredArrayList = new ArrayList<Model>(((ArrayList<Model>) results.values));
            }

            notifyDataSetChanged();
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView mItemTextView0, mItemTextView1, mItemTextView2, mItemTextView3, mItemTextView4;

        private ItemViewHolder(View itemView) {
            super(itemView);
            mItemTextView0 = (TextView) itemView.findViewById(R.id.list_item_results0);
            mItemTextView1 = (TextView) itemView.findViewById(R.id.list_item_results1);
            mItemTextView2 = (TextView) itemView.findViewById(R.id.list_item_results2);
            mItemTextView3 = (TextView) itemView.findViewById(R.id.list_item_results3);
            mItemTextView4 = (TextView) itemView.findViewById(R.id.list_item_results4);
        }
    }
}
