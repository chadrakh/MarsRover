package marsmission.marsrover;

import marsmission.marsrover.model.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    private final Rover ROVER = new Rover('N', new int[]{0,0});

    @Test
    public void setId_AssignsId_IfRoverIsInstantiated() {
        boolean result = !(String.valueOf(ROVER.getId()).isBlank());

        assertTrue(result);
    }

    @Test
    public void moveTo_ReturnsNewPosition_IfInstructionIsValid() {

    }

    @Test
    public void moveTo_ReturnsNewPositionAndRemainingInstruction_IfInstructionExceedsPlateauLimit() {

    }
}
