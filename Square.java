/**
 * For calculation purposes, you only need one number, the side, because a square
 * is a rectangle with length = width. So I have Square IS-A Rectangle
 * relationship as a child of square.
 */
class Square extends Rectangle {
    public Square(int numberOfDimensions, double sideLength) {
        super(numberOfDimensions, sideLength, sideLength);
    }
}