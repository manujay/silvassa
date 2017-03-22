package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * Property Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface PropertyModel extends BaseModel {

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
     * propertyOwner.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyowner();

    /**
     * propertyOccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyoccupiername();

    /**
     * propertyRelationOwner.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyrelationowner();

    /**
     * zoneId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getZoneid();

    /**
     * propertySublocality.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertysublocality();

    /**
     * email.
     * Cannot be {@code null}.
     */
    @NonNull
    String getEmail();

    /**
     * phone.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPhone();

    /**
     * propertyLandmark.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertylandmark();

    /**
     * propertyPlotNo.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyplotno();

    /**
     * propertyHouseNo.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyhouseno();

    /**
     * propertyRoad.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyroad();

    /**
     * propertyPincode.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertypincode();

    /**
     * propertyBuildingName.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertybuildingname();
}
