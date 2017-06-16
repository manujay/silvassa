package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
     * PropertyUniqueId.
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
     * Mode
     * Cannot be {@code null}.
     */
    @NonNull
    String getMode();

    /**
     * Cheque
     * Can be {@code null}.
     */
    @Nullable
    String getCheque();

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
