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
        subpunct2();
        subpunct3();
        subpunct4();

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


    private void subpunct2() {
        System.out.print("Input Spacecraft: ");
        String spacecraft = scanner.nextLine();

        service.filterBySpacecraft(spacecraft).forEach(System.out::println);
        System.out.println("\n");
    }


    private void subpunct3() {
        service.getSortedAstronauts().forEach(System.out::println);
        System.out.println("\n");
    }


    private void subpunct4() {
        service.writeReversed();
    }
}