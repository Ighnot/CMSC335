/**
 * ThreeDimensionalShape further narrows down the shape properties,
 * giving the Shape a volume. The constructor sets up the number of
 * dimensions and the volume, and getVolume() method returns the volume.
 */
class ThreeDimensionalShape extends Shape {
    private double volume;

    public ThreeDimensionalShape(int numberOfDimensions, double volume) {
        super(numberOfDimensions);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}
