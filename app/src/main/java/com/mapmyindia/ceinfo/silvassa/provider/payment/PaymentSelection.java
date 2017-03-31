package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractSelection;

/**
 * Selection for the {@code payment} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class PaymentSelection extends AbstractSelection<PaymentSelection> {
    @Override
    protected Uri baseUri() {
        return PaymentColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PaymentCursor} object, which is positioned before the first entry, or null.
     */
    public PaymentCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PaymentCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PaymentCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PaymentCursor} object, which is positioned before the first entry, or null.
     */
    public PaymentCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PaymentCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PaymentCursor query(Context context) {
        return query(context, null);
    }


    public PaymentSelection id(long... value) {
        addEquals("payment." + PaymentColumns._ID, toObjectArray(value));
        return this;
    }

    public PaymentSelection idNot(long... value) {
        addNotEquals("payment." + PaymentColumns._ID, toObjectArray(value));
        return this;
    }

    public PaymentSelection orderById(boolean desc) {
        orderBy("payment." + PaymentColumns._ID, desc);
        return this;
    }

    public PaymentSelection orderById() {
        return orderById(false);
    }

    public PaymentSelection userid(String... value) {
        addEquals(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection useridNot(String... value) {
        addNotEquals(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection useridLike(String... value) {
        addLike(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection useridContains(String... value) {
        addContains(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection useridStartsWith(String... value) {
        addStartsWith(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection useridEndsWith(String... value) {
        addEndsWith(PaymentColumns.USERID, value);
        return this;
    }

    public PaymentSelection orderByUserid(boolean desc) {
        orderBy(PaymentColumns.USERID, desc);
        return this;
    }

    public PaymentSelection orderByUserid() {
        orderBy(PaymentColumns.USERID, false);
        return this;
    }

    public PaymentSelection propertyuniqueid(String... value) {
        addEquals(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection propertyuniqueidNot(String... value) {
        addNotEquals(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection propertyuniqueidLike(String... value) {
        addLike(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection propertyuniqueidContains(String... value) {
        addContains(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection propertyuniqueidStartsWith(String... value) {
        addStartsWith(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection propertyuniqueidEndsWith(String... value) {
        addEndsWith(PaymentColumns.PROPERTYUNIQUEID, value);
        return this;
    }

    public PaymentSelection orderByPropertyuniqueid(boolean desc) {
        orderBy(PaymentColumns.PROPERTYUNIQUEID, desc);
        return this;
    }

    public PaymentSelection orderByPropertyuniqueid() {
        orderBy(PaymentColumns.PROPERTYUNIQUEID, false);
        return this;
    }

    public PaymentSelection taxno(String... value) {
        addEquals(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection taxnoNot(String... value) {
        addNotEquals(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection taxnoLike(String... value) {
        addLike(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection taxnoContains(String... value) {
        addContains(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection taxnoStartsWith(String... value) {
        addStartsWith(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection taxnoEndsWith(String... value) {
        addEndsWith(PaymentColumns.TAXNO, value);
        return this;
    }

    public PaymentSelection orderByTaxno(boolean desc) {
        orderBy(PaymentColumns.TAXNO, desc);
        return this;
    }

    public PaymentSelection orderByTaxno() {
        orderBy(PaymentColumns.TAXNO, false);
        return this;
    }

    public PaymentSelection mode(String... value) {
        addEquals(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection modeNot(String... value) {
        addNotEquals(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection modeLike(String... value) {
        addLike(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection modeContains(String... value) {
        addContains(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection modeStartsWith(String... value) {
        addStartsWith(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection modeEndsWith(String... value) {
        addEndsWith(PaymentColumns.MODE, value);
        return this;
    }

    public PaymentSelection orderByMode(boolean desc) {
        orderBy(PaymentColumns.MODE, desc);
        return this;
    }

    public PaymentSelection orderByMode() {
        orderBy(PaymentColumns.MODE, false);
        return this;
    }

    public PaymentSelection amount(String... value) {
        addEquals(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection amountNot(String... value) {
        addNotEquals(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection amountLike(String... value) {
        addLike(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection amountContains(String... value) {
        addContains(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection amountStartsWith(String... value) {
        addStartsWith(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection amountEndsWith(String... value) {
        addEndsWith(PaymentColumns.AMOUNT, value);
        return this;
    }

    public PaymentSelection orderByAmount(boolean desc) {
        orderBy(PaymentColumns.AMOUNT, desc);
        return this;
    }

    public PaymentSelection orderByAmount() {
        orderBy(PaymentColumns.AMOUNT, false);
        return this;
    }

    public PaymentSelection pdate(String... value) {
        addEquals(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection pdateNot(String... value) {
        addNotEquals(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection pdateLike(String... value) {
        addLike(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection pdateContains(String... value) {
        addContains(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection pdateStartsWith(String... value) {
        addStartsWith(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection pdateEndsWith(String... value) {
        addEndsWith(PaymentColumns.PDATE, value);
        return this;
    }

    public PaymentSelection orderByPdate(boolean desc) {
        orderBy(PaymentColumns.PDATE, desc);
        return this;
    }

    public PaymentSelection orderByPdate() {
        orderBy(PaymentColumns.PDATE, false);
        return this;
    }
}
