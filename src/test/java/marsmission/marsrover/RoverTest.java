package marsmission.marsrover;

import marsmission.marsrover.model.Rover;
import marsmission.marsrover.model.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    private final Rover ROVER = new Rover('N', new int[]{0, 0});

    @Test
    public void generateCodeName_ReturnsCodeName_IfRoverIsInstantiated() {
        String expected = ROVER.getType() + "Rover-" + ROVER.getId();
        String result = ROVER.getCodeName();

        assertEquals(expected, result);
    }

    @Test
    public void setDirection_SetsDirectionValue_IfNewDirectionIsValid() {
    }

    @Test
    public void setDirection_ReturnsInvalidInstructionMessage_IfNewDirectionIsInvalid() {

    }
}