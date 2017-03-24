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
    public static PropertyBean newInstance(long id, @NonNull String propertyuniqueid, @NonNull String propertyowner, @NonNull String propertyoccupiername, @NonNull String propertyrelationowner, @NonNull String zoneid, @Nullable String ward, @NonNull String propertysublocality, @NonNull String email, @NonNull String phone, @NonNull String propertylandmark, @NonNull String propertyplotno, @NonNull String propertyhouseno, @NonNull String propertyroad, @NonNull String propertypincode, @NonNull String propertybuildingname) {
        if (propertyuniqueid == null)
            throw new IllegalArgumentException("propertyuniqueid must not be null");
        if (propertyowner == null)
            throw new IllegalArgumentException("propertyowner must not be null");
        if (propertyoccupiername == null)
            throw new IllegalArgumentException("propertyoccupiername must not be null");
        if (propertyrelationowner == null)
            throw new IllegalArgumentException("propertyrelationowner must not be null");
        if (zoneid == null) throw new IllegalArgumentException("zoneid must not be null");
        if (propertysublocality == null)
            throw new IllegalArgumentException("propertysublocality must not be null");
        if (email == null) throw new IllegalArgumentException("email must not be null");
        if (phone == null) throw new IllegalArgumentException("phone must not be null");
        if (propertylandmark == null)
            throw new IllegalArgumentException("propertylandmark must not be null");
        if (propertyplotno == null)
            throw new IllegalArgumentException("propertyplotno must not be null");
        if (propertyhouseno == null)
            throw new IllegalArgumentException("propertyhouseno must not be null");
        if (propertyroad == null)
            throw new IllegalArgumentException("propertyroad must not be null");
        if (propertypincode == null)
            throw new IllegalArgumentException("propertypincode must not be null");
        if (propertybuildingname == null)
            throw new IllegalArgumentException("propertybuildingname must not be null");
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyowner() {
        return mPropertyowner;
    }

    /**
     * propertyOwner.
     * Must not be {@code null}.
     */
    public void setPropertyowner(@NonNull String propertyowner) {
        if (propertyowner == null)
            throw new IllegalArgumentException("propertyowner must not be null");
        mPropertyowner = propertyowner;
    }

    /**
     * propertyOccupierName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyoccupiername() {
        return mPropertyoccupiername;
    }

    /**
     * propertyOccupierName.
     * Must not be {@code null}.
     */
    public void setPropertyoccupiername(@NonNull String propertyoccupiername) {
        if (propertyoccupiername == null)
            throw new IllegalArgumentException("propertyoccupiername must not be null");
        mPropertyoccupiername = propertyoccupiername;
    }

    /**
     * propertyRelationOwner.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyrelationowner() {
        return mPropertyrelationowner;
    }

    /**
     * propertyRelationOwner.
     * Must not be {@code null}.
     */
    public void setPropertyrelationowner(@NonNull String propertyrelationowner) {
        if (propertyrelationowner == null)
            throw new IllegalArgumentException("propertyrelationowner must not be null");
        mPropertyrelationowner = propertyrelationowner;
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
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertysublocality() {
        return mPropertysublocality;
    }

    /**
     * propertySublocality.
     * Must not be {@code null}.
     */
    public void setPropertysublocality(@NonNull String propertysublocality) {
        if (propertysublocality == null)
            throw new IllegalArgumentException("propertysublocality must not be null");
        mPropertysublocality = propertysublocality;
    }

    /**
     * email.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getEmail() {
        return mEmail;
    }

    /**
     * email.
     * Must not be {@code null}.
     */
    public void setEmail(@NonNull String email) {
        if (email == null) throw new IllegalArgumentException("email must not be null");
        mEmail = email;
    }

    /**
     * phone.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPhone() {
        return mPhone;
    }

    /**
     * phone.
     * Must not be {@code null}.
     */
    public void setPhone(@NonNull String phone) {
        if (phone == null) throw new IllegalArgumentException("phone must not be null");
        mPhone = phone;
    }

    /**
     * propertyLandmark.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertylandmark() {
        return mPropertylandmark;
    }

    /**
     * propertyLandmark.
     * Must not be {@code null}.
     */
    public void setPropertylandmark(@NonNull String propertylandmark) {
        if (propertylandmark == null)
            throw new IllegalArgumentException("propertylandmark must not be null");
        mPropertylandmark = propertylandmark;
    }

    /**
     * propertyPlotNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyplotno() {
        return mPropertyplotno;
    }

    /**
     * propertyPlotNo.
     * Must not be {@code null}.
     */
    public void setPropertyplotno(@NonNull String propertyplotno) {
        if (propertyplotno == null)
            throw new IllegalArgumentException("propertyplotno must not be null");
        mPropertyplotno = propertyplotno;
    }

    /**
     * propertyHouseNo.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyhouseno() {
        return mPropertyhouseno;
    }

    /**
     * propertyHouseNo.
     * Must not be {@code null}.
     */
    public void setPropertyhouseno(@NonNull String propertyhouseno) {
        if (propertyhouseno == null)
            throw new IllegalArgumentException("propertyhouseno must not be null");
        mPropertyhouseno = propertyhouseno;
    }

    /**
     * propertyRoad.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertyroad() {
        return mPropertyroad;
    }

    /**
     * propertyRoad.
     * Must not be {@code null}.
     */
    public void setPropertyroad(@NonNull String propertyroad) {
        if (propertyroad == null)
            throw new IllegalArgumentException("propertyroad must not be null");
        mPropertyroad = propertyroad;
    }

    /**
     * propertyPincode.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertypincode() {
        return mPropertypincode;
    }

    /**
     * propertyPincode.
     * Must not be {@code null}.
     */
    public void setPropertypincode(@NonNull String propertypincode) {
        if (propertypincode == null)
            throw new IllegalArgumentException("propertypincode must not be null");
        mPropertypincode = propertypincode;
    }

    /**
     * propertyBuildingName.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public String getPropertybuildingname() {
        return mPropertybuildingname;
    }

    /**
     * propertyBuildingName.
     * Must not be {@code null}.
     */
    public void setPropertybuildingname(@NonNull String propertybuildingname) {
        if (propertybuildingname == null)
            throw new IllegalArgumentException("propertybuildingname must not be null");
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
         * Must not be {@code null}.
         */
        public Builder propertyowner(@NonNull String propertyowner) {
            if (propertyowner == null)
                throw new IllegalArgumentException("propertyowner must not be null");
            mRes.mPropertyowner = propertyowner;
            return this;
        }

        /**
         * propertyOccupierName.
         * Must not be {@code null}.
         */
        public Builder propertyoccupiername(@NonNull String propertyoccupiername) {
            if (propertyoccupiername == null)
                throw new IllegalArgumentException("propertyoccupiername must not be null");
            mRes.mPropertyoccupiername = propertyoccupiername;
            return this;
        }

        /**
         * propertyRelationOwner.
         * Must not be {@code null}.
         */
        public Builder propertyrelationowner(@NonNull String propertyrelationowner) {
            if (propertyrelationowner == null)
                throw new IllegalArgumentException("propertyrelationowner must not be null");
            mRes.mPropertyrelationowner = propertyrelationowner;
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
         * ward.
         * Can be {@code null}.
         */
        public Builder ward(@Nullable String ward) {
            mRes.mWard = ward;
            return this;
        }

        /**
         * propertySublocality.
         * Must not be {@code null}.
         */
        public Builder propertysublocality(@NonNull String propertysublocality) {
            if (propertysublocality == null)
                throw new IllegalArgumentException("propertysublocality must not be null");
            mRes.mPropertysublocality = propertysublocality;
            return this;
        }

        /**
         * email.
         * Must not be {@code null}.
         */
        public Builder email(@NonNull String email) {
            if (email == null) throw new IllegalArgumentException("email must not be null");
            mRes.mEmail = email;
            return this;
        }

        /**
         * phone.
         * Must not be {@code null}.
         */
        public Builder phone(@NonNull String phone) {
            if (phone == null) throw new IllegalArgumentException("phone must not be null");
            mRes.mPhone = phone;
            return this;
        }

        /**
         * propertyLandmark.
         * Must not be {@code null}.
         */
        public Builder propertylandmark(@NonNull String propertylandmark) {
            if (propertylandmark == null)
                throw new IllegalArgumentException("propertylandmark must not be null");
            mRes.mPropertylandmark = propertylandmark;
            return this;
        }

        /**
         * propertyPlotNo.
         * Must not be {@code null}.
         */
        public Builder propertyplotno(@NonNull String propertyplotno) {
            if (propertyplotno == null)
                throw new IllegalArgumentException("propertyplotno must not be null");
            mRes.mPropertyplotno = propertyplotno;
            return this;
        }

        /**
         * propertyHouseNo.
         * Must not be {@code null}.
         */
        public Builder propertyhouseno(@NonNull String propertyhouseno) {
            if (propertyhouseno == null)
                throw new IllegalArgumentException("propertyhouseno must not be null");
            mRes.mPropertyhouseno = propertyhouseno;
            return this;
        }

        /**
         * propertyRoad.
         * Must not be {@code null}.
         */
        public Builder propertyroad(@NonNull String propertyroad) {
            if (propertyroad == null)
                throw new IllegalArgumentException("propertyroad must not be null");
            mRes.mPropertyroad = propertyroad;
            return this;
        }

        /**
         * propertyPincode.
         * Must not be {@code null}.
         */
        public Builder propertypincode(@NonNull String propertypincode) {
            if (propertypincode == null)
                throw new IllegalArgumentException("propertypincode must not be null");
            mRes.mPropertypincode = propertypincode;
            return this;
        }

        /**
         * propertyBuildingName.
         * Must not be {@code null}.
         */
        public Builder propertybuildingname(@NonNull String propertybuildingname) {
            if (propertybuildingname == null)
                throw new IllegalArgumentException("propertybuildingname must not be null");
            mRes.mPropertybuildingname = propertybuildingname;
            return this;
        }

        /**
         * Get a new PropertyBean built with the given values.
         */
        public PropertyBean build() {
            if (mRes.mPropertyuniqueid == null)
                throw new IllegalArgumentException("propertyuniqueid must not be null");
            if (mRes.mPropertyowner == null)
                throw new IllegalArgumentException("propertyowner must not be null");
            if (mRes.mPropertyoccupiername == null)
                throw new IllegalArgumentException("propertyoccupiername must not be null");
            if (mRes.mPropertyrelationowner == null)
                throw new IllegalArgumentException("propertyrelationowner must not be null");
            if (mRes.mZoneid == null) throw new IllegalArgumentException("zoneid must not be null");
            if (mRes.mPropertysublocality == null)
                throw new IllegalArgumentException("propertysublocality must not be null");
            if (mRes.mEmail == null) throw new IllegalArgumentException("email must not be null");
            if (mRes.mPhone == null) throw new IllegalArgumentException("phone must not be null");
            if (mRes.mPropertylandmark == null)
                throw new IllegalArgumentException("propertylandmark must not be null");
            if (mRes.mPropertyplotno == null)
                throw new IllegalArgumentException("propertyplotno must not be null");
            if (mRes.mPropertyhouseno == null)
                throw new IllegalArgumentException("propertyhouseno must not be null");
            if (mRes.mPropertyroad == null)
                throw new IllegalArgumentException("propertyroad must not be null");
            if (mRes.mPropertypincode == null)
                throw new IllegalArgumentException("propertypincode must not be null");
            if (mRes.mPropertybuildingname == null)
                throw new IllegalArgumentException("propertybuildingname must not be null");
            return mRes;
        }
    }
}
