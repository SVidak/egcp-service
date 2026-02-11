package rs.erste.egcpservice.model.egcp;

public class AcsCardholderData {

    private String acctNumber;
    private String requestCardImage;

    public AcsCardholderData() {
    }

    public AcsCardholderData(String acctNumber, String requestCardImage) {
        this.acctNumber = acctNumber;
        this.requestCardImage = requestCardImage;
    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public String getRequestCardImage() {
        return requestCardImage;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public void setRequestCardImage(String requestCardImage) {
        this.requestCardImage = requestCardImage;
    }
}
