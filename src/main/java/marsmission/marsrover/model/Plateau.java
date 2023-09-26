package marsmission.marsrover.model;

public class Plateau {
    final long ID;
    final int LENGTH;
    final int WIDTH;

    public Plateau(int length, int width) {
        Identifier identifier = new Identifier();
        this.ID = identifier.generateId();
        this.LENGTH = length;
        this.WIDTH = width;
    }

    public void getDetails() {
        System.out.println("Plateau-" + ID);
        System.out.println("Area: " + LENGTH + " x " + WIDTH);
    }

    public int getLength() {
        return this.LENGTH;
    }

    public int getWidth() {
        return this.WIDTH;
    }
}
