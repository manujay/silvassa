
package com.mapmyindia.ceinfo.silvassa.wsmodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWSModel implements Parcelable {

    public final static Parcelable.Creator<UserWSModel> CREATOR = new Creator<UserWSModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserWSModel createFromParcel(Parcel in) {
            UserWSModel instance = new UserWSModel();
            instance.usermasterId = ((long) in.readValue((long.class.getClassLoader())));
            instance.userId = ((String) in.readValue((String.class.getClassLoader())));
            instance.username = ((String) in.readValue((String.class.getClassLoader())));
            instance.pasword = ((String) in.readValue((String.class.getClassLoader())));
            instance.roleId = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdBy = ((String) in.readValue((String.class.getClassLoader())));
            instance.mobile = ((String) in.readValue((String.class.getClassLoader())));
            instance.email = ((String) in.readValue((String.class.getClassLoader())));
            instance.address = ((String) in.readValue((String.class.getClassLoader())));
            instance.empId = ((String) in.readValue((String.class.getClassLoader())));
            instance.modifiedOn = ((String) in.readValue((Object.class.getClassLoader())));
            instance.permissionList = ((String) in.readValue((Object.class.getClassLoader())));
            instance.createdOn = ((String) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public UserWSModel[] newArray(int size) {
            return (new UserWSModel[size]);
        }

    };
    @SerializedName("usermasterId")
    @Expose
    private long usermasterId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("pasword")
    @Expose
    private String pasword;
    @SerializedName("roleId")
    @Expose
    private String roleId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("empId")
    @Expose
    private String empId;
    @SerializedName("modifiedOn")
    @Expose
    private String modifiedOn;
    @SerializedName("permissionList")
    @Expose
    private String permissionList;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;

    public long getUsermasterId() {
        return usermasterId;
    }

    public void setUsermasterId(long usermasterId) {
        this.usermasterId = usermasterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(String permissionList) {
        this.permissionList = permissionList;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(usermasterId);
        dest.writeValue(userId);
        dest.writeValue(username);
        dest.writeValue(pasword);
        dest.writeValue(roleId);
        dest.writeValue(status);
        dest.writeValue(createdBy);
        dest.writeValue(mobile);
        dest.writeValue(email);
        dest.writeValue(address);
        dest.writeValue(empId);
        dest.writeValue(modifiedOn);
        dest.writeValue(permissionList);
        dest.writeValue(createdOn);
    }

    public int describeContents() {
        return 0;
    }

}
