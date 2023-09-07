package marsmission.marsrover.userInterface;

import marsmission.marsrover.model.Rover;
import marsmission.marsrover.model.RoverManager;

import java.util.Arrays;

public class InputHandler {
    public int[] parsePosition(String inputPosition) {
        String[] coordinates = inputPosition.split(",");

        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Invalid coordinates. The rover position MUST be in the format \"x,y\".");
        }

        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new int[]{x,y};
    }

    public char parseDirection(String inputDirection) {
        switch (inputDirection.toUpperCase()) {
            case "NORTH" -> {
                return 'N';
            }
            case "EAST" -> {
                return 'E';
            }
            case "SOUTH" -> {
                return 'S';
            }
            case "WEST" -> {
                return 'W';
            }
            default -> {
                throw new IllegalArgumentException("Invalid direction: " + inputDirection);
            }
        }
    }

    public String handleRoverInstruction(Rover rover, char newDirection, int[] newPosition) {
        rover.moveTo(newDirection, newPosition);

        return newDirection + " " + Arrays.toString(rover.getPosition());
    }
}
