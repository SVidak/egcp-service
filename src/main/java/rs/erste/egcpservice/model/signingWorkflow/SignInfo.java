package rs.erste.egcpservice.model.signingWorkflow;

public class SignInfo {

    private String state;
    private String signId;

    public SignInfo() {

    }

    public SignInfo(String state, String signId) {
        this.state = state;
        this.signId = signId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }
}
