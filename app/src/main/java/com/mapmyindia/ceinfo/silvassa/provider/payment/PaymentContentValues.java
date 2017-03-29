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
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PaymentSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where   The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PaymentSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
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
     * taxNo
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
     * payableAmount
     */
    public PaymentContentValues putPayableamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("payableamount must not be null");
        mContentValues.put(PaymentColumns.PAYABLEAMOUNT, value);
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
     * Check
     */
    public PaymentContentValues putCheck(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("check must not be null");
        mContentValues.put(PaymentColumns.CHECK, value);
        return this;
    }


    /**
     * DD
     */
    public PaymentContentValues putDd(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("dd must not be null");
        mContentValues.put(PaymentColumns.DD, value);
        return this;
    }


    /**
     * POS
     */
    public PaymentContentValues putPos(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("pos must not be null");
        mContentValues.put(PaymentColumns.POS, value);
        return this;
    }


    /**
     * email
     */
    public PaymentContentValues putEmail(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("email must not be null");
        mContentValues.put(PaymentColumns.EMAIL, value);
        return this;
    }


    /**
     * phone
     */
    public PaymentContentValues putPhone(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("phone must not be null");
        mContentValues.put(PaymentColumns.PHONE, value);
        return this;
    }


    /**
     * date
     */
    public PaymentContentValues putDate(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("date must not be null");
        mContentValues.put(PaymentColumns.DATE, value);
        return this;
    }

}
