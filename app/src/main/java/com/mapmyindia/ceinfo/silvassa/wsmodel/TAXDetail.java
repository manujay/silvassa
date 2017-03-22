
package com.mapmyindia.ceinfo.silvassa.wsmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TAXDetail {

    @SerializedName("taxNo")
    @Expose
    private String taxNo;
    @SerializedName("taxAmount")
    @Expose
    private String taxAmount;
    @SerializedName("builtArea")
    @Expose
    private Object builtArea;
    @SerializedName("dueDate")
    @Expose
    private long dueDate;
    @SerializedName("amount")
    @Expose
    private Object amount;
    @SerializedName("noticeGenerated")
    @Expose
    private String noticeGenerated;
    @SerializedName("propId")
    @Expose
    private String propId;
    @SerializedName("financialYear")
    @Expose
    private String financialYear;
    @SerializedName("arrear")
    @Expose
    private Object arrear;
    @SerializedName("ilp")
    @Expose
    private Object ilp;
    @SerializedName("fine")
    @Expose
    private Object fine;
    @SerializedName("rebate")
    @Expose
    private Object rebate;
    @SerializedName("rebateOnline")
    @Expose
    private Object rebateOnline;
    @SerializedName("rebateOther")
    @Expose
    private Object rebateOther;
    @SerializedName("partialPaidAmount")
    @Expose
    private Object partialPaidAmount;

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Object getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(Object builtArea) {
        this.builtArea = builtArea;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public String getNoticeGenerated() {
        return noticeGenerated;
    }

    public void setNoticeGenerated(String noticeGenerated) {
        this.noticeGenerated = noticeGenerated;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public Object getArrear() {
        return arrear;
    }

    public void setArrear(Object arrear) {
        this.arrear = arrear;
    }

    public Object getIlp() {
        return ilp;
    }

    public void setIlp(Object ilp) {
        this.ilp = ilp;
    }

    public Object getFine() {
        return fine;
    }

    public void setFine(Object fine) {
        this.fine = fine;
    }

    public Object getRebate() {
        return rebate;
    }

    public void setRebate(Object rebate) {
        this.rebate = rebate;
    }

    public Object getRebateOnline() {
        return rebateOnline;
    }

    public void setRebateOnline(Object rebateOnline) {
        this.rebateOnline = rebateOnline;
    }

    public Object getRebateOther() {
        return rebateOther;
    }

    public void setRebateOther(Object rebateOther) {
        this.rebateOther = rebateOther;
    }

    public Object getPartialPaidAmount() {
        return partialPaidAmount;
    }

    public void setPartialPaidAmount(Object partialPaidAmount) {
        this.partialPaidAmount = partialPaidAmount;
    }

}
