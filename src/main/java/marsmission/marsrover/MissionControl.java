package marsmission.marsrover;

import marsmission.marsrover.userInterface.ConsoleMessenger;

public class MissionControl {
    private static final ConsoleMessenger CONSOLE_APP = new ConsoleMessenger();
    public static void main(String[] args) {
        CONSOLE_APP.startApplication();
    }
}