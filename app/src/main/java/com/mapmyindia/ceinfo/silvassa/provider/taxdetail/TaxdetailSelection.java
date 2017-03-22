package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code taxdetail} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class TaxdetailSelection extends AbstractSelection<TaxdetailSelection> {
    @Override
    protected Uri baseUri() {
        return TaxdetailColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection      A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TaxdetailCursor} object, which is positioned before the first entry, or null.
     */
    public TaxdetailCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TaxdetailCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TaxdetailCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context    The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TaxdetailCursor} object, which is positioned before the first entry, or null.
     */
    public TaxdetailCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TaxdetailCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TaxdetailCursor query(Context context) {
        return query(context, null);
    }


    public TaxdetailSelection id(long... value) {
        addEquals("taxdetail." + TaxdetailColumns._ID, toObjectArray(value));
        return this;
    }

    public TaxdetailSelection idNot(long... value) {
        addNotEquals("taxdetail." + TaxdetailColumns._ID, toObjectArray(value));
        return this;
    }

    public TaxdetailSelection orderById(boolean desc) {
        orderBy("taxdetail." + TaxdetailColumns._ID, desc);
        return this;
    }

    public TaxdetailSelection orderById() {
        return orderById(false);
    }

    public TaxdetailSelection taxno(String... value) {
        addEquals(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection taxnoNot(String... value) {
        addNotEquals(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection taxnoLike(String... value) {
        addLike(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection taxnoContains(String... value) {
        addContains(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection taxnoStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection taxnoEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailSelection orderByTaxno(boolean desc) {
        orderBy(TaxdetailColumns.TAXNO, desc);
        return this;
    }

    public TaxdetailSelection orderByTaxno() {
        orderBy(TaxdetailColumns.TAXNO, false);
        return this;
    }

    public TaxdetailSelection taxamount(String... value) {
        addEquals(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection taxamountNot(String... value) {
        addNotEquals(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection taxamountLike(String... value) {
        addLike(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection taxamountContains(String... value) {
        addContains(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection taxamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection taxamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.TAXAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByTaxamount(boolean desc) {
        orderBy(TaxdetailColumns.TAXAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByTaxamount() {
        orderBy(TaxdetailColumns.TAXAMOUNT, false);
        return this;
    }

    public TaxdetailSelection duedate(String... value) {
        addEquals(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection duedateNot(String... value) {
        addNotEquals(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection duedateLike(String... value) {
        addLike(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection duedateContains(String... value) {
        addContains(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection duedateStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection duedateEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailSelection orderByDuedate(boolean desc) {
        orderBy(TaxdetailColumns.DUEDATE, desc);
        return this;
    }

    public TaxdetailSelection orderByDuedate() {
        orderBy(TaxdetailColumns.DUEDATE, false);
        return this;
    }

    public TaxdetailSelection noticegenerated(String... value) {
        addEquals(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection noticegeneratedNot(String... value) {
        addNotEquals(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection noticegeneratedLike(String... value) {
        addLike(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection noticegeneratedContains(String... value) {
        addContains(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection noticegeneratedStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection noticegeneratedEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailSelection orderByNoticegenerated(boolean desc) {
        orderBy(TaxdetailColumns.NOTICEGENERATED, desc);
        return this;
    }

    public TaxdetailSelection orderByNoticegenerated() {
        orderBy(TaxdetailColumns.NOTICEGENERATED, false);
        return this;
    }

    public TaxdetailSelection propid(String... value) {
        addEquals(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection propidNot(String... value) {
        addNotEquals(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection propidLike(String... value) {
        addLike(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection propidContains(String... value) {
        addContains(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection propidStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection propidEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.PROPID, value);
        return this;
    }

    public TaxdetailSelection orderByPropid(boolean desc) {
        orderBy(TaxdetailColumns.PROPID, desc);
        return this;
    }

    public TaxdetailSelection orderByPropid() {
        orderBy(TaxdetailColumns.PROPID, false);
        return this;
    }

    public TaxdetailSelection financialyear(String... value) {
        addEquals(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection financialyearNot(String... value) {
        addNotEquals(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection financialyearLike(String... value) {
        addLike(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection financialyearContains(String... value) {
        addContains(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection financialyearStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection financialyearEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailSelection orderByFinancialyear(boolean desc) {
        orderBy(TaxdetailColumns.FINANCIALYEAR, desc);
        return this;
    }

    public TaxdetailSelection orderByFinancialyear() {
        orderBy(TaxdetailColumns.FINANCIALYEAR, false);
        return this;
    }
}
