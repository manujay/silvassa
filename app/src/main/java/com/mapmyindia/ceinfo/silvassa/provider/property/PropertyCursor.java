package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code property} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class PropertyCursor extends AbstractCursor implements PropertyModel {
    public PropertyCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(PropertyColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyUniqueId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyuniqueid() {
        String res = getStringOrNull(PropertyColumns.PROPERTYUNIQUEID);
        if (res == null)
            throw new NullPointerException("The value of 'propertyuniqueid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyOwner.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyowner() {
        String res = getStringOrNull(PropertyColumns.PROPERTYOWNER);
        return res;
    }

    /**
     * propertyOccupierName.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyoccupiername() {
        String res = getStringOrNull(PropertyColumns.PROPERTYOCCUPIERNAME);
        return res;
    }

    /**
     * propertyRelationOwner.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyrelationowner() {
        String res = getStringOrNull(PropertyColumns.PROPERTYRELATIONOWNER);
        return res;
    }

    /**
     * zoneId.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getZoneid() {
        String res = getStringOrNull(PropertyColumns.ZONEID);
        return res;
    }

    /**
     * ward.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWard() {
        String res = getStringOrNull(PropertyColumns.WARD);
        return res;
    }

    /**
     * propertySublocality.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertysublocality() {
        String res = getStringOrNull(PropertyColumns.PROPERTYSUBLOCALITY);
        return res;
    }

    /**
     * email.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEmail() {
        String res = getStringOrNull(PropertyColumns.EMAIL);
        return res;
    }

    /**
     * phone.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPhone() {
        String res = getStringOrNull(PropertyColumns.PHONE);
        return res;
    }

    /**
     * propertyLandmark.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertylandmark() {
        String res = getStringOrNull(PropertyColumns.PROPERTYLANDMARK);
        return res;
    }

    /**
     * propertyPlotNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyplotno() {
        String res = getStringOrNull(PropertyColumns.PROPERTYPLOTNO);
        return res;
    }

    /**
     * propertyHouseNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyhouseno() {
        String res = getStringOrNull(PropertyColumns.PROPERTYHOUSENO);
        return res;
    }

    /**
     * propertyRoad.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyroad() {
        String res = getStringOrNull(PropertyColumns.PROPERTYROAD);
        return res;
    }

    /**
     * propertyPincode.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertypincode() {
        String res = getStringOrNull(PropertyColumns.PROPERTYPINCODE);
        return res;
    }

    /**
     * propertyBuildingName.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertybuildingname() {
        String res = getStringOrNull(PropertyColumns.PROPERTYBUILDINGNAME);
        return res;
    }
}
