package rs.erste.egcpservice.model.poll;

import java.util.List;

public class PollResponse {

    private String state;
    private int pollInterval;
    private List<String> flags;

    public PollResponse() {

    }

    public PollResponse(String state, int pollInterval, List<String> flags) {
        this.state = state;
        this.pollInterval = pollInterval;
        this.flags = flags;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getPollInterval() {
        return pollInterval;
    }
    public void setPollInterval(int pollInterval) {
        this.pollInterval = pollInterval;
    }

    public List<String> getFlags() {
        return flags;
    }
    public void setFlags(List<String> flags) {
        this.flags = flags;
    }
}
