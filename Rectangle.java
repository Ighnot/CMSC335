class Rectangle extends TwoDimensionalShape {
    private double length;
    private double width;

    public Rectangle(int numberOfDimensions, double length, double width) {
        super(numberOfDimensions, length * width);
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return getArea();
    }
}
