package com.mapmyindia.ceinfo.silvassa.wsmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PropertyWSModel {

    @SerializedName("propertyUniqueId")
    @Expose
    private String propertyUniqueId;
    @SerializedName("propertyOwner")
    @Expose
    private String propertyOwner;
    @SerializedName("propertyOccupierName")
    @Expose
    private String propertyOccupierName;
    @SerializedName("propertyRelationOwner")
    @Expose
    private String propertyRelationOwner;
    @SerializedName("zoneId")
    @Expose
    private String zoneId;
    @SerializedName("ward")
    @Expose
    private Object ward;
    @SerializedName("propertySublocality")
    @Expose
    private String propertySublocality;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("propertyLandmark")
    @Expose
    private String propertyLandmark;
    @SerializedName("propertyPlotNo")
    @Expose
    private String propertyPlotNo;
    @SerializedName("propertyHouseNo")
    @Expose
    private String propertyHouseNo;
    @SerializedName("propertyRoad")
    @Expose
    private String propertyRoad;
    @SerializedName("propertyPincode")
    @Expose
    private String propertyPincode;
    @SerializedName("propertyBuildingName")
    @Expose
    private String propertyBuildingName;
    @SerializedName("tAXDetailBean")
    @Expose
    private TAXDetailBean tAXDetailBeanBean;

    public String getPropertyUniqueId() {
        return propertyUniqueId;
    }

    public void setPropertyUniqueId(String propertyUniqueId) {
        this.propertyUniqueId = propertyUniqueId;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public String getPropertyOccupierName() {
        return propertyOccupierName;
    }

    public void setPropertyOccupierName(String propertyOccupierName) {
        this.propertyOccupierName = propertyOccupierName;
    }

    public String getPropertyRelationOwner() {
        return propertyRelationOwner;
    }

    public void setPropertyRelationOwner(String propertyRelationOwner) {
        this.propertyRelationOwner = propertyRelationOwner;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public Object getWard() {
        return ward;
    }

    public void setWard(Object ward) {
        this.ward = ward;
    }

    public String getPropertySublocality() {
        return propertySublocality;
    }

    public void setPropertySublocality(String propertySublocality) {
        this.propertySublocality = propertySublocality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPropertyLandmark() {
        return propertyLandmark;
    }

    public void setPropertyLandmark(String propertyLandmark) {
        this.propertyLandmark = propertyLandmark;
    }

    public String getPropertyPlotNo() {
        return propertyPlotNo;
    }

    public void setPropertyPlotNo(String propertyPlotNo) {
        this.propertyPlotNo = propertyPlotNo;
    }

    public String getPropertyHouseNo() {
        return propertyHouseNo;
    }

    public void setPropertyHouseNo(String propertyHouseNo) {
        this.propertyHouseNo = propertyHouseNo;
    }

    public String getPropertyRoad() {
        return propertyRoad;
    }

    public void setPropertyRoad(String propertyRoad) {
        this.propertyRoad = propertyRoad;
    }

    public String getPropertyPincode() {
        return propertyPincode;
    }

    public void setPropertyPincode(String propertyPincode) {
        this.propertyPincode = propertyPincode;
    }

    public String getPropertyBuildingName() {
        return propertyBuildingName;
    }

    public void setPropertyBuildingName(String propertyBuildingName) {
        this.propertyBuildingName = propertyBuildingName;
    }

    public TAXDetailBean getTAXDetailBean() {
        return tAXDetailBeanBean;
    }

    public void setTAXDetailBean(TAXDetailBean tAXDetailBeanBean) {
        this.tAXDetailBeanBean = tAXDetailBeanBean;
    }

}
