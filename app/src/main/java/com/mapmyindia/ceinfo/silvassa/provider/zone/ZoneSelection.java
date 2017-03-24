package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code zone} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class ZoneSelection extends AbstractSelection<ZoneSelection> {
    @Override
    protected Uri baseUri() {
        return ZoneColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ZoneCursor} object, which is positioned before the first entry, or null.
     */
    public ZoneCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ZoneCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public ZoneCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code ZoneCursor} object, which is positioned before the first entry, or null.
     */
    public ZoneCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new ZoneCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public ZoneCursor query(Context context) {
        return query(context, null);
    }


    public ZoneSelection id(long... value) {
        addEquals("zone." + ZoneColumns._ID, toObjectArray(value));
        return this;
    }

    public ZoneSelection idNot(long... value) {
        addNotEquals("zone." + ZoneColumns._ID, toObjectArray(value));
        return this;
    }

    public ZoneSelection orderById(boolean desc) {
        orderBy("zone." + ZoneColumns._ID, desc);
        return this;
    }

    public ZoneSelection orderById() {
        return orderById(false);
    }

    public ZoneSelection zoneid(String... value) {
        addEquals(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection zoneidNot(String... value) {
        addNotEquals(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection zoneidLike(String... value) {
        addLike(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection zoneidContains(String... value) {
        addContains(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection zoneidStartsWith(String... value) {
        addStartsWith(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection zoneidEndsWith(String... value) {
        addEndsWith(ZoneColumns.ZONEID, value);
        return this;
    }

    public ZoneSelection orderByZoneid(boolean desc) {
        orderBy(ZoneColumns.ZONEID, desc);
        return this;
    }

    public ZoneSelection orderByZoneid() {
        orderBy(ZoneColumns.ZONEID, false);
        return this;
    }

    public ZoneSelection zonename(String... value) {
        addEquals(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection zonenameNot(String... value) {
        addNotEquals(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection zonenameLike(String... value) {
        addLike(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection zonenameContains(String... value) {
        addContains(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection zonenameStartsWith(String... value) {
        addStartsWith(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection zonenameEndsWith(String... value) {
        addEndsWith(ZoneColumns.ZONENAME, value);
        return this;
    }

    public ZoneSelection orderByZonename(boolean desc) {
        orderBy(ZoneColumns.ZONENAME, desc);
        return this;
    }

    public ZoneSelection orderByZonename() {
        orderBy(ZoneColumns.ZONENAME, false);
        return this;
    }
}
