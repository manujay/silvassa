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
     * UserId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getUserid();

    /**
     * propertyUniqueId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyuniqueid();

    /**
     * TaxNo.
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
     * Amount
     * Cannot be {@code null}.
     */
    @NonNull
    String getAmount();

    /**
     * PaymentDate
     * Cannot be {@code null}.
     */
    @NonNull
    String getPdate();
}
