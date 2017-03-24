package com.mapmyindia.ceinfo.silvassa.provider.taxdetail;

// @formatter:off

import android.support.annotation.NonNull;

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
    public static TaxdetailBean newInstance(long id, @NonNull String taxno, @NonNull String propertyid, @NonNull String financialyear, @NonNull String propertytax, @NonNull String watertax, @NonNull String conservancytax, @NonNull String waterseweragecharge, @NonNull String watermeterbillamount, @NonNull String arrearamount, @NonNull String advancepaidamount, @NonNull String rebateamount, @NonNull String adjustmentamount, @NonNull String totalpropertytax, @NonNull String servicetax, @NonNull String othertax, @NonNull String grandtotal, @NonNull String delaypaymentcharges, @NonNull String payableamount, @NonNull String duedate, @NonNull String noticegenerated, @NonNull String objectionstatus) {
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
        if (propertyid == null) throw new IllegalArgumentException("propertyid must not be null");
        if (financialyear == null)
            throw new IllegalArgumentException("financialyear must not be null");
        if (propertytax == null) throw new IllegalArgumentException("propertytax must not be null");
        if (watertax == null) throw new IllegalArgumentException("watertax must not be null");
        if (conservancytax == null)
            throw new IllegalArgumentException("conservancytax must not be null");
        if (waterseweragecharge == null)
            throw new IllegalArgumentException("waterseweragecharge must not be null");
        if (watermeterbillamount == null)
            throw new IllegalArgumentException("watermeterbillamount must not be null");
        if (arrearamount == null)
            throw new IllegalArgumentException("arrearamount must not be null");
        if (advancepaidamount == null)
            throw new IllegalArgumentException("advancepaidamount must not be null");
        if (rebateamount == null)
            throw new IllegalArgumentException("rebateamount must not be null");
        if (adjustmentamount == null)
            throw new IllegalArgumentException("adjustmentamount must not be null");
        if (totalpropertytax == null)
            throw new IllegalArgumentException("totalpropertytax must not be null");
        if (servicetax == null) throw new IllegalArgumentException("servicetax must not be null");
        if (othertax == null) throw new IllegalArgumentException("othertax must not be null");
        if (grandtotal == null) throw new IllegalArgumentException("grandtotal must not be null");
        if (delaypaymentcharges == null)
            throw new IllegalArgumentException("delaypaymentcharges must not be null");
        if (payableamount == null)
            throw new IllegalArgumentException("payableamount must not be null");
        if (duedate == null) throw new IllegalArgumentException("duedate must not be null");
        if (noticegenerated == null)
            throw new IllegalArgumentException("noticegenerated must not be null");
        if (objectionstatus == null)
            throw new IllegalArgumentException("objectionstatus must not be null");
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        return mTaxno;
    }

    /**
     * taxNo.
     * Must not be {@code null}.
     */
    public void setTaxno(@NonNull String taxno) {
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getFinancialyear() {
        return mFinancialyear;
    }

    /**
     * financialYear.
     * Must not be {@code null}.
     */
    public void setFinancialyear(@NonNull String financialyear) {
        if (financialyear == null)
            throw new IllegalArgumentException("financialyear must not be null");
        mFinancialyear = financialyear;
    }

    /**
     * propertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertytax() {
        return mPropertytax;
    }

    /**
     * propertyTax.
     * Must not be {@code null}.
     */
    public void setPropertytax(@NonNull String propertytax) {
        if (propertytax == null) throw new IllegalArgumentException("propertytax must not be null");
        mPropertytax = propertytax;
    }

    /**
     * waterTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWatertax() {
        return mWatertax;
    }

    /**
     * waterTax.
     * Must not be {@code null}.
     */
    public void setWatertax(@NonNull String watertax) {
        if (watertax == null) throw new IllegalArgumentException("watertax must not be null");
        mWatertax = watertax;
    }

    /**
     * conservancyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getConservancytax() {
        return mConservancytax;
    }

    /**
     * conservancyTax.
     * Must not be {@code null}.
     */
    public void setConservancytax(@NonNull String conservancytax) {
        if (conservancytax == null)
            throw new IllegalArgumentException("conservancytax must not be null");
        mConservancytax = conservancytax;
    }

    /**
     * waterSewerageCharge.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWaterseweragecharge() {
        return mWaterseweragecharge;
    }

    /**
     * waterSewerageCharge.
     * Must not be {@code null}.
     */
    public void setWaterseweragecharge(@NonNull String waterseweragecharge) {
        if (waterseweragecharge == null)
            throw new IllegalArgumentException("waterseweragecharge must not be null");
        mWaterseweragecharge = waterseweragecharge;
    }

    /**
     * waterMeterBillAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getWatermeterbillamount() {
        return mWatermeterbillamount;
    }

    /**
     * waterMeterBillAmount.
     * Must not be {@code null}.
     */
    public void setWatermeterbillamount(@NonNull String watermeterbillamount) {
        if (watermeterbillamount == null)
            throw new IllegalArgumentException("watermeterbillamount must not be null");
        mWatermeterbillamount = watermeterbillamount;
    }

    /**
     * arrearAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getArrearamount() {
        return mArrearamount;
    }

    /**
     * arrearAmount.
     * Must not be {@code null}.
     */
    public void setArrearamount(@NonNull String arrearamount) {
        if (arrearamount == null)
            throw new IllegalArgumentException("arrearamount must not be null");
        mArrearamount = arrearamount;
    }

    /**
     * advancePaidAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAdvancepaidamount() {
        return mAdvancepaidamount;
    }

    /**
     * advancePaidAmount.
     * Must not be {@code null}.
     */
    public void setAdvancepaidamount(@NonNull String advancepaidamount) {
        if (advancepaidamount == null)
            throw new IllegalArgumentException("advancepaidamount must not be null");
        mAdvancepaidamount = advancepaidamount;
    }

    /**
     * rebateAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getRebateamount() {
        return mRebateamount;
    }

    /**
     * rebateAmount.
     * Must not be {@code null}.
     */
    public void setRebateamount(@NonNull String rebateamount) {
        if (rebateamount == null)
            throw new IllegalArgumentException("rebateamount must not be null");
        mRebateamount = rebateamount;
    }

    /**
     * adjustmentAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAdjustmentamount() {
        return mAdjustmentamount;
    }

    /**
     * adjustmentAmount.
     * Must not be {@code null}.
     */
    public void setAdjustmentamount(@NonNull String adjustmentamount) {
        if (adjustmentamount == null)
            throw new IllegalArgumentException("adjustmentamount must not be null");
        mAdjustmentamount = adjustmentamount;
    }

    /**
     * totalPropertyTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTotalpropertytax() {
        return mTotalpropertytax;
    }

    /**
     * totalPropertyTax.
     * Must not be {@code null}.
     */
    public void setTotalpropertytax(@NonNull String totalpropertytax) {
        if (totalpropertytax == null)
            throw new IllegalArgumentException("totalpropertytax must not be null");
        mTotalpropertytax = totalpropertytax;
    }

    /**
     * serviceTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getServicetax() {
        return mServicetax;
    }

    /**
     * serviceTax.
     * Must not be {@code null}.
     */
    public void setServicetax(@NonNull String servicetax) {
        if (servicetax == null) throw new IllegalArgumentException("servicetax must not be null");
        mServicetax = servicetax;
    }

    /**
     * otherTax.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOthertax() {
        return mOthertax;
    }

    /**
     * otherTax.
     * Must not be {@code null}.
     */
    public void setOthertax(@NonNull String othertax) {
        if (othertax == null) throw new IllegalArgumentException("othertax must not be null");
        mOthertax = othertax;
    }

    /**
     * grandTotal.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getGrandtotal() {
        return mGrandtotal;
    }

    /**
     * grandTotal.
     * Must not be {@code null}.
     */
    public void setGrandtotal(@NonNull String grandtotal) {
        if (grandtotal == null) throw new IllegalArgumentException("grandtotal must not be null");
        mGrandtotal = grandtotal;
    }

    /**
     * delayPaymentCharges.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDelaypaymentcharges() {
        return mDelaypaymentcharges;
    }

    /**
     * delayPaymentCharges.
     * Must not be {@code null}.
     */
    public void setDelaypaymentcharges(@NonNull String delaypaymentcharges) {
        if (delaypaymentcharges == null)
            throw new IllegalArgumentException("delaypaymentcharges must not be null");
        mDelaypaymentcharges = delaypaymentcharges;
    }

    /**
     * payableAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPayableamount() {
        return mPayableamount;
    }

    /**
     * payableAmount.
     * Must not be {@code null}.
     */
    public void setPayableamount(@NonNull String payableamount) {
        if (payableamount == null)
            throw new IllegalArgumentException("payableamount must not be null");
        mPayableamount = payableamount;
    }

    /**
     * dueDate.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDuedate() {
        return mDuedate;
    }

    /**
     * dueDate.
     * Must not be {@code null}.
     */
    public void setDuedate(@NonNull String duedate) {
        if (duedate == null) throw new IllegalArgumentException("duedate must not be null");
        mDuedate = duedate;
    }

    /**
     * noticeGenerated.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getNoticegenerated() {
        return mNoticegenerated;
    }

    /**
     * noticeGenerated.
     * Must not be {@code null}.
     */
    public void setNoticegenerated(@NonNull String noticegenerated) {
        if (noticegenerated == null)
            throw new IllegalArgumentException("noticegenerated must not be null");
        mNoticegenerated = noticegenerated;
    }

    /**
     * objectionStatus.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getObjectionstatus() {
        return mObjectionstatus;
    }

    /**
     * objectionStatus.
     * Must not be {@code null}.
     */
    public void setObjectionstatus(@NonNull String objectionstatus) {
        if (objectionstatus == null)
            throw new IllegalArgumentException("objectionstatus must not be null");
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
         * Must not be {@code null}.
         */
        public Builder taxno(@NonNull String taxno) {
            if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
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
         * Must not be {@code null}.
         */
        public Builder financialyear(@NonNull String financialyear) {
            if (financialyear == null)
                throw new IllegalArgumentException("financialyear must not be null");
            mRes.mFinancialyear = financialyear;
            return this;
        }

        /**
         * propertyTax.
         * Must not be {@code null}.
         */
        public Builder propertytax(@NonNull String propertytax) {
            if (propertytax == null)
                throw new IllegalArgumentException("propertytax must not be null");
            mRes.mPropertytax = propertytax;
            return this;
        }

        /**
         * waterTax.
         * Must not be {@code null}.
         */
        public Builder watertax(@NonNull String watertax) {
            if (watertax == null) throw new IllegalArgumentException("watertax must not be null");
            mRes.mWatertax = watertax;
            return this;
        }

        /**
         * conservancyTax.
         * Must not be {@code null}.
         */
        public Builder conservancytax(@NonNull String conservancytax) {
            if (conservancytax == null)
                throw new IllegalArgumentException("conservancytax must not be null");
            mRes.mConservancytax = conservancytax;
            return this;
        }

        /**
         * waterSewerageCharge.
         * Must not be {@code null}.
         */
        public Builder waterseweragecharge(@NonNull String waterseweragecharge) {
            if (waterseweragecharge == null)
                throw new IllegalArgumentException("waterseweragecharge must not be null");
            mRes.mWaterseweragecharge = waterseweragecharge;
            return this;
        }

        /**
         * waterMeterBillAmount.
         * Must not be {@code null}.
         */
        public Builder watermeterbillamount(@NonNull String watermeterbillamount) {
            if (watermeterbillamount == null)
                throw new IllegalArgumentException("watermeterbillamount must not be null");
            mRes.mWatermeterbillamount = watermeterbillamount;
            return this;
        }

        /**
         * arrearAmount.
         * Must not be {@code null}.
         */
        public Builder arrearamount(@NonNull String arrearamount) {
            if (arrearamount == null)
                throw new IllegalArgumentException("arrearamount must not be null");
            mRes.mArrearamount = arrearamount;
            return this;
        }

        /**
         * advancePaidAmount.
         * Must not be {@code null}.
         */
        public Builder advancepaidamount(@NonNull String advancepaidamount) {
            if (advancepaidamount == null)
                throw new IllegalArgumentException("advancepaidamount must not be null");
            mRes.mAdvancepaidamount = advancepaidamount;
            return this;
        }

        /**
         * rebateAmount.
         * Must not be {@code null}.
         */
        public Builder rebateamount(@NonNull String rebateamount) {
            if (rebateamount == null)
                throw new IllegalArgumentException("rebateamount must not be null");
            mRes.mRebateamount = rebateamount;
            return this;
        }

        /**
         * adjustmentAmount.
         * Must not be {@code null}.
         */
        public Builder adjustmentamount(@NonNull String adjustmentamount) {
            if (adjustmentamount == null)
                throw new IllegalArgumentException("adjustmentamount must not be null");
            mRes.mAdjustmentamount = adjustmentamount;
            return this;
        }

        /**
         * totalPropertyTax.
         * Must not be {@code null}.
         */
        public Builder totalpropertytax(@NonNull String totalpropertytax) {
            if (totalpropertytax == null)
                throw new IllegalArgumentException("totalpropertytax must not be null");
            mRes.mTotalpropertytax = totalpropertytax;
            return this;
        }

        /**
         * serviceTax.
         * Must not be {@code null}.
         */
        public Builder servicetax(@NonNull String servicetax) {
            if (servicetax == null)
                throw new IllegalArgumentException("servicetax must not be null");
            mRes.mServicetax = servicetax;
            return this;
        }

        /**
         * otherTax.
         * Must not be {@code null}.
         */
        public Builder othertax(@NonNull String othertax) {
            if (othertax == null) throw new IllegalArgumentException("othertax must not be null");
            mRes.mOthertax = othertax;
            return this;
        }

        /**
         * grandTotal.
         * Must not be {@code null}.
         */
        public Builder grandtotal(@NonNull String grandtotal) {
            if (grandtotal == null)
                throw new IllegalArgumentException("grandtotal must not be null");
            mRes.mGrandtotal = grandtotal;
            return this;
        }

        /**
         * delayPaymentCharges.
         * Must not be {@code null}.
         */
        public Builder delaypaymentcharges(@NonNull String delaypaymentcharges) {
            if (delaypaymentcharges == null)
                throw new IllegalArgumentException("delaypaymentcharges must not be null");
            mRes.mDelaypaymentcharges = delaypaymentcharges;
            return this;
        }

        /**
         * payableAmount.
         * Must not be {@code null}.
         */
        public Builder payableamount(@NonNull String payableamount) {
            if (payableamount == null)
                throw new IllegalArgumentException("payableamount must not be null");
            mRes.mPayableamount = payableamount;
            return this;
        }

        /**
         * dueDate.
         * Must not be {@code null}.
         */
        public Builder duedate(@NonNull String duedate) {
            if (duedate == null) throw new IllegalArgumentException("duedate must not be null");
            mRes.mDuedate = duedate;
            return this;
        }

        /**
         * noticeGenerated.
         * Must not be {@code null}.
         */
        public Builder noticegenerated(@NonNull String noticegenerated) {
            if (noticegenerated == null)
                throw new IllegalArgumentException("noticegenerated must not be null");
            mRes.mNoticegenerated = noticegenerated;
            return this;
        }

        /**
         * objectionStatus.
         * Must not be {@code null}.
         */
        public Builder objectionstatus(@NonNull String objectionstatus) {
            if (objectionstatus == null)
                throw new IllegalArgumentException("objectionstatus must not be null");
            mRes.mObjectionstatus = objectionstatus;
            return this;
        }

        /**
         * Get a new TaxdetailBean built with the given values.
         */
        public TaxdetailBean build() {
            if (mRes.mTaxno == null) throw new IllegalArgumentException("taxno must not be null");
            if (mRes.mPropertyid == null)
                throw new IllegalArgumentException("propertyid must not be null");
            if (mRes.mFinancialyear == null)
                throw new IllegalArgumentException("financialyear must not be null");
            if (mRes.mPropertytax == null)
                throw new IllegalArgumentException("propertytax must not be null");
            if (mRes.mWatertax == null)
                throw new IllegalArgumentException("watertax must not be null");
            if (mRes.mConservancytax == null)
                throw new IllegalArgumentException("conservancytax must not be null");
            if (mRes.mWaterseweragecharge == null)
                throw new IllegalArgumentException("waterseweragecharge must not be null");
            if (mRes.mWatermeterbillamount == null)
                throw new IllegalArgumentException("watermeterbillamount must not be null");
            if (mRes.mArrearamount == null)
                throw new IllegalArgumentException("arrearamount must not be null");
            if (mRes.mAdvancepaidamount == null)
                throw new IllegalArgumentException("advancepaidamount must not be null");
            if (mRes.mRebateamount == null)
                throw new IllegalArgumentException("rebateamount must not be null");
            if (mRes.mAdjustmentamount == null)
                throw new IllegalArgumentException("adjustmentamount must not be null");
            if (mRes.mTotalpropertytax == null)
                throw new IllegalArgumentException("totalpropertytax must not be null");
            if (mRes.mServicetax == null)
                throw new IllegalArgumentException("servicetax must not be null");
            if (mRes.mOthertax == null)
                throw new IllegalArgumentException("othertax must not be null");
            if (mRes.mGrandtotal == null)
                throw new IllegalArgumentException("grandtotal must not be null");
            if (mRes.mDelaypaymentcharges == null)
                throw new IllegalArgumentException("delaypaymentcharges must not be null");
            if (mRes.mPayableamount == null)
                throw new IllegalArgumentException("payableamount must not be null");
            if (mRes.mDuedate == null)
                throw new IllegalArgumentException("duedate must not be null");
            if (mRes.mNoticegenerated == null)
                throw new IllegalArgumentException("noticegenerated must not be null");
            if (mRes.mObjectionstatus == null)
                throw new IllegalArgumentException("objectionstatus must not be null");
            return mRes;
        }
    }
}
