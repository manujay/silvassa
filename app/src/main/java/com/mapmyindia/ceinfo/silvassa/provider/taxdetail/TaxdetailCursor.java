package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code taxdetail} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class TaxdetailCursor extends AbstractCursor implements TaxdetailModel {
    public TaxdetailCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(TaxdetailColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * taxNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTaxno() {
        String res = getStringOrNull(TaxdetailColumns.TAXNO);
        return res;
    }

    /**
     * propertyId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyid() {
        String res = getStringOrNull(TaxdetailColumns.PROPERTYID);
        if (res == null)
            throw new NullPointerException("The value of 'propertyid' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * financialYear.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFinancialyear() {
        String res = getStringOrNull(TaxdetailColumns.FINANCIALYEAR);
        return res;
    }

    /**
     * propertyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertytax() {
        String res = getStringOrNull(TaxdetailColumns.PROPERTYTAX);
        return res;
    }

    /**
     * waterTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWatertax() {
        String res = getStringOrNull(TaxdetailColumns.WATERTAX);
        return res;
    }

    /**
     * conservancyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getConservancytax() {
        String res = getStringOrNull(TaxdetailColumns.CONSERVANCYTAX);
        return res;
    }

    /**
     * waterSewerageCharge.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWaterseweragecharge() {
        String res = getStringOrNull(TaxdetailColumns.WATERSEWERAGECHARGE);
        return res;
    }

    /**
     * waterMeterBillAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWatermeterbillamount() {
        String res = getStringOrNull(TaxdetailColumns.WATERMETERBILLAMOUNT);
        return res;
    }

    /**
     * arrearAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getArrearamount() {
        String res = getStringOrNull(TaxdetailColumns.ARREARAMOUNT);
        return res;
    }

    /**
     * advancePaidAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdvancepaidamount() {
        String res = getStringOrNull(TaxdetailColumns.ADVANCEPAIDAMOUNT);
        return res;
    }

    /**
     * rebateAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRebateamount() {
        String res = getStringOrNull(TaxdetailColumns.REBATEAMOUNT);
        return res;
    }

    /**
     * adjustmentAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdjustmentamount() {
        String res = getStringOrNull(TaxdetailColumns.ADJUSTMENTAMOUNT);
        return res;
    }

    /**
     * totalPropertyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTotalpropertytax() {
        String res = getStringOrNull(TaxdetailColumns.TOTALPROPERTYTAX);
        return res;
    }

    /**
     * serviceTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getServicetax() {
        String res = getStringOrNull(TaxdetailColumns.SERVICETAX);
        return res;
    }

    /**
     * otherTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getOthertax() {
        String res = getStringOrNull(TaxdetailColumns.OTHERTAX);
        return res;
    }

    /**
     * grandTotal.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGrandtotal() {
        String res = getStringOrNull(TaxdetailColumns.GRANDTOTAL);
        return res;
    }

    /**
     * delayPaymentCharges.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDelaypaymentcharges() {
        String res = getStringOrNull(TaxdetailColumns.DELAYPAYMENTCHARGES);
        return res;
    }

    /**
     * payableAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPayableamount() {
        String res = getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT);
        return res;
    }

    /**
     * dueDate.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDuedate() {
        String res = getStringOrNull(TaxdetailColumns.DUEDATE);
        return res;
    }

    /**
     * noticeGenerated.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNoticegenerated() {
        String res = getStringOrNull(TaxdetailColumns.NOTICEGENERATED);
        return res;
    }

    /**
     * objectionStatus.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getObjectionstatus() {
        String res = getStringOrNull(TaxdetailColumns.OBJECTIONSTATUS);
        return res;
    }
}
