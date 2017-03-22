package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code zone} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class ZoneContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ZoneColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable ZoneSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where   The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable ZoneSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * zoneId.
     */
    public ZoneContentValues putZoneid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("zoneid must not be null");
        mContentValues.put(ZoneColumns.ZONEID, value);
        return this;
    }


    /**
     * zoneName
     */
    public ZoneContentValues putZonename(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("zonename must not be null");
        mContentValues.put(ZoneColumns.ZONENAME, value);
        return this;
    }

}
