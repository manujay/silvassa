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
    private String mTaxamount;
    private String mDuedate;
    private String mNoticegenerated;
    private String mPropid;
    private String mFinancialyear;

    /**
     * Instantiate a new TaxdetailBean with specified values.
     */
    @NonNull
    public static TaxdetailBean newInstance(long id, @NonNull String taxno, @NonNull String taxamount, @NonNull String duedate, @NonNull String noticegenerated, @NonNull String propid, @NonNull String financialyear) {
        if (taxno == null) throw new IllegalArgumentException("taxno must not be null");
        if (taxamount == null) throw new IllegalArgumentException("taxamount must not be null");
        if (duedate == null) throw new IllegalArgumentException("duedate must not be null");
        if (noticegenerated == null)
            throw new IllegalArgumentException("noticegenerated must not be null");
        if (propid == null) throw new IllegalArgumentException("propid must not be null");
        if (financialyear == null)
            throw new IllegalArgumentException("financialyear must not be null");
        TaxdetailBean res = new TaxdetailBean();
        res.mId = id;
        res.mTaxno = taxno;
        res.mTaxamount = taxamount;
        res.mDuedate = duedate;
        res.mNoticegenerated = noticegenerated;
        res.mPropid = propid;
        res.mFinancialyear = financialyear;
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
        res.mTaxamount = from.getTaxamount();
        res.mDuedate = from.getDuedate();
        res.mNoticegenerated = from.getNoticegenerated();
        res.mPropid = from.getPropid();
        res.mFinancialyear = from.getFinancialyear();
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
     * taxAmount.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getTaxamount() {
        return mTaxamount;
    }

    /**
     * taxAmount.
     * Must not be {@code null}.
     */
    public void setTaxamount(@NonNull String taxamount) {
        if (taxamount == null) throw new IllegalArgumentException("taxamount must not be null");
        mTaxamount = taxamount;
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
     * propId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropid() {
        return mPropid;
    }

    /**
     * propId.
     * Must not be {@code null}.
     */
    public void setPropid(@NonNull String propid) {
        if (propid == null) throw new IllegalArgumentException("propid must not be null");
        mPropid = propid;
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
         * taxAmount.
         * Must not be {@code null}.
         */
        public Builder taxamount(@NonNull String taxamount) {
            if (taxamount == null) throw new IllegalArgumentException("taxamount must not be null");
            mRes.mTaxamount = taxamount;
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
         * propId.
         * Must not be {@code null}.
         */
        public Builder propid(@NonNull String propid) {
            if (propid == null) throw new IllegalArgumentException("propid must not be null");
            mRes.mPropid = propid;
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
         * Get a new TaxdetailBean built with the given values.
         */
        public TaxdetailBean build() {
            if (mRes.mTaxno == null) throw new IllegalArgumentException("taxno must not be null");
            if (mRes.mTaxamount == null)
                throw new IllegalArgumentException("taxamount must not be null");
            if (mRes.mDuedate == null)
                throw new IllegalArgumentException("duedate must not be null");
            if (mRes.mNoticegenerated == null)
                throw new IllegalArgumentException("noticegenerated must not be null");
            if (mRes.mPropid == null) throw new IllegalArgumentException("propid must not be null");
            if (mRes.mFinancialyear == null)
                throw new IllegalArgumentException("financialyear must not be null");
            return mRes;
        }
    }
}
