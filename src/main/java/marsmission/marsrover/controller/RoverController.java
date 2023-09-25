package marsmission.marsrover.controller;

import marsmission.marsrover.model.Plateau;
import marsmission.marsrover.model.Rover;

public class RoverController {
    public void instruct(Rover rover, String instructions, Plateau plateau) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    rotateLeft(rover);
                    break;
                case 'R':
                    rotateRight(rover);
                    break;
                case 'M':
                    moveForward(rover, plateau);
                    break;
                default:
                    System.out.println("Invalid instruction: " + instruction);
            }
        }
    }

    private void rotateLeft(Rover rover) {
        char currentDirection = rover.getDirection();

        switch (currentDirection) {
            case 'N':
                rover.setDirection('W');
                break;
            case 'E':
                rover.setDirection('N');
                break;
            case 'S':
                rover.setDirection('E');
                break;
            case 'W':
                rover.setDirection('S');
                break;
            default:
                System.out.println("Invalid direction: " + currentDirection);
        }
    }

    private void rotateRight(Rover rover) {
        char currentDirection = rover.getDirection();

        switch (currentDirection) {
            case 'N':
                rover.setDirection('E');
                break;
            case 'E':
                rover.setDirection('S');
                break;
            case 'S':
                rover.setDirection('W');
                break;
            case 'W':
                rover.setDirection('N');
                break;
            default:
                System.out.println("Invalid direction: " + currentDirection);
        }
    }


    public void moveForward(Rover targetRover, Plateau currentPlateau) {
        int[] currentPosition = targetRover.getCoordinate();
        int x = currentPosition[0];
        int y = currentPosition[1];

        int plateauLength = currentPlateau.getLength();
        int plateauWidth = currentPlateau.getWidth();

        char direction = targetRover.getDirection();

        switch (direction) {
            case 'N':
                if (y < plateauLength) {
                    y++;
                }
                break;
            case 'E':
                if (x < plateauWidth) {
                    x++;
                }
                break;
            case 'S':
                if (y > 0) {
                    y--;
                }
                break;
            case 'W':
                if (x > 0) {
                    x--;
                }
                break;
        }

        int[] newPosition = {x, y};
        targetRover.setCoordinate(newPosition);
    }
}
