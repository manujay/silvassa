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
     * @param projection      A list of which columns to return. Passing null will return all columns, which is inefficient.
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
     * @param context    The context to use for the query.
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

    public PaymentSelection payableamount(String... value) {
        addEquals(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection payableamountNot(String... value) {
        addNotEquals(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection payableamountLike(String... value) {
        addLike(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection payableamountContains(String... value) {
        addContains(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection payableamountStartsWith(String... value) {
        addStartsWith(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection payableamountEndsWith(String... value) {
        addEndsWith(PaymentColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public PaymentSelection orderByPayableamount(boolean desc) {
        orderBy(PaymentColumns.PAYABLEAMOUNT, desc);
        return this;
    }

    public PaymentSelection orderByPayableamount() {
        orderBy(PaymentColumns.PAYABLEAMOUNT, false);
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

    public PaymentSelection check(String... value) {
        addEquals(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection checkNot(String... value) {
        addNotEquals(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection checkLike(String... value) {
        addLike(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection checkContains(String... value) {
        addContains(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection checkStartsWith(String... value) {
        addStartsWith(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection checkEndsWith(String... value) {
        addEndsWith(PaymentColumns.CHECK, value);
        return this;
    }

    public PaymentSelection orderByCheck(boolean desc) {
        orderBy(PaymentColumns.CHECK, desc);
        return this;
    }

    public PaymentSelection orderByCheck() {
        orderBy(PaymentColumns.CHECK, false);
        return this;
    }

    public PaymentSelection dd(String... value) {
        addEquals(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection ddNot(String... value) {
        addNotEquals(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection ddLike(String... value) {
        addLike(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection ddContains(String... value) {
        addContains(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection ddStartsWith(String... value) {
        addStartsWith(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection ddEndsWith(String... value) {
        addEndsWith(PaymentColumns.DD, value);
        return this;
    }

    public PaymentSelection orderByDd(boolean desc) {
        orderBy(PaymentColumns.DD, desc);
        return this;
    }

    public PaymentSelection orderByDd() {
        orderBy(PaymentColumns.DD, false);
        return this;
    }

    public PaymentSelection pos(String... value) {
        addEquals(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection posNot(String... value) {
        addNotEquals(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection posLike(String... value) {
        addLike(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection posContains(String... value) {
        addContains(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection posStartsWith(String... value) {
        addStartsWith(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection posEndsWith(String... value) {
        addEndsWith(PaymentColumns.POS, value);
        return this;
    }

    public PaymentSelection orderByPos(boolean desc) {
        orderBy(PaymentColumns.POS, desc);
        return this;
    }

    public PaymentSelection orderByPos() {
        orderBy(PaymentColumns.POS, false);
        return this;
    }

    public PaymentSelection email(String... value) {
        addEquals(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection emailNot(String... value) {
        addNotEquals(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection emailLike(String... value) {
        addLike(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection emailContains(String... value) {
        addContains(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection emailStartsWith(String... value) {
        addStartsWith(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection emailEndsWith(String... value) {
        addEndsWith(PaymentColumns.EMAIL, value);
        return this;
    }

    public PaymentSelection orderByEmail(boolean desc) {
        orderBy(PaymentColumns.EMAIL, desc);
        return this;
    }

    public PaymentSelection orderByEmail() {
        orderBy(PaymentColumns.EMAIL, false);
        return this;
    }

    public PaymentSelection phone(String... value) {
        addEquals(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection phoneNot(String... value) {
        addNotEquals(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection phoneLike(String... value) {
        addLike(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection phoneContains(String... value) {
        addContains(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection phoneStartsWith(String... value) {
        addStartsWith(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection phoneEndsWith(String... value) {
        addEndsWith(PaymentColumns.PHONE, value);
        return this;
    }

    public PaymentSelection orderByPhone(boolean desc) {
        orderBy(PaymentColumns.PHONE, desc);
        return this;
    }

    public PaymentSelection orderByPhone() {
        orderBy(PaymentColumns.PHONE, false);
        return this;
    }

    public PaymentSelection date(String... value) {
        addEquals(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection dateNot(String... value) {
        addNotEquals(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection dateLike(String... value) {
        addLike(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection dateContains(String... value) {
        addContains(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection dateStartsWith(String... value) {
        addStartsWith(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection dateEndsWith(String... value) {
        addEndsWith(PaymentColumns.DATE, value);
        return this;
    }

    public PaymentSelection orderByDate(boolean desc) {
        orderBy(PaymentColumns.DATE, desc);
        return this;
    }

    public PaymentSelection orderByDate() {
        orderBy(PaymentColumns.DATE, false);
        return this;
    }
}
