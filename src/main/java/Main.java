import controller.ConsoleController;
import repository.AstronautRepository;
import repository.MissionEventRepository;
import repository.SupplyRepository;
import service.SpaceMissionService;

public class Main {

    public static void main(String[] args) {
        run();
    }


    private static void run() {
        AstronautRepository astronautRepository = new AstronautRepository("src/data/astronauts.json");
        MissionEventRepository missionEventRepository = new MissionEventRepository("src/data/events.json");
        SupplyRepository supplyRepository = new SupplyRepository("src/data/supplies.json");
        SpaceMissionService service = new SpaceMissionService(astronautRepository, supplyRepository, missionEventRepository);

        new ConsoleController(service).run();
    }

}
