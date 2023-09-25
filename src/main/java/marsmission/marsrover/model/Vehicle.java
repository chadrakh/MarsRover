package marsmission.marsrover.model;

public abstract class Vehicle {
    final long ID;
    final String CODENAME;
    final VehicleType TYPE;
    char direction;
    int[] position;

    public Vehicle(VehicleType type, char direction, int[] position) {
        Identifier identifier = new Identifier();
        this.ID = identifier.generateId();
        this.CODENAME = generateCodeName();
        this.TYPE = type;
        this.direction = direction;
        this.position = position;
    }

    private String generateCodeName() {
        return getType().toString() + getId();
    }

    public void displayInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Codename: " + CODENAME);
        System.out.println("Type: " + TYPE.toString());
    }

    public long getId() {
        return ID;
    }

    public String getCodeName() {
        return CODENAME;
    }

    public VehicleType getType() {
        return TYPE;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int[] getPosition() {
        return position;
    }

    private void setPosition(int[] position) {
        this.position = position;
    }

    public void moveTo(char direction, int[] position) {
        setDirection(direction);
        setPosition(position);
    }
}
