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

    // Constructor
    public DungeonMaster(int timeToClear, List<DungeonStatus> dungeonStatuses) {
        this.timeToClear = timeToClear;
        this.dungeonStatuses = dungeonStatuses;
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
                    System.out.println("Dungeon " + i + " is currently active.");

                    try {
                        Thread.sleep(timeToClear * 1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Dungeon cleared after timeToClear seconds
                    dungeonStatus.setStatus(false);
                    dungeonCleared = true;
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
