package rectangletest;
class Rectangle {
    private double length = 1.0;
    private double width = 1.0;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0.0 && length < 20.0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be > 0.0 and < 20.0");
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0.0 && width < 20.0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width must be > 0.0 and < 20.0");
        }
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateArea() {
        return length * width;
    }

    public void displayRectangle() {
        System.out.println("Rectangle Details:");
        System.out.println("Length       : " + length);
        System.out.println("Width        : " + width);
        System.out.println("Perimeter    : " + calculatePerimeter());
        System.out.println("Area         : " + calculateArea());
        System.out.println("-----------------------------");
    }
}

// Test program for Rectangle class
public class RectangleTest {
    public static void main(String[] args) {
        try {
            // Creating Rectangle object with default values
            Rectangle rectangle1 = new Rectangle();
            rectangle1.displayRectangle();

            // Setting values within the allowed range
            rectangle1.setLength(15.5);
            rectangle1.setWidth(10.2);
            rectangle1.displayRectangle();

            // Creating Rectangle object with specific values
            Rectangle rectangle2 = new Rectangle(8.0, 12.5);
            rectangle2.displayRectangle();

            // Uncommenting this will throw an exception
            // Rectangle rectangle3 = new Rectangle(21.0, 5.0); // Out of range
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
