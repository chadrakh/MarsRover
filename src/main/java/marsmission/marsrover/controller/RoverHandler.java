package marsmission.marsrover.controller;

import marsmission.marsrover.model.Rover;

import java.util.*;

public class RoverHandler {
    private final Map<Long, Rover> ROVER_MAP = new HashMap<>();

    public void add(Rover rover) {
        ROVER_MAP.put(rover.getId(), rover);
    }

    public void remove(String targetCodeName) {
        Rover targetRover = null;

        for (Rover rover : ROVER_MAP.values()) {
            String expectedCodename = rover.getType().toString() + rover.getId();

            if (expectedCodename.equalsIgnoreCase(targetCodeName)) {
                targetRover = rover;
                break;
            }
        }

        if (targetRover == null) {
            System.out.println(
                    "Error!" +
                    "\n" +
                    "Vehicle " + targetCodeName + " does not exist." +
                    "Please check the codename and try again."
            );
        } else {
            ROVER_MAP.remove(targetRover.getId());
            System.out.println("Rover " + targetCodeName + " has been removed.");
        }
    }

    public Rover find(String targetCodeName) {
        for (Rover rover : ROVER_MAP.values()) {
            String expectedCodename = rover.getType().toString() + "-" + rover.getId();

            if (expectedCodename.equalsIgnoreCase(targetCodeName)) {
                return rover;
            }
        }

        System.out.println(
                "Error! Target vehicle does not exist." +
                        "\n" +
                        "Please enter a valid codename for a deployed vehicle."
        );

        return null;
    }

    public List<String> findAll() {
        List<String> roverList = new ArrayList<>();

        for (Rover rover : ROVER_MAP.values()) {
            roverList.add(rover.getCodeName());
        }

        return roverList;
    }
}