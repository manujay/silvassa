package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * TaxDetail Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class TaxdetailBean implements TaxdetailModel {
    private long mId;
    private String mTaxno;
    private String mPropertyid;
    private String mFinancialyear;
    private String mPropertytax;
    private String mWatertax;
    private String mConservancytax;
    private String mWaterseweragecharge;
    private String mWatermeterbillamount;
    private String mArrearamount;
    private String mAdvancepaidamount;
    private String mRebateamount;
    private String mAdjustmentamount;
    private String mTotalpropertytax;
    private String mServicetax;
    private String mOthertax;
    private String mGrandtotal;
    private String mDelaypaymentcharges;
    private String mPayableamount;
    private String mDuedate;
    private String mNoticegenerated;
    private String mObjectionstatus;

    /**
     * Instantiate a new TaxdetailBean with specified values.
     */
    @NonNull
    public static TaxdetailBean newInstance(long id, @Nullable String taxno, @NonNull String propertyid, @Nullable String financialyear, @Nullable String propertytax, @Nullable String watertax, @Nullable String conservancytax, @Nullable String waterseweragecharge, @Nullable String watermeterbillamount, @Nullable String arrearamount, @Nullable String advancepaidamount, @Nullable String rebateamount, @Nullable String adjustmentamount, @Nullable String totalpropertytax, @Nullable String servicetax, @Nullable String othertax, @Nullable String grandtotal, @Nullable String delaypaymentcharges, @Nullable String payableamount, @Nullable String duedate, @Nullable String noticegenerated, @Nullable String objectionstatus) {
        if (propertyid == null) throw new IllegalArgumentException("propertyid must not be null");
        TaxdetailBean res = new TaxdetailBean();
        res.mId = id;
        res.mTaxno = taxno;
        res.mPropertyid = propertyid;
        res.mFinancialyear = financialyear;
        res.mPropertytax = propertytax;
        res.mWatertax = watertax;
        res.mConservancytax = conservancytax;
        res.mWaterseweragecharge = waterseweragecharge;
        res.mWatermeterbillamount = watermeterbillamount;
        res.mArrearamount = arrearamount;
        res.mAdvancepaidamount = advancepaidamount;
        res.mRebateamount = rebateamount;
        res.mAdjustmentamount = adjustmentamount;
        res.mTotalpropertytax = totalpropertytax;
        res.mServicetax = servicetax;
        res.mOthertax = othertax;
        res.mGrandtotal = grandtotal;
        res.mDelaypaymentcharges = delaypaymentcharges;
        res.mPayableamount = payableamount;
        res.mDuedate = duedate;
        res.mNoticegenerated = noticegenerated;
        res.mObjectionstatus = objectionstatus;
        return res;
    }

    /**
     * Instantiate a new TaxdetailBean with all the values copied from the given model.
     */
    @NonNull
    public static TaxdetailBean copy(@NonNull TaxdetailModel from) {
        TaxdetailBean res = new TaxdetailBean();
        res.mId = from.getId();
        res.mTaxno = from.getTaxno();
        res.mPropertyid = from.getPropertyid();
        res.mFinancialyear = from.getFinancialyear();
        res.mPropertytax = from.getPropertytax();
        res.mWatertax = from.getWatertax();
        res.mConservancytax = from.getConservancytax();
        res.mWaterseweragecharge = from.getWaterseweragecharge();
        res.mWatermeterbillamount = from.getWatermeterbillamount();
        res.mArrearamount = from.getArrearamount();
        res.mAdvancepaidamount = from.getAdvancepaidamount();
        res.mRebateamount = from.getRebateamount();
        res.mAdjustmentamount = from.getAdjustmentamount();
        res.mTotalpropertytax = from.getTotalpropertytax();
        res.mServicetax = from.getServicetax();
        res.mOthertax = from.getOthertax();
        res.mGrandtotal = from.getGrandtotal();
        res.mDelaypaymentcharges = from.getDelaypaymentcharges();
        res.mPayableamount = from.getPayableamount();
        res.mDuedate = from.getDuedate();
        res.mNoticegenerated = from.getNoticegenerated();
        res.mObjectionstatus = from.getObjectionstatus();
        return res;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Primary key.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * taxNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTaxno() {
        return mTaxno;
    }

    /**
     * taxNo.
     * Can be {@code null}.
     */
    public void setTaxno(@Nullable String taxno) {
        mTaxno = taxno;
    }

    /**
     * propertyId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyid() {
        return mPropertyid;
    }

    /**
     * propertyId.
     * Must not be {@code null}.
     */
    public void setPropertyid(@NonNull String propertyid) {
        if (propertyid == null) throw new IllegalArgumentException("propertyid must not be null");
        mPropertyid = propertyid;
    }

    /**
     * financialYear.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFinancialyear() {
        return mFinancialyear;
    }

    /**
     * financialYear.
     * Can be {@code null}.
     */
    public void setFinancialyear(@Nullable String financialyear) {
        mFinancialyear = financialyear;
    }

    /**
     * propertyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertytax() {
        return mPropertytax;
    }

    /**
     * propertyTax.
     * Can be {@code null}.
     */
    public void setPropertytax(@Nullable String propertytax) {
        mPropertytax = propertytax;
    }

    /**
     * waterTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWatertax() {
        return mWatertax;
    }

    /**
     * waterTax.
     * Can be {@code null}.
     */
    public void setWatertax(@Nullable String watertax) {
        mWatertax = watertax;
    }

    /**
     * conservancyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getConservancytax() {
        return mConservancytax;
    }

    /**
     * conservancyTax.
     * Can be {@code null}.
     */
    public void setConservancytax(@Nullable String conservancytax) {
        mConservancytax = conservancytax;
    }

    /**
     * waterSewerageCharge.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWaterseweragecharge() {
        return mWaterseweragecharge;
    }

    /**
     * waterSewerageCharge.
     * Can be {@code null}.
     */
    public void setWaterseweragecharge(@Nullable String waterseweragecharge) {
        mWaterseweragecharge = waterseweragecharge;
    }

    /**
     * waterMeterBillAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWatermeterbillamount() {
        return mWatermeterbillamount;
    }

    /**
     * waterMeterBillAmount.
     * Can be {@code null}.
     */
    public void setWatermeterbillamount(@Nullable String watermeterbillamount) {
        mWatermeterbillamount = watermeterbillamount;
    }

    /**
     * arrearAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getArrearamount() {
        return mArrearamount;
    }

    /**
     * arrearAmount.
     * Can be {@code null}.
     */
    public void setArrearamount(@Nullable String arrearamount) {
        mArrearamount = arrearamount;
    }

    /**
     * advancePaidAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdvancepaidamount() {
        return mAdvancepaidamount;
    }

    /**
     * advancePaidAmount.
     * Can be {@code null}.
     */
    public void setAdvancepaidamount(@Nullable String advancepaidamount) {
        mAdvancepaidamount = advancepaidamount;
    }

    /**
     * rebateAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRebateamount() {
        return mRebateamount;
    }

    /**
     * rebateAmount.
     * Can be {@code null}.
     */
    public void setRebateamount(@Nullable String rebateamount) {
        mRebateamount = rebateamount;
    }

    /**
     * adjustmentAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdjustmentamount() {
        return mAdjustmentamount;
    }

    /**
     * adjustmentAmount.
     * Can be {@code null}.
     */
    public void setAdjustmentamount(@Nullable String adjustmentamount) {
        mAdjustmentamount = adjustmentamount;
    }

    /**
     * totalPropertyTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTotalpropertytax() {
        return mTotalpropertytax;
    }

    /**
     * totalPropertyTax.
     * Can be {@code null}.
     */
    public void setTotalpropertytax(@Nullable String totalpropertytax) {
        mTotalpropertytax = totalpropertytax;
    }

    /**
     * serviceTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getServicetax() {
        return mServicetax;
    }

    /**
     * serviceTax.
     * Can be {@code null}.
     */
    public void setServicetax(@Nullable String servicetax) {
        mServicetax = servicetax;
    }

    /**
     * otherTax.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getOthertax() {
        return mOthertax;
    }

    /**
     * otherTax.
     * Can be {@code null}.
     */
    public void setOthertax(@Nullable String othertax) {
        mOthertax = othertax;
    }

    /**
     * grandTotal.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGrandtotal() {
        return mGrandtotal;
    }

    /**
     * grandTotal.
     * Can be {@code null}.
     */
    public void setGrandtotal(@Nullable String grandtotal) {
        mGrandtotal = grandtotal;
    }

    /**
     * delayPaymentCharges.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDelaypaymentcharges() {
        return mDelaypaymentcharges;
    }

    /**
     * delayPaymentCharges.
     * Can be {@code null}.
     */
    public void setDelaypaymentcharges(@Nullable String delaypaymentcharges) {
        mDelaypaymentcharges = delaypaymentcharges;
    }

    /**
     * payableAmount.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPayableamount() {
        return mPayableamount;
    }

    /**
     * payableAmount.
     * Can be {@code null}.
     */
    public void setPayableamount(@Nullable String payableamount) {
        mPayableamount = payableamount;
    }

    /**
     * dueDate.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDuedate() {
        return mDuedate;
    }

    /**
     * dueDate.
     * Can be {@code null}.
     */
    public void setDuedate(@Nullable String duedate) {
        mDuedate = duedate;
    }

    /**
     * noticeGenerated.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNoticegenerated() {
        return mNoticegenerated;
    }

    /**
     * noticeGenerated.
     * Can be {@code null}.
     */
    public void setNoticegenerated(@Nullable String noticegenerated) {
        mNoticegenerated = noticegenerated;
    }

    /**
     * objectionStatus.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getObjectionstatus() {
        return mObjectionstatus;
    }

    /**
     * objectionStatus.
     * Can be {@code null}.
     */
    public void setObjectionstatus(@Nullable String objectionstatus) {
        mObjectionstatus = objectionstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxdetailBean bean = (TaxdetailBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private TaxdetailBean mRes = new TaxdetailBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * taxNo.
         * Can be {@code null}.
         */
        public Builder taxno(@Nullable String taxno) {
            mRes.mTaxno = taxno;
            return this;
        }

        /**
         * propertyId.
         * Must not be {@code null}.
         */
        public Builder propertyid(@NonNull String propertyid) {
            if (propertyid == null)
                throw new IllegalArgumentException("propertyid must not be null");
            mRes.mPropertyid = propertyid;
            return this;
        }

        /**
         * financialYear.
         * Can be {@code null}.
         */
        public Builder financialyear(@Nullable String financialyear) {
            mRes.mFinancialyear = financialyear;
            return this;
        }

        /**
         * propertyTax.
         * Can be {@code null}.
         */
        public Builder propertytax(@Nullable String propertytax) {
            mRes.mPropertytax = propertytax;
            return this;
        }

        /**
         * waterTax.
         * Can be {@code null}.
         */
        public Builder watertax(@Nullable String watertax) {
            mRes.mWatertax = watertax;
            return this;
        }

        /**
         * conservancyTax.
         * Can be {@code null}.
         */
        public Builder conservancytax(@Nullable String conservancytax) {
            mRes.mConservancytax = conservancytax;
            return this;
        }

        /**
         * waterSewerageCharge.
         * Can be {@code null}.
         */
        public Builder waterseweragecharge(@Nullable String waterseweragecharge) {
            mRes.mWaterseweragecharge = waterseweragecharge;
            return this;
        }

        /**
         * waterMeterBillAmount.
         * Can be {@code null}.
         */
        public Builder watermeterbillamount(@Nullable String watermeterbillamount) {
            mRes.mWatermeterbillamount = watermeterbillamount;
            return this;
        }

        /**
         * arrearAmount.
         * Can be {@code null}.
         */
        public Builder arrearamount(@Nullable String arrearamount) {
            mRes.mArrearamount = arrearamount;
            return this;
        }

        /**
         * advancePaidAmount.
         * Can be {@code null}.
         */
        public Builder advancepaidamount(@Nullable String advancepaidamount) {
            mRes.mAdvancepaidamount = advancepaidamount;
            return this;
        }

        /**
         * rebateAmount.
         * Can be {@code null}.
         */
        public Builder rebateamount(@Nullable String rebateamount) {
            mRes.mRebateamount = rebateamount;
            return this;
        }

        /**
         * adjustmentAmount.
         * Can be {@code null}.
         */
        public Builder adjustmentamount(@Nullable String adjustmentamount) {
            mRes.mAdjustmentamount = adjustmentamount;
            return this;
        }

        /**
         * totalPropertyTax.
         * Can be {@code null}.
         */
        public Builder totalpropertytax(@Nullable String totalpropertytax) {
            mRes.mTotalpropertytax = totalpropertytax;
            return this;
        }

        /**
         * serviceTax.
         * Can be {@code null}.
         */
        public Builder servicetax(@Nullable String servicetax) {
            mRes.mServicetax = servicetax;
            return this;
        }

        /**
         * otherTax.
         * Can be {@code null}.
         */
        public Builder othertax(@Nullable String othertax) {
            mRes.mOthertax = othertax;
            return this;
        }

        /**
         * grandTotal.
         * Can be {@code null}.
         */
        public Builder grandtotal(@Nullable String grandtotal) {
            mRes.mGrandtotal = grandtotal;
            return this;
        }

        /**
         * delayPaymentCharges.
         * Can be {@code null}.
         */
        public Builder delaypaymentcharges(@Nullable String delaypaymentcharges) {
            mRes.mDelaypaymentcharges = delaypaymentcharges;
            return this;
        }

        /**
         * payableAmount.
         * Can be {@code null}.
         */
        public Builder payableamount(@Nullable String payableamount) {
            mRes.mPayableamount = payableamount;
            return this;
        }

        /**
         * dueDate.
         * Can be {@code null}.
         */
        public Builder duedate(@Nullable String duedate) {
            mRes.mDuedate = duedate;
            return this;
        }

        /**
         * noticeGenerated.
         * Can be {@code null}.
         */
        public Builder noticegenerated(@Nullable String noticegenerated) {
            mRes.mNoticegenerated = noticegenerated;
            return this;
        }

        /**
         * objectionStatus.
         * Can be {@code null}.
         */
        public Builder objectionstatus(@Nullable String objectionstatus) {
            mRes.mObjectionstatus = objectionstatus;
            return this;
        }

        /**
         * Get a new TaxdetailBean built with the given values.
         */
        public TaxdetailBean build() {
            if (mRes.mPropertyid == null)
                throw new IllegalArgumentException("propertyid must not be null");
            return mRes;
        }
    }
}
