
package com.mapmyindia.ceinfo.silvassa.wsmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchCWSModel {

    @SerializedName("occupierArr")
    @Expose
    private List<String> occupierArr = null;
    @SerializedName("propIdArr")
    @Expose
    private List<String> propIdArr = null;
    @SerializedName("ownerArr")
    @Expose
    private List<String> ownerArr = null;

    public List<String> getOccupierArr() {
        return occupierArr;
    }

    public void setOccupierArr(List<String> occupierArr) {
        this.occupierArr = occupierArr;
    }

    public List<String> getPropIdArr() {
        return propIdArr;
    }

    public void setPropIdArr(List<String> propIdArr) {
        this.propIdArr = propIdArr;
    }

    public List<String> getOwnerArr() {
        return ownerArr;
    }

    public void setOwnerArr(List<String> ownerArr) {
        this.ownerArr = ownerArr;
    }

}
