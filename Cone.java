class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(int numberOfDimensions, double radius, double height) {
        super(numberOfDimensions,
                (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height);
        this.radius = radius;
        this.height = height;
    }

    public double calculateVolume() {
        return getVolume();
    }
}