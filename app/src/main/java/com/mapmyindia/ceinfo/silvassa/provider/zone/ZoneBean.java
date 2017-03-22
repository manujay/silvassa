package com.mapmyindia.ceinfo.silvassa.provider.zone;

// @formatter:off

import android.support.annotation.NonNull;

/**
 * Zone Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class ZoneBean implements ZoneModel {
    private long mId;
    private String mZoneid;
    private String mZonename;

    /**
     * Instantiate a new ZoneBean with specified values.
     */
    @NonNull
    public static ZoneBean newInstance(long id, @NonNull String zoneid, @NonNull String zonename) {
        if (zoneid == null) throw new IllegalArgumentException("zoneid must not be null");
        if (zonename == null) throw new IllegalArgumentException("zonename must not be null");
        ZoneBean res = new ZoneBean();
        res.mId = id;
        res.mZoneid = zoneid;
        res.mZonename = zonename;
        return res;
    }

    /**
     * Instantiate a new ZoneBean with all the values copied from the given model.
     */
    @NonNull
    public static ZoneBean copy(@NonNull ZoneModel from) {
        ZoneBean res = new ZoneBean();
        res.mId = from.getId();
        res.mZoneid = from.getZoneid();
        res.mZonename = from.getZonename();
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
     * zoneId.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getZoneid() {
        return mZoneid;
    }

    /**
     * zoneId.
     * Must not be {@code null}.
     */
    public void setZoneid(@NonNull String zoneid) {
        if (zoneid == null) throw new IllegalArgumentException("zoneid must not be null");
        mZoneid = zoneid;
    }

    /**
     * zoneName
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getZonename() {
        return mZonename;
    }

    /**
     * zoneName
     * Must not be {@code null}.
     */
    public void setZonename(@NonNull String zonename) {
        if (zonename == null) throw new IllegalArgumentException("zonename must not be null");
        mZonename = zonename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneBean bean = (ZoneBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private ZoneBean mRes = new ZoneBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * zoneId.
         * Must not be {@code null}.
         */
        public Builder zoneid(@NonNull String zoneid) {
            if (zoneid == null) throw new IllegalArgumentException("zoneid must not be null");
            mRes.mZoneid = zoneid;
            return this;
        }

        /**
         * zoneName
         * Must not be {@code null}.
         */
        public Builder zonename(@NonNull String zonename) {
            if (zonename == null) throw new IllegalArgumentException("zonename must not be null");
            mRes.mZonename = zonename;
            return this;
        }

        /**
         * Get a new ZoneBean built with the given values.
         */
        public ZoneBean build() {
            if (mRes.mZoneid == null) throw new IllegalArgumentException("zoneid must not be null");
            if (mRes.mZonename == null)
                throw new IllegalArgumentException("zonename must not be null");
            return mRes;
        }
    }
}
