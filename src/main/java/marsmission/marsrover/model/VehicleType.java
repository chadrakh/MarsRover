package marsmission.marsrover.model;

public enum VehicleType {
    AERIAL,
    SURFACE,
    SUBSURFACE,
    UNDERWATER;

    @Override
    public String toString() {
        switch (this) {
            case AERIAL -> {
                return "Aerial";
            }
            case SURFACE -> {
                return "Surface";
            }
            case SUBSURFACE -> {
                return "Sub-surface";
            }
            case UNDERWATER -> {
                return "Underwater";
            }
            default -> {
                return "Unknown";
            }
        }
    }
}
