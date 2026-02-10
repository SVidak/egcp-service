package rs.erste.egcpservice.model.signID;

public class Poll {

    private String url;
    private String id;
    private String interval;

    public Poll() {

    }

    public Poll(String url, String id, String interval) {
        this.url = url;
        this.id = id;
        this.interval = interval;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}
