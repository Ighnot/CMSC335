import java.util.Scanner;

public class ShapeMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("********* Welcome to the Java OO Shapes Program **********");

        do {
            System.out.println("Select from the menu below:");
            System.out.println("1. Construct a Circle");
            System.out.println("2. Construct a Rectangle");
            System.out.println("3. Construct a Square");
            System.out.println("4. Construct a Triangle");
            System.out.println("5. Construct a Sphere");
            System.out.println("6. Construct a Cube");
            System.out.println("7. Construct a Cone");
            System.out.println("8. Construct a Cylinder");
            System.out.println("9. Construct a Torus");
            System.out.println("10. Exit the program");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("We will construct a Circle");
                    double circleRadius = getValidInput("What's the radius?", scanner);
                    Circle circle = new Circle(2, circleRadius);
                    System.out.println("The area of the Circle is " + circle.calculateArea());
                    break;
                case "2":
                    System.out.println("We will construct a Rectangle");
                    double length = getValidInput("What's the length?", scanner);
                    double width = getValidInput("What's the width?", scanner);
                    Rectangle rectangle = new Rectangle(2, length, width);
                    System.out.println("The area of the Rectangle is " + rectangle.calculateArea());
                    break;
                case "3":
                    System.out.println("We will construct a Square");
                    double sideLength = getValidInput("What's the side length?", scanner);
                    Square square = new Square(2, sideLength);
                    System.out.println("The area of the Square is " + square.calculateArea());
                    break;
                case "4":
                    System.out.println("We will construct a Triangle");
                    double baseLength = getValidInput("What's the base length?", scanner);
                    double height = getValidInput("What's the height?", scanner);
                    Triangle triangle = new Triangle(2, baseLength, height);
                    System.out.println("The area of the Triangle is " + triangle.calculateArea());
                    break;
                case "5":
                    System.out.println("We will construct a Sphere");
                    double sphereRadius = getValidInput("What's the radius?", scanner);
                    Sphere sphere = new Sphere(3, sphereRadius);
                    System.out.println("The volume of the Sphere is " + sphere.calculateVolume());
                    break;
                case "6":
                    System.out.println("We will construct a Cube");
                    double cubeSideLength = getValidInput("What's the side length?", scanner);
                    Cube cube = new Cube(3, cubeSideLength);
                    System.out.println("The volume of the Cube is " + cube.calculateVolume());
                    break;
                case "7":
                    System.out.println("We will construct a Cone");
                    double coneRadius = getValidInput("What's the radius?", scanner);
                    double coneHeight = getValidInput("What's the height?", scanner);
                    Cone cone = new Cone(3, coneRadius, coneHeight);
                    System.out.println("The volume of the Cone is " + cone.calculateVolume());
                    break;
                case "8":
                    System.out.println("We will construct a Cylinder");
                    double cylinderRadius = getValidInput("What's the radius?", scanner);
                    double cylinderHeight = getValidInput("What's the height?", scanner);
                    Cylinder cylinder = new Cylinder(3, cylinderRadius, cylinderHeight);
                    System.out.println("The volume of the Cylinder is " + cylinder.calculateVolume());
                    break;
                case "9":
                    System.out.println("We will construct a Torus");
                    double majorRadius = getValidInput("What's the major radius?", scanner);
                    double minorRadius = getValidInput("What's the minor radius?", scanner);
                    Torus torus = new Torus(3, majorRadius, minorRadius);
                    System.out.println("The volume of the Torus is " + torus.calculateVolume());
                    break;
                case "10":
                    System.out.println("Thank you and goodbye!. Current date and " +
                            "time: " + java.time.LocalDateTime.now());
                    break;
                default:
                    System.out.println("Please use an integer from 1 to 10.");
            }
        } while (!choice.equals("10"));
    }

    private static double getValidInput(String prompt, Scanner scanner) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Bad input. Please use a number.");
            }
        }

        return value;
    }
}


class Shape {
    private int numberOfDimensions;

    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }
}

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

class ThreeDimensionalShape extends Shape {
    private double volume;

    public ThreeDimensionalShape(int numberOfDimensions, double volume) {
        super(numberOfDimensions);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

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

class Square extends Rectangle {
    public Square(int numberOfDimensions, double sideLength) {
        super(numberOfDimensions, sideLength, sideLength);
    }
}

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

class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(int numberOfDimensions, double radius, double height) {
        super(numberOfDimensions, (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height);
        this.radius = radius;
        this.height = height;
    }

    public double calculateVolume() {
        return getVolume();
    }
}

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

class Torus extends ThreeDimensionalShape {
    private double majorRadius;
    private double minorRadius;

    public Torus(int numberOfDimensions, double majorRadius, double minorRadius) {
        super(numberOfDimensions, 2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2));
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double calculateVolume() {
        return getVolume();
    }
}
