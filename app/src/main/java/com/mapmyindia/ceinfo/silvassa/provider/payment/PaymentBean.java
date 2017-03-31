package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Payment Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class PaymentBean implements PaymentModel {
    private long mId;
    private String mUserid;
    private String mPropertyuniqueid;
    private String mTaxno;
    private String mMode;
    private String mAmount;
    private String mPdate;

    /**
     * Instantiate a new PaymentBean with specified values.
     */
    @NonNull
    public static PaymentBean newInstance(long id, @NonNull String userid, @NonNull String propertyuniqueid, @NonNull String taxno, @NonNull String mode, @NonNull String amount, @NonNull String pdate) {
        if (userid == null) throw new IllegalArgumentException("userid must not be null");
        if (propertyuniqueid == null)
            throw new IllegalArgumentException("propertyuniqueid must not be null");
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
        if (mode == null) throw new IllegalArgumentException("mode must not be null");
        if (amount == null) throw new IllegalArgumentException("amount must not be null");
        if (pdate == null) throw new IllegalArgumentException("pdate must not be null");
        PaymentBean res = new PaymentBean();
        res.mId = id;
        res.mUserid = userid;
        res.mPropertyuniqueid = propertyuniqueid;
        res.mTaxno = taxno;
        res.mMode = mode;
        res.mAmount = amount;
        res.mPdate = pdate;
        return res;
    }

    /**
     * Instantiate a new PaymentBean with all the values copied from the given model.
     */
    @NonNull
    public static PaymentBean copy(@NonNull PaymentModel from) {
        PaymentBean res = new PaymentBean();
        res.mId = from.getId();
        res.mUserid = from.getUserid();
        res.mPropertyuniqueid = from.getPropertyuniqueid();
        res.mTaxno = from.getTaxno();
        res.mMode = from.getMode();
        res.mAmount = from.getAmount();
        res.mPdate = from.getPdate();
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
     * UserId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getUserid() {
        return mUserid;
    }

    /**
     * UserId.
     * Must not be {@code null}.
     */
    public void setUserid(@NonNull String userid) {
        if (userid == null) throw new IllegalArgumentException("userid must not be null");
        mUserid = userid;
    }

    /**
     * propertyUniqueId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyuniqueid() {
        return mPropertyuniqueid;
    }

    /**
     * propertyUniqueId.
     * Must not be {@code null}.
     */
    public void setPropertyuniqueid(@NonNull String propertyuniqueid) {
        if (propertyuniqueid == null)
            throw new IllegalArgumentException("propertyuniqueid must not be null");
        mPropertyuniqueid = propertyuniqueid;
    }

    /**
     * TaxNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        return mTaxno;
    }

    /**
     * TaxNo.
     * Must not be {@code null}.
     */
    public void setTaxno(@NonNull String taxno) {
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
        mTaxno = taxno;
    }

    /**
     * mode
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getMode() {
        return mMode;
    }

    /**
     * mode
     * Must not be {@code null}.
     */
    public void setMode(@NonNull String mode) {
        if (mode == null) throw new IllegalArgumentException("mode must not be null");
        mMode = mode;
    }

    /**
     * Amount
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getAmount() {
        return mAmount;
    }

    /**
     * Amount
     * Must not be {@code null}.
     */
    public void setAmount(@NonNull String amount) {
        if (amount == null) throw new IllegalArgumentException("amount must not be null");
        mAmount = amount;
    }

    /**
     * PaymentDate
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPdate() {
        return mPdate;
    }

    /**
     * PaymentDate
     * Must not be {@code null}.
     */
    public void setPdate(@NonNull String pdate) {
        if (pdate == null) throw new IllegalArgumentException("pdate must not be null");
        mPdate = pdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentBean bean = (PaymentBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private PaymentBean mRes = new PaymentBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * UserId.
         * Must not be {@code null}.
         */
        public Builder userid(@NonNull String userid) {
            if (userid == null) throw new IllegalArgumentException("userid must not be null");
            mRes.mUserid = userid;
            return this;
        }

        /**
         * propertyUniqueId.
         * Must not be {@code null}.
         */
        public Builder propertyuniqueid(@NonNull String propertyuniqueid) {
            if (propertyuniqueid == null)
                throw new IllegalArgumentException("propertyuniqueid must not be null");
            mRes.mPropertyuniqueid = propertyuniqueid;
            return this;
        }

        /**
         * TaxNo.
         * Must not be {@code null}.
         */
        public Builder taxno(@NonNull String taxno) {
            if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
            mRes.mTaxno = taxno;
            return this;
        }

        /**
         * mode
         * Must not be {@code null}.
         */
        public Builder mode(@NonNull String mode) {
            if (mode == null) throw new IllegalArgumentException("mode must not be null");
            mRes.mMode = mode;
            return this;
        }

        /**
         * Amount
         * Must not be {@code null}.
         */
        public Builder amount(@NonNull String amount) {
            if (amount == null) throw new IllegalArgumentException("amount must not be null");
            mRes.mAmount = amount;
            return this;
        }

        /**
         * PaymentDate
         * Must not be {@code null}.
         */
        public Builder pdate(@NonNull String pdate) {
            if (pdate == null) throw new IllegalArgumentException("pdate must not be null");
            mRes.mPdate = pdate;
            return this;
        }

        /**
         * Get a new PaymentBean built with the given values.
         */
        public PaymentBean build() {
            if (mRes.mUserid == null) throw new IllegalArgumentException("userid must not be null");
            if (mRes.mPropertyuniqueid == null)
                throw new IllegalArgumentException("propertyuniqueid must not be null");
            if (mRes.mTaxno == null) throw new IllegalArgumentException("taxno must not be null");
            if (mRes.mMode == null) throw new IllegalArgumentException("mode must not be null");
            if (mRes.mAmount == null) throw new IllegalArgumentException("amount must not be null");
            if (mRes.mPdate == null) throw new IllegalArgumentException("pdate must not be null");
            return mRes;
        }
    }
}
