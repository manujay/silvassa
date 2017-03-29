package com.mapmyindia.ceinfo.silvassa.provider.property;

// @formatter:off

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Property Table Schema
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class PropertyBean implements PropertyModel {
    private long mId;
    private String mPropertyuniqueid;
    private String mPropertyowner;
    private String mPropertyoccupiername;
    private String mPropertyrelationowner;
    private String mZoneid;
    private String mWard;
    private String mPropertysublocality;
    private String mEmail;
    private String mPhone;
    private String mPropertylandmark;
    private String mPropertyplotno;
    private String mPropertyhouseno;
    private String mPropertyroad;
    private String mPropertypincode;
    private String mPropertybuildingname;

    /**
     * Instantiate a new PropertyBean with specified values.
     */
    @NonNull
    public static PropertyBean newInstance(long id, @NonNull String propertyuniqueid, @Nullable String propertyowner, @Nullable String propertyoccupiername, @Nullable String propertyrelationowner, @Nullable String zoneid, @Nullable String ward, @Nullable String propertysublocality, @Nullable String email, @Nullable String phone, @Nullable String propertylandmark, @Nullable String propertyplotno, @Nullable String propertyhouseno, @Nullable String propertyroad, @Nullable String propertypincode, @Nullable String propertybuildingname) {
        if (propertyuniqueid == null)
            throw new IllegalArgumentException("propertyuniqueid must not be null");
        PropertyBean res = new PropertyBean();
        res.mId = id;
        res.mPropertyuniqueid = propertyuniqueid;
        res.mPropertyowner = propertyowner;
        res.mPropertyoccupiername = propertyoccupiername;
        res.mPropertyrelationowner = propertyrelationowner;
        res.mZoneid = zoneid;
        res.mWard = ward;
        res.mPropertysublocality = propertysublocality;
        res.mEmail = email;
        res.mPhone = phone;
        res.mPropertylandmark = propertylandmark;
        res.mPropertyplotno = propertyplotno;
        res.mPropertyhouseno = propertyhouseno;
        res.mPropertyroad = propertyroad;
        res.mPropertypincode = propertypincode;
        res.mPropertybuildingname = propertybuildingname;
        return res;
    }

    /**
     * Instantiate a new PropertyBean with all the values copied from the given model.
     */
    @NonNull
    public static PropertyBean copy(@NonNull PropertyModel from) {
        PropertyBean res = new PropertyBean();
        res.mId = from.getId();
        res.mPropertyuniqueid = from.getPropertyuniqueid();
        res.mPropertyowner = from.getPropertyowner();
        res.mPropertyoccupiername = from.getPropertyoccupiername();
        res.mPropertyrelationowner = from.getPropertyrelationowner();
        res.mZoneid = from.getZoneid();
        res.mWard = from.getWard();
        res.mPropertysublocality = from.getPropertysublocality();
        res.mEmail = from.getEmail();
        res.mPhone = from.getPhone();
        res.mPropertylandmark = from.getPropertylandmark();
        res.mPropertyplotno = from.getPropertyplotno();
        res.mPropertyhouseno = from.getPropertyhouseno();
        res.mPropertyroad = from.getPropertyroad();
        res.mPropertypincode = from.getPropertypincode();
        res.mPropertybuildingname = from.getPropertybuildingname();
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
     * propertyOwner.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyowner() {
        return mPropertyowner;
    }

    /**
     * propertyOwner.
     * Can be {@code null}.
     */
    public void setPropertyowner(@Nullable String propertyowner) {
        mPropertyowner = propertyowner;
    }

    /**
     * propertyOccupierName.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyoccupiername() {
        return mPropertyoccupiername;
    }

    /**
     * propertyOccupierName.
     * Can be {@code null}.
     */
    public void setPropertyoccupiername(@Nullable String propertyoccupiername) {
        mPropertyoccupiername = propertyoccupiername;
    }

    /**
     * propertyRelationOwner.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyrelationowner() {
        return mPropertyrelationowner;
    }

    /**
     * propertyRelationOwner.
     * Can be {@code null}.
     */
    public void setPropertyrelationowner(@Nullable String propertyrelationowner) {
        mPropertyrelationowner = propertyrelationowner;
    }

    /**
     * zoneId.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getZoneid() {
        return mZoneid;
    }

    /**
     * zoneId.
     * Can be {@code null}.
     */
    public void setZoneid(@Nullable String zoneid) {
        mZoneid = zoneid;
    }

    /**
     * ward.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getWard() {
        return mWard;
    }

    /**
     * ward.
     * Can be {@code null}.
     */
    public void setWard(@Nullable String ward) {
        mWard = ward;
    }

    /**
     * propertySublocality.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertysublocality() {
        return mPropertysublocality;
    }

    /**
     * propertySublocality.
     * Can be {@code null}.
     */
    public void setPropertysublocality(@Nullable String propertysublocality) {
        mPropertysublocality = propertysublocality;
    }

    /**
     * email.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEmail() {
        return mEmail;
    }

    /**
     * email.
     * Can be {@code null}.
     */
    public void setEmail(@Nullable String email) {
        mEmail = email;
    }

    /**
     * phone.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPhone() {
        return mPhone;
    }

    /**
     * phone.
     * Can be {@code null}.
     */
    public void setPhone(@Nullable String phone) {
        mPhone = phone;
    }

    /**
     * propertyLandmark.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertylandmark() {
        return mPropertylandmark;
    }

    /**
     * propertyLandmark.
     * Can be {@code null}.
     */
    public void setPropertylandmark(@Nullable String propertylandmark) {
        mPropertylandmark = propertylandmark;
    }

    /**
     * propertyPlotNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyplotno() {
        return mPropertyplotno;
    }

    /**
     * propertyPlotNo.
     * Can be {@code null}.
     */
    public void setPropertyplotno(@Nullable String propertyplotno) {
        mPropertyplotno = propertyplotno;
    }

    /**
     * propertyHouseNo.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyhouseno() {
        return mPropertyhouseno;
    }

    /**
     * propertyHouseNo.
     * Can be {@code null}.
     */
    public void setPropertyhouseno(@Nullable String propertyhouseno) {
        mPropertyhouseno = propertyhouseno;
    }

    /**
     * propertyRoad.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertyroad() {
        return mPropertyroad;
    }

    /**
     * propertyRoad.
     * Can be {@code null}.
     */
    public void setPropertyroad(@Nullable String propertyroad) {
        mPropertyroad = propertyroad;
    }

    /**
     * propertyPincode.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertypincode() {
        return mPropertypincode;
    }

    /**
     * propertyPincode.
     * Can be {@code null}.
     */
    public void setPropertypincode(@Nullable String propertypincode) {
        mPropertypincode = propertypincode;
    }

    /**
     * propertyBuildingName.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPropertybuildingname() {
        return mPropertybuildingname;
    }

    /**
     * propertyBuildingName.
     * Can be {@code null}.
     */
    public void setPropertybuildingname(@Nullable String propertybuildingname) {
        mPropertybuildingname = propertybuildingname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyBean bean = (PropertyBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    public static class Builder {
        private PropertyBean mRes = new PropertyBean();

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
         * propertyOwner.
         * Can be {@code null}.
         */
        public Builder propertyowner(@Nullable String propertyowner) {
            mRes.mPropertyowner = propertyowner;
            return this;
        }

        /**
         * propertyOccupierName.
         * Can be {@code null}.
         */
        public Builder propertyoccupiername(@Nullable String propertyoccupiername) {
            mRes.mPropertyoccupiername = propertyoccupiername;
            return this;
        }

        /**
         * propertyRelationOwner.
         * Can be {@code null}.
         */
        public Builder propertyrelationowner(@Nullable String propertyrelationowner) {
            mRes.mPropertyrelationowner = propertyrelationowner;
            return this;
        }

        /**
         * zoneId.
         * Can be {@code null}.
         */
        public Builder zoneid(@Nullable String zoneid) {
            mRes.mZoneid = zoneid;
            return this;
        }

        /**
         * ward.
         * Can be {@code null}.
         */
        public Builder ward(@Nullable String ward) {
            mRes.mWard = ward;
            return this;
        }

        /**
         * propertySublocality.
         * Can be {@code null}.
         */
        public Builder propertysublocality(@Nullable String propertysublocality) {
            mRes.mPropertysublocality = propertysublocality;
            return this;
        }

        /**
         * email.
         * Can be {@code null}.
         */
        public Builder email(@Nullable String email) {
            mRes.mEmail = email;
            return this;
        }

        /**
         * phone.
         * Can be {@code null}.
         */
        public Builder phone(@Nullable String phone) {
            mRes.mPhone = phone;
            return this;
        }

        /**
         * propertyLandmark.
         * Can be {@code null}.
         */
        public Builder propertylandmark(@Nullable String propertylandmark) {
            mRes.mPropertylandmark = propertylandmark;
            return this;
        }

        /**
         * propertyPlotNo.
         * Can be {@code null}.
         */
        public Builder propertyplotno(@Nullable String propertyplotno) {
            mRes.mPropertyplotno = propertyplotno;
            return this;
        }

        /**
         * propertyHouseNo.
         * Can be {@code null}.
         */
        public Builder propertyhouseno(@Nullable String propertyhouseno) {
            mRes.mPropertyhouseno = propertyhouseno;
            return this;
        }

        /**
         * propertyRoad.
         * Can be {@code null}.
         */
        public Builder propertyroad(@Nullable String propertyroad) {
            mRes.mPropertyroad = propertyroad;
            return this;
        }

        /**
         * propertyPincode.
         * Can be {@code null}.
         */
        public Builder propertypincode(@Nullable String propertypincode) {
            mRes.mPropertypincode = propertypincode;
            return this;
        }

        /**
         * propertyBuildingName.
         * Can be {@code null}.
         */
        public Builder propertybuildingname(@Nullable String propertybuildingname) {
            mRes.mPropertybuildingname = propertybuildingname;
            return this;
        }

        /**
         * Get a new PropertyBean built with the given values.
         */
        public PropertyBean build() {
            if (mRes.mPropertyuniqueid == null)
                throw new IllegalArgumentException("propertyuniqueid must not be null");
            return mRes;
        }
    }
}
