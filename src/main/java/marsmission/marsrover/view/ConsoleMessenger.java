package marsmission.marsrover.view;

import marsmission.marsrover.controller.InputHandler;
import marsmission.marsrover.controller.RoverController;
import marsmission.marsrover.model.Rover;
import marsmission.marsrover.controller.RoverHandler;
import marsmission.marsrover.model.Plateau;

import java.util.Scanner;

public class ConsoleMessenger {
    public Plateau plateau;
    private final RoverHandler ROVER_HANDLER = new RoverHandler();
    private final RoverController ROVER_CONTROLLER = new RoverController();
    private final InputHandler INPUT_HANDLER = new InputHandler();
    
    Scanner scanner = new Scanner(System.in);    

    public void startApplication() {
        System.out.println("Initialising Mission Control Program...\n");

        System.out.println("Welcome to the Mars Rover Mission");
        System.out.println("This program is designated for the creation and management of surface rovers.\n");

        System.out.println("You are required to input the dimensions of the plateau and the details of the rover for this mission.");

        createPlateau();
        createRover();
        
        System.out.println("\n--- Mission Details ---");
        plateau.getDetails();
        viewRovers();
        
        actionMenu();
    }

    public void actionMenu() {
        System.out.println("\n--- Select Action ---");
        System.out.println("1. Instruct Rover");
        System.out.println("2. Deploy New Rover");
        System.out.println("3. View Deployed Rovers");
        System.out.println("4. View Plateau Details");

        System.out.println("\nTIP: \nQ to End Application\n");

        System.out.print("Enter Action: ");
        String action = scanner.next();

        handleActionMenu(action);
    }

    public void returnToMenu() {
        System.out.println("""
                Would you like to return to the menu?
                - Enter Y to return
                
                (Hint: Any other entry to exit application)
                """
        );
        System.out.print("Enter choice: ");
        String action = scanner.next();

        if (action.equalsIgnoreCase("Y")) {
            actionMenu();
        } else {
            endApplication();
        }
    }

    public void handleActionMenu(String action) {
        viewRovers();

        switch(action.toUpperCase()) {
            case "1" -> {
                System.out.print("Enter Target Rover Codename: ");
                Rover targetRover = ROVER_HANDLER.find(scanner.next());

                instructRover(targetRover);
            }
            case "2" -> {
                createRover();
            }
            case "3" -> {
                viewRovers();
                returnToMenu();
            }
            case "4" -> {
                viewPlateau(plateau);
                returnToMenu();
            }
            case "Q" -> {
                endApplication();
            }
            default -> {
                System.out.println("Entry \\'" + action + "\\' is invalid.");
                returnToMenu();
            }
        }
    }

    private void createPlateau() {
        System.out.println("\n--- Define Plateau ---");
        System.out.println("""
                To define a plateau you are required to define the length and width of the area.
                Enter 'Q' to exit and end the program.
                """
        );

        while (true) {
            System.out.print("Enter length: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                endApplication();
            }

            try {
                int length = Integer.parseInt(input);

                System.out.print("Enter width: ");
                input = scanner.next();

                int width = Integer.parseInt(input);

                plateau = new Plateau(length, width);
                break;
            } catch (NumberFormatException e) {
                System.out.println("""
                        Error!
                        Please enter a valid length and width.
                        """
                );
            }
        }
    }

    private void roverTips() {
        System.out.println("""
                TIP:
                - Position requires an X and Y coordinates separated with a single comma. (e.g. "0,0")
                - Direction requires a cardinal point of a compass. (e.g. "North, East, South, West")
                """
        );
    }

    public void createRover() {
        System.out.println("\n--- Deploy Rover ---");
        System.out.println("""
            Define the starting direction and position on the plateau to deploy rover.
            All exploration vehicles are assigned a codename comprised of type and ID.
            EXAMPLE: Surface Rover with ID 148 is assigned codename 'SURFACE-148'.
            """
        );

        roverTips();

        char direction;
        int[] position = {};

        while (true) {
            System.out.print("Enter direction: ");
            direction = INPUT_HANDLER.parseDirection(scanner.next());

            if (direction != 0) {
                break;
            }

            System.out.println("Invalid direction. Please enter a valid direction.");
        }

        System.out.println("CHOSEN DIRECTION " + direction);

        System.out.print("Enter position (x,y): ");
        int[] parsedInput = INPUT_HANDLER.parsePosition(scanner.next());

        if (parsedInput.length != 2) {
            System.out.println("position array size <= 1");

        } else {
            position = parsedInput;

            Rover newRover = new Rover(direction, position);
            System.out.println(newRover.getCodeName());
            ROVER_HANDLER.add(newRover);

            System.out.println("\n- New Rover Deployed -");
            System.out.println("Codename: " + newRover.getCodeName());
            System.out.println("Position: " + newRover.getPosition());

            actionMenu();
        }
    }

    private void viewPlateau(Plateau plateau) {
        System.out.println("\n- Plateau Details -");
        plateau.getDetails();
    }

    private void viewRovers() {
        System.out.println("\n--- Deployed Rovers ---");

        if (ROVER_HANDLER.findAll().isEmpty()) {
            System.out.println("Deployed Rovers: 0");
        } else {
            System.out.println("Deployed Rovers: " + ROVER_HANDLER.findAll().size());

            for (String codename : ROVER_HANDLER.findAll()) {
                System.out.println(codename);
            }
        }
    }

    public void instructRover(Rover targetRover) {
        System.out.println("\n- Instruct Rover -");
        roverTips();

        if (targetRover != null) {
            System.out.println("Current Position: " + targetRover.getPosition() + "\n");
            System.out.print("Enter instructions (L, R, M): ");
            String instructions = scanner.next();

            ROVER_CONTROLLER.instruct(targetRover, instructions, plateau);

            System.out.println("\nTarget: " + targetRover.getCodeName());
            System.out.println("\nRover moved successfully.");
            System.out.println("New Position: " + targetRover.getPosition());

            System.out.println("\n");
            System.out.print("Would you like to continue moving the rover?");
            String action = scanner.next();

            if (action.equalsIgnoreCase("Y")) {
                instructRover(targetRover);
            } else {
                actionMenu();
            }
        } else {
            System.out.println("""
                    Error!
                    Target not found. Returning to menu.
                    """
            );

            actionMenu();
        }
    }

    public void endApplication() {
        scanner.close();
        System.out.println("\nEnding session...");
        System.exit(0);
    }
}