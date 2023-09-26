package marsmission.marsrover.model;

import marsmission.marsrover.model.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    private Rover rover = new Rover('N', new int[]{1,2});

    @Test
    public void generateCodeName_ReturnsTypeHyphenatedWithId() {
            String expected = "SURFACE-" + rover.getId();
            String result = rover.getCodeName();

            assertEquals(expected, result);
    }

    @Test
    public void getPosition_ReturnsFormattedCoordinateAndDirection() {
        String expected = "1 2 N";
        String result = rover.getPosition();

        assertEquals(expected, result);
    }
}