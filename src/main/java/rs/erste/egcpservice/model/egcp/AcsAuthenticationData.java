package rs.erste.egcpservice.model.egcp;


public class AcsAuthenticationData {

    private String purchaseExponent;
    private String dsTransID;
    private String purchaseCurrency;
    private String deviceChannel;
    private String merchantName;
    private String purchaseAmount;

    public AcsAuthenticationData() {

    }

    public AcsAuthenticationData(String purchaseExponent, String dsTransID, String purchaseCurrency, String deviceChannel, String merchantName, String purchaseAmount) {
        this.purchaseExponent = purchaseExponent;
        this.dsTransID = dsTransID;
        this.purchaseCurrency = purchaseCurrency;
        this.deviceChannel = deviceChannel;
        this.merchantName = merchantName;
        this.purchaseAmount = purchaseAmount;
    }

    public String getPurchaseExponent() {
        return purchaseExponent;
    }

    public String getDsTransID() {
        return dsTransID;
    }

    public String getPurchaseCurrency() {
        return purchaseCurrency;
    }

    public String getDeviceChannel() {
        return deviceChannel;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseExponent(String purchaseExponent) {
        this.purchaseExponent = purchaseExponent;
    }

    public void setDsTransID(String dsTransID) {
        this.dsTransID = dsTransID;
    }

    public void setPurchaseCurrency(String purchaseCurrency) {
        this.purchaseCurrency = purchaseCurrency;
    }

    public void setDeviceChannel(String deviceChannel) {
        this.deviceChannel = deviceChannel;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
