package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Owner Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface OwnerModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * OwnerName.
     * Cannot be {@code null}.
     */
    @NonNull
    String getOwnername();
}
