package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code taxdetail} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class TaxdetailContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TaxdetailColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TaxdetailSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where   The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TaxdetailSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * taxNo.
     */
    public TaxdetailContentValues putTaxno(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("taxno must not be null");
        mContentValues.put(TaxdetailColumns.TAXNO, value);
        return this;
    }


    /**
     * taxAmount.
     */
    public TaxdetailContentValues putTaxamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("taxamount must not be null");
        mContentValues.put(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }


    /**
     * dueDate.
     */
    public TaxdetailContentValues putDuedate(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("duedate must not be null");
        mContentValues.put(TaxdetailColumns.DUEDATE, value);
        return this;
    }


    /**
     * noticeGenerated.
     */
    public TaxdetailContentValues putNoticegenerated(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("noticegenerated must not be null");
        mContentValues.put(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }


    /**
     * propId.
     */
    public TaxdetailContentValues putPropid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propid must not be null");
        mContentValues.put(TaxdetailColumns.PROPID, value);
        return this;
    }


    /**
     * financialYear.
     */
    public TaxdetailContentValues putFinancialyear(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("financialyear must not be null");
        mContentValues.put(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

}
