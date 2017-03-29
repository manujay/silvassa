package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Payment Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface PaymentModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * propertyUniqueId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyuniqueid();

    /**
     * taxNo
     * Cannot be {@code null}.
     */
    @NonNull
    String getTaxno();

    /**
     * mode
     * Cannot be {@code null}.
     */
    @NonNull
    String getMode();

    /**
     * payableAmount
     * Cannot be {@code null}.
     */
    @NonNull
    String getPayableamount();

    /**
     * Amount
     * Cannot be {@code null}.
     */
    @NonNull
    String getAmount();

    /**
     * Check
     * Cannot be {@code null}.
     */
    @NonNull
    String getCheck();

    /**
     * DD
     * Cannot be {@code null}.
     */
    @NonNull
    String getDd();

    /**
     * POS
     * Cannot be {@code null}.
     */
    @NonNull
    String getPos();

    /**
     * email
     * Cannot be {@code null}.
     */
    @NonNull
    String getEmail();

    /**
     * phone
     * Cannot be {@code null}.
     */
    @NonNull
    String getPhone();

    /**
     * date
     * Cannot be {@code null}.
     */
    @NonNull
    String getDate();
}
