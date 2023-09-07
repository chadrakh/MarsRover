package org.example;

import org.junit.jupiter.api.Test;

class RoverTest {
    private final Rover ROVER = new Rover(RoverType.SURFACE, "0 0");

    @Test
    public void generateCodeName_ReturnsCodeName_IfRoverIsInstantiated() {
        String expected = ROVER.getType() + "-" + ROVER.getId();
        String result = ROVER.getCodeName();

        assertEquals(expected, result);
    }

    @Test
    public void setId_Increments_IfRoverIsInstantiated() {

    }

    @Test
    public void setDirection_SetsDirectionValue_IfNewDirectionIsValid() {

    }

    @Test
    public void setDirection_ReturnsInvalidInstructionMessage_IfNewDirectionIsInvalid() {

    }
}