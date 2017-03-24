package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code occupier} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class OccupierContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return OccupierColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable OccupierSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable OccupierSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * OccupierName.
     */
    public OccupierContentValues putOccupiername(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("occupiername must not be null");
        mContentValues.put(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

}
