package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Occupier Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface OccupierModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * OccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    String getOccupiername();
}
