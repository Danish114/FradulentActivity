package com.t4solution.fradulentactivity.model;

public class AccountPayableHeadOffice {

    private Integer id;
    private String user;
    private String userDepartment;
    private String lumSum;
    private String total;
    private String remarks;
    private String reason;
    private String penaltyClause;
    private String penaltyCaseNo;
    private String surchargePerLiter;
    private String penalty;
    private int deleteButton;

    public AccountPayableHeadOffice(){

    }

    public AccountPayableHeadOffice(String reason, String penaltyClause, String penaltyCaseNo, String surchargePerLiter, String penalty, int deleteButton) {
        this.reason = reason;
        this.penaltyClause = penaltyClause;
        this.penaltyCaseNo = penaltyCaseNo;
        this.surchargePerLiter = surchargePerLiter;
        this.penalty = penalty;
        this.deleteButton=deleteButton;
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

    public String getPenaltyCaseNo() {
        return penaltyCaseNo;
    }

    public void setPenaltyCaseNo(String penaltyCaseNo) {
        this.penaltyCaseNo = penaltyCaseNo;
    }

    public String getSurchargePerLiter() {
        return surchargePerLiter;
    }

    public void setSurchargePerLiter(String surchargePerLiter) {
        this.surchargePerLiter = surchargePerLiter;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public int getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(int deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getLumSum() {
        return lumSum;
    }

    public void setLumSum(String lumSum) {
        this.lumSum = lumSum;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
