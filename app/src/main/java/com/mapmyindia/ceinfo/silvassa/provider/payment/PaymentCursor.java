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
     * taxNo
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
     * payableAmount
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPayableamount() {
        String res = getStringOrNull(PaymentColumns.PAYABLEAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'payableamount' in the database was null, which is not allowed according to the model definition");
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
     * Check
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getCheck() {
        String res = getStringOrNull(PaymentColumns.CHECK);
        if (res == null)
            throw new NullPointerException("The value of 'check' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * DD
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDd() {
        String res = getStringOrNull(PaymentColumns.DD);
        if (res == null)
            throw new NullPointerException("The value of 'dd' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * POS
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPos() {
        String res = getStringOrNull(PaymentColumns.POS);
        if (res == null)
            throw new NullPointerException("The value of 'pos' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * email
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getEmail() {
        String res = getStringOrNull(PaymentColumns.EMAIL);
        if (res == null)
            throw new NullPointerException("The value of 'email' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * phone
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPhone() {
        String res = getStringOrNull(PaymentColumns.PHONE);
        if (res == null)
            throw new NullPointerException("The value of 'phone' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * date
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDate() {
        String res = getStringOrNull(PaymentColumns.DATE);
        if (res == null)
            throw new NullPointerException("The value of 'date' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
