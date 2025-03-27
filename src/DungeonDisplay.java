/*
Java class for displaying current program status
    Includes:
    > Dungeon ID
    > Dungeon Status, either Active (True) / Empty (False)
    > Total number of parties served (Count of parties who have completed their run in that dungeon)
    > Accumulated time for dungeon runs in that dungeon
    > AFTER EXECUTION: Number of leftovers in each role
 */

import java.io.IOException;

public class DungeonDisplay {

    private int dungeonId; // Thread ID from dungeonPool (Main)
    private boolean status; // DungeonStatus class
    private int totalParty;
    private int totalTime;
    private int tankCount; // partyCreation : getPartyTank()
    private int healerCount; // partyCreation : getPartyHealer()
    private int dpsCount; // partyCreation : getPartyDps()

    // Constructor
    public DungeonDisplay(int dungeonId, boolean status, int totalParty, int totalTime, int tankCount, int healerCount, int dpsCount) {
        this.dungeonId = dungeonId;
        this.status = status;
        this.totalParty = totalParty;
        this.totalTime = totalTime;
        this.tankCount = tankCount;
        this.healerCount = healerCount;
        this.dpsCount = dpsCount;
    }

    public void displayDungeon() {
        // Clear previous display
        displayClear();

        System.out.println("╔===========================================================================================╗");
        System.out.println("║                                 Dungeon (Placeholder Name)                                ║");
        System.out.println("╠===========================================================================================╣");
        System.out.println("║              ║                      ║     Total Parties      ║        Dungeon Run         ║");
        System.out.println("║  Dungeon ID  ║        Status        ║         Served         ║      Accumulated Time      ║");
        System.out.println("╠===========================================================================================╣");

        // Different dungeons here

        //
    }

    public void leftoverPlayers() {
        System.out.println("╠===========================================================================================╣");
        System.out.println("║                                     Players in Queue                                      ║");
        System.out.println("╠===========================================================================================╣");
        System.out.println("║   Tanks: " + "10" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
        System.out.println("║   Healers: " + "1" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
        System.out.println("║   DPS: " + "12" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
        displayClose();
    }

    public void displayClose() {
        System.out.println("╚===========================================================================================╝");
    }

    public void displayClear() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Setter
    public void updateTank(int tankUpdate) {
        this.tankCount = tankUpdate;
    }

    public void updateHealer(int healerUpdate) {
        this.healerCount = healerUpdate;
    }

    public void updateDps(int dpsUpdate) {
        this.dpsCount = dpsUpdate;
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
