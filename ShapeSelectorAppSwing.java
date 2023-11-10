import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ShapeSelectorAppSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Selector");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Use BoxLayout for the content pane
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            // Declare shapeSelectorPanel outside the block
            JPanel shapeSelectorPanel = new JPanel();
            shapeSelectorPanel.setLayout(new FlowLayout());

            JComboBox<String> shapeComboBox = new JComboBox<>(new String[]{"Circle",
                    "Square", "Triangle", "Rectangle", "Sphere", "Cube", "Cone",
                    "Cylinder", "Torus"});
            shapeComboBox.setSelectedItem("Select a shape");

            // Add a JLabel for instructions
            JLabel instructionsLabel = new JLabel("Select a shape from the " +
                    "dropdown, hit 'submit' and enter parameters. Then hit " +
                    "'Generate Shape'");
            shapeSelectorPanel.add(instructionsLabel);
            shapeSelectorPanel.add(shapeComboBox);

            // JPanel shapeSelectorPanel = new JPanel();
            shapeSelectorPanel.setLayout(new FlowLayout());
            shapeSelectorPanel.add(shapeComboBox);

            JPanel parameterPanel = new JPanel();
            parameterPanel.setLayout(new GridLayout(0, 2));

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> {
                String selectedShape = shapeComboBox.getSelectedItem().toString();
                displayParameters(selectedShape, parameterPanel);
            });

            JButton generateButton = new JButton("Generate Shape");
            generateButton.addActionListener(e -> {
                String selectedShape = shapeComboBox.getSelectedItem().toString();
                generateAndDisplayShape(selectedShape, getParameterValues(parameterPanel));
            });

            frame.add(shapeSelectorPanel);
            frame.add(parameterPanel);
            frame.add(submitButton);
            frame.add(generateButton);

            frame.setVisible(true);
        });
    }

    private static void displayParameters(String selectedShape, JPanel parameterPanel) {
        parameterPanel.removeAll();
        parameterPanel.repaint();

        switch (selectedShape) {
            case "Circle":
                addParameterField(parameterPanel, "Radius:");
                break;
            case "Square":
                addParameterField(parameterPanel, "Side Length:");
                break;
            case "Rectangle":
                addParameterField(parameterPanel, "Length:");
                addParameterField(parameterPanel, "Width:");
                break;
            case "Triangle":
                addParameterField(parameterPanel, "Base Length:");
                addParameterField(parameterPanel, "Height:");
                break;
            case "Sphere":
                addParameterField(parameterPanel, "Radius:");
                break;
            case "Cube":
                addParameterField(parameterPanel, "Side Length:");
                break;
            case "Cone":
                addParameterField(parameterPanel, "Radius:");
                addParameterField(parameterPanel, "Height:");
                break;
            case "Cylinder":
                addParameterField(parameterPanel, "Radius:");
                addParameterField(parameterPanel, "Height:");
                break;
            case "Torus":
                addParameterField(parameterPanel, "Major Radius:");
                addParameterField(parameterPanel, "Minor Radius:");
                break;
            default:
                break;
        }

        parameterPanel.revalidate();
    }

    private static void addParameterField(JPanel panel, String parameterName) {
        JTextField textField = new JTextField(10);
        panel.add(new JLabel(parameterName));
        panel.add(textField);
    }

/*    private static Map<String, Double> getParameterValues(JPanel parameterPanel) {
        Map<String, Double> parameters = new HashMap<>();
        Component[] components = parameterPanel.getComponents();

        for (int i = 0; i < components.length; i += 2) {
            if (components[i] instanceof JLabel && components[i + 1] instanceof JTextField) {
                String parameterName = ((JLabel) components[i]).getText();
                String parameterText = ((JTextField) components[i + 1]).getText();

                // Check if the parameter text is empty
                if (!parameterText.isEmpty()) {
                    try {
                        Double parameterValue = Double.parseDouble(parameterText);
                        parameters.put(parameterName, parameterValue);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for " + parameterName);
                    }
                } else {
                    // Set a default value (e.g., 0) for empty parameters
                    parameters.put(parameterName, 0.0);
                }
            }
        }

        return parameters;
    }*/

    private static Map<String, Double> getParameterValues(JPanel parameterPanel) {
        Map<String, Double> parameters = new HashMap<>();

        String parameterName = null;
        JTextField currentTextField = null;

        for (Component component : parameterPanel.getComponents()) {
            if (component instanceof JLabel) {
                parameterName = ((JLabel) component).getText();
            } else if (component instanceof JTextField) {
                currentTextField = (JTextField) component;
                String parameterText = currentTextField.getText();

                // Check if the parameter text is empty
                if (!parameterText.isEmpty()) {
                    System.out.println("Non-empty parameter! " + parameterName +
                            " " + parameterText);
                    try {
                        Double parameterValue = Double.parseDouble(parameterText);
                        parameters.put(parameterName, parameterValue);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for " + parameterName);
                    }
                } else {
                    // Set a default value (e.g., 0) for empty parameters
                    System.out.println("Setting to 0.0 to avoid null!");
                    parameters.put(parameterName, 0.0);
                }
            }
        }

        return parameters;
    }





    private static void generateAndDisplayShape(String selectedShape, Map<String, Double> parameters) {
        if (parameters == null) {
            System.out.println("Parameters are null. Cannot generate shape.");
            return;
        }

        Shape shape = createShape(selectedShape, parameters);
        if (shape != null) {
            displayShape(shape);
        }
    }


    private static Shape createShape(String selectedShape, Map<String, Double> parameters) {
        switch (selectedShape) {
            case "Circle":
                Double circleRadius = parameters.get("Radius");
                if (circleRadius != null) {
                    return new Circle(2, circleRadius);
                } else {
                    System.out.println("Radius is null. Cannot create Circle.");
                    return null;
                }
            case "Square":
                return new Square(2, parameters.get("Side Length"));
            case "Rectangle":
                return new Rectangle(2, parameters.get("Length"), parameters.get("Width"));
            case "Triangle":
                return new Triangle(2, parameters.get("Base Length"), parameters.get("Height"));
            case "Sphere":
                return new Sphere(3, parameters.get("Radius"));
            case "Cube":
                return new Cube(3, parameters.get("Side Length"));
            case "Cone":
                return new Cone(3, parameters.get("Radius"), parameters.get("Height"));
            case "Cylinder":
                return new Cylinder(3, parameters.get("Radius"), parameters.get("Height"));
            case "Torus":
                return new Torus(3, parameters.get("Major Radius"), parameters.get("Minor Radius"));
            default:
                System.out.println("Invalid shape selected: " + selectedShape);
                return null;
        }
    }


    private static void displayShape(Shape shape) {
        JFrame frame = new JFrame("Shape Display");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);

        ShapePanel shapePanel = new ShapePanel(shape);
        frame.add(shapePanel);

        frame.setVisible(true);
    }
}
