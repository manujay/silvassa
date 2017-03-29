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
    public PropertyContentValues putPropertyowner(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertyContentValues putPropertyownerNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYOWNER);
        return this;
    }

    /**
     * propertyOccupierName.
     */
    public PropertyContentValues putPropertyoccupiername(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertyContentValues putPropertyoccupiernameNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYOCCUPIERNAME);
        return this;
    }

    /**
     * propertyRelationOwner.
     */
    public PropertyContentValues putPropertyrelationowner(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertyContentValues putPropertyrelationownerNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYRELATIONOWNER);
        return this;
    }

    /**
     * zoneId.
     */
    public PropertyContentValues putZoneid(@Nullable String value) {
        mContentValues.put(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertyContentValues putZoneidNull() {
        mContentValues.putNull(PropertyColumns.ZONEID);
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
    public PropertyContentValues putPropertysublocality(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertyContentValues putPropertysublocalityNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYSUBLOCALITY);
        return this;
    }

    /**
     * email.
     */
    public PropertyContentValues putEmail(@Nullable String value) {
        mContentValues.put(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertyContentValues putEmailNull() {
        mContentValues.putNull(PropertyColumns.EMAIL);
        return this;
    }

    /**
     * phone.
     */
    public PropertyContentValues putPhone(@Nullable String value) {
        mContentValues.put(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertyContentValues putPhoneNull() {
        mContentValues.putNull(PropertyColumns.PHONE);
        return this;
    }

    /**
     * propertyLandmark.
     */
    public PropertyContentValues putPropertylandmark(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertyContentValues putPropertylandmarkNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYLANDMARK);
        return this;
    }

    /**
     * propertyPlotNo.
     */
    public PropertyContentValues putPropertyplotno(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertyContentValues putPropertyplotnoNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYPLOTNO);
        return this;
    }

    /**
     * propertyHouseNo.
     */
    public PropertyContentValues putPropertyhouseno(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertyContentValues putPropertyhousenoNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYHOUSENO);
        return this;
    }

    /**
     * propertyRoad.
     */
    public PropertyContentValues putPropertyroad(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertyContentValues putPropertyroadNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYROAD);
        return this;
    }

    /**
     * propertyPincode.
     */
    public PropertyContentValues putPropertypincode(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertyContentValues putPropertypincodeNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYPINCODE);
        return this;
    }

    /**
     * propertyBuildingName.
     */
    public PropertyContentValues putPropertybuildingname(@Nullable String value) {
        mContentValues.put(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertyContentValues putPropertybuildingnameNull() {
        mContentValues.putNull(PropertyColumns.PROPERTYBUILDINGNAME);
        return this;
    }
}
