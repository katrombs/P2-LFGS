import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // INPUT SECTION //
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Dungeon (Placeholder Name)!");

        // Max concurrent instances
        System.out.println("Dungeons to create: ");
        int dungeon = input.nextInt();

        // Total number of tanks
        System.out.println("Number of tanks in queue: ");
        int tank = input.nextInt();

        // Total number of healers
        System.out.println("Number of healers in queue: ");
        int healer = input.nextInt();

        // Total number of DPS
        System.out.println("Number of DPSes in queue: ");
        int dps = input.nextInt();

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
            dungeonStatuses.add(new DungeonStatus(false)); // All dungeons start with Empty status
        }
        // DUNGEON INSTANTIATE END //

        // DUNGEON ASSIGNMENT //

        PartyCreation partyInformation = new PartyCreation(tank, healer, dps);
        // Party is successfully created
        while (partyInformation.partyCompleted()) {
            dungeonPool.submit(new DungeonMaster(rand.nextInt((t2 - t1) + 1) + t1, dungeonStatuses));

            // DUNGEON DISPLAY : DungeonDisplay //

            // TEST display //
            // DungeonDisplay myDisplay = new DungeonDisplay(1, "Empty", 3,15, 2,3,2);
            // myDisplay.displayDungeon();
            // TEST display END //

            // DUNGEON DISPLAY END //

        }

        // Shut down dungeon pool when party cannot be completed
        dungeonPool.shutdown();

        // DUNGEON ASSIGNMENT END //
    }
}