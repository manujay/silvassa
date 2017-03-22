package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code occupier} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class OccupierSelection extends AbstractSelection<OccupierSelection> {
    @Override
    protected Uri baseUri() {
        return OccupierColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection      A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OccupierCursor} object, which is positioned before the first entry, or null.
     */
    public OccupierCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OccupierCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public OccupierCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context    The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OccupierCursor} object, which is positioned before the first entry, or null.
     */
    public OccupierCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OccupierCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public OccupierCursor query(Context context) {
        return query(context, null);
    }


    public OccupierSelection id(long... value) {
        addEquals("occupier." + OccupierColumns._ID, toObjectArray(value));
        return this;
    }

    public OccupierSelection idNot(long... value) {
        addNotEquals("occupier." + OccupierColumns._ID, toObjectArray(value));
        return this;
    }

    public OccupierSelection orderById(boolean desc) {
        orderBy("occupier." + OccupierColumns._ID, desc);
        return this;
    }

    public OccupierSelection orderById() {
        return orderById(false);
    }

    public OccupierSelection occupiername(String... value) {
        addEquals(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection occupiernameNot(String... value) {
        addNotEquals(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection occupiernameLike(String... value) {
        addLike(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection occupiernameContains(String... value) {
        addContains(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection occupiernameStartsWith(String... value) {
        addStartsWith(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection occupiernameEndsWith(String... value) {
        addEndsWith(OccupierColumns.OCCUPIERNAME, value);
        return this;
    }

    public OccupierSelection orderByOccupiername(boolean desc) {
        orderBy(OccupierColumns.OCCUPIERNAME, desc);
        return this;
    }

    public OccupierSelection orderByOccupiername() {
        orderBy(OccupierColumns.OCCUPIERNAME, false);
        return this;
    }
}
