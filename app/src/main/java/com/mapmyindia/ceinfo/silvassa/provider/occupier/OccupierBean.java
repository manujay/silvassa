package com.mapmyindia.ceinfo.silvassa.provider.occupier;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Occupier Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class OccupierBean implements OccupierModel {
    private long mId;
    private String mOccupiername;

    /**
     * Instantiate a new OccupierBean with specified values.
     */
    @NonNull
    public static OccupierBean newInstance(long id, @NonNull String occupiername) {
        if (occupiername == null)
            throw new IllegalArgumentException("occupiername must not be null");
        OccupierBean res = new OccupierBean();
        res.mId = id;
        res.mOccupiername = occupiername;
        return res;
    }

    /**
     * Instantiate a new OccupierBean with all the values copied from the given model.
     */
    @NonNull
    public static OccupierBean copy(@NonNull OccupierModel from) {
        OccupierBean res = new OccupierBean();
        res.mId = from.getId();
        res.mOccupiername = from.getOccupiername();
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
     * OccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOccupiername() {
        return mOccupiername;
    }

    /**
     * OccupierName.
     * Must not be {@code null}.
     */
    public void setOccupiername(@NonNull String occupiername) {
        if (occupiername == null)
            throw new IllegalArgumentException("occupiername must not be null");
        mOccupiername = occupiername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OccupierBean bean = (OccupierBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private OccupierBean mRes = new OccupierBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * OccupierName.
         * Must not be {@code null}.
         */
        public Builder occupiername(@NonNull String occupiername) {
            if (occupiername == null)
                throw new IllegalArgumentException("occupiername must not be null");
            mRes.mOccupiername = occupiername;
            return this;
        }

        /**
         * Get a new OccupierBean built with the given values.
         */
        public OccupierBean build() {
            if (mRes.mOccupiername == null)
                throw new IllegalArgumentException("occupiername must not be null");
            return mRes;
        }
    }
}
