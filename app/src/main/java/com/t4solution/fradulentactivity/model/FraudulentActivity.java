package com.t4solution.fradulentactivity.model;

public class FraudulentActivity {

    private Integer id;
    private String involvementIn;
    private String quantity;
    private String remarks;
    private int attachment;

    public FraudulentActivity(){

    }

    public FraudulentActivity(String involvementIn, String quantity, String remarks,int attachment) {
        this.involvementIn = involvementIn;
        this.quantity = quantity;
        this.remarks = remarks;
        this.attachment=attachment;
    }

    public String getInvolvementIn() {
        return involvementIn;
    }

    public void setInvolvementIn(String involvementIn) {
        this.involvementIn = involvementIn;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getAttachment() {
        return attachment;
    }

    public void setAttachment(int attachment) {
        this.attachment = attachment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
