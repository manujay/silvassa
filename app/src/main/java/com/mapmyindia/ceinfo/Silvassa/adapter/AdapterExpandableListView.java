package com.mapmyindia.ceinfo.silvassa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.databinding.ListGroupBinding;
import com.mapmyindia.ceinfo.silvassa.databinding.ListItemBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of ExpandableListview using Databinding
 *
 * @author Manujay K. Yadav
 */

public class AdapterExpandableListView extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public AdapterExpandableListView(Context context, List<String> listDataHeader,
                                     HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        String itemTitle = (String) getChild(groupPosition, childPosition);
        if (null == convertView) {
            holder = new MyViewHolder(LayoutInflater.from(parent.getContext()), parent);
            convertView = holder.item.getRoot();
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }

        holder.bindItem(itemTitle);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, final boolean isExpanded,
                             View convertView, ViewGroup parent) {
        MyViewHolder holder;
        String headerTitle = (String) getGroup(groupPosition);
        if (null == convertView) {
            holder = new MyViewHolder(LayoutInflater.from(parent.getContext()), parent);
            convertView = holder.group.getRoot();
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }

        holder.bindGroup(headerTitle);

        if (isExpanded) {
            holder.group.addbutton.setImageDrawable(AdapterExpandableListView.this._context.getResources().getDrawable(R.drawable.ic_remove_circle_outline_black_24dp));
        } else {
            holder.group.addbutton.setImageDrawable(AdapterExpandableListView.this._context.getResources().getDrawable(R.drawable.ic_add_circle_outline_black_24dp));
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class MyViewHolder {
        private ListGroupBinding group;
        private ListItemBinding item;

        private MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            this.group = ListGroupBinding.inflate(inflater, parent, false);
            this.item = ListItemBinding.inflate(inflater, parent, false);
        }

        private void bindItem(String itemTitle) {
            item.setItemHeader(itemTitle);
            item.executePendingBindings();
        }

        private void bindGroup(String headerTitle) {
            group.setGroupHeader(String.format(Locale.getDefault(), "Property ID   :%s", headerTitle));
            group.executePendingBindings();
        }
    }
}
