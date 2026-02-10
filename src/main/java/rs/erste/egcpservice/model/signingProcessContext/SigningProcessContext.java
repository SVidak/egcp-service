package rs.erste.egcpservice.model.signingProcessContext;

import rs.erste.egcpservice.model.signingWorkflow.SignInfo;

public class SigningProcessContext {

    private String accessToken;
    private SignInfo signInfo;

    public SigningProcessContext() {
    }

    public SigningProcessContext(String accessToken, SignInfo signInfo) {
        this.accessToken = accessToken;
        this.signInfo = signInfo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public SignInfo getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(SignInfo signInfo) {
        this.signInfo = signInfo;
    }
}