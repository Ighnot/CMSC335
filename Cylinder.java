class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(int numberOfDimensions, double radius, double height) {
        super(numberOfDimensions, Math.PI * Math.pow(radius, 2) * height);
        this.radius = radius;
        this.height = height;
    }

    public double calculateVolume() {
        return getVolume();
    }
}