package marsmission.marsrover.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// rename to parseCoordinate
class InputHandlerTest {
    private final InputHandler HANDLER = new InputHandler();

    @Test
    void parsePosition_ReturnsCoordinateAsArray_IfInputIsValid() {
        String input = "5,5";

        int x = Integer.parseInt(String.valueOf(input.charAt(0)));
        int y = Integer.parseInt(String.valueOf(input.charAt(2)));

        int[] expected = new int[]{x,y};

        int[] result = HANDLER.parsePosition(input);

        assertArrayEquals(expected, result);
    }

    @Test
    void parseDirection_ReturnsInitialForDirection_IfDirectionIsValid() {
        String input = "North";

        char expected = input.charAt(0);

        char result = HANDLER.parseDirection(input);

        assertEquals(expected, result);
    }

    @Test
    void parseDirection_ReturnsZero_IfDirectionIsInvalid() {
        String input = "null";

        char expected = 0;

        char result = HANDLER.parseDirection(input);

        assertEquals(expected, result);
    }
}