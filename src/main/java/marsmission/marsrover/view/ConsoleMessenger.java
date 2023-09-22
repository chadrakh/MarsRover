package marsmission.marsrover.view;

import marsmission.marsrover.controller.InputHandler;
import marsmission.marsrover.model.Rover;
import marsmission.marsrover.controller.RoverHandler;
import marsmission.marsrover.model.Plateau;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleMessenger {
    public Plateau plateau;
    private final RoverHandler ROVER_MANAGER = new RoverHandler();
    private final InputHandler INPUT_HANDLER = new InputHandler();
    
    Scanner scanner = new Scanner(System.in);    

    public void startApplication() {
        System.out.println("Initialising Mission Control Software...\n");

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

        System.out.print("Enter Action: " + scanner.nextLine());

        handleActionMenu(scanner.nextLine());
    }

    public void handleActionMenu(String action) {
        System.out.println("\n--- Deployed Rovers ---");

        if (ROVER_MANAGER.findAll().isEmpty()) {
            System.out.println("Deployed Rovers: 0");
        } else {
            System.out.println("Deployed Rovers: " + ROVER_MANAGER.findAll().size());
            System.out.println(ROVER_MANAGER.findAll());
        }

        switch(action.toUpperCase()) {
            case "1" -> {
                instructRover();
            }
            case "2" -> {
                createRover();
            }
            case "3" -> {
                ROVER_MANAGER.findAll();
                actionMenu();
            }
            case "4" -> {
                plateau.getDetails();
                actionMenu();
            }
            case "Q" -> {
                endApplication();
            }
            default -> {
                System.out.println("Invalid input. Input an action from the menu.");
                System.out.println("EXAMPLE: Enter 2 to select Deploy Rover");

                System.out.println("Ending program.");
            }
        }
    }

    public void endApplication() {
        System.out.println("\nEnding session...");
        System.exit(0);
    }
    
    private void viewPlateau(Plateau plateau) {
        System.out.println("\n- Current Plateau -");
        plateau.getDetails();
    }
    
    private void viewRovers() {
        System.out.println("\n- Deployed Rovers -");
        
        for (String codename : ROVER_MANAGER.findAll()) {
            System.out.println(codename + "\n");
        }        
    }

    private void createPlateau() {
        System.out.println("\n--- Define Plateau ---");
        System.out.println("To define a plateau you are required to define the length and width of the area.\n");

        System.out.print("Enter length: ");
        int length = Integer.parseInt(scanner.next());

        System.out.print("Enter width: ");
        int width = Integer.parseInt(scanner.next());

        plateau = new Plateau(length, width);
    }

    public void createRover() {
        System.out.println("\n--- Deploy Rover ---");
        System.out.println("To deploy a rover you are required to define the starting direction and position on the plateau.\n");
        System.out.println("All rovers are designated a codename. The characters denote type and vehicle, followed by the ID.");
        System.out.println("EXAMPLE: Surface Rover with ID 5 is assigned codename 'SurfaceRover-5'.");

        roverTips();

        System.out.print("Enter direction: ");
        char direction = INPUT_HANDLER.parseDirection(scanner.next());

        System.out.print("Enter position: ");
        int[] position = INPUT_HANDLER.parsePosition(scanner.next());

        System.out.println();

        Rover newRover = new Rover(direction, position);
        ROVER_MANAGER.addRover(newRover);

        System.out.println("\n- New Rover Deployed -");
        System.out.println("Codename: " + newRover.getCodeName());
        System.out.println("Position: " + newRover.getDirection() + " " + Arrays.toString(newRover.getPosition()));

        actionMenu();
    }

    public void instructRover() {
        String newPosition;
        
        System.out.println("\n- Instruct Rover -");
        roverTips();

        System.out.print("Enter Target Rover Codename: ");
        Rover targetRover = ROVER_MANAGER.findByCodeName(scanner.next());
        
        System.out.print("Enter new direction: ");
        char direction = INPUT_HANDLER.parseDirection(scanner.next());

        System.out.print("Enter new position: ");
        int[] position = INPUT_HANDLER.parsePosition(scanner.next());
        
        newPosition = INPUT_HANDLER.handleRoverInstruction(targetRover, direction, position);

        System.out.println("\nTarget: " + targetRover.getCodeName());
        System.out.println("New Position: " + newPosition);

        actionMenu();
    }
    
    private void roverTips() {
        System.out.println("TIP:");
        System.out.println("- Position requires an X and Y coordinates separated with a single comma. (e.g. \"0,0\")");
        System.out.println("- Direction requires a cardinal point of a compass. (e.g. \"North, East, South, West\")");
        System.out.println();
    }
}