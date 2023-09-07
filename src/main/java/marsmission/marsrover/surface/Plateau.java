package marsmission.marsrover.surface;

public class Plateau {
    private static int existingInstances = 0;
    final int ID;
    final int LENGTH;
    final int WIDTH;

    public Plateau(int length, int width) {
        this.ID = generateId();
        this.LENGTH = length;
        this.WIDTH = width;
    }

    private int generateId() {
        int newId = existingInstances;
        existingInstances++;

        return newId;
    }

    public void getDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Area: " + LENGTH + " x " + WIDTH);
    }
}
