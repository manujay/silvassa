package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code taxdetail} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class TaxdetailCursor extends AbstractCursor implements TaxdetailModel {
    public TaxdetailCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(TaxdetailColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * taxNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        String res = getStringOrNull(TaxdetailColumns.TAXNO);
        if (res == null)
            throw new NullPointerException("The value of 'taxno' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * taxAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxamount() {
        String res = getStringOrNull(TaxdetailColumns.TAXAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'taxamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * dueDate.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDuedate() {
        String res = getStringOrNull(TaxdetailColumns.DUEDATE);
        if (res == null)
            throw new NullPointerException("The value of 'duedate' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * noticeGenerated.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getNoticegenerated() {
        String res = getStringOrNull(TaxdetailColumns.NOTICEGENERATED);
        if (res == null)
            throw new NullPointerException("The value of 'noticegenerated' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropid() {
        String res = getStringOrNull(TaxdetailColumns.PROPID);
        if (res == null)
            throw new NullPointerException("The value of 'propid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * financialYear.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getFinancialyear() {
        String res = getStringOrNull(TaxdetailColumns.FINANCIALYEAR);
        if (res == null)
            throw new NullPointerException("The value of 'financialyear' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
