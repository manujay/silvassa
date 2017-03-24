package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.database.Cursor;
import android.support.annotation.NonNull;

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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        String res = getStringOrNull(TaxdetailColumns.TAXNO);
        if (res == null)
            throw new NullPointerException("The value of 'taxno' in the database was null, which is not allowed according to the model definition");
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getFinancialyear() {
        String res = getStringOrNull(TaxdetailColumns.FINANCIALYEAR);
        if (res == null)
            throw new NullPointerException("The value of 'financialyear' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * propertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertytax() {
        String res = getStringOrNull(TaxdetailColumns.PROPERTYTAX);
        if (res == null)
            throw new NullPointerException("The value of 'propertytax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * waterTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWatertax() {
        String res = getStringOrNull(TaxdetailColumns.WATERTAX);
        if (res == null)
            throw new NullPointerException("The value of 'watertax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * conservancyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getConservancytax() {
        String res = getStringOrNull(TaxdetailColumns.CONSERVANCYTAX);
        if (res == null)
            throw new NullPointerException("The value of 'conservancytax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * waterSewerageCharge.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWaterseweragecharge() {
        String res = getStringOrNull(TaxdetailColumns.WATERSEWERAGECHARGE);
        if (res == null)
            throw new NullPointerException("The value of 'waterseweragecharge' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * waterMeterBillAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWatermeterbillamount() {
        String res = getStringOrNull(TaxdetailColumns.WATERMETERBILLAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'watermeterbillamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * arrearAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getArrearamount() {
        String res = getStringOrNull(TaxdetailColumns.ARREARAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'arrearamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * advancePaidAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAdvancepaidamount() {
        String res = getStringOrNull(TaxdetailColumns.ADVANCEPAIDAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'advancepaidamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * rebateAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getRebateamount() {
        String res = getStringOrNull(TaxdetailColumns.REBATEAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'rebateamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * adjustmentAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAdjustmentamount() {
        String res = getStringOrNull(TaxdetailColumns.ADJUSTMENTAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'adjustmentamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * totalPropertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTotalpropertytax() {
        String res = getStringOrNull(TaxdetailColumns.TOTALPROPERTYTAX);
        if (res == null)
            throw new NullPointerException("The value of 'totalpropertytax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * serviceTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getServicetax() {
        String res = getStringOrNull(TaxdetailColumns.SERVICETAX);
        if (res == null)
            throw new NullPointerException("The value of 'servicetax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * otherTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOthertax() {
        String res = getStringOrNull(TaxdetailColumns.OTHERTAX);
        if (res == null)
            throw new NullPointerException("The value of 'othertax' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * grandTotal.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getGrandtotal() {
        String res = getStringOrNull(TaxdetailColumns.GRANDTOTAL);
        if (res == null)
            throw new NullPointerException("The value of 'grandtotal' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * delayPaymentCharges.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDelaypaymentcharges() {
        String res = getStringOrNull(TaxdetailColumns.DELAYPAYMENTCHARGES);
        if (res == null)
            throw new NullPointerException("The value of 'delaypaymentcharges' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * payableAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPayableamount() {
        String res = getStringOrNull(TaxdetailColumns.PAYABLEAMOUNT);
        if (res == null)
            throw new NullPointerException("The value of 'payableamount' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * dueDate.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDuedate() {
        String res = getStringOrNull(TaxdetailColumns.DUEDATE);
        if (res == null)
            throw new NullPointerException("The value of 'duedate' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * noticeGenerated.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getNoticegenerated() {
        String res = getStringOrNull(TaxdetailColumns.NOTICEGENERATED);
        if (res == null)
            throw new NullPointerException("The value of 'noticegenerated' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * objectionStatus.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getObjectionstatus() {
        String res = getStringOrNull(TaxdetailColumns.OBJECTIONSTATUS);
        if (res == null)
            throw new NullPointerException("The value of 'objectionstatus' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
