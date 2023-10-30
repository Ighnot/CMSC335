class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(int numberOfDimensions, double radius) {
        super(numberOfDimensions, (4.0 / 3.0) * Math.PI * Math.pow(radius, 3));
        this.radius = radius;
    }

    public double calculateVolume() {
        return getVolume();
    }
}
