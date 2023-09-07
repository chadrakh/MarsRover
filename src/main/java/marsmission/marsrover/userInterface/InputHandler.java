package marsmission.marsrover.validation;

public class InputHandler {
    public int[] parsePosition(String inputPosition) {
        String[] coordinates = inputPosition.split(",");

        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Invalid coordinates. The rover position MUST be in the format \"x,y\".");
        }

        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new int[]{x,y};
    }

    public char parseDirection(String inputDirection) {
        switch (inputDirection.toLowerCase()) {
            case "north" -> {
                return 'N';
            }
            case "east" -> {
                return 'E';
            }
            case "south" -> {
                return 'S';
            }
            case "west" -> {
                return 'W';
            }
            default -> {
                throw new IllegalArgumentException("Invalid direction: " + inputDirection);
            }
        }
    }
}
