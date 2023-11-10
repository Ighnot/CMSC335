/**
 * TwoDimensionalShape further narrows down the shape properties,
 * giving the Shape an area. The constructor sets up the number of
 * dimensions and the area, and getArea() method returns the area.
 */
class TwoDimensionalShape extends Shape {
    private double area;

    public TwoDimensionalShape(int numberOfDimensions, double area) {
        super(numberOfDimensions);
        this.area = area;
    }

    public double getArea() {
        return area;
    }
}