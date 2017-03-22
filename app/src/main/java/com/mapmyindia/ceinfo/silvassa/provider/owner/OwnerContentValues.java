package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code owner} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class OwnerContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return OwnerColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable OwnerSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where   The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable OwnerSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * OwnerName.
     */
    public OwnerContentValues putOwnername(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("ownername must not be null");
        mContentValues.put(OwnerColumns.OWNERNAME, value);
        return this;
    }

}
