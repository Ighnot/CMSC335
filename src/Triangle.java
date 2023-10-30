class Triangle extends TwoDimensionalShape {
    private double baseLength;
    private double height;

    public Triangle(int numberOfDimensions, double baseLength, double height) {
        super(numberOfDimensions, 0.5 * baseLength * height);
        this.baseLength = baseLength;
        this.height = height;
    }

    public double calculateArea() {
        return getArea();
    }
}
