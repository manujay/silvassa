package com.mapmyindia.ceinfo.silvassa.provider.owner;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Owner Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class OwnerBean implements OwnerModel {
    private long mId;
    private String mOwnername;

    /**
     * Instantiate a new OwnerBean with specified values.
     */
    @NonNull
    public static OwnerBean newInstance(long id, @NonNull String ownername) {
        if (ownername == null) throw new IllegalArgumentException("ownername must not be null");
        OwnerBean res = new OwnerBean();
        res.mId = id;
        res.mOwnername = ownername;
        return res;
    }

    /**
     * Instantiate a new OwnerBean with all the values copied from the given model.
     */
    @NonNull
    public static OwnerBean copy(@NonNull OwnerModel from) {
        OwnerBean res = new OwnerBean();
        res.mId = from.getId();
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
     * OwnerName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getOwnername() {
        return mOwnername;
    }

    /**
     * OwnerName.
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
        OwnerBean bean = (OwnerBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private OwnerBean mRes = new OwnerBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * OwnerName.
         * Must not be {@code null}.
         */
        public Builder ownername(@NonNull String ownername) {
            if (ownername == null) throw new IllegalArgumentException("ownername must not be null");
            mRes.mOwnername = ownername;
            return this;
        }

        /**
         * Get a new OwnerBean built with the given values.
         */
        public OwnerBean build() {
            if (mRes.mOwnername == null)
                throw new IllegalArgumentException("ownername must not be null");
            return mRes;
        }
    }
}
