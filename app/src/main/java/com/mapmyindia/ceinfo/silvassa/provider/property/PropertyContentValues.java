package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code property} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class PropertyContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PropertyColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PropertySelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PropertySelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * propertyUniqueId.
     */
    public PropertyContentValues putPropertyuniqueid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyuniqueid must not be null");
        mContentValues.put(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }


    /**
     * propertyOwner.
     */
    public PropertyContentValues putPropertyowner(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyowner must not be null");
        mContentValues.put(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }


    /**
     * propertyOccupierName.
     */
    public PropertyContentValues putPropertyoccupiername(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("propertyoccupiername must not be null");
        mContentValues.put(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }


    /**
     * propertyRelationOwner.
     */
    public PropertyContentValues putPropertyrelationowner(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("propertyrelationowner must not be null");
        mContentValues.put(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }


    /**
     * zoneId.
     */
    public PropertyContentValues putZoneid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("zoneid must not be null");
        mContentValues.put(PropertyColumns.ZONEID, value);
        return this;
    }


    /**
     * ward.
     */
    public PropertyContentValues putWard(@Nullable String value) {
        mContentValues.put(PropertyColumns.WARD, value);
        return this;
    }

    public PropertyContentValues putWardNull() {
        mContentValues.putNull(PropertyColumns.WARD);
        return this;
    }

    /**
     * propertySublocality.
     */
    public PropertyContentValues putPropertysublocality(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("propertysublocality must not be null");
        mContentValues.put(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }


    /**
     * email.
     */
    public PropertyContentValues putEmail(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("email must not be null");
        mContentValues.put(PropertyColumns.EMAIL, value);
        return this;
    }


    /**
     * phone.
     */
    public PropertyContentValues putPhone(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("phone must not be null");
        mContentValues.put(PropertyColumns.PHONE, value);
        return this;
    }


    /**
     * propertyLandmark.
     */
    public PropertyContentValues putPropertylandmark(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertylandmark must not be null");
        mContentValues.put(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }


    /**
     * propertyPlotNo.
     */
    public PropertyContentValues putPropertyplotno(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyplotno must not be null");
        mContentValues.put(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }


    /**
     * propertyHouseNo.
     */
    public PropertyContentValues putPropertyhouseno(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyhouseno must not be null");
        mContentValues.put(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }


    /**
     * propertyRoad.
     */
    public PropertyContentValues putPropertyroad(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyroad must not be null");
        mContentValues.put(PropertyColumns.PROPERTYROAD, value);
        return this;
    }


    /**
     * propertyPincode.
     */
    public PropertyContentValues putPropertypincode(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertypincode must not be null");
        mContentValues.put(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }


    /**
     * propertyBuildingName.
     */
    public PropertyContentValues putPropertybuildingname(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("propertybuildingname must not be null");
        mContentValues.put(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

}
