package rs.erste.egcpservice.model.signingWorkflow;

public class SigningWorkflowResponse {

    private SignInfo signInfo;

    public SigningWorkflowResponse() {

    }

    public SigningWorkflowResponse(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    public SignInfo getSignInfo() {
        return signInfo;
    }
    public void setSignInfo(SignInfo signInfo) {
        this.signInfo = signInfo;
    }
}
