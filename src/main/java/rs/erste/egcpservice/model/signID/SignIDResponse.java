package rs.erste.egcpservice.model.signID;

import rs.erste.egcpservice.model.signingWorkflow.SignInfo;

import java.util.List;

public class SignIDResponse {

    private String authorizationType;
    private List<List<String>> scenarios;
    private List<String> signIds;
    private SignInfo signInfo;
    private List<String> flags;

    private Poll poll;
    private String authorizationRequestId;
    private String authTransactionId;

    public SignIDResponse() {

    }

    public SignIDResponse(String authorizationType, List<List<String>> scenarios, List<String> signIds, SignInfo signInfo, List<String> flags) {
        this.authorizationType = authorizationType;
        this.scenarios = scenarios;
        this.signIds = signIds;
        this.signInfo = signInfo;
        this.flags = flags;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public List<List<String>> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<List<String>> scenarios) {
        this.scenarios = scenarios;
    }

    public List<String> getSignIds() {
        return signIds;
    }

    public void setSignIds(List<String> signIds) {
        this.signIds = signIds;
    }

    public SignInfo getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
