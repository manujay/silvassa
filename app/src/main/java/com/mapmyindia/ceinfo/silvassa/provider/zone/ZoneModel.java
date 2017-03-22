package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Zone Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface ZoneModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * zoneId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getZoneid();

    /**
     * zoneName
     * Cannot be {@code null}.
     */
    @NonNull
    String getZonename();
}
