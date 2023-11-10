class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(int numberOfDimensions, double radius) {
        super(numberOfDimensions, Math.PI * radius * radius);
        this.radius = radius;
    }

    public double calculateArea() {
        return getArea();
    }
}