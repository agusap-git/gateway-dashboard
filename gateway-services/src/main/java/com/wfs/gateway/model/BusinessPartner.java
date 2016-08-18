package com.wfs.gateway.model;


/**
 * Created by aaltamir on 8/18/16.
 */
public class BusinessPartner extends Entity {

    private String number;
    private String partnerCode;
    private String partnerName;
    private String partyName;
    private Boolean active;
    private String creationDate;
    private String createdBy;
    private String lastUpdatedDate;
    private String lastUpdatedBy;
    private String status;

    public BusinessPartner(String number, String partnerCode, String partnerName, String partyName, Boolean active, String creationDate, String createdBy, String lastUpdatedDate, String lastUpdatedBy, String status) {
        this.number = number;
        this.partnerCode = partnerCode;
        this.partnerName = partnerName;
        this.partyName = partyName;
        this.active = active;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getId() {
        return number;
    }
}
