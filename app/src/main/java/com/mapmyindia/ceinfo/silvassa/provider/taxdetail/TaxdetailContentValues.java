package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code taxdetail} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class TaxdetailContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TaxdetailColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TaxdetailSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TaxdetailSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * taxNo.
     */
    public TaxdetailContentValues putTaxno(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.TAXNO, value);
        return this;
    }

    public TaxdetailContentValues putTaxnoNull() {
        mContentValues.putNull(TaxdetailColumns.TAXNO);
        return this;
    }

    /**
     * propertyId.
     */
    public TaxdetailContentValues putPropertyid(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertyid must not be null");
        mContentValues.put(TaxdetailColumns.PROPERTYID, value);
        return this;
    }


    /**
     * financialYear.
     */
    public TaxdetailContentValues putFinancialyear(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }

    public TaxdetailContentValues putFinancialyearNull() {
        mContentValues.putNull(TaxdetailColumns.FINANCIALYEAR);
        return this;
    }

    /**
     * propertyTax.
     */
    public TaxdetailContentValues putPropertytax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }

    public TaxdetailContentValues putPropertytaxNull() {
        mContentValues.putNull(TaxdetailColumns.PROPERTYTAX);
        return this;
    }

    /**
     * waterTax.
     */
    public TaxdetailContentValues putWatertax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.WATERTAX, value);
        return this;
    }

    public TaxdetailContentValues putWatertaxNull() {
        mContentValues.putNull(TaxdetailColumns.WATERTAX);
        return this;
    }

    /**
     * conservancyTax.
     */
    public TaxdetailContentValues putConservancytax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }

    public TaxdetailContentValues putConservancytaxNull() {
        mContentValues.putNull(TaxdetailColumns.CONSERVANCYTAX);
        return this;
    }

    /**
     * waterSewerageCharge.
     */
    public TaxdetailContentValues putWaterseweragecharge(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }

    public TaxdetailContentValues putWaterseweragechargeNull() {
        mContentValues.putNull(TaxdetailColumns.WATERSEWERAGECHARGE);
        return this;
    }

    /**
     * waterMeterBillAmount.
     */
    public TaxdetailContentValues putWatermeterbillamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putWatermeterbillamountNull() {
        mContentValues.putNull(TaxdetailColumns.WATERMETERBILLAMOUNT);
        return this;
    }

    /**
     * arrearAmount.
     */
    public TaxdetailContentValues putArrearamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putArrearamountNull() {
        mContentValues.putNull(TaxdetailColumns.ARREARAMOUNT);
        return this;
    }

    /**
     * advancePaidAmount.
     */
    public TaxdetailContentValues putAdvancepaidamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putAdvancepaidamountNull() {
        mContentValues.putNull(TaxdetailColumns.ADVANCEPAIDAMOUNT);
        return this;
    }

    /**
     * rebateAmount.
     */
    public TaxdetailContentValues putRebateamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putRebateamountNull() {
        mContentValues.putNull(TaxdetailColumns.REBATEAMOUNT);
        return this;
    }

    /**
     * adjustmentAmount.
     */
    public TaxdetailContentValues putAdjustmentamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putAdjustmentamountNull() {
        mContentValues.putNull(TaxdetailColumns.ADJUSTMENTAMOUNT);
        return this;
    }

    /**
     * totalPropertyTax.
     */
    public TaxdetailContentValues putTotalpropertytax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }

    public TaxdetailContentValues putTotalpropertytaxNull() {
        mContentValues.putNull(TaxdetailColumns.TOTALPROPERTYTAX);
        return this;
    }

    /**
     * serviceTax.
     */
    public TaxdetailContentValues putServicetax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.SERVICETAX, value);
        return this;
    }

    public TaxdetailContentValues putServicetaxNull() {
        mContentValues.putNull(TaxdetailColumns.SERVICETAX);
        return this;
    }

    /**
     * otherTax.
     */
    public TaxdetailContentValues putOthertax(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.OTHERTAX, value);
        return this;
    }

    public TaxdetailContentValues putOthertaxNull() {
        mContentValues.putNull(TaxdetailColumns.OTHERTAX);
        return this;
    }

    /**
     * grandTotal.
     */
    public TaxdetailContentValues putGrandtotal(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }

    public TaxdetailContentValues putGrandtotalNull() {
        mContentValues.putNull(TaxdetailColumns.GRANDTOTAL);
        return this;
    }

    /**
     * delayPaymentCharges.
     */
    public TaxdetailContentValues putDelaypaymentcharges(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }

    public TaxdetailContentValues putDelaypaymentchargesNull() {
        mContentValues.putNull(TaxdetailColumns.DELAYPAYMENTCHARGES);
        return this;
    }

    /**
     * payableAmount.
     */
    public TaxdetailContentValues putPayableamount(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }

    public TaxdetailContentValues putPayableamountNull() {
        mContentValues.putNull(TaxdetailColumns.PAYABLEAMOUNT);
        return this;
    }

    /**
     * dueDate.
     */
    public TaxdetailContentValues putDuedate(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.DUEDATE, value);
        return this;
    }

    public TaxdetailContentValues putDuedateNull() {
        mContentValues.putNull(TaxdetailColumns.DUEDATE);
        return this;
    }

    /**
     * noticeGenerated.
     */
    public TaxdetailContentValues putNoticegenerated(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }

    public TaxdetailContentValues putNoticegeneratedNull() {
        mContentValues.putNull(TaxdetailColumns.NOTICEGENERATED);
        return this;
    }

    /**
     * objectionStatus.
     */
    public TaxdetailContentValues putObjectionstatus(@Nullable String value) {
        mContentValues.put(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

    public TaxdetailContentValues putObjectionstatusNull() {
        mContentValues.putNull(TaxdetailColumns.OBJECTIONSTATUS);
        return this;
    }
}
