package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code criteria} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class CriteriaContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CriteriaColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CriteriaSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where   The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable CriteriaSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * occupierName.
     */
    public CriteriaContentValues putOccupiername(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("occupiername must not be null");
        mContentValues.put(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }


    /**
     * propId
     */
    public CriteriaContentValues putPropid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propid must not be null");
        mContentValues.put(CriteriaColumns.PROPID, value);
        return this;
    }


    /**
     * ownerName
     */
    public CriteriaContentValues putOwnername(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("ownername must not be null");
        mContentValues.put(CriteriaColumns.OWNERNAME, value);
        return this;
    }

}
