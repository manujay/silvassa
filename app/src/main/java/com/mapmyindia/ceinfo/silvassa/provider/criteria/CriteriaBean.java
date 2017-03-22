package com.mapmyindia.ceinfo.silvassa.provider.criteria;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Criteria Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class CriteriaBean implements CriteriaModel {
    private long mId;
    private String mOccupiername;
    private String mPropid;
    private String mOwnername;

    /**
     * Instantiate a new CriteriaBean with specified values.
     */
    @NonNull
    public static CriteriaBean newInstance(long id, @NonNull String occupiername, @NonNull String propid, @NonNull String ownername) {
        if (occupiername == null)
            throw new IllegalArgumentException("occupiername must not be null");
        if (propid == null) throw new IllegalArgumentException("propid must not be null");
        if (ownername == null) throw new IllegalArgumentException("ownername must not be null");
        CriteriaBean res = new CriteriaBean();
        res.mId = id;
        res.mOccupiername = occupiername;
        res.mPropid = propid;
        res.mOwnername = ownername;
        return res;
    }

    /**
     * Instantiate a new CriteriaBean with all the values copied from the given model.
     */
    @NonNull
    public static CriteriaBean copy(@NonNull CriteriaModel from) {
        CriteriaBean res = new CriteriaBean();
        res.mId = from.getId();
        res.mOccupiername = from.getOccupiername();
        res.mPropid = from.getPropid();
        res.mOwnername = from.getOwnername();
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
     * occupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOccupiername() {
        return mOccupiername;
    }

    /**
     * occupierName.
     * Must not be {@code null}.
     */
    public void setOccupiername(@NonNull String occupiername) {
        if (occupiername == null)
            throw new IllegalArgumentException("occupiername must not be null");
        mOccupiername = occupiername;
    }

    /**
     * propId
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropid() {
        return mPropid;
    }

    /**
     * propId
     * Must not be {@code null}.
     */
    public void setPropid(@NonNull String propid) {
        if (propid == null) throw new IllegalArgumentException("propid must not be null");
        mPropid = propid;
    }

    /**
     * ownerName
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOwnername() {
        return mOwnername;
    }

    /**
     * ownerName
     * Must not be {@code null}.
     */
    public void setOwnername(@NonNull String ownername) {
        if (ownername == null) throw new IllegalArgumentException("ownername must not be null");
        mOwnername = ownername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriteriaBean bean = (CriteriaBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private CriteriaBean mRes = new CriteriaBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * occupierName.
         * Must not be {@code null}.
         */
        public Builder occupiername(@NonNull String occupiername) {
            if (occupiername == null)
                throw new IllegalArgumentException("occupiername must not be null");
            mRes.mOccupiername = occupiername;
            return this;
        }

        /**
         * propId
         * Must not be {@code null}.
         */
        public Builder propid(@NonNull String propid) {
            if (propid == null) throw new IllegalArgumentException("propid must not be null");
            mRes.mPropid = propid;
            return this;
        }

        /**
         * ownerName
         * Must not be {@code null}.
         */
        public Builder ownername(@NonNull String ownername) {
            if (ownername == null) throw new IllegalArgumentException("ownername must not be null");
            mRes.mOwnername = ownername;
            return this;
        }

        /**
         * Get a new CriteriaBean built with the given values.
         */
        public CriteriaBean build() {
            if (mRes.mOccupiername == null)
                throw new IllegalArgumentException("occupiername must not be null");
            if (mRes.mPropid == null) throw new IllegalArgumentException("propid must not be null");
            if (mRes.mOwnername == null)
                throw new IllegalArgumentException("ownername must not be null");
            return mRes;
        }
    }
}
