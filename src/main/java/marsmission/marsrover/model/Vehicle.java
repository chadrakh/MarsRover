package marsmission.marsrover.model;

public abstract class Vehicle {
    final long ID;
    final VehicleType TYPE;
    final String CODENAME;
    char direction;
    int[] coordinate;

    public Vehicle(VehicleType type, char direction, int[] coordinate) {
        Identifier identifier = new Identifier();
        this.ID = identifier.generateId();
        this.TYPE = type;
        this.CODENAME = generateCodeName();
        this.direction = direction;
        this.coordinate = coordinate;
    }

    private String generateCodeName() {
        return getType().toString() + "-" + getId();
    }

    public void displayInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Codename: " + CODENAME);
        System.out.println("Type: " + TYPE.toString());
    }

    public long getId() {
        return ID;
    }

    public VehicleType getType() {
        return TYPE;
    }

    public String getCodeName() {
        return CODENAME;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public String getPosition() {
        char direction = getDirection();
        String formattedCoordinate = formatCoordinate(getCoordinate());

        return formattedCoordinate + " " + direction;
    }

    private String formatCoordinate(int[] coordinate) {
        StringBuilder coordinateBuilder = new StringBuilder();

        for (int position : coordinate) {
            coordinateBuilder.append(" ").append(position);
        }

        return coordinateBuilder.toString().trim();
    }
}
