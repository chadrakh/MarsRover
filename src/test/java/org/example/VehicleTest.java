package org.example;

import org.junit.jupiter.api.Test;

class VehicleTest {
    private final Rover ROVER = new Rover(RoverType.SURFACE, "0 0");

    @Test
    public void generateCodeName_ReturnsCodeName_IfRoverIsInstantiated() {
        String expected = ROVER.getType() + "-" + ROVER.getId();
        String result = ROVER.getCodeName();

        assertEquals(expected, result);
    }

    @Test
    public void setDirection_SetsDirectionValue_IfInputDirectionIsValid() {

    }

    @Test
    public void moveTo_ReturnsNewPosition_IfInstructionIsValid() {

    }

    @Test
    public void moveTo_ReturnsNewPositionAndRemainingInstruction_IfRoverExceedsPlateauLimit() {

    }
}