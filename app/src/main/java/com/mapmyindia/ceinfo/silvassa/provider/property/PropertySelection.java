package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code property} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class PropertySelection extends AbstractSelection<PropertySelection> {
    @Override
    protected Uri baseUri() {
        return PropertyColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection      A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PropertyCursor} object, which is positioned before the first entry, or null.
     */
    public PropertyCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PropertyCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PropertyCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context    The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PropertyCursor} object, which is positioned before the first entry, or null.
     */
    public PropertyCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PropertyCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PropertyCursor query(Context context) {
        return query(context, null);
    }


    public PropertySelection id(long... value) {
        addEquals("property." + PropertyColumns._ID, toObjectArray(value));
        return this;
    }

    public PropertySelection idNot(long... value) {
        addNotEquals("property." + PropertyColumns._ID, toObjectArray(value));
        return this;
    }

    public PropertySelection orderById(boolean desc) {
        orderBy("property." + PropertyColumns._ID, desc);
        return this;
    }

    public PropertySelection orderById() {
        return orderById(false);
    }

    public PropertySelection propertyuniqueid(String... value) {
        addEquals(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection propertyuniqueidNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection propertyuniqueidLike(String... value) {
        addLike(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection propertyuniqueidContains(String... value) {
        addContains(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection propertyuniqueidStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection propertyuniqueidEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PropertySelection orderByPropertyuniqueid(boolean desc) {
        orderBy(PropertyColumns.PROPERTYUNIQUEID, desc);
        return this;
    }

    public PropertySelection orderByPropertyuniqueid() {
        orderBy(PropertyColumns.PROPERTYUNIQUEID, false);
        return this;
    }

    public PropertySelection propertyowner(String... value) {
        addEquals(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection propertyownerNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection propertyownerLike(String... value) {
        addLike(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection propertyownerContains(String... value) {
        addContains(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection propertyownerStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection propertyownerEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYOWNER, value);
        return this;
    }

    public PropertySelection orderByPropertyowner(boolean desc) {
        orderBy(PropertyColumns.PROPERTYOWNER, desc);
        return this;
    }

    public PropertySelection orderByPropertyowner() {
        orderBy(PropertyColumns.PROPERTYOWNER, false);
        return this;
    }

    public PropertySelection propertyoccupiername(String... value) {
        addEquals(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection propertyoccupiernameNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection propertyoccupiernameLike(String... value) {
        addLike(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection propertyoccupiernameContains(String... value) {
        addContains(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection propertyoccupiernameStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection propertyoccupiernameEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYOCCUPIERNAME, value);
        return this;
    }

    public PropertySelection orderByPropertyoccupiername(boolean desc) {
        orderBy(PropertyColumns.PROPERTYOCCUPIERNAME, desc);
        return this;
    }

    public PropertySelection orderByPropertyoccupiername() {
        orderBy(PropertyColumns.PROPERTYOCCUPIERNAME, false);
        return this;
    }

    public PropertySelection propertyrelationowner(String... value) {
        addEquals(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection propertyrelationownerNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection propertyrelationownerLike(String... value) {
        addLike(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection propertyrelationownerContains(String... value) {
        addContains(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection propertyrelationownerStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection propertyrelationownerEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYRELATIONOWNER, value);
        return this;
    }

    public PropertySelection orderByPropertyrelationowner(boolean desc) {
        orderBy(PropertyColumns.PROPERTYRELATIONOWNER, desc);
        return this;
    }

    public PropertySelection orderByPropertyrelationowner() {
        orderBy(PropertyColumns.PROPERTYRELATIONOWNER, false);
        return this;
    }

    public PropertySelection zoneid(String... value) {
        addEquals(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection zoneidNot(String... value) {
        addNotEquals(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection zoneidLike(String... value) {
        addLike(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection zoneidContains(String... value) {
        addContains(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection zoneidStartsWith(String... value) {
        addStartsWith(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection zoneidEndsWith(String... value) {
        addEndsWith(PropertyColumns.ZONEID, value);
        return this;
    }

    public PropertySelection orderByZoneid(boolean desc) {
        orderBy(PropertyColumns.ZONEID, desc);
        return this;
    }

    public PropertySelection orderByZoneid() {
        orderBy(PropertyColumns.ZONEID, false);
        return this;
    }

    public PropertySelection propertysublocality(String... value) {
        addEquals(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection propertysublocalityNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection propertysublocalityLike(String... value) {
        addLike(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection propertysublocalityContains(String... value) {
        addContains(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection propertysublocalityStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection propertysublocalityEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYSUBLOCALITY, value);
        return this;
    }

    public PropertySelection orderByPropertysublocality(boolean desc) {
        orderBy(PropertyColumns.PROPERTYSUBLOCALITY, desc);
        return this;
    }

    public PropertySelection orderByPropertysublocality() {
        orderBy(PropertyColumns.PROPERTYSUBLOCALITY, false);
        return this;
    }

    public PropertySelection email(String... value) {
        addEquals(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection emailNot(String... value) {
        addNotEquals(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection emailLike(String... value) {
        addLike(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection emailContains(String... value) {
        addContains(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection emailStartsWith(String... value) {
        addStartsWith(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection emailEndsWith(String... value) {
        addEndsWith(PropertyColumns.EMAIL, value);
        return this;
    }

    public PropertySelection orderByEmail(boolean desc) {
        orderBy(PropertyColumns.EMAIL, desc);
        return this;
    }

    public PropertySelection orderByEmail() {
        orderBy(PropertyColumns.EMAIL, false);
        return this;
    }

    public PropertySelection phone(String... value) {
        addEquals(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection phoneNot(String... value) {
        addNotEquals(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection phoneLike(String... value) {
        addLike(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection phoneContains(String... value) {
        addContains(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection phoneStartsWith(String... value) {
        addStartsWith(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection phoneEndsWith(String... value) {
        addEndsWith(PropertyColumns.PHONE, value);
        return this;
    }

    public PropertySelection orderByPhone(boolean desc) {
        orderBy(PropertyColumns.PHONE, desc);
        return this;
    }

    public PropertySelection orderByPhone() {
        orderBy(PropertyColumns.PHONE, false);
        return this;
    }

    public PropertySelection propertylandmark(String... value) {
        addEquals(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection propertylandmarkNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection propertylandmarkLike(String... value) {
        addLike(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection propertylandmarkContains(String... value) {
        addContains(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection propertylandmarkStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection propertylandmarkEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYLANDMARK, value);
        return this;
    }

    public PropertySelection orderByPropertylandmark(boolean desc) {
        orderBy(PropertyColumns.PROPERTYLANDMARK, desc);
        return this;
    }

    public PropertySelection orderByPropertylandmark() {
        orderBy(PropertyColumns.PROPERTYLANDMARK, false);
        return this;
    }

    public PropertySelection propertyplotno(String... value) {
        addEquals(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection propertyplotnoNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection propertyplotnoLike(String... value) {
        addLike(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection propertyplotnoContains(String... value) {
        addContains(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection propertyplotnoStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection propertyplotnoEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYPLOTNO, value);
        return this;
    }

    public PropertySelection orderByPropertyplotno(boolean desc) {
        orderBy(PropertyColumns.PROPERTYPLOTNO, desc);
        return this;
    }

    public PropertySelection orderByPropertyplotno() {
        orderBy(PropertyColumns.PROPERTYPLOTNO, false);
        return this;
    }

    public PropertySelection propertyhouseno(String... value) {
        addEquals(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection propertyhousenoNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection propertyhousenoLike(String... value) {
        addLike(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection propertyhousenoContains(String... value) {
        addContains(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection propertyhousenoStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection propertyhousenoEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYHOUSENO, value);
        return this;
    }

    public PropertySelection orderByPropertyhouseno(boolean desc) {
        orderBy(PropertyColumns.PROPERTYHOUSENO, desc);
        return this;
    }

    public PropertySelection orderByPropertyhouseno() {
        orderBy(PropertyColumns.PROPERTYHOUSENO, false);
        return this;
    }

    public PropertySelection propertyroad(String... value) {
        addEquals(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection propertyroadNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection propertyroadLike(String... value) {
        addLike(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection propertyroadContains(String... value) {
        addContains(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection propertyroadStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection propertyroadEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYROAD, value);
        return this;
    }

    public PropertySelection orderByPropertyroad(boolean desc) {
        orderBy(PropertyColumns.PROPERTYROAD, desc);
        return this;
    }

    public PropertySelection orderByPropertyroad() {
        orderBy(PropertyColumns.PROPERTYROAD, false);
        return this;
    }

    public PropertySelection propertypincode(String... value) {
        addEquals(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection propertypincodeNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection propertypincodeLike(String... value) {
        addLike(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection propertypincodeContains(String... value) {
        addContains(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection propertypincodeStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection propertypincodeEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYPINCODE, value);
        return this;
    }

    public PropertySelection orderByPropertypincode(boolean desc) {
        orderBy(PropertyColumns.PROPERTYPINCODE, desc);
        return this;
    }

    public PropertySelection orderByPropertypincode() {
        orderBy(PropertyColumns.PROPERTYPINCODE, false);
        return this;
    }

    public PropertySelection propertybuildingname(String... value) {
        addEquals(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection propertybuildingnameNot(String... value) {
        addNotEquals(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection propertybuildingnameLike(String... value) {
        addLike(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection propertybuildingnameContains(String... value) {
        addContains(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection propertybuildingnameStartsWith(String... value) {
        addStartsWith(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection propertybuildingnameEndsWith(String... value) {
        addEndsWith(PropertyColumns.PROPERTYBUILDINGNAME, value);
        return this;
    }

    public PropertySelection orderByPropertybuildingname(boolean desc) {
        orderBy(PropertyColumns.PROPERTYBUILDINGNAME, desc);
        return this;
    }

    public PropertySelection orderByPropertybuildingname() {
        orderBy(PropertyColumns.PROPERTYBUILDINGNAME, false);
        return this;
    }
}
