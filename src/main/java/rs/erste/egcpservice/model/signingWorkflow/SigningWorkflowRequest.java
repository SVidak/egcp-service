package rs.erste.egcpservice.model.signingWorkflow;

public class SigningWorkflowRequest {

    private String businessObject;
    private String requestType;
    private String businessObjectType;
    private String requestSource;
    private String operation;
    private String url;

    public SigningWorkflowRequest() {

    }

    public SigningWorkflowRequest(String businessObject, String requestType, String businessObjectType, String requestSource, String operation, String url) {
        this.businessObject = businessObject;
        this.requestType = requestType;
        this.businessObjectType = businessObjectType;
        this.requestSource = requestSource;
        this.operation = operation;
        this.url = url;
    }

    public String getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getBusinessObjectType() {
        return businessObjectType;
    }

    public void setBusinessObjectType(String businessObjectType) {
        this.businessObjectType = businessObjectType;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
