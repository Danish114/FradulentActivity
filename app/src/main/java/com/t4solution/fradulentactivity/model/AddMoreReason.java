package com.t4solution.fradulentactivity.model;

public class AddMoreReason {

    private int id;
    private String reason;
    private String penaltyClause;
    private String penaltyCase;
    private String surchargePerLiter;
    private String penaltyPercentOfProduct;
    private String lumsum;
    private String Total;
    private String remarks;

    public AddMoreReason(){

    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPenaltyClause() {
        return penaltyClause;
    }

    public void setPenaltyClause(String penaltyClause) {
        this.penaltyClause = penaltyClause;
    }

    public String getPenaltyCase() {
        return penaltyCase;
    }

    public void setPenaltyCase(String penaltyCase) {
        this.penaltyCase = penaltyCase;
    }

    public String getSurchargePerLiter() {
        return surchargePerLiter;
    }

    public void setSurchargePerLiter(String surchargePerLiter) {
        this.surchargePerLiter = surchargePerLiter;
    }

    public String getPenaltyPercentOfProduct() {
        return penaltyPercentOfProduct;
    }

    public void setPenaltyPercentOfProduct(String penaltyPercentOfProduct) {
        this.penaltyPercentOfProduct = penaltyPercentOfProduct;
    }

    public String getLumsum() {
        return lumsum;
    }

    public void setLumsum(String lumsum) {
        this.lumsum = lumsum;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
