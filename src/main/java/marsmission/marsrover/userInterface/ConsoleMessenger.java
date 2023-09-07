package marsmission.marsrover.messenger;

import marsmission.marsrover.model.Rover;
import marsmission.marsrover.surface.Plateau;
import marsmission.marsrover.validation.InputHandler;

import java.util.Scanner;

public class ConsoleMessenger {
    private final InputHandler INPUT_HANDLER = new InputHandler();
    Scanner scanner = new Scanner(System.in);

    public void startApplication() {
        System.out.println("Initialising Mission Control Software...\n");

        System.out.println("Welcome to the Mars Rover Mission");
        System.out.println("This program is designated for the creation and management of surface rovers.\n");

        System.out.println("You are required to input the dimensions of the plateau and the details of the rover for this mission.");

        generatePlateau();
        generateRover();
    }

    public Plateau generatePlateau() {
        System.out.println("--- Define Plateau ---");
        System.out.println("To define a plateau you are required to define the width and height of the area.\n");

        System.out.println("Enter width:");
        int width = Integer.parseInt(scanner.next());

        System.out.println();

        System.out.print("Enter height:");
        int height = Integer.parseInt(scanner.next());

        return new Plateau(width, height);
    }

    public Rover generateRover() {
        System.out.println("--- Deploy Rover ---");
        System.out.println("To deploy a rover you are required to define the starting direction and position on the plateau.\n");

        System.out.println("Enter the X and Y coordinates for the position, separated with a single comma. \n(e.g. \"0,0\" ");
        System.out.print("Enter position:");
        String inputPosition = scanner.next();

        System.out.println();

        System.out.println("Enter the cardinal direction \n(e.g. \"North, East, South, West\")");
        System.out.print("Enter direction:");
        String inputDirection = scanner.next();

        int[] position = INPUT_HANDLER.parsePosition(inputPosition);
        char direction = INPUT_HANDLER.parseDirection(inputDirection);

        return new Rover(direction, position);
    }
}