package marsmission.marsrover.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoverManager {
    private final Map<Integer, Rover> ROVER_MAP = new HashMap<>();

    public void addRover(Rover rover) {
        ROVER_MAP.put(rover.getId(), rover);
    }

    public Rover findById(int id) {
        return ROVER_MAP.get(id);
    }

    public Rover findByCodeName(String codename) {
        for (Rover rover : ROVER_MAP.values()) {
            String expectedCodename = rover.getType().toString() + "Rover-" + rover.getId();

            if (expectedCodename.equalsIgnoreCase(codename)) {
                return rover;
            } else {
                throw new IllegalArgumentException("Rover instruction error. Target rover does not exist.");
            }
        }
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