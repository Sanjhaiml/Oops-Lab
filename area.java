
import java.util.Scanner;

// Abstract class
abstract class Shape {
    int dim1, dim2;
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        dim1 = length;
        dim2 = breadth;
    }
    void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle = " + area);
    }
}

// Triangle class
class Triangle extends Shape {
    Triangle(int base, int height) {
        dim1 = base;
        dim2 = height;
    }
    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle = " + area);
    }
}

// Circle class
class Circle extends Shape {
    Circle(int radius) {
        dim1 = radius;
    }
    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle = " + area);
    }
}

// Main class with main method
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rectangle
        System.out.print("Enter length of Rectangle: ");
        int l = sc.nextInt();
        System.out.print("Enter breadth of Rectangle: ");
        int b = sc.nextInt();
        Shape rect = new Rectangle(l, b);
        rect.printArea();

        // Triangle
        System.out.print("\nEnter base of Triangle: ");
        int base = sc.nextInt();
        System.out.print("Enter height of Triangle: ");
        int h = sc.nextInt();
        Shape tri = new Triangle(base, h);
        tri.printArea();

        // Circle
        System.out.print("\nEnter radius of Circle: ");
        int r = sc.nextInt();
        Shape cir = new Circle(r);
        cir.printArea();

        sc.close();
    }
}