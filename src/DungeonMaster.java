/*
Java class for executing the dungeon run of a party
    Includes:
    > Dungeon ID
    > Time required to complete dungeon run
    > Dungeon status: Active (true) / Empty (false)
 */

import java.util.List;

public class DungeonMaster implements Runnable {
    private int timeToClear;
    private List<DungeonStatus> dungeonStatuses;
    private DungeonDisplay dungeonDisplay;
    private int partyCount;

    // Constructor
    public DungeonMaster(int timeToClear, List<DungeonStatus> dungeonStatuses, DungeonDisplay dungeonDisplay, int partyCount) {
        this.timeToClear = timeToClear;
        this.dungeonStatuses = dungeonStatuses;
        this.dungeonDisplay = dungeonDisplay;
        this.partyCount = partyCount;
    }

    @Override
    public void run() {
        boolean dungeonCleared = false;

        // Dungeon still ongoing
        while(!dungeonCleared) {
            for(int i = 0; i < dungeonStatuses.size(); i++) {
                DungeonStatus dungeonStatus = dungeonStatuses.get(i);

                // If dungeon is Empty, set to Active
                if(!dungeonStatus.getStatus()) {
                    dungeonStatus.setStatus(true); // Set active
                    //System.out.println("\n=============================================");
                    //System.out.println("   Dungeon " + i + " is currently active.");
                    //System.out.println("=============================================\n");

                    try {
                        Thread.sleep(timeToClear * 1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Dungeon cleared after timeToClear seconds
                    dungeonStatus.setStatus(false);
                    dungeonCleared = true;

                    // Increment dungeon clearers
                    //System.out.println("\n=============================================");
                    dungeonStatus.incTotalParty();
                    //System.out.println("  Dungeon " + i + " clearer count: " + dungeonStatus.getTotalParty());
                    dungeonStatus.incTotalTime(timeToClear);
                    //System.out.println("  Dungeon " + i + " time count: " + dungeonStatus.getTotalTime());
                    //System.out.println("  Dungeon " + i + " is now empty!");
                    //System.out.println("=============================================\n");
                    System.out.println("Total number of parties created: " + partyCount);
                    dungeonDisplay.displayDungeon();
                    break;

                }
            }

            // Sleep before trying to check for dungeon status
            if(!dungeonCleared) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
