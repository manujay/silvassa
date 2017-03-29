package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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
     * Can be {@code null}.
     */
    @Nullable
    String getTaxno();

    /**
     * propertyId.
     * Cannot be {@code null}.
     */
    @NonNull
    String getPropertyid();

    /**
     * financialYear.
     * Can be {@code null}.
     */
    @Nullable
    String getFinancialyear();

    /**
     * propertyTax.
     * Can be {@code null}.
     */
    @Nullable
    String getPropertytax();

    /**
     * waterTax.
     * Can be {@code null}.
     */
    @Nullable
    String getWatertax();

    /**
     * conservancyTax.
     * Can be {@code null}.
     */
    @Nullable
    String getConservancytax();

    /**
     * waterSewerageCharge.
     * Can be {@code null}.
     */
    @Nullable
    String getWaterseweragecharge();

    /**
     * waterMeterBillAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getWatermeterbillamount();

    /**
     * arrearAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getArrearamount();

    /**
     * advancePaidAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getAdvancepaidamount();

    /**
     * rebateAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getRebateamount();

    /**
     * adjustmentAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getAdjustmentamount();

    /**
     * totalPropertyTax.
     * Can be {@code null}.
     */
    @Nullable
    String getTotalpropertytax();

    /**
     * serviceTax.
     * Can be {@code null}.
     */
    @Nullable
    String getServicetax();

    /**
     * otherTax.
     * Can be {@code null}.
     */
    @Nullable
    String getOthertax();

    /**
     * grandTotal.
     * Can be {@code null}.
     */
    @Nullable
    String getGrandtotal();

    /**
     * delayPaymentCharges.
     * Can be {@code null}.
     */
    @Nullable
    String getDelaypaymentcharges();

    /**
     * payableAmount.
     * Can be {@code null}.
     */
    @Nullable
    String getPayableamount();

    /**
     * dueDate.
     * Can be {@code null}.
     */
    @Nullable
    String getDuedate();

    /**
     * noticeGenerated.
     * Can be {@code null}.
     */
    @Nullable
    String getNoticegenerated();

    /**
     * objectionStatus.
     * Can be {@code null}.
     */
    @Nullable
    String getObjectionstatus();
}
