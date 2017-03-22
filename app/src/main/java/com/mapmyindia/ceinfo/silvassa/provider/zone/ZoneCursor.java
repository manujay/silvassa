package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code zone} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class ZoneCursor extends AbstractCursor implements ZoneModel {
    public ZoneCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(ZoneColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * zoneId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getZoneid() {
        String res = getStringOrNull(ZoneColumns.ZONEID);
        if (res == null)
            throw new NullPointerException("The value of 'zoneid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * zoneName
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getZonename() {
        String res = getStringOrNull(ZoneColumns.ZONENAME);
        if (res == null)
            throw new NullPointerException("The value of 'zonename' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
