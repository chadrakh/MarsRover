package marsmission.marsrover.model;

public class Rover extends Vehicle {

    public Rover(char direction, int[] position) {
        super(VehicleType.SURFACE, direction, position);
    }
}