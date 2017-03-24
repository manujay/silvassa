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
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
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
     * @param context The context to use for the query.
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

    public TaxdetailSelection propertyid(String... value) {
        addEquals(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection propertyidNot(String... value) {
        addNotEquals(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection propertyidLike(String... value) {
        addLike(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection propertyidContains(String... value) {
        addContains(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection propertyidStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection propertyidEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.PROPERTYID, value);
        return this;
    }

    public TaxdetailSelection orderByPropertyid(boolean desc) {
        orderBy(TaxdetailColumns.PROPERTYID, desc);
        return this;
    }

    public TaxdetailSelection orderByPropertyid() {
        orderBy(TaxdetailColumns.PROPERTYID, false);
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

    public TaxdetailSelection propertytax(String... value) {
        addEquals(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection propertytaxNot(String... value) {
        addNotEquals(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection propertytaxLike(String... value) {
        addLike(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection propertytaxContains(String... value) {
        addContains(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection propertytaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection propertytaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection orderByPropertytax(boolean desc) {
        orderBy(TaxdetailColumns.PROPERTYTAX, desc);
        return this;
    }

    public TaxdetailSelection orderByPropertytax() {
        orderBy(TaxdetailColumns.PROPERTYTAX, false);
        return this;
    }

    public TaxdetailSelection watertax(String... value) {
        addEquals(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection watertaxNot(String... value) {
        addNotEquals(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection watertaxLike(String... value) {
        addLike(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection watertaxContains(String... value) {
        addContains(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection watertaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection watertaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailSelection orderByWatertax(boolean desc) {
        orderBy(TaxdetailColumns.WATERTAX, desc);
        return this;
    }

    public TaxdetailSelection orderByWatertax() {
        orderBy(TaxdetailColumns.WATERTAX, false);
        return this;
    }

    public TaxdetailSelection conservancytax(String... value) {
        addEquals(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection conservancytaxNot(String... value) {
        addNotEquals(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection conservancytaxLike(String... value) {
        addLike(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection conservancytaxContains(String... value) {
        addContains(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection conservancytaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection conservancytaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailSelection orderByConservancytax(boolean desc) {
        orderBy(TaxdetailColumns.CONSERVANCYTAX, desc);
        return this;
    }

    public TaxdetailSelection orderByConservancytax() {
        orderBy(TaxdetailColumns.CONSERVANCYTAX, false);
        return this;
    }

    public TaxdetailSelection waterseweragecharge(String... value) {
        addEquals(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection waterseweragechargeNot(String... value) {
        addNotEquals(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection waterseweragechargeLike(String... value) {
        addLike(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection waterseweragechargeContains(String... value) {
        addContains(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection waterseweragechargeStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection waterseweragechargeEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailSelection orderByWaterseweragecharge(boolean desc) {
        orderBy(TaxdetailColumns.WATERSEWERAGECHARGE, desc);
        return this;
    }

    public TaxdetailSelection orderByWaterseweragecharge() {
        orderBy(TaxdetailColumns.WATERSEWERAGECHARGE, false);
        return this;
    }

    public TaxdetailSelection watermeterbillamount(String... value) {
        addEquals(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection watermeterbillamountNot(String... value) {
        addNotEquals(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection watermeterbillamountLike(String... value) {
        addLike(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection watermeterbillamountContains(String... value) {
        addContains(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection watermeterbillamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection watermeterbillamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByWatermeterbillamount(boolean desc) {
        orderBy(TaxdetailColumns.WATERMETERBILLAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByWatermeterbillamount() {
        orderBy(TaxdetailColumns.WATERMETERBILLAMOUNT, false);
        return this;
    }

    public TaxdetailSelection arrearamount(String... value) {
        addEquals(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection arrearamountNot(String... value) {
        addNotEquals(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection arrearamountLike(String... value) {
        addLike(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection arrearamountContains(String... value) {
        addContains(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection arrearamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection arrearamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByArrearamount(boolean desc) {
        orderBy(TaxdetailColumns.ARREARAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByArrearamount() {
        orderBy(TaxdetailColumns.ARREARAMOUNT, false);
        return this;
    }

    public TaxdetailSelection advancepaidamount(String... value) {
        addEquals(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection advancepaidamountNot(String... value) {
        addNotEquals(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection advancepaidamountLike(String... value) {
        addLike(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection advancepaidamountContains(String... value) {
        addContains(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection advancepaidamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection advancepaidamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByAdvancepaidamount(boolean desc) {
        orderBy(TaxdetailColumns.ADVANCEPAIDAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByAdvancepaidamount() {
        orderBy(TaxdetailColumns.ADVANCEPAIDAMOUNT, false);
        return this;
    }

    public TaxdetailSelection rebateamount(String... value) {
        addEquals(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection rebateamountNot(String... value) {
        addNotEquals(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection rebateamountLike(String... value) {
        addLike(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection rebateamountContains(String... value) {
        addContains(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection rebateamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection rebateamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByRebateamount(boolean desc) {
        orderBy(TaxdetailColumns.REBATEAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByRebateamount() {
        orderBy(TaxdetailColumns.REBATEAMOUNT, false);
        return this;
    }

    public TaxdetailSelection adjustmentamount(String... value) {
        addEquals(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection adjustmentamountNot(String... value) {
        addNotEquals(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection adjustmentamountLike(String... value) {
        addLike(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection adjustmentamountContains(String... value) {
        addContains(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection adjustmentamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection adjustmentamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByAdjustmentamount(boolean desc) {
        orderBy(TaxdetailColumns.ADJUSTMENTAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByAdjustmentamount() {
        orderBy(TaxdetailColumns.ADJUSTMENTAMOUNT, false);
        return this;
    }

    public TaxdetailSelection totalpropertytax(String... value) {
        addEquals(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection totalpropertytaxNot(String... value) {
        addNotEquals(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection totalpropertytaxLike(String... value) {
        addLike(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection totalpropertytaxContains(String... value) {
        addContains(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection totalpropertytaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection totalpropertytaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailSelection orderByTotalpropertytax(boolean desc) {
        orderBy(TaxdetailColumns.TOTALPROPERTYTAX, desc);
        return this;
    }

    public TaxdetailSelection orderByTotalpropertytax() {
        orderBy(TaxdetailColumns.TOTALPROPERTYTAX, false);
        return this;
    }

    public TaxdetailSelection servicetax(String... value) {
        addEquals(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection servicetaxNot(String... value) {
        addNotEquals(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection servicetaxLike(String... value) {
        addLike(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection servicetaxContains(String... value) {
        addContains(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection servicetaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection servicetaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailSelection orderByServicetax(boolean desc) {
        orderBy(TaxdetailColumns.SERVICETAX, desc);
        return this;
    }

    public TaxdetailSelection orderByServicetax() {
        orderBy(TaxdetailColumns.SERVICETAX, false);
        return this;
    }

    public TaxdetailSelection othertax(String... value) {
        addEquals(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection othertaxNot(String... value) {
        addNotEquals(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection othertaxLike(String... value) {
        addLike(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection othertaxContains(String... value) {
        addContains(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection othertaxStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection othertaxEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailSelection orderByOthertax(boolean desc) {
        orderBy(TaxdetailColumns.OTHERTAX, desc);
        return this;
    }

    public TaxdetailSelection orderByOthertax() {
        orderBy(TaxdetailColumns.OTHERTAX, false);
        return this;
    }

    public TaxdetailSelection grandtotal(String... value) {
        addEquals(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection grandtotalNot(String... value) {
        addNotEquals(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection grandtotalLike(String... value) {
        addLike(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection grandtotalContains(String... value) {
        addContains(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection grandtotalStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection grandtotalEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailSelection orderByGrandtotal(boolean desc) {
        orderBy(TaxdetailColumns.GRANDTOTAL, desc);
        return this;
    }

    public TaxdetailSelection orderByGrandtotal() {
        orderBy(TaxdetailColumns.GRANDTOTAL, false);
        return this;
    }

    public TaxdetailSelection delaypaymentcharges(String... value) {
        addEquals(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection delaypaymentchargesNot(String... value) {
        addNotEquals(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection delaypaymentchargesLike(String... value) {
        addLike(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection delaypaymentchargesContains(String... value) {
        addContains(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection delaypaymentchargesStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection delaypaymentchargesEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailSelection orderByDelaypaymentcharges(boolean desc) {
        orderBy(TaxdetailColumns.DELAYPAYMENTCHARGES, desc);
        return this;
    }

    public TaxdetailSelection orderByDelaypaymentcharges() {
        orderBy(TaxdetailColumns.DELAYPAYMENTCHARGES, false);
        return this;
    }

    public TaxdetailSelection payableamount(String... value) {
        addEquals(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection payableamountNot(String... value) {
        addNotEquals(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection payableamountLike(String... value) {
        addLike(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection payableamountContains(String... value) {
        addContains(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection payableamountStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection payableamountEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailSelection orderByPayableamount(boolean desc) {
        orderBy(TaxdetailColumns.PAYABLEAMOUNT, desc);
        return this;
    }

    public TaxdetailSelection orderByPayableamount() {
        orderBy(TaxdetailColumns.PAYABLEAMOUNT, false);
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

    public TaxdetailSelection objectionstatus(String... value) {
        addEquals(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection objectionstatusNot(String... value) {
        addNotEquals(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection objectionstatusLike(String... value) {
        addLike(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection objectionstatusContains(String... value) {
        addContains(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection objectionstatusStartsWith(String... value) {
        addStartsWith(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection objectionstatusEndsWith(String... value) {
        addEndsWith(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailSelection orderByObjectionstatus(boolean desc) {
        orderBy(TaxdetailColumns.OBJECTIONSTATUS, desc);
        return this;
    }

    public TaxdetailSelection orderByObjectionstatus() {
        orderBy(TaxdetailColumns.OBJECTIONSTATUS, false);
        return this;
    }
}
