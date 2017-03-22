package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code owner} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class OwnerCursor extends AbstractCursor implements OwnerModel {
    public OwnerCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(OwnerColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * OwnerName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOwnername() {
        String res = getStringOrNull(OwnerColumns.OWNERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'ownername' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
