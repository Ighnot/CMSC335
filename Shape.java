/**
 * Shape is the superclass of this program. All shapes have a number
 * of dimensions. There are 11 inheritors (Children) of this class.
 */
class Shape {
    private int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }
}