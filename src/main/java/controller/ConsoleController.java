package controller;

import model.Astronaut;
import model.MissionEvent;
import model.Supply;
import service.SpaceMissionService;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {


    private final SpaceMissionService service;
    private final Scanner scanner = new Scanner(System.in);


    public ConsoleController(SpaceMissionService service) {
        this.service = service;
    }


    public void run() {
        subpunct1();

    }


    private void subpunct1() {
        List<Astronaut> astronauts = service.getAllAstronauts();
        List<Supply> supplies = service.getAllSupplies();
        List<MissionEvent> events = service.getAllMissionEvents();

        System.out.println("Astronauts loaded: " + astronauts.size());
        System.out.println("Events loaded: " + events.size());
        System.out.println("Supplies loaded: " + supplies.size() + "\n");

        astronauts.forEach(System.out::println);
        System.out.println("\n");
    }
}