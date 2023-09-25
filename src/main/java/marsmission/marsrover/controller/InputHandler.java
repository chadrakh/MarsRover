package marsmission.marsrover.controller;

public class InputHandler {
    public int[] parsePosition(String inputPosition) {
        String[] coordinates = inputPosition.split(",");

        if (coordinates.length != 2) {
            System.out.println("""
                    Error!
                    Please enter valid coordinates in the format \\"x,y\\".                                       \s
                    """
            );
        }

        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        return new int[]{x,y};
    }

    public char parseDirection(String inputDirection) {
        switch (inputDirection.toUpperCase()) {
            case "NORTH" -> {
                return 'N';
            }
            case "EAST" -> {
                return 'E';
            }
            case "SOUTH" -> {
                return 'S';
            }
            case "WEST" -> {
                return 'W';
            }
            default -> {
                System.out.println("""
                    Error!
                    Please enter a valid direction (N, E, S, W)."                                      \s
                    """
                );
                return 0;
            }
        }
    }
}