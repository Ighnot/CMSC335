class Cube extends ThreeDimensionalShape {
    private double sideLength;

    public Cube(int numberOfDimensions, double sideLength) {
        super(numberOfDimensions, Math.pow(sideLength, 3));
        this.sideLength = sideLength;
    }

    public double calculateVolume() {
        return getVolume();
    }
}
