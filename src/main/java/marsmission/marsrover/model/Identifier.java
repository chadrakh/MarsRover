package marsmission.marsrover.model;

public class Identifier {
    private static long nextId = 0;

    public long generateId() {
        return nextId++;
    }
}
