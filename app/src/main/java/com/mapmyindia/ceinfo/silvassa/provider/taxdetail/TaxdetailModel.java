package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.support.annotation.NonNull;

import com.mapmyindia.ceinfo.silvassa.provider.base.BaseModel;

/**
 * TaxDetail Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface TaxdetailModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * taxNo.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTaxno();

    /**
     * propertyId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyid();

    /**
     * financialYear.
     * Cannot be {@code null}.
     */
    @NonNull
    String getFinancialyear();

    /**
     * propertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertytax();

    /**
     * waterTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getWatertax();

    /**
     * conservancyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getConservancytax();

    /**
     * waterSewerageCharge.
     * Cannot be {@code null}.
     */
    @NonNull
    String getWaterseweragecharge();

    /**
     * waterMeterBillAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getWatermeterbillamount();

    /**
     * arrearAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getArrearamount();

    /**
     * advancePaidAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getAdvancepaidamount();

    /**
     * rebateAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getRebateamount();

    /**
     * adjustmentAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getAdjustmentamount();

    /**
     * totalPropertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getTotalpropertytax();

    /**
     * serviceTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getServicetax();

    /**
     * otherTax.
     * Cannot be {@code null}.
     */
    @NonNull
    String getOthertax();

    /**
     * grandTotal.
     * Cannot be {@code null}.
     */
    @NonNull
    String getGrandtotal();

    /**
     * delayPaymentCharges.
     * Cannot be {@code null}.
     */
    @NonNull
    String getDelaypaymentcharges();

    /**
     * payableAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPayableamount();

    /**
     * dueDate.
     * Cannot be {@code null}.
     */
    @NonNull
    String getDuedate();

    /**
     * noticeGenerated.
     * Cannot be {@code null}.
     */
    @NonNull
    String getNoticegenerated();

    /**
     * objectionStatus.
     * Cannot be {@code null}.
     */
    @NonNull
    String getObjectionstatus();
}
