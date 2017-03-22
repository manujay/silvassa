package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Criteria Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface CriteriaModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * occupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    String getOccupiername();

    /**
     * propId
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropid();

    /**
     * ownerName
     * Cannot be {@code null}.
     */
    @NonNull
    String getOwnername();
}
