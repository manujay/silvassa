package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code payment} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class PaymentCursor extends AbstractCursor implements PaymentModel {
    public PaymentCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(PaymentColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * UserId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getUserid() {
        String res = getStringOrNull(PaymentColumns.USERID);
        if (res == null)
            throw new NullPointerException("The value of 'userid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyUniqueId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyuniqueid() {
        String res = getStringOrNull(PaymentColumns.PROPERTYUNIQUEID);
        if (res == null)
            throw new NullPointerException("The value of 'propertyuniqueid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * TaxNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        String res = getStringOrNull(PaymentColumns.TAXNO);
        if (res == null)
            throw new NullPointerException("The value of 'taxno' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * mode
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getMode() {
        String res = getStringOrNull(PaymentColumns.MODE);
        if (res == null)
            throw new NullPointerException("The value of 'mode' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Amount
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAmount() {
        String res = getStringOrNull(PaymentColumns.AMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'amount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * PaymentDate
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPdate() {
        String res = getStringOrNull(PaymentColumns.PDATE);
        if (res == null)
            throw new NullPointerException("The value of 'pdate' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
