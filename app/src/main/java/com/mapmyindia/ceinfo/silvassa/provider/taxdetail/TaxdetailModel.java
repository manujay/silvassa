package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * TaxDetail Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface TaxdetailModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * taxNo.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTaxno();

    /**
     * taxAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTaxamount();

    /**
     * dueDate.
     * Cannot be {@code null}.
     */
    @NonNull
    String getDuedate();

    /**
     * noticeGenerated.
     * Cannot be {@code null}.
     */
    @NonNull
    String getNoticegenerated();

    /**
     * propId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropid();

    /**
     * financialYear.
     * Cannot be {@code null}.
     */
    @NonNull
    String getFinancialyear();
}
