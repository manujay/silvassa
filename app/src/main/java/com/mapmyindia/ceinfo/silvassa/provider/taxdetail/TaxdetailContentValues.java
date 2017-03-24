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
    public TaxdetailContentValues putTaxno(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("taxno must not be null");
        mContentValues.put(TaxdetailColumns.TAXNO, value);
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
    public TaxdetailContentValues putFinancialyear(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("financialyear must not be null");
        mContentValues.put(TaxdetailColumns.FINANCIALYEAR, value);
        return this;
    }


    /**
     * propertyTax.
     */
    public TaxdetailContentValues putPropertytax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("propertytax must not be null");
        mContentValues.put(TaxdetailColumns.PROPERTYTAX, value);
        return this;
    }


    /**
     * waterTax.
     */
    public TaxdetailContentValues putWatertax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("watertax must not be null");
        mContentValues.put(TaxdetailColumns.WATERTAX, value);
        return this;
    }


    /**
     * conservancyTax.
     */
    public TaxdetailContentValues putConservancytax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("conservancytax must not be null");
        mContentValues.put(TaxdetailColumns.CONSERVANCYTAX, value);
        return this;
    }


    /**
     * waterSewerageCharge.
     */
    public TaxdetailContentValues putWaterseweragecharge(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("waterseweragecharge must not be null");
        mContentValues.put(TaxdetailColumns.WATERSEWERAGECHARGE, value);
        return this;
    }


    /**
     * waterMeterBillAmount.
     */
    public TaxdetailContentValues putWatermeterbillamount(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("watermeterbillamount must not be null");
        mContentValues.put(TaxdetailColumns.WATERMETERBILLAMOUNT, value);
        return this;
    }


    /**
     * arrearAmount.
     */
    public TaxdetailContentValues putArrearamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("arrearamount must not be null");
        mContentValues.put(TaxdetailColumns.ARREARAMOUNT, value);
        return this;
    }


    /**
     * advancePaidAmount.
     */
    public TaxdetailContentValues putAdvancepaidamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("advancepaidamount must not be null");
        mContentValues.put(TaxdetailColumns.ADVANCEPAIDAMOUNT, value);
        return this;
    }


    /**
     * rebateAmount.
     */
    public TaxdetailContentValues putRebateamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("rebateamount must not be null");
        mContentValues.put(TaxdetailColumns.REBATEAMOUNT, value);
        return this;
    }


    /**
     * adjustmentAmount.
     */
    public TaxdetailContentValues putAdjustmentamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("adjustmentamount must not be null");
        mContentValues.put(TaxdetailColumns.ADJUSTMENTAMOUNT, value);
        return this;
    }


    /**
     * totalPropertyTax.
     */
    public TaxdetailContentValues putTotalpropertytax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("totalpropertytax must not be null");
        mContentValues.put(TaxdetailColumns.TOTALPROPERTYTAX, value);
        return this;
    }


    /**
     * serviceTax.
     */
    public TaxdetailContentValues putServicetax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("servicetax must not be null");
        mContentValues.put(TaxdetailColumns.SERVICETAX, value);
        return this;
    }


    /**
     * otherTax.
     */
    public TaxdetailContentValues putOthertax(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("othertax must not be null");
        mContentValues.put(TaxdetailColumns.OTHERTAX, value);
        return this;
    }


    /**
     * grandTotal.
     */
    public TaxdetailContentValues putGrandtotal(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("grandtotal must not be null");
        mContentValues.put(TaxdetailColumns.GRANDTOTAL, value);
        return this;
    }


    /**
     * delayPaymentCharges.
     */
    public TaxdetailContentValues putDelaypaymentcharges(@NonNull String value) {
        if (value == null)
            throw new IllegalArgumentException("delaypaymentcharges must not be null");
        mContentValues.put(TaxdetailColumns.DELAYPAYMENTCHARGES, value);
        return this;
    }


    /**
     * payableAmount.
     */
    public TaxdetailContentValues putPayableamount(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("payableamount must not be null");
        mContentValues.put(TaxdetailColumns.PAYABLEAMOUNT, value);
        return this;
    }


    /**
     * dueDate.
     */
    public TaxdetailContentValues putDuedate(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("duedate must not be null");
        mContentValues.put(TaxdetailColumns.DUEDATE, value);
        return this;
    }


    /**
     * noticeGenerated.
     */
    public TaxdetailContentValues putNoticegenerated(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("noticegenerated must not be null");
        mContentValues.put(TaxdetailColumns.NOTICEGENERATED, value);
        return this;
    }


    /**
     * objectionStatus.
     */
    public TaxdetailContentValues putObjectionstatus(@NonNull String value) {
        if (value == null) throw new IllegalArgumentException("objectionstatus must not be null");
        mContentValues.put(TaxdetailColumns.OBJECTIONSTATUS, value);
        return this;
    }

}
