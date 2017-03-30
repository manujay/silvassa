package com.mapmyindia.ceinfo.silvassa.provider.payment;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Payment Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class PaymentBean implements PaymentModel {
    private long mId;
    private String mPropertyuniqueid;
    private String mTaxno;
    private String mMode;
    private String mPayableamount;
    private String mAmount;
    private String mCheuque;
    private String mDd;
    private String mPos;
    private String mEmail;
    private String mPhone;
    private String mPdate;

    /**
     * Instantiate a new PaymentBean with specified values.
     */
    @NonNull
    public static PaymentBean newInstance(long id, @NonNull String propertyuniqueid, @NonNull String taxno, @NonNull String mode, @NonNull String payableamount, @NonNull String amount, @NonNull String cheuque, @NonNull String dd, @NonNull String pos, @NonNull String email, @NonNull String phone, @NonNull String pdate) {
        if (propertyuniqueid == null)
            throw new IllegalArgumentException("propertyuniqueid must not be null");
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
        if (mode == null) throw new IllegalArgumentException("mode must not be null");
        if (payableamount == null)
            throw new IllegalArgumentException("payableamount must not be null");
        if (amount == null) throw new IllegalArgumentException("amount must not be null");
        if (cheuque == null) throw new IllegalArgumentException("cheuque must not be null");
        if (dd == null) throw new IllegalArgumentException("dd must not be null");
        if (pos == null) throw new IllegalArgumentException("pos must not be null");
        if (email == null) throw new IllegalArgumentException("email must not be null");
        if (phone == null) throw new IllegalArgumentException("phone must not be null");
        if (pdate == null) throw new IllegalArgumentException("pdate must not be null");
        PaymentBean res = new PaymentBean();
        res.mId = id;
        res.mPropertyuniqueid = propertyuniqueid;
        res.mTaxno = taxno;
        res.mMode = mode;
        res.mPayableamount = payableamount;
        res.mAmount = amount;
        res.mCheuque = cheuque;
        res.mDd = dd;
        res.mPos = pos;
        res.mEmail = email;
        res.mPhone = phone;
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
        res.mPropertyuniqueid = from.getPropertyuniqueid();
        res.mTaxno = from.getTaxno();
        res.mMode = from.getMode();
        res.mPayableamount = from.getPayableamount();
        res.mAmount = from.getAmount();
        res.mCheuque = from.getCheuque();
        res.mDd = from.getDd();
        res.mPos = from.getPos();
        res.mEmail = from.getEmail();
        res.mPhone = from.getPhone();
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
     * taxNo
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxno() {
        return mTaxno;
    }

    /**
     * taxNo
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
     * payableAmount
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPayableamount() {
        return mPayableamount;
    }

    /**
     * payableAmount
     * Must not be {@code null}.
     */
    public void setPayableamount(@NonNull String payableamount) {
        if (payableamount == null)
            throw new IllegalArgumentException("payableamount must not be null");
        mPayableamount = payableamount;
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
     * Cheuque
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getCheuque() {
        return mCheuque;
    }

    /**
     * Cheuque
     * Must not be {@code null}.
     */
    public void setCheuque(@NonNull String cheuque) {
        if (cheuque == null) throw new IllegalArgumentException("cheuque must not be null");
        mCheuque = cheuque;
    }

    /**
     * DD
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getDd() {
        return mDd;
    }

    /**
     * DD
     * Must not be {@code null}.
     */
    public void setDd(@NonNull String dd) {
        if (dd == null) throw new IllegalArgumentException("dd must not be null");
        mDd = dd;
    }

    /**
     * POS
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPos() {
        return mPos;
    }

    /**
     * POS
     * Must not be {@code null}.
     */
    public void setPos(@NonNull String pos) {
        if (pos == null) throw new IllegalArgumentException("pos must not be null");
        mPos = pos;
    }

    /**
     * email
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getEmail() {
        return mEmail;
    }

    /**
     * email
     * Must not be {@code null}.
     */
    public void setEmail(@NonNull String email) {
        if (email == null) throw new IllegalArgumentException("email must not be null");
        mEmail = email;
    }

    /**
     * phone
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPhone() {
        return mPhone;
    }

    /**
     * phone
     * Must not be {@code null}.
     */
    public void setPhone(@NonNull String phone) {
        if (phone == null) throw new IllegalArgumentException("phone must not be null");
        mPhone = phone;
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
         * taxNo
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
         * payableAmount
         * Must not be {@code null}.
         */
        public Builder payableamount(@NonNull String payableamount) {
            if (payableamount == null)
                throw new IllegalArgumentException("payableamount must not be null");
            mRes.mPayableamount = payableamount;
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
         * Cheuque
         * Must not be {@code null}.
         */
        public Builder cheuque(@NonNull String cheuque) {
            if (cheuque == null) throw new IllegalArgumentException("cheuque must not be null");
            mRes.mCheuque = cheuque;
            return this;
        }

        /**
         * DD
         * Must not be {@code null}.
         */
        public Builder dd(@NonNull String dd) {
            if (dd == null) throw new IllegalArgumentException("dd must not be null");
            mRes.mDd = dd;
            return this;
        }

        /**
         * POS
         * Must not be {@code null}.
         */
        public Builder pos(@NonNull String pos) {
            if (pos == null) throw new IllegalArgumentException("pos must not be null");
            mRes.mPos = pos;
            return this;
        }

        /**
         * email
         * Must not be {@code null}.
         */
        public Builder email(@NonNull String email) {
            if (email == null) throw new IllegalArgumentException("email must not be null");
            mRes.mEmail = email;
            return this;
        }

        /**
         * phone
         * Must not be {@code null}.
         */
        public Builder phone(@NonNull String phone) {
            if (phone == null) throw new IllegalArgumentException("phone must not be null");
            mRes.mPhone = phone;
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
            if (mRes.mPropertyuniqueid == null)
                throw new IllegalArgumentException("propertyuniqueid must not be null");
            if (mRes.mTaxno == null) throw new IllegalArgumentException("taxno must not be null");
            if (mRes.mMode == null) throw new IllegalArgumentException("mode must not be null");
            if (mRes.mPayableamount == null)
                throw new IllegalArgumentException("payableamount must not be null");
            if (mRes.mAmount == null) throw new IllegalArgumentException("amount must not be null");
            if (mRes.mCheuque == null)
                throw new IllegalArgumentException("cheuque must not be null");
            if (mRes.mDd == null) throw new IllegalArgumentException("dd must not be null");
            if (mRes.mPos == null) throw new IllegalArgumentException("pos must not be null");
            if (mRes.mEmail == null) throw new IllegalArgumentException("email must not be null");
            if (mRes.mPhone == null) throw new IllegalArgumentException("phone must not be null");
            if (mRes.mPdate == null) throw new IllegalArgumentException("pdate must not be null");
            return mRes;
        }
    }
}
