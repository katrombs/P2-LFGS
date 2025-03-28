/*
Java class for displaying current program status
    Includes:
    > Dungeon ID (Thread ID from dungeonPool [taken from Main])
    > Dungeon status (DungeonStatus class)
    > Total Parties Served (DungeonMaster : dungeonClearers)
    > Total Time Dungeon is Active (DungeonMaster : Time to Clear)
    > Players remaining in each role (PartyCreation : getParty<Role>())
 */

import java.io.IOException;
import java.util.List;

public class DungeonDisplay {

    private List<DungeonStatus> status; // DungeonStatus class
    private int tankCount; // partyCreation : getPartyTank()
    private int healerCount; // partyCreation : getPartyHealer()
    private int dpsCount; // partyCreation : getPartyDps()

    // Constructor
    public DungeonDisplay(List<DungeonStatus> status, int tankCount, int healerCount, int dpsCount) {
        this.status = status;
        this.tankCount = tankCount;
        this.healerCount = healerCount;
        this.dpsCount = dpsCount;
    }

    public void displayDungeon() {
        // Clear previous display
        displayClear();

        System.out.println("╔===========================================================================================╗");
        System.out.println("║                                         Decked Out                                        ║");
        System.out.println("╠==============╦======================╦========================╦============================╣");
        System.out.println("║              ║                      ║     Total Parties      ║        Total Dungeon       ║");
        System.out.println("║  Dungeon ID  ║        Status        ║         Served         ║           Runtime          ║");
        System.out.println("╠==============╬======================╬========================╬============================╣");

        // Different dungeons here
        for (DungeonStatus dungeonStatus : status){
            String currStatus = "";
            // Active dungeon
            if(dungeonStatus.getStatus()) {
                currStatus = "Active";
            } else {
                currStatus = "Empty";
            }
            System.out.println("║\t\t" + dungeonStatus.getId() + "\t   ║\t\t" + currStatus + "\t\t  ║\t\t\t   " + dungeonStatus.getTotalParty() + "\t\t   ║\t\t\t" + dungeonStatus.getTotalTime() + "\t\t\t\t║");
        }
        //displayClose();
        // Players in Queue
        leftoverPlayers();
    }

    public void leftoverPlayers() {
        System.out.println("╠==============╩======================╩========================╩============================╣");
        System.out.println("║                                     Leftover Players                                      ║");
        System.out.println("╠===========================================================================================╣");
        System.out.println("║   Tanks: " + tankCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
        System.out.println("║   Healers: " + healerCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
        System.out.println("║   DPS: " + dpsCount + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t║");
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

}
