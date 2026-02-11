package rs.erste.egcpservice.model.egcp;

import jakarta.persistence.*;

@Entity
public class EGCPEvent {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    private String apiVersion;
    private String cardID;
    private Long customerId;

    @Embedded
    private AcsAuthenticationData acsAuthenticationData;

    @Embedded
    private AcsCardholderData acsCardholderData;

    public EGCPEvent() {

    }

    public EGCPEvent(String apiVersion, String cardID, Long customerId, AcsAuthenticationData ascAuthenticationData, AcsCardholderData ascCardholderData) {
        this.apiVersion = apiVersion;
        this.cardID = cardID;
        this.customerId = customerId;
        this.acsAuthenticationData = ascAuthenticationData;
        this.acsCardholderData = ascCardholderData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AcsAuthenticationData getAcsAuthenticationData() {
        return acsAuthenticationData;
    }

    public void setAcsAuthenticationData(AcsAuthenticationData acsAuthenticationData) {
        this.acsAuthenticationData = acsAuthenticationData;
    }

    public AcsCardholderData getAcsCardholderData() {
        return acsCardholderData;
    }

    public void setAcsCardholderData(AcsCardholderData acsCardholderData) {
        this.acsCardholderData = acsCardholderData;
    }
}