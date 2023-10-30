class Torus extends ThreeDimensionalShape {
    private double majorRadius;
    private double minorRadius;

    public Torus(int numberOfDimensions, double majorRadius, double minorRadius) {
        super(numberOfDimensions,
                2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2));
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double calculateVolume() {
        return getVolume();
    }
}
