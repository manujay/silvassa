package com.mapmyindia.ceinfo.silvassa.wsmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TAXDetailBean {

    @SerializedName("taxNo")
    @Expose
    private String taxNo;
    @SerializedName("propertyId")
    @Expose
    private String propertyId;
    @SerializedName("financialYear")
    @Expose
    private String financialYear;
    @SerializedName("propertyTax")
    @Expose
    private String propertyTax;
    @SerializedName("waterTax")
    @Expose
    private String waterTax;
    @SerializedName("conservancyTax")
    @Expose
    private String conservancyTax;
    @SerializedName("waterSewerageCharge")
    @Expose
    private String waterSewerageCharge;
    @SerializedName("waterMeterBillAmount")
    @Expose
    private String waterMeterBillAmount;
    @SerializedName("arrearAmount")
    @Expose
    private String arrearAmount;
    @SerializedName("advancePaidAmount")
    @Expose
    private String advancePaidAmount;
    @SerializedName("rebateAmount")
    @Expose
    private String rebateAmount;
    @SerializedName("adjustmentAmount")
    @Expose
    private String adjustmentAmount;
    @SerializedName("totalPropertyTax")
    @Expose
    private String totalPropertyTax;
    @SerializedName("serviceTax")
    @Expose
    private String serviceTax;
    @SerializedName("otherTax")
    @Expose
    private String otherTax;
    @SerializedName("grandTotal")
    @Expose
    private String grandTotal;
    @SerializedName("delayPaymentCharges")
    @Expose
    private String delayPaymentCharges;
    @SerializedName("payableAmount")
    @Expose
    private String payableAmount;
    @SerializedName("dueDate")
    @Expose
    private long dueDate;
    @SerializedName("noticeGenerated")
    @Expose
    private String noticeGenerated;
    @SerializedName("objectionStatus")
    @Expose
    private String objectionStatus;

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(String propertyTax) {
        this.propertyTax = propertyTax;
    }

    public String getWaterTax() {
        return waterTax;
    }

    public void setWaterTax(String waterTax) {
        this.waterTax = waterTax;
    }

    public String getConservancyTax() {
        return conservancyTax;
    }

    public void setConservancyTax(String conservancyTax) {
        this.conservancyTax = conservancyTax;
    }

    public String getWaterSewerageCharge() {
        return waterSewerageCharge;
    }

    public void setWaterSewerageCharge(String waterSewerageCharge) {
        this.waterSewerageCharge = waterSewerageCharge;
    }

    public String getWaterMeterBillAmount() {
        return waterMeterBillAmount;
    }

    public void setWaterMeterBillAmount(String waterMeterBillAmount) {
        this.waterMeterBillAmount = waterMeterBillAmount;
    }

    public String getArrearAmount() {
        return arrearAmount;
    }

    public void setArrearAmount(String arrearAmount) {
        this.arrearAmount = arrearAmount;
    }

    public String getAdvancePaidAmount() {
        return advancePaidAmount;
    }

    public void setAdvancePaidAmount(String advancePaidAmount) {
        this.advancePaidAmount = advancePaidAmount;
    }

    public String getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(String rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public String getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(String adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public String getTotalPropertyTax() {
        return totalPropertyTax;
    }

    public void setTotalPropertyTax(String totalPropertyTax) {
        this.totalPropertyTax = totalPropertyTax;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }

    public String getOtherTax() {
        return otherTax;
    }

    public void setOtherTax(String otherTax) {
        this.otherTax = otherTax;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getDelayPaymentCharges() {
        return delayPaymentCharges;
    }

    public void setDelayPaymentCharges(String delayPaymentCharges) {
        this.delayPaymentCharges = delayPaymentCharges;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public String getNoticeGenerated() {
        return noticeGenerated;
    }

    public void setNoticeGenerated(String noticeGenerated) {
        this.noticeGenerated = noticeGenerated;
    }

    public String getObjectionStatus() {
        return objectionStatus;
    }

    public void setObjectionStatus(String objectionStatus) {
        this.objectionStatus = objectionStatus;
    }

}
