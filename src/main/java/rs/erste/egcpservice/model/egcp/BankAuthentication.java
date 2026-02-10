package rs.erste.egcpservice.model.egcp;

public class BankAuthentication {

    private String bankAuthenticationStatus;
    private String bankAuthenticationType;

    public BankAuthentication() {

    }

    public String getBankAuthenticationStatus() {
        return bankAuthenticationStatus;
    }

    public void setBankAuthenticationStatus(String bankAuthenticationStatus) {
        this.bankAuthenticationStatus = bankAuthenticationStatus;
    }

    public String getBankAuthenticationType() {
        return bankAuthenticationType;
    }

    public void setBankAuthenticationType(String bankAuthenticationType) {
        this.bankAuthenticationType = bankAuthenticationType;
    }
}
