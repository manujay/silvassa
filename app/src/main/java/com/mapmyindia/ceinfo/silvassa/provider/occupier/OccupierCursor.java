package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code occupier} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class OccupierCursor extends AbstractCursor implements OccupierModel {
    public OccupierCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(OccupierColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * OccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOccupiername() {
        String res = getStringOrNull(OccupierColumns.OCCUPIERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'occupiername' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
