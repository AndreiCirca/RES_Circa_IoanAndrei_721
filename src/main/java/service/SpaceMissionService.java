package service;

import model.Astronaut;
import model.AstronautStatus;
import model.MissionEvent;
import model.Supply;
import repository.AstronautRepository;
import repository.MissionEventRepository;
import repository.SupplyRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpaceMissionService {


    private final AstronautRepository astronautRepository;
    private final SupplyRepository supplyRepository;
    private final MissionEventRepository missionEventRepository;


    public SpaceMissionService(AstronautRepository astronautRepository, SupplyRepository supplyRepository, MissionEventRepository missionEventRepository) {
        this.astronautRepository = astronautRepository;
        this.supplyRepository = supplyRepository;
        this.missionEventRepository = missionEventRepository;
    }

    public List<Astronaut> getAllAstronauts() {
        return astronautRepository.getAllAstronauts();
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.getAllSupplies();
    }

    public List<MissionEvent> getAllMissionEvents() {
        return missionEventRepository.getAllMissionEvents();
    }

    //2
    public List<Astronaut> filterBySpacecraft(String spacecraft) {
        return astronautRepository.getAllAstronauts().stream()
                .filter(a -> a.getSpacecraft().equalsIgnoreCase(spacecraft))
                .filter(a -> a.getStatus() == AstronautStatus.ACTIVE)
                .toList();
    }

    // 3)
    public List<Astronaut> getSortedAstronauts() {
        return astronautRepository.getAllAstronauts().stream()
                .sorted(Comparator
                        .comparing(Astronaut::getExperienceLevel).reversed()
                        .thenComparing(Astronaut::getName))
                .toList();
    }
}