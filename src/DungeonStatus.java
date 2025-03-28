public class DungeonStatus {

    private boolean status; // Active: True, Empty: False
    private int id;
    private int totalParty;
    private long totalTime;

    public DungeonStatus(int id, boolean status, int totalParty, long totalTime) {
        this.id = id;
        this.status = status;
        this.totalParty = totalParty;
        this.totalTime = totalTime;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public int getTotalParty() {
        return totalParty;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void incTotalParty() {
        this.totalParty = totalParty + 1;
    }

    public void incTotalTime(long totalTime) {
        this.totalTime = this.totalTime + totalTime;
    }

}
