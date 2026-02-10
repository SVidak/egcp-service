package rs.erste.egcpservice.model.egcp;

public class EGCPRequest {

    private BankAuthentication bankAuthentication;
    private String apiVersion;
    private String apiMessageType;
    private String apiAuthID;

    public EGCPRequest() {

    }

    public EGCPRequest(BankAuthentication bankAuthentication, String apiVersion, String apiMessageType, String apiAuthID) {
        this.bankAuthentication = bankAuthentication;
        this.apiVersion = apiVersion;
        this.apiMessageType = apiMessageType;
        this.apiAuthID = apiAuthID;
    }

    public BankAuthentication getBankAuthentication() {
        return bankAuthentication;
    }

    public void setBankAuthentication(BankAuthentication bankAuthentication) {
        this.bankAuthentication = bankAuthentication;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getApiMessageType() {
        return apiMessageType;
    }

    public void setApiMessageType(String apiMessageType) {
        this.apiMessageType = apiMessageType;
    }

    public String getApiAuthID() {
        return apiAuthID;
    }

    public void setApiAuthID(String apiAuthID) {
        this.apiAuthID = apiAuthID;
    }
}
