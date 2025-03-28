import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // INPUT SECTION //
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Decked Out (Ripoff)!");
        System.out.println("Original Decked Out Game by TangoTek");

        // Max concurrent instances
        System.out.println("Dungeons to create: ");
        int dungeon = input.nextInt();
        while(dungeon < 1) {
            System.out.println("Please set total number of dungeons over 0: ");
            dungeon = input.nextInt();
        }

        // Total number of tanks
        System.out.println("Number of tanks in queue: ");
        int tank = input.nextInt();
        while(tank < 1) {
            System.out.println("Please set total number of tanks over 0: ");
            tank = input.nextInt();
        }

        // Total number of healers
        System.out.println("Number of healers in queue: ");
        int healer = input.nextInt();
        while(healer < 1) {
            System.out.println("Please set total number of healer over 0: ");
            healer = input.nextInt();
        }

        // Total number of DPS
        System.out.println("Number of DPSes in queue: ");
        int dps = input.nextInt();
        while(dps < 1) {
            System.out.println("Please set total number of dps over 0: ");
            dps = input.nextInt();
        }

        // Minimum time to finish dungeon run
        System.out.println("Minimum time to finish dungeon run (in sec): ");
        int t1 = input.nextInt();
        while(t1 < 1 || t1 > 15) {
            System.out.println("Please set time between 1 and 15 seconds: ");
            t1 = input.nextInt();
        }

        // Maximum time to finish dungeon run
        System.out.println("Maximum time to finish dungeon run (in sec): ");
        int t2 = input.nextInt();
        while(t2 < t1 || t2 > 15) {
            System.out.println("Please set time between Min.Time and 15 seconds: ");
            t2 = input.nextInt();
        }

        // INPUT SECTION END //

        // RNG
        Random rand = new Random();

        // CREATING THREAD POOL
        ExecutorService dungeonPool = Executors.newFixedThreadPool(dungeon);

        // Hold dungeon status
        List<DungeonStatus> dungeonStatuses = new ArrayList<>();

        // DUNGEON INSTANTIATE : DungeonStatus //
        for(int i = 0; i < dungeon; i++) {
            dungeonStatuses.add(new DungeonStatus(i, false, 0, 0)); // All dungeons start with Empty status, 0 Parties, 0 time
        }
        // DUNGEON INSTANTIATE END //

        // DUNGEON ASSIGNMENT //

        PartyCreation partyInformation = new PartyCreation(tank, healer, dps);
        int partyCounter = 0;
        // Party is successfully created

        while (partyInformation.partyCompleted()) {
            // Increment partyCounter if party is filled
            partyCounter++;

            // Update player count for each role
            partyInformation.updatePartyTank();
            partyInformation.updatePartyHealer();
            partyInformation.updatePartyDps();

        }

        // Scheduled display
        // ScheduledExecutorService scheduledDisplay = Executors.newScheduledThreadPool(1);
        DungeonDisplay dungeonDisplay = new DungeonDisplay(dungeonStatuses, partyInformation.getPartyTank(),partyInformation.getPartyHealer(), partyInformation.getPartyDps());


        // Submit dungeon runs to dungeonPool for as many as there are parties created
        for (int i = 0; i < partyCounter; i++) {
            // DungeonMaster instance
            DungeonMaster dungeonMaster = new DungeonMaster(rand.nextInt((t2 - t1) + 1) + t1, dungeonStatuses);
            dungeonPool.submit(dungeonMaster);

            //dungeonDisplay.displayDungeon();
        }

        // DUNGEON DISPLAY : DungeonDisplay //

        //dungeonDisplay.displayDungeon();
        // scheduledDisplay.scheduleAtFixedRate(() -> dungeonDisplay.displayDungeon(), 0, 2, TimeUnit.SECONDS);

        // DUNGEON DISPLAY END //

        // Shut down dungeon pool when party cannot be completed
        dungeonPool.shutdown();
        // scheduledDisplay.shutdown();

        // Final display
//        dungeonDisplay.displayDungeon();
//        System.out.println("All parties have cleared the dungeon!");

        // DUNGEON ASSIGNMENT END //


    }
}