package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code criteria} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class CriteriaCursor extends AbstractCursor implements CriteriaModel {
    public CriteriaCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(CriteriaColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * occupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOccupiername() {
        String res = getStringOrNull(CriteriaColumns.OCCUPIERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'occupiername' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propId
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropid() {
        String res = getStringOrNull(CriteriaColumns.PROPID);
        if (res == null)
            throw new NullPointerException("The value of 'propid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * ownerName
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOwnername() {
        String res = getStringOrNull(CriteriaColumns.OWNERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'ownername' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
