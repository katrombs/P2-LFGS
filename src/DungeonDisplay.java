/*
Java class for displaying current program status
    Includes:
    > Dungeon ID
    > Dungeon Status, either Active (True) / Empty (False)
    > Total number of parties served (Count of parties who have completed their run in that dungeon)
    > Accumulated time for dungeon runs in that dungeon
    > AFTER EXECUTION: Number of leftovers in each role
 */

public class DungeonDisplay {

    private int dungeonId; // Thread ID from dungeonPool (Main)
    private boolean status; // DungeonStatus class
    private int totalParty;
    private int totalTime;
    private int tankLeft; // partyCreation : getPartyTank()
    private int healerLeft; // partyCreation : getPartyHealer()
    private int dpsLeft; // partyCreation : getPartyDps()

    // Constructor
    public DungeonDisplay(int dungeonId, boolean status, int totalParty, int totalTime, int tankLeft, int healerLeft, int dpsLeft) {
        this.dungeonId = dungeonId;
        this.status = status;
        this.totalParty = totalParty;
        this.totalTime = totalTime;
        this.tankLeft = tankLeft;
        this.healerLeft = healerLeft;
        this.dpsLeft = dpsLeft;
    }

    public void displayDungeon() {
        System.out.println("╔==========================================================================================╗");
        System.out.println("║                                Dungeon (Placeholder Name)                                ║");
        System.out.println("╠==========================================================================================╣");
        System.out.println("║              ║                      ║     Total Parties     ║        Dungeon Run         ║");
        System.out.println("║  Dungeon ID  ║        Status        ║         Served        ║      Accumulated Time      ║");
        System.out.println("╠==========================================================================================╣");
    }

    // Setter
    public void updateTank(int tankUpdate) {
        this.tankLeft = tankUpdate;
    }

    public void updateHealer(int healerUpdate) {
        this.healerLeft = healerUpdate;
    }

    public void updateDps(int dpsUpdate) {
        this.dpsLeft = dpsUpdate;
    }

    public void updateStatus(boolean status) {
        this.status = status;
    }

    public void updateTotalParty(int totalPartyUpdate) {
        this.totalParty = totalPartyUpdate;
    }

    public void updateTotalTime(int totalTimeUpdate) {
        this.totalTime = totalTimeUpdate;
    }

}
