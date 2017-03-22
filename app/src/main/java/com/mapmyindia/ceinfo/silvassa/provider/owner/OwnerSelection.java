package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code owner} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class OwnerSelection extends AbstractSelection<OwnerSelection> {
    @Override
    protected Uri baseUri() {
        return OwnerColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection      A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OwnerCursor} object, which is positioned before the first entry, or null.
     */
    public OwnerCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OwnerCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public OwnerCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context    The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code OwnerCursor} object, which is positioned before the first entry, or null.
     */
    public OwnerCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new OwnerCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public OwnerCursor query(Context context) {
        return query(context, null);
    }


    public OwnerSelection id(long... value) {
        addEquals("owner." + OwnerColumns._ID, toObjectArray(value));
        return this;
    }

    public OwnerSelection idNot(long... value) {
        addNotEquals("owner." + OwnerColumns._ID, toObjectArray(value));
        return this;
    }

    public OwnerSelection orderById(boolean desc) {
        orderBy("owner." + OwnerColumns._ID, desc);
        return this;
    }

    public OwnerSelection orderById() {
        return orderById(false);
    }

    public OwnerSelection ownername(String... value) {
        addEquals(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection ownernameNot(String... value) {
        addNotEquals(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection ownernameLike(String... value) {
        addLike(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection ownernameContains(String... value) {
        addContains(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection ownernameStartsWith(String... value) {
        addStartsWith(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection ownernameEndsWith(String... value) {
        addEndsWith(OwnerColumns.OWNERNAME, value);
        return this;
    }

    public OwnerSelection orderByOwnername(boolean desc) {
        orderBy(OwnerColumns.OWNERNAME, desc);
        return this;
    }

    public OwnerSelection orderByOwnername() {
        orderBy(OwnerColumns.OWNERNAME, false);
        return this;
    }
}
