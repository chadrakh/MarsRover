package marsmission.marsrover.model;

import java.util.Arrays;

public class Rover extends Vehicle {
    final String CODENAME;

    public Rover(char direction, int[] position) {
        super(VehicleType.SURFACE, direction, position);
        this.CODENAME = generateCodeName();
    }

    private String generateCodeName() {
        return getType().toString() + "Rover-" + getId();
    }

    public void getDetails() {
        System.out.println("Codename: " + CODENAME);
        System.out.println("Type: " + TYPE.toString());
        System.out.println("ID: " + ID);
        System.out.println("Start Position: " + direction + " " + Arrays.toString(position));
    }

    public String getCodeName() {
        return CODENAME;
    }
}