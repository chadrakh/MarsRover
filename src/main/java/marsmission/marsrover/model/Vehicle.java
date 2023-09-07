package marsmission.marsrover.model;

import java.util.Arrays;

public abstract class Vehicle {
    private static int existingInstances = 0;
    final int ID;
    final VehicleType TYPE;
    char direction;
    int[] position;

    public Vehicle(VehicleType type, char direction, int[] position) {
        this.ID = generateId();
        this.TYPE = type;
        this.direction = direction;
        this.position = position;
    }

    private int generateId() {
        int newId = existingInstances;
        existingInstances++;

        return newId;
    }

    public void getDetails() {
        System.out.println("Type: " + TYPE.toString());
        System.out.println("ID: " + ID);
        System.out.println("Start Position: " + direction + " " + Arrays.toString(position));
    }

    public int getId() {
        return ID;
    }

    public VehicleType getType() {
        return TYPE;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int[] getPosition() {
        return position;
    }

    private void setPosition(int[] position) {
        this.position = position;
    }

    public void moveTo(char direction, int[] position) {
        setDirection(direction);
        setPosition(position);
    }
}
