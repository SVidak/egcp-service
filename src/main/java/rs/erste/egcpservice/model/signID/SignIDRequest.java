package rs.erste.egcpservice.model.signID;

public class SignIDRequest {

    private String authorizationType;

    public SignIDRequest() {

    }

    public SignIDRequest(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }
}
