package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code criteria} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class CriteriaSelection extends AbstractSelection<CriteriaSelection> {
    @Override
    protected Uri baseUri() {
        return CriteriaColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CriteriaCursor} object, which is positioned before the first entry, or null.
     */
    public CriteriaCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CriteriaCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public CriteriaCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CriteriaCursor} object, which is positioned before the first entry, or null.
     */
    public CriteriaCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CriteriaCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public CriteriaCursor query(Context context) {
        return query(context, null);
    }


    public CriteriaSelection id(long... value) {
        addEquals("criteria." + CriteriaColumns._ID, toObjectArray(value));
        return this;
    }

    public CriteriaSelection idNot(long... value) {
        addNotEquals("criteria." + CriteriaColumns._ID, toObjectArray(value));
        return this;
    }

    public CriteriaSelection orderById(boolean desc) {
        orderBy("criteria." + CriteriaColumns._ID, desc);
        return this;
    }

    public CriteriaSelection orderById() {
        return orderById(false);
    }

    public CriteriaSelection occupiername(String... value) {
        addEquals(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection occupiernameNot(String... value) {
        addNotEquals(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection occupiernameLike(String... value) {
        addLike(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection occupiernameContains(String... value) {
        addContains(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection occupiernameStartsWith(String... value) {
        addStartsWith(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection occupiernameEndsWith(String... value) {
        addEndsWith(CriteriaColumns.OCCUPIERNAME, value);
        return this;
    }

    public CriteriaSelection orderByOccupiername(boolean desc) {
        orderBy(CriteriaColumns.OCCUPIERNAME, desc);
        return this;
    }

    public CriteriaSelection orderByOccupiername() {
        orderBy(CriteriaColumns.OCCUPIERNAME, false);
        return this;
    }

    public CriteriaSelection propid(String... value) {
        addEquals(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection propidNot(String... value) {
        addNotEquals(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection propidLike(String... value) {
        addLike(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection propidContains(String... value) {
        addContains(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection propidStartsWith(String... value) {
        addStartsWith(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection propidEndsWith(String... value) {
        addEndsWith(CriteriaColumns.PROPID, value);
        return this;
    }

    public CriteriaSelection orderByPropid(boolean desc) {
        orderBy(CriteriaColumns.PROPID, desc);
        return this;
    }

    public CriteriaSelection orderByPropid() {
        orderBy(CriteriaColumns.PROPID, false);
        return this;
    }

    public CriteriaSelection ownername(String... value) {
        addEquals(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection ownernameNot(String... value) {
        addNotEquals(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection ownernameLike(String... value) {
        addLike(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection ownernameContains(String... value) {
        addContains(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection ownernameStartsWith(String... value) {
        addStartsWith(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection ownernameEndsWith(String... value) {
        addEndsWith(CriteriaColumns.OWNERNAME, value);
        return this;
    }

    public CriteriaSelection orderByOwnername(boolean desc) {
        orderBy(CriteriaColumns.OWNERNAME, desc);
        return this;
    }

    public CriteriaSelection orderByOwnername() {
        orderBy(CriteriaColumns.OWNERNAME, false);
        return this;
    }
}
