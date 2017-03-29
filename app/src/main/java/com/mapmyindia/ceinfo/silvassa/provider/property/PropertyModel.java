package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyowner();

    /**
     * propertyOccupierName.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyoccupiername();

    /**
     * propertyRelationOwner.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyrelationowner();

    /**
     * zoneId.
     * Can be {@code null}.
     */
    @Nullable
    String getZoneid();

    /**
     * ward.
     * Can be {@code null}.
     */
    @Nullable
    String getWard();

    /**
     * propertySublocality.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertysublocality();

    /**
     * email.
     * Can be {@code null}.
     */
    @Nullable
    String getEmail();

    /**
     * phone.
     * Can be {@code null}.
     */
    @Nullable
    String getPhone();

    /**
     * propertyLandmark.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertylandmark();

    /**
     * propertyPlotNo.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyplotno();

    /**
     * propertyHouseNo.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyhouseno();

    /**
     * propertyRoad.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertyroad();

    /**
     * propertyPincode.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertypincode();

    /**
     * propertyBuildingName.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertybuildingname();
}
