package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code payment} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class PaymentContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PaymentColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PaymentSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PaymentSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * UserId.
     */
    public PaymentContentValues putUserid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("userid must not be null");
        mContentValues.put(PaymentColumns.USERID, value);
        return this;
    }


    /**
     * propertyUniqueId.
     */
    public PaymentContentValues putPropertyuniqueid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyuniqueid must not be null");
        mContentValues.put(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }


    /**
     * TaxNo.
     */
    public PaymentContentValues putTaxno(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("taxno must not be null");
        mContentValues.put(PaymentColumns.TAXNO, value);
        return this;
    }


    /**
     * mode
     */
    public PaymentContentValues putMode(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("mode must not be null");
        mContentValues.put(PaymentColumns.MODE, value);
        return this;
    }


    /**
     * Amount
     */
    public PaymentContentValues putAmount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("amount must not be null");
        mContentValues.put(PaymentColumns.AMOUNT, value);
        return this;
    }


    /**
     * PaymentDate
     */
    public PaymentContentValues putPdate(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("pdate must not be null");
        mContentValues.put(PaymentColumns.PDATE, value);
        return this;
    }

}
