/**
 * John Leckie, CMSC335, Oct '23
 *
 * This program presents a menu for constructing various two-dimensional and
 * three-dimensional shapes. The user can choose to create shapes like circles,
 * rectangles, cubes, spheres, and more. The program ensures that the user
 * provides valid input, such as numeric values for dimensions.
 *
 * The primary purpose ot the program is to demonstrate class hierarchy,
 * inheritance, encapsulation, and polymorphism.
 */

import java.util.Scanner;

/**
 * ShapeMenu is the user interface, allowing the user to choose the different
 * shape they wish to construct.
 */
public class ShapeMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("********* Welcome to the Java OO Shapes Program " +
                "**********");

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
                    double circleRadius = getValidInput("What's the radius?",
                            scanner);
                    Circle circle = new Circle(2, circleRadius);
                    System.out.println("The area of the Circle is "
                            + circle.calculateArea());
                    break;
                case "2":
                    System.out.println("We will construct a Rectangle");
                    double length = getValidInput("What's the length?",
                            scanner);
                    double width = getValidInput("What's the width?",
                            scanner);
                    Rectangle rectangle = new Rectangle(2,
                            length, width);
                    System.out.println("The area of the Rectangle is "
                            + rectangle.calculateArea());
                    break;
                case "3":
                    System.out.println("We will construct a Square");
                    double sideLength = getValidInput("What's the side length?",
                            scanner);
                    Square square = new Square(2, sideLength);
                    System.out.println("The area of the Square is "
                            + square.calculateArea());
                    break;
                case "4":
                    System.out.println("We will construct a Triangle");
                    double baseLength = getValidInput("What's the base length?",
                            scanner);
                    double height = getValidInput("What's the height?",
                            scanner);
                    Triangle triangle = new Triangle(2,
                            baseLength, height);
                    System.out.println("The area of the Triangle is "
                            + triangle.calculateArea());
                    break;
                case "5":
                    System.out.println("We will construct a Sphere");
                    double sphereRadius = getValidInput("What's the radius?",
                            scanner);
                    Sphere sphere = new Sphere(3, sphereRadius);
                    System.out.println("The volume of the Sphere is "
                            + sphere.calculateVolume());
                    break;
                case "6":
                    System.out.println("We will construct a Cube");
                    double cubeSideLength = getValidInput("What's the side " +
                            "length?", scanner);
                    Cube cube = new Cube(3, cubeSideLength);
                    System.out.println("The volume of the Cube is "
                            + cube.calculateVolume());
                    break;
                case "7":
                    System.out.println("We will construct a Cone");
                    double coneRadius = getValidInput("What's the radius?",
                            scanner);
                    double coneHeight = getValidInput("What's the height?",
                            scanner);
                    Cone cone = new Cone(3, coneRadius, coneHeight);
                    System.out.println("The volume of the Cone is "
                            + cone.calculateVolume());
                    break;
                case "8":
                    System.out.println("We will construct a Cylinder");
                    double cylinderRadius = getValidInput("What's the radius?",
                            scanner);
                    double cylinderHeight = getValidInput("What's the height?",
                            scanner);
                    Cylinder cylinder = new Cylinder(3,
                            cylinderRadius,
                            cylinderHeight);
                    System.out.println("The volume of the Cylinder is "
                            + cylinder.calculateVolume());
                    break;
                case "9":
                    System.out.println("We will construct a Torus");
                    double majorRadius = getValidInput("What's the major radius?",
                            scanner);
                    double minorRadius = getValidInput("What's the minor radius?",
                            scanner);
                    Torus torus = new Torus(3, majorRadius,
                            minorRadius);
                    System.out.println("The volume of the Torus is "
                            + torus.calculateVolume());
                    break;
                case "10":
                    System.out.println("Thank you and goodbye!. Current time: " +
                            java.time.LocalDateTime.now().format(java.time.format.
                                    DateTimeFormatter.ofPattern("HH:mm:ss")));

                    break;
                default:
                    System.out.println("Please use an integer from 1 to 10.");
            }
        } while (!choice.equals("10"));
    }

    /**
     * getValidInput is an 'extra' method that ensures that the user enters a valid
     * numeric input so proper arguments are passed to the various shape classes.
     *
     * @param prompt   The prompt message to guide the user.
     * @param scanner  The Scanner object for reading user input.
     * @return         A valid numeric value entered by the user.
     */
    private static double getValidInput(String prompt, Scanner scanner) {
        double value = -1; // Initialize with a negative value to ensure it's replaced with a valid input
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                if (value >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad input. Please use a number.");
            }
        }
        return value;
    }
}

