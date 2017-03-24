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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyowner() {
        String res = getStringOrNull(PropertyColumns.PROPERTYOWNER);
        if (res == null)
            throw new NullPointerException("The value of 'propertyowner' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyOccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyoccupiername() {
        String res = getStringOrNull(PropertyColumns.PROPERTYOCCUPIERNAME);
        if (res == null)
            throw new NullPointerException("The value of 'propertyoccupiername' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyRelationOwner.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyrelationowner() {
        String res = getStringOrNull(PropertyColumns.PROPERTYRELATIONOWNER);
        if (res == null)
            throw new NullPointerException("The value of 'propertyrelationowner' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * zoneId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getZoneid() {
        String res = getStringOrNull(PropertyColumns.ZONEID);
        if (res == null)
            throw new NullPointerException("The value of 'zoneid' in the database was null, which is not allowed according to the model definition");
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertysublocality() {
        String res = getStringOrNull(PropertyColumns.PROPERTYSUBLOCALITY);
        if (res == null)
            throw new NullPointerException("The value of 'propertysublocality' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * email.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getEmail() {
        String res = getStringOrNull(PropertyColumns.EMAIL);
        if (res == null)
            throw new NullPointerException("The value of 'email' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * phone.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPhone() {
        String res = getStringOrNull(PropertyColumns.PHONE);
        if (res == null)
            throw new NullPointerException("The value of 'phone' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyLandmark.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertylandmark() {
        String res = getStringOrNull(PropertyColumns.PROPERTYLANDMARK);
        if (res == null)
            throw new NullPointerException("The value of 'propertylandmark' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyPlotNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyplotno() {
        String res = getStringOrNull(PropertyColumns.PROPERTYPLOTNO);
        if (res == null)
            throw new NullPointerException("The value of 'propertyplotno' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyHouseNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyhouseno() {
        String res = getStringOrNull(PropertyColumns.PROPERTYHOUSENO);
        if (res == null)
            throw new NullPointerException("The value of 'propertyhouseno' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyRoad.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyroad() {
        String res = getStringOrNull(PropertyColumns.PROPERTYROAD);
        if (res == null)
            throw new NullPointerException("The value of 'propertyroad' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyPincode.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertypincode() {
        String res = getStringOrNull(PropertyColumns.PROPERTYPINCODE);
        if (res == null)
            throw new NullPointerException("The value of 'propertypincode' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyBuildingName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertybuildingname() {
        String res = getStringOrNull(PropertyColumns.PROPERTYBUILDINGNAME);
        if (res == null)
            throw new NullPointerException("The value of 'propertybuildingname' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
